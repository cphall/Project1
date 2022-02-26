package hall.christian.reimbursement;

import hall.christian.reimbursement.dao.ManagerDatabase;
import hall.christian.reimbursement.models.Manager;
import hall.christian.reimbursement.services.ManagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ManagerServiceTests {
    private ManagerService managerService;
    private ManagerDatabase managerDatabase;

    @BeforeEach
    void initBeforeTests(){
        managerDatabase = mock(ManagerDatabase.class);
        managerService = new ManagerService(managerDatabase);
    }

    @Test
    void returnEmployeeById(){
        Manager manager = new Manager("test", "test", "mister manager","engineering");
        when(managerDatabase.getById(1)).thenReturn(manager);
        Manager temp = managerService.getManagerByID(1);
        assertEquals(managerService.getManagerByID(1),temp);
    }
}
