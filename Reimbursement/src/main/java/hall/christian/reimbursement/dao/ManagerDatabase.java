package hall.christian.reimbursement.dao;

import hall.christian.reimbursement.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerDatabase extends JpaRepository<Manager, Integer> {

}
