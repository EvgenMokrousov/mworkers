package ru.moneta.mes.tst.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="tabel")
public class Tabel {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "d")
    private Date d;

    @Column(name = "d_type")
    private String d_type;

    @ManyToOne
    @JoinColumn(name="worker_id")
    private Worker worker;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public String getD_type() {
        return d_type;
    }

    public void setD_type(String d_type) {
        this.d_type = d_type;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
//public String[] getDayTypes() {return DayTypes;}


}
