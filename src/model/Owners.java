package model;
public class Owners {
	private int id;
	private String name;
	private String address;
	private String city;
	private String telephone;
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
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}
	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return city;
	}
	public void setTelephone(String telephone){
		this.telephone = telephone;
	}
	public String getTelephone(){
		return telephone;
	}

    @Override
    public String toString() {
        return "Owners{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
