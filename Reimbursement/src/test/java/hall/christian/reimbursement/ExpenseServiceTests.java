package hall.christian.reimbursement;

import hall.christian.reimbursement.dao.EmployeeDatabase;
import hall.christian.reimbursement.dao.ExpenseDatabase;
import hall.christian.reimbursement.dto.ExpenseDto;
import hall.christian.reimbursement.models.Employee;
import hall.christian.reimbursement.models.Expense;
import hall.christian.reimbursement.services.EmployeeService;
import hall.christian.reimbursement.services.ExpenseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExpenseServiceTests {
    private ExpenseService expenseService;
    private ExpenseDatabase expDatabase;

    @BeforeEach
    void initBeforeTests(){
        expDatabase = mock(ExpenseDatabase.class);
        expenseService = new ExpenseService(expDatabase);
    }

    @Test
    void returnExpenseByEmployee(){
        List<Expense> listExp = new ArrayList<>();
        when(expDatabase.getExpenseByEmployee_Id(1)).thenReturn(Collections.emptyList());
        ExpenseDto temp = expenseService.getExpByEmployee(1);
        assertTrue(temp.getExpenses().isEmpty());
    }

    @Test
    void returnExpenseByManager(){
        List<Expense> listExp = new ArrayList<>();
        when(expDatabase.getExpensesByManager_Id(1)).thenReturn(Collections.emptyList());
        ExpenseDto temp = expenseService.getAllExp(1);
        assertTrue(temp.getExpenses().isEmpty());
    }

}
