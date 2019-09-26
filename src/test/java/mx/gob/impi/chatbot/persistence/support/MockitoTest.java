package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import mx.gob.impi.chatbot.persistence.api.model.domain.User;
import mx.gob.impi.chatbot.persistence.api.service.UserService;

@RunWith(SpringRunner.class)
public class MockitoTest {
    @MockBean
    private UserService userService;
    
    @Before
    public void setUp() {
        User gus = new User("goose", "xyz", "gus@hotmail.com");
        Mockito.when(userService.findUserByName("goose"))
          .thenReturn(gus);
    }
    
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        User user = userService.findUserByName("goose");
        // and
        User tavo = new User("goose", "xyz", "gus@aol.com");
        // when
        String password = user.getPassword();
        // then
        assertTrue("Error al comprobar el password", tavo.getPassword().equals(password));
        // and
        assertFalse("Error al comprobar el password", !tavo.getPassword().equals(password));
    }

}
