package ru.moneta.mes.tst.service;

import ru.moneta.mes.tst.model.Worker;

import java.sql.Date;
import java.util.List;

public interface WorkerService {
    void addWorker(Worker worker);

    void updateWorker (Worker worker);

    List<Worker> listWorker();

    List<Worker> selectWorker(String val);

    List<Object[]> selectWorker2(String val, Date d);

    void deleteWorker(Long id);
    
    Worker getWorkerById(Long id);

}
