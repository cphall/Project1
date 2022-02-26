package hall.christian.reimbursement;

import hall.christian.reimbursement.dao.EmployeeDatabase;
import hall.christian.reimbursement.models.Employee;
import hall.christian.reimbursement.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeServiceTests {

    private EmployeeService employeeService;
    private EmployeeDatabase employeeDatabase;

    @BeforeEach
    void initBeforeTests(){
        employeeDatabase = mock(EmployeeDatabase.class);
        employeeService = new EmployeeService(employeeDatabase);
    }

    @Test
    void returnEmployeeById(){
        Employee emp = new Employee("test", "test", "tester mctesterman","engineering");
        when(employeeDatabase.getById(1)).thenReturn(emp);
        Employee temp = employeeService.getEmployee(1);
        assertEquals(employeeService.getEmployee(1),temp);
    }
}
