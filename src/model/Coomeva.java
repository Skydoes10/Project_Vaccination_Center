package model;

public class Coomeva extends Prepagada{
	private Category category;
	
	public Coomeva(String name, String lastName, int age, String id, int affiliationNumber, String entityName, int entityNumber, Category category){
		super(name, lastName, age, id, affiliationNumber, entityName, entityNumber);
		this.category = category;
	}
	
	public Category getCategory(){
		return category;
	}
	
	public void setCategory(Category category){
		this.category = category;
	}
	
	public String toString() {
		return "\n***************************************" +
				"\nNombre: " +getName()+ "\nApellido: " +getLastName()+ "\nEdad: " +getAge()+ "\nID: " +getId()+ "\nEntidad: COOMEVA \nCategoria: " +category+
				"\n***************************************";
	}
}