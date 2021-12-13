package model;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Date;
public class Pets {
	private int id;
	private String name;
    private Date birth_date;
	private String type;
	//宠物所有人名字
	private String oname;

    public String getType() {
        return type;
    }

    public String getOname() {
        return oname;
    }



    public void setOname(String oname) {
        this.oname = oname;
    }

    public void setType(String type) {
        this.type = type;
    }
    private int owner_id;
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setBirth_date(Date birth_date){
		this.birth_date = birth_date;
	}
    @JsonFormat(pattern="yyyy-MM-dd")
	public Date getBirth_date(){
		return birth_date;
	}
	public void setOwner_id(int owner_id){
		this.owner_id = owner_id;
	}
	public int getOwner_id(){
		return owner_id;
	}
    @Override
    public String toString() {
        return "Pets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth_date=" + birth_date +
                ", type='" + type + '\'' +
                ", oname='" + oname + '\'' +
                ", owner_id=" + owner_id +
                '}';
    }
}
