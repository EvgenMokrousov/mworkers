package ru.moneta.mes.tst.service;

import ru.moneta.mes.tst.model.Tabel;
import ru.moneta.mes.tst.model.Worker;

import java.util.List;

public interface TabelService {
    List<Tabel> getTabelForWorker(Worker worker);

    void addTabel(Tabel tabel);

    List<Tabel> listTabel();

    //List<Tabel> selectTabel(String val);

    void deleteTabel(Long id);

    void updateTabel(Tabel tabel);

    Tabel getTabelById(Long id);

}
