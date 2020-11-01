package model;

public class Prepagada extends Patient{
	
	private int affiliationNumber;
	private String entityName;
	private int entityNumber;
	
	public Prepagada(String name, String lastName, int age, String id, int affiliationNumber, String entityName, int entityNumber){
		super(name, lastName, age, id);
		this.affiliationNumber = affiliationNumber;
		this.entityName = entityName;
		this.entityNumber = entityNumber;
	}
	
	public int getAffiliationNumber(){
		return affiliationNumber;
	}
	
	public void setAffiliationNumber(int affiliationNumber){
		this.affiliationNumber = affiliationNumber;
	}
	
	public String getEntityName(){
		return entityName;
	}
	
	public void setEntityName(String entityName){
		this.entityName = entityName;
	}
	
	public int getEntityNumber(){
		return entityNumber;
	}
	
	public void setEntityNumber(int entityNumber){
		this.entityNumber = entityNumber;
	}
	
	public String toString() {
		return "\n***************************************" +
				"\nNombre: " +getName()+ "\nApellido: " +getLastName()+ "\nEdad: " +getAge()+ "\nID: " +getId()+ "\nEntidad: " +entityName+ "\nN. de afiliacion: " +affiliationNumber+ "\nTelefono de la entidad: " +entityNumber+
				"\n***************************************";
	}
}