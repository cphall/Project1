package hall.christian.reimbursement.dao;

import hall.christian.reimbursement.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseDatabase extends JpaRepository<Expense, Integer> {
    public List<Expense> getExpenseByEmployee_Id(Integer id);
    public List<Expense> getExpensesByManager_Id(Integer id);
}
