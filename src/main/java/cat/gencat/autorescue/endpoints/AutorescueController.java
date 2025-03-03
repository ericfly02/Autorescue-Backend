/**
 * Project: AUTORESCUE

 */
package cat.gencat.autorescue.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.gencat.autorescue.dto.AutorescueDTO;
import cat.gencat.autorescue.service.AutorescueService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/autorescue")
@RequiredArgsConstructor
public class AutorescueController {

	private final AutorescueService autorescueService;

	@GetMapping("/{id}")
	public AutorescueDTO getAutorescue(@PathVariable Long id) {
		return autorescueService.getAutorescue(id);
	}

}
