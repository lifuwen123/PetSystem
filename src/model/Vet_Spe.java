package model;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李
 * @Date: 2021/11/30/21:37
 * @Description:
 */
public class Vet_Spe {
    private String sname;
    private String vname;
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    @Override
    public String toString() {
        return "Vet_Spe{" +
                "sname='" + sname + '\'' +
                ", vname='" + vname + '\'' +
                '}';
    }
}
