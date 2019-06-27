package fi.haagahelia.codingLesson;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import fi.haagahelia.codingLesson.repo.UserRepository;
import fi.haagahelia.codingLesson.domain.User;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository urepository;

    @Test
    public void findByUserNameShouldReturnUser() {
        
       User users = urepository.findByUsername("user");
        
        assertThat(users.getRole()).isEqualTo("USER");
    }
    
    @Test
    public void addNewUser() {
    	User user = new User("TestingUser", "HelloWorld", "TesingtRole");
    	urepository.save(user);
    	assertThat(user.getId()).isNotNull();
    }  
    
  
}