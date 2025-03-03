/**
 * Project: AUTORESCUE

 */
package autorescue.service.impl;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import autorescue.dto.KYCMatchRequest;
import autorescue.dto.KYCMatchResponse;
import autorescue.dto.LocationRetrievalResponse;
import autorescue.dto.SendFormRequest;
import autorescue.dto.SendNotificationRequest;
import autorescue.model.Autorescue;
import autorescue.model.FormData;
import autorescue.nokia.NokiaClient;
import autorescue.repository.AutorescueRepository;
import autorescue.repository.FormDataRepository;
import autorescue.service.AutorescueService;
import lombok.RequiredArgsConstructor;

@Service("AutorescueService")
@RequiredArgsConstructor
public class AutorescueServiceImpl implements AutorescueService {

	private final AutorescueRepository autorescueRepository;

	private final FormDataRepository formDataRepository;

	private final NokiaClient nokiaClient;

	@Override
	public void sendNotification(SendNotificationRequest request) {

		Optional<Autorescue> autorescueOpt = autorescueRepository.findBySerialNumber(request.getSerialNumber());
		if (autorescueOpt.isPresent()) {
			Autorescue autorescue = autorescueOpt.get();
			String phone = autorescue.getPhone();
			if (getDeviceStatus(phone)) {
				// Enviamos un evento al móvil para abrir el formulario
				System.out.println("SEND NOTIFICATION");
			}
		}
	}

	@Override
	public void needHelp(SendNotificationRequest request) throws Exception {
		Optional<Autorescue> autorescueOpt = autorescueRepository.findBySerialNumber(request.getSerialNumber());
		if (autorescueOpt.isPresent()) {
			Autorescue autorescue = autorescueOpt.get();
			String phone = autorescue.getPhone();
			LocationRetrievalResponse response = nokiaClient.callLocationRetrieval(phone);
			// Llamamos a los servicios de emergencia con la información de localización
			// obtenida
			System.out.println("CALL EMERGENCY PHONE");
		}
	}

	@Override
	public ResponseEntity<Object> sendForm(SendFormRequest request) throws Exception {

		Optional<Autorescue> autorescueOpt = autorescueRepository.findByCarPlate(request.getCarPlate());
		if (autorescueOpt.isPresent()) {
			Autorescue autorescue = autorescueOpt.get();
			String phone = autorescue.getPhone();
			KYCMatchRequest kycRequest = new KYCMatchRequest();
			kycRequest.setPhoneNumber(phone);
			kycRequest.setIdDocument(request.getIdDocument());
			kycRequest.setName(request.getName());
			KYCMatchResponse response = nokiaClient.callKYCMatch(kycRequest);
			if ("true".equals(response.getIdDocumentMatch()) && "true".equals(response.getNameMatch())) {
				FormData formData = new FormData();
				formData.setCarPlate(request.getCarPlate());
				formData.setDescription(request.getDescription());
				formData.setIdDocument(request.getIdDocument());
				formData.setName(request.getName());
				formDataRepository.save(formData);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	private boolean getDeviceStatus(String phone) {

		return nokiaClient.callDeviceStatus(phone);

	}

}
