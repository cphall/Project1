package hall.christian.reimbursement.controllers;

import hall.christian.reimbursement.ReimbursementApplication;
import hall.christian.reimbursement.dto.ExpenseDto;
import hall.christian.reimbursement.services.ExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("expense")
public class ExpenseController {

    private ExpenseService expenseService;
    static final Logger logger = LoggerFactory.getLogger(ReimbursementApplication.class);

    @Autowired
    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    public ExpenseController(){

    }

    /**
     * This method is mapped to a get request to retrieve all expenses based on the employee id provided
     * @author Christian Hall
     * @param id Employee id
     * @return ResponseEntity of all expenses of supplied employee id
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "getExpByEmployee/{id}")
    public ResponseEntity<List<ExpenseDto>> getExpByEmployee(@PathVariable Integer id){
        logger.info("Get Request for ExpByEmployee received.");
        ExpenseDto employeeExpenses = expenseService.getExpByEmployee(id);
        logger.info("Returning employee expenses.");
        return ResponseEntity.ok(employeeExpenses.getExpenses());
    }

    /**
     * This method is mapped to a get request to retrieve all expenses based on provided manager id
     * @author Christian Hall
     * @param id manager id
     * @return ResponseEntity of all expenses that manager is assigned to
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "getAllExp/{id}")
    public ResponseEntity<List<ExpenseDto>> getAllExp(@PathVariable Integer id){
        logger.info("Get Request for allExpenses received.");
        ExpenseDto allExpenses = expenseService.getAllExp(id);
        logger.info("Returning all expenses");
        return ResponseEntity.ok(allExpenses.getExpenses());
    }
}
