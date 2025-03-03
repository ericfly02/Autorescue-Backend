/**
 * Project: AUTORESCUE

 */
package autorescue.service.impl;

import org.springframework.stereotype.Service;

import autorescue.dto.AutorescueDTO;
import autorescue.nokia.NokiaClient;
import autorescue.repository.AutorescueRepository;
import autorescue.service.AutorescueService;
import lombok.RequiredArgsConstructor;

@Service("AutorescueService")
@RequiredArgsConstructor
public class AutorescueServiceImpl implements AutorescueService {

	private final AutorescueRepository autorescueRepository;
	
	private final NokiaClient nokiaClient;

	@Override
	public AutorescueDTO getAutorescue(Long id) {
		AutorescueDTO autorescueDto = new AutorescueDTO();
		/*
		Optional<Autorescue> autorescueOpt = autorescueRepository.findById(id);
		if (autorescueOpt.isPresent()) {
			Autorescue autorescue = autorescueOpt.get();
			autorescueDto.setName(autorescue.getName());
		}*/
		nokiaClient.callDeviceStatus();

		return autorescueDto;
	}
}
