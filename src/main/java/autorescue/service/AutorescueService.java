/**
 * Project: AUTORESCUE

 */
package autorescue.service;

import org.springframework.http.ResponseEntity;

import autorescue.dto.SendFormRequest;
import autorescue.dto.SendNotificationRequest;

public interface AutorescueService {

	ResponseEntity<Object> sendNotification(SendNotificationRequest request);

	ResponseEntity<Object> needHelp(SendNotificationRequest request) throws Exception;

	ResponseEntity<Object> sendForm(SendFormRequest request) throws Exception;
}
