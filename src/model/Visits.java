package model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
public class Visits {
	private int id;
	private int pet_id;
    @JsonFormat(pattern = "yyyy-MM-dd")
	private Date visit_date;
	private String description;
	private String state;
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setPet_id(int pet_id){
		this.pet_id = pet_id;
	}
	public int getPet_id(){
		return pet_id;
	}
	public void setVisit_date(Date visit_date){
		this.visit_date = visit_date;
	}
	public Date getVisit_date(){
		return visit_date;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}

    @Override
    public String toString() {
        return "Visits{" +
                "id=" + id +
                ", pet_id=" + pet_id +
                ", visit_date=" + visit_date +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
