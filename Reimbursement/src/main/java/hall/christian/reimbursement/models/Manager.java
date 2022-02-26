package hall.christian.reimbursement.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Column(name = "password", length = 40)
    private String password;

    @Column(name = "name", length = 40)
    private String name;

    @Column(name = "department", length = 20)
    private String department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public Manager(){

    }

    public Manager(Integer id, String email, String password, String name, String department, Role role){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.department = department;
        this.role = role;
    }

    public Manager(String email, String password, String name, String department) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role roles) {
        this.role = roles;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}