package hall.christian.reimbursement.dao;

import hall.christian.reimbursement.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDatabase extends JpaRepository<Employee, Integer> {
    public Employee getByEmail(String email);
}
