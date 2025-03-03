/**
 * Project: AUTORESCUE

 */
package autorescue.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import autorescue.dto.AutorescueDTO;
import autorescue.model.Autorescue;
import autorescue.repository.AutorescueRepository;
import autorescue.service.AutorescueService;
import lombok.RequiredArgsConstructor;

@Service("AutorescueService")
@RequiredArgsConstructor
public class AutorescueServiceImpl implements AutorescueService {

	private final AutorescueRepository autorescueRepository;

	@Override
	public AutorescueDTO getAutorescue(Long id) {
		AutorescueDTO autorescueDto = new AutorescueDTO();
		Optional<Autorescue> autorescueOpt = autorescueRepository.findById(id);
		if (autorescueOpt.isPresent()) {
			Autorescue autorescue = autorescueOpt.get();
			autorescueDto.setName(autorescue.getName());
		}

		return autorescueDto;
	}
}
