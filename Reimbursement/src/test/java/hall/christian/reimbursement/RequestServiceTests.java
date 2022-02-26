package hall.christian.reimbursement;

import hall.christian.reimbursement.dao.EmployeeDatabase;
import hall.christian.reimbursement.dao.RequestDatabase;
import hall.christian.reimbursement.dto.RequestDto;
import hall.christian.reimbursement.models.Request;
import hall.christian.reimbursement.services.RequestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RequestServiceTests {

    private RequestService requestService;
    private RequestDatabase requestDatabase;
    private EmployeeDatabase employeeDatabase;

    @BeforeEach
    void initBeforeTests(){
        requestDatabase = mock(RequestDatabase.class);
        employeeDatabase = mock(EmployeeDatabase.class);
        requestService = new RequestService(requestDatabase, employeeDatabase);
    }

    @Test
    void returnRequestsByEmployee(){
        List<Request> listExp = new ArrayList<>();
        when(requestDatabase.getRequestsByEmail("test@gmail.com")).thenReturn(Collections.emptyList());
        RequestDto temp = requestService.getAllRequests("test@gmail.com");
        assertTrue(temp.getRequests().isEmpty());
    }
}
