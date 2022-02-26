package hall.christian.email;

import hall.christian.email.controllers.EmailController;
import hall.christian.email.models.Mail;
import hall.christian.email.service.EmailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.*;

@WebMvcTest(EmailController.class)
public class EmailControllerTests {
    @MockBean
    private EmailServiceImpl emailService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnMail(){
        /*Mail email = new Mail("pwnfest7@gmail.com", "christianphall@gmail.com","Test","This is a test");
        when(emailService.send(email))
        mockMvc.perform(MockMvcRequestBuilders.get("exact mapping", id)).andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(id))*/

        //jsonPath for id needs to be mapped properly in controller for this to work.
    }
}
