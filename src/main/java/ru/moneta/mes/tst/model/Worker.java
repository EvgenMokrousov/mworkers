package ru.moneta.mes.tst.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name="workers")
public class Worker {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Size(min=1, max=20, message="Username must be between 1 and 20 characters long.")
    @Pattern(regexp="^[a-zA-Zа-яА-Я]+$", message="Username must be alphanumeric with no spaces")
    @Column(name = "fam")
    private String fam;

    @Size(min=1, max=20, message="Username must be between 1 and 20 characters long.")
    @Column(name = "imj")
    private String imj;

    @Column(name = "otch")
    private String otch;

    @Column(name = "dbirth")
    private Date dbirth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getImj() {
        return imj;
    }

    public void setImj(String imj) {
        this.imj = imj;
    }

    public String getOtch() {
        return otch;
    }

    public void setOtch(String otch) {
        this.otch = otch;
    }

    public Date getDbirth() {
        return dbirth;
    }

    public void setDbirth(Date dbirth) {
        this.dbirth = dbirth;
    }
}
