package hall.christian.reimbursement.services;

import hall.christian.reimbursement.ReimbursementApplication;
import hall.christian.reimbursement.dao.EmployeeDatabase;
import hall.christian.reimbursement.dao.RequestDatabase;
import hall.christian.reimbursement.dto.ExpenseDto;
import hall.christian.reimbursement.dto.RequestDto;
import hall.christian.reimbursement.models.Employee;
import hall.christian.reimbursement.models.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestService {

    RequestDatabase requestDatabase;
    EmployeeDatabase employeeDatabase;
    static final Logger logger = LoggerFactory.getLogger(ReimbursementApplication.class);

    @Autowired
    public RequestService(RequestDatabase requestDatabase, EmployeeDatabase employeeDatabase){
        this.requestDatabase = requestDatabase;
        this.employeeDatabase = employeeDatabase;
    }

    /**
     * This method takes an employee email to return all requests from the database for that employee
     * @author Christian Hall
     * @param email employee email address
     * @return returns list of request objects containing all relevant requests for that user
     */
    public RequestDto getAllRequests(String email) {
        logger.info("getAllRequests() invoked.");
        List<Request> requests = requestDatabase.getRequestsByEmail(email);

        List<RequestDto> requestDtoList = requests.stream().map(r -> new RequestDto(r.getId(), employeeDatabase.getByEmail(r.getEmail()), employeeDatabase.getByEmail(r.getEmail()).getManager(), r.getCost(), r.getStatus(), r.getExpenseDate())).collect(Collectors.toList());
        logger.info("Requests gathered based on employee email. Returning list of requests from database.");
        return new RequestDto(requestDtoList);
    }

    /**
     * This method takes an employee request form in the shape of a RequestDto and saves it to database
     * @author Christian Hall
     * @param request employee request form
     */
    public void createRequest(RequestDto request) {
        logger.info("createRequest() invoked.");
        Employee emp = employeeDatabase.getByEmail(request.getEmail());
        logger.info("Saving request to database...");
        requestDatabase.save(new Request(request, emp.getEmail(), request.getCost(), request.getStatus(), request.getExpenseDate()));
    }
}
