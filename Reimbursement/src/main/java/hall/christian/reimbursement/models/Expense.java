package hall.christian.reimbursement.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @Column(name = "expense_date", length = 40)
    private String expenseDate;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "category", length = 20)
    private String category;

    @Column(name = "cost", precision = 131089)
    private BigDecimal cost;

    @Column(name = "status", length = 20)
    private String status;

    public Expense(){

    }

    public Expense(Integer id, Employee employee, Manager manager, String expenseDate, String description, String category, BigDecimal cost, String status) {
        this.id = id;
        this.employee = employee;
        this.manager = manager;
        this.expenseDate = expenseDate;
        this.description = description;
        this.category = category;
        this.cost = cost;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public void setManager(Manager managers) {
        this.manager = managers;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employees) {
        this.employee = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}