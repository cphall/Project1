package hall.christian.reimbursement.dto;

import hall.christian.reimbursement.models.Employee;
import hall.christian.reimbursement.models.Expense;
import hall.christian.reimbursement.models.Manager;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class ExpenseDto {

    private Integer id;
    private BigDecimal cost;
    private String category;
    private String description;
    private String expenseDate;
    private Manager manager;
    private Employee employee;
    private String status;

    List<ExpenseDto> expenses;

    public ExpenseDto(){

    }

    public ExpenseDto(Integer id, Employee employee, Manager manager, String expenseDate, String description, String category, BigDecimal cost, String status) {
        this.id = id;
        this.employee = employee;
        this.manager = manager;
        this.expenseDate = expenseDate;
        this.description = description;
        this.category = category;
        this.cost = cost;
        this.status = status;
    }

    public ExpenseDto(List<ExpenseDto> expenseList){
        this.expenses = expenseList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ExpenseDto> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<ExpenseDto> expenses) {
        this.expenses = expenses;
    }
}
