package hall.christian.reimbursement.dao;

import hall.christian.reimbursement.dto.RequestDto;
import hall.christian.reimbursement.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestDatabase extends JpaRepository<Request, Integer> {
    public List<Request> getRequestsByEmail(String email);
}
