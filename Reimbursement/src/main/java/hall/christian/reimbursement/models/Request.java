package hall.christian.reimbursement.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hall.christian.reimbursement.dto.RequestDto;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", length = 40)
    private String email;

    @Column(name = "expense_date", length = 40)
    private String expenseDate;

    @Column(name = "cost", precision = 131089)
    private BigDecimal cost;

    @Column(name = "status", length = 20)
    private String status;

    public Request(){

    }

    public Request(Integer id, String email, BigDecimal cost, String status){
        this.id = id;
        this.email = email;
        this.cost = cost;
        this.status = status;
    }

    public Request(RequestDto request, String email, BigDecimal cost, String status, String expenseDate) {
        this.email = email;
        this.cost = request.getCost();
        this.status = request.getStatus();
        this.expenseDate = request.getExpenseDate();
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

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
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
}