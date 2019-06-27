package fi.haagahelia.codingLesson;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.codingLesson.web.WebController;
import fi.haagahelia.codingLesson.service.UserDetailServiceImpl;
/**
* Testing that the context is creating your controller
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CodingLessonApplicationTests {

	@Autowired
	private WebController controller;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		assertThat(userDetailServiceImpl).isNotNull();
	}

}