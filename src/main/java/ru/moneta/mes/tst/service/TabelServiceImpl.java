package ru.moneta.mes.tst.service;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 */

//import org.springframework.security.access.annotation.Secured;
import ru.moneta.mes.tst.model.Tabel;
import ru.moneta.mes.tst.model.Worker;
import ru.moneta.mes.tst.persistence.TabelDAO;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named //@Service
public class TabelServiceImpl implements TabelService {

    @Inject //@Autowired
    private TabelDAO tabelDAO;

    public List<Tabel> getTabelForWorker(Worker worker) {
        return tabelDAO.getTabelForWorker(worker);
    }

    public void addTabel(Tabel tabel) {
        tabelDAO.addTabel(tabel);
    }

    public List<Tabel> listTabel() {
        return tabelDAO.listTabel();
    }

    public void deleteTabel(Long id) {
        tabelDAO.deleteTabel(id);
    }

    public void updateTabel(Tabel tabel) {tabelDAO.updateTabel(tabel);}

    public Tabel getTabelById(Long id) {
        return tabelDAO.getTabelById(id);
    }
}
