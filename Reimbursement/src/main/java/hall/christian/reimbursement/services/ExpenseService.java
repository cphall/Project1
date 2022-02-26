package hall.christian.reimbursement.services;

import hall.christian.reimbursement.ReimbursementApplication;
import hall.christian.reimbursement.dao.ExpenseDatabase;
import hall.christian.reimbursement.dto.ExpenseDto;
import hall.christian.reimbursement.models.Expense;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    ExpenseDatabase expenseDatabase;
    static final Logger logger = LoggerFactory.getLogger(ReimbursementApplication.class);

    public ExpenseService(){

    }

    @Autowired
    public ExpenseService(ExpenseDatabase expenseDatabase) {
        this.expenseDatabase = expenseDatabase;
    }
    /**
     * This method takes a employee id to return all expenses from the database for that employee
     * @author Christian Hall
     * @param id employee id
     * @return returns expense object containing all relevant expenses
     */
    public ExpenseDto getExpByEmployee(Integer id) {
        logger.info("getExpByEmployee() invoked.");
        List<Expense> expenseList = expenseDatabase.getExpenseByEmployee_Id(id);
        logger.info("Mapping and returning list of expense objects by employee from database.");
        List<ExpenseDto> expenseDtoList = expenseList.stream().map(e -> new ExpenseDto(e.getId(), e.getEmployee(), e.getManager(), e.getExpenseDate(), e.getDescription(), e.getCategory(), e.getCost(), e.getStatus())).collect(Collectors.toList());
        return new ExpenseDto(expenseDtoList);
    }

    /**
     * This method takes a manager id to return all expenses from the database
     * @author Christian Hall
     * @param id manager id
     * @return returns expense object containing all expenses
     */
    public ExpenseDto getAllExp(Integer id) {
        logger.info("getAllExp() invoked.");
        List<Expense> expenseList = expenseDatabase.getExpensesByManager_Id(id);
        logger.info("Mapping and returning list of all expense objects from database.");
        List<ExpenseDto> expenseDtoList = expenseList.stream().map(e -> new ExpenseDto(e.getId(), e.getEmployee(), e.getManager(), e.getExpenseDate(), e.getDescription(), e.getCategory(), e.getCost(), e.getStatus())).collect(Collectors.toList());
        return new ExpenseDto(expenseDtoList);
    }
}
