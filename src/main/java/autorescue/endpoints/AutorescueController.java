/**
 * Project: AUTORESCUE

 */
package autorescue.endpoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import autorescue.dto.SendFormRequest;
import autorescue.dto.SendNotificationRequest;
import autorescue.service.AutorescueService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/autorescue")
@RequiredArgsConstructor
public class AutorescueController {

	private final AutorescueService autorescueService;

	@PostMapping("/deviceStatus")
	public ResponseEntity<Object> sendNotification(@RequestBody SendNotificationRequest request) {
		return autorescueService.sendNotification(request);
	}

	@PostMapping("/needHelp")
	public ResponseEntity<Object> needHelp(@RequestBody SendNotificationRequest request) throws Exception {
		return autorescueService.needHelp(request);
	}

	@PostMapping("/sendForm")
	public ResponseEntity<Object> sendForm(@RequestBody SendFormRequest request) throws Exception {
		return autorescueService.sendForm(request);
	}

}
