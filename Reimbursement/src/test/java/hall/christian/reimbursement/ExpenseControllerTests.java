package hall.christian.reimbursement;

import hall.christian.reimbursement.controllers.ExpenseController;
import hall.christian.reimbursement.controllers.RequestController;
import hall.christian.reimbursement.dao.EmployeeDatabase;
import hall.christian.reimbursement.dto.ExpenseDto;
import hall.christian.reimbursement.dto.RequestDto;
import hall.christian.reimbursement.services.ExpenseService;
import hall.christian.reimbursement.services.RequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExpenseController.class)
public class ExpenseControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpenseService expenseService;

    @MockBean
    private RestTemplateBuilder restTemplateBuilder;

    @Test
    void getAllRequests() throws Exception{
        when(expenseService.getAllExp(1)).thenReturn(new ExpenseDto(Collections.singletonList(new ExpenseDto())));
        mockMvc.perform(get("http://localhost:8080/expense/getAllExp/1")).andExpect(status().isOk());
    }

    @Test
    void getByEmployee()throws Exception{
        when(expenseService.getExpByEmployee(1)).thenReturn(new ExpenseDto(Collections.singletonList(new ExpenseDto())));
        mockMvc.perform(get("http://localhost:8080/expense/getExpByEmployee/1")).andExpect(status().isOk());
    }
}
