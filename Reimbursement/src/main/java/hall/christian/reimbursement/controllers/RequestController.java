package hall.christian.reimbursement.controllers;

import hall.christian.reimbursement.ReimbursementApplication;
import hall.christian.reimbursement.dao.EmployeeDatabase;
import hall.christian.reimbursement.dto.RequestDto;
import hall.christian.reimbursement.models.Employee;
import hall.christian.reimbursement.services.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("request")
public class RequestController {

    @Value("${api.config.api2-url:http://localhost:8081/email}")
    String api2Url;

    private RequestService requestService;
    private EmployeeDatabase employeeDatabase;
    static final Logger logger = LoggerFactory.getLogger(ReimbursementApplication.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    public RequestController(RequestService requestService, EmployeeDatabase employeeDatabase){
        this.requestService = requestService;
        this.employeeDatabase = employeeDatabase;
    }

    public RequestController(){}

    /**
     * This method is mapped to a get request and takes an employee email to return list of requests from database
     * @author Christian Hall
     * @param email employee email address
     * @return returns list of request objects containing all relevant requests for that user
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path="getAllRequests/{email}")
    public ResponseEntity<List<RequestDto>> getAllRequests(@PathVariable String email){
        logger.info("Received request for getting all user requests");
        RequestDto requests = requestService.getAllRequests(email);
        return ResponseEntity.ok(requests.getRequests());
    }

    /**
     * This method is mapped to a post request and takes an employee request json object and emails them on submission
     * @author Christian Hall
     * @param request employee request object in the form of a json
     * @return returns no content 204 and sends email to user confirming request submission
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path="createRequest")
    public ResponseEntity<?> createRequest(@RequestBody RequestDto request) throws URISyntaxException {
        logger.info("Received post for create request");
        //send our message to email api
        List<String> emailMessage = new ArrayList<String>();
        emailMessage.add(request.getEmail());
        emailMessage.add("Expense Request Submitted");
        emailMessage.add("Thanks for submitting your expense! Your department manager will review this request shortly.");
        logger.info("Request successful. Sending message to email API...");
        ResponseEntity resp = restTemplate.postForEntity(api2Url, emailMessage, null);
        requestService.createRequest(request);
        if (resp.getStatusCode().is5xxServerError())
        {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.noContent().build();
    }
}
