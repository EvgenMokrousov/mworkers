package ru.moneta.mes.tst.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.moneta.mes.tst.model.Worker;

import java.sql.Date;
import java.util.List;

@Repository
public class WorkerHibernateDAOImpl implements WorkerDAO {
    private SessionFactory sessionFactory;

    @Inject
    public WorkerHibernateDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession () {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public Worker getWorkerById(Long id) {
        return (Worker) currentSession().get(Worker.class, id);
    }

    @Transactional
    public void addWorker (Worker worker) {
        currentSession().save(worker);
    }

    @Transactional
    public void updateWorker (Worker worker) {
        currentSession().saveOrUpdate(worker);
    }

    @Transactional
    public List<Worker> listWorker() {
        return currentSession().createQuery("from Worker").list();
    }

    @Transactional
    public List<Worker> selectWorker(String val) {
        return currentSession().createQuery("from Worker where fam like :fam ")
                .setParameter("fam", "%" + val + "%")
                .list();
    }

    @Transactional
    public List<Object[]> selectWorker2(String val, Date d) {
        return currentSession().createQuery("select w.fam, w.imj, w.otch, t.d_type " +
                "from Worker w, Tabel t where w = t.worker and fam like :fam and d = :d ")
                .setParameter("fam", "%" + val + "%")
                .setParameter("d", d)
                .list();
    }

    @Transactional
    public void deleteWorker(Long id) {
        currentSession().delete(getWorkerById(id));
    }

}
