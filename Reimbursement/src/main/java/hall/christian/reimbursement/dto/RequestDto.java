package hall.christian.reimbursement.dto;

import hall.christian.reimbursement.models.Employee;
import hall.christian.reimbursement.models.Manager;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class RequestDto {
    private Integer id;
    private String email;
    private Employee employee;
    private Manager manager;
    private String expenseDate;
    private BigDecimal cost;
    private String status;


    private Integer employeeID;

    private List<RequestDto> requests;

    public RequestDto(){

    }

    public RequestDto(Integer id, Employee employee, Manager manager, BigDecimal cost, String status, String expenseDate){
        this.id = id;
        this.employee = employee;
        this.manager = manager;
        this.cost = cost;
        this.status = status;
        this.expenseDate = expenseDate;
    }

    public RequestDto(String email, BigDecimal cost, String status, String expenseDate){
        this.email = email;
        this.cost = cost;
        this.status = status;
        this.expenseDate = expenseDate;
    }

    public RequestDto(List<RequestDto> requestList) {
        this.requests = requestList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<RequestDto> getRequests() {
        return requests;
    }

    public void setRequests(List<RequestDto> requests) {
        this.requests = requests;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }
}
