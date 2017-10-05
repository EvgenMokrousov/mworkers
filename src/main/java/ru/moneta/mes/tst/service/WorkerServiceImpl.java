package ru.moneta.mes.tst.service;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 */
import javax.inject.Inject;
import javax.inject.Named;

import ru.moneta.mes.tst.model.Worker;
import ru.moneta.mes.tst.persistence.WorkerDAO;

import java.sql.Date;
import java.util.List;

@Named //@Service
public class WorkerServiceImpl implements WorkerService {

    @Inject //@Autowired
    private WorkerDAO workerDAO;

    public void addWorker (Worker worker) {
        workerDAO.addWorker(worker);
    }

    public void updateWorker (Worker worker) {workerDAO.updateWorker(worker);}

    public List<Worker> listWorker() {
        return workerDAO.listWorker();
    }

    public List<Worker> selectWorker(String val) {
        return workerDAO.selectWorker(val);
    }

    public List<Object[]> selectWorker2(String val, Date d) {
        return workerDAO.selectWorker2(val, d);
    }

    public void deleteWorker(Long id) {
        workerDAO.deleteWorker(id);
    }

    public Worker getWorkerById(Long id) {
        return workerDAO.getWorkerById(id);
    }
}
