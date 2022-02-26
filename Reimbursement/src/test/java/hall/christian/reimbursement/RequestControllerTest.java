package hall.christian.reimbursement;

import hall.christian.reimbursement.controllers.RequestController;
import hall.christian.reimbursement.dao.EmployeeDatabase;
import hall.christian.reimbursement.dao.RequestDatabase;
import hall.christian.reimbursement.dto.RequestDto;
import hall.christian.reimbursement.services.RequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;

import static org.mockito.Mockito.when;

@WebMvcTest(RequestController.class)
public class RequestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    String email = "christianphall@gmail.com";

    @MockBean
    private RequestService requestService;

    @MockBean
    private RestTemplate restTemplate;

    @MockBean
    private EmployeeDatabase employeeDatabase;

    @Test
    void getAllRequests() throws Exception{
        when(requestService.getAllRequests(email)).thenReturn(new RequestDto(Collections.singletonList(new RequestDto())));
        mockMvc.perform(get("http://localhost:8080/request/getAllRequests/christianphall@gmail.com")).andExpect(status().isOk());
    }

    @Test
    void shouldThrowClientError() throws Exception{
        requestService.createRequest(any());
        mockMvc.perform(post("/createRequest").contentType("application/json").content("{\"username\": \"pwnfest7@gmail.com\", \"cost\": \"200.00\",\"status\": \"Requested\", \"expenseDate\": \"2/18/2022\"}")).andExpect(status().is4xxClientError());
    }
}
