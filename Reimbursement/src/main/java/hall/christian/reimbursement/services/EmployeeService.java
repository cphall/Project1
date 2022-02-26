package hall.christian.reimbursement.services;

import hall.christian.reimbursement.dao.EmployeeDatabase;
import hall.christian.reimbursement.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeDatabase employeeDatabase;

    @Autowired
    public EmployeeService(EmployeeDatabase employeeDatabase){
        this.employeeDatabase = employeeDatabase;
    }

    public Employee getEmployee(Integer id){
        return employeeDatabase.getById(id);
    }
}
