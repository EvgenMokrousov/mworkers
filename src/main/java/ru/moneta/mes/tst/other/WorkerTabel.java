package ru.moneta.mes.tst.other;
/**
 * класс-структура для запроса
 */
import java.util.Date;

public class WorkerTabel {
    public String fam;
    public String imj;
    public String otch;
    public Date dbirth;
    public Date d;
    public String d_type;

    public WorkerTabel() {
    }

    public WorkerTabel(String fam, String d_type) {
        this.fam = fam;
        this.d_type = d_type;
    }

    public WorkerTabel(String fam, String imj, String otch, String d_type) {
        this.fam = fam;
        this.imj = imj;
        this.otch = otch;
        this.d_type = d_type;
    }

    public WorkerTabel(String fam, String imj, String otch, Date dbirth, Date d, String d_type) {
        this.fam = fam;
        this.imj = imj;
        this.otch = otch;
        this.dbirth = dbirth;
        this.d = d;
        this.d_type = d_type;
    }

    public String toMyString() {
        return this.fam + " " + this.imj + " " + this.otch + " " + this.d_type;
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
}
