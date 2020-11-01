package model;

public class EPS extends Patient{
	
	private String epsName;
	private int orderNumber;
	
	public EPS(String name, String lastName, int age, String id, String epsName, int orderNumber){
		super(name, lastName, age, id);
		this.epsName = epsName;
		this.orderNumber = orderNumber;
	}
	
	public String getEpsName(){
		return epsName;
	}
	
	public void setEpsName(String epsName){
		this.epsName = epsName;
	}
	
	public int getOrderNumber(){
		return orderNumber;
	}
	
	public void setOrderNumber(int orderNumber){
		this.orderNumber = orderNumber;
	}	
	
	public String toString() {
		return "\n***************************************" +
				"\nNombre: " +getName()+ "\nApellido: " +getLastName()+ "\nEdad: " +getAge()+ "\nID: " +getId()+ "\nEPS: " +epsName+ "\nN. Orden: " +orderNumber+
				"\n***************************************";
	}
}