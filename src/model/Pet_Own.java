package model;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李
 * @Date: 2021/11/30/21:37
 * @Description:
 */
public class Pet_Own {
    private String pname;
    private String oname;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    @Override
    public String toString() {
        return "Pet_Own{" +
                "pname='" + pname + '\'' +
                ", oname='" + oname + '\'' +
                '}';
    }
}
