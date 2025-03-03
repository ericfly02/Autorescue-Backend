package cat.gencat.autorescue;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "spring.main.allow-bean-definition-overriding=true" ,"spring.profiles.include=loc"})
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public abstract class CommonRepositoryTest {

	public static Pageable page = PageRequest.of(0, 20);

}
