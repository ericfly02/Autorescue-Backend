/**
 * Project: AUTORESCUE

 */
package cat.gencat.autorescue.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import cat.gencat.autorescue.dto.AutorescueDTO;
import cat.gencat.autorescue.model.Autorescue;
import cat.gencat.autorescue.repository.AutorescueRepository;
import cat.gencat.autorescue.service.AutorescueService;
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
