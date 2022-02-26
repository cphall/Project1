package hall.christian.reimbursement.services;

import hall.christian.reimbursement.dao.ManagerDatabase;
import hall.christian.reimbursement.models.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    private final ManagerDatabase managerDatabase;

    @Autowired
    public ManagerService(ManagerDatabase managerDatabase) {
        this.managerDatabase = managerDatabase;
    }

    public Manager getManagerByID(Integer id){
        return managerDatabase.getById(id);
    }
}
