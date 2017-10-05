package ru.moneta.mes.tst.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.moneta.mes.tst.model.Tabel;
import ru.moneta.mes.tst.model.Worker;

import javax.inject.Inject;
import java.util.List;

@Repository
public class TabelHibernateDAOImpl implements TabelDAO {
    private SessionFactory sessionFactory;

    @Inject
    public TabelHibernateDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession () {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public Tabel getTabelById(Long id) {
        return (Tabel) currentSession().get(Tabel.class, id);
    }

    @Transactional
    public List<Tabel> getTabelForWorker(Worker w) {
        return currentSession().createQuery("from Tabel t where t.worker.id = :workerId order by t.d")
                .setLong("workerId", w.getId())
                .list();
    }

    @Transactional
    public void addTabel (Tabel tabel) {
        currentSession().save(tabel);
    }

    @Transactional
    public List<Tabel> listTabel() {
        return currentSession().createQuery("from Tabel").list();
    }

    /*@Transactional
    public List<Tabel> selectTabel(String val) {
        return currentSession().createQuery("from Tabel where fam like '%"+val+"%'").list();
    }
*/
    @Transactional
    public void deleteTabel(Long id) {
        currentSession().delete(getTabelById(id));
    }

    @Transactional
    public void updateTabel(Tabel tabel) {
        currentSession().saveOrUpdate(tabel);
    }

}
