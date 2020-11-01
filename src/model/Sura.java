package model;

public class Sura extends Prepagada{
	
	private int minimunRank;
	private int maxRank;
	
	public Sura(String name, String lastName, int age, String id, int affiliationNumber, String entityName, int entityNumber, int minimunRank, int maxRank){
		super(name, lastName, age, id, affiliationNumber, entityName, entityNumber);
		this.minimunRank = minimunRank;
		this.maxRank = maxRank;
	}
	
	public int getMinimunRank(){
		return minimunRank;
	}
	
	public void setMinimunRank(int minimunRank){
		this.minimunRank = minimunRank;
	}
	
	public int getMaxRank(){
		return maxRank;
	}
	
	public void setMaxRank(int maxRank){
		this.maxRank = maxRank;
	}
	
	public String toString() {
		return "\n***************************************" +
				"\nNombre: " +getName()+ "\nApellido: " +getLastName()+ "\nEdad: " +getAge()+ "\nID: " +getId()+ "\nEntidad: SURA \nPoliza: Minima: " +minimunRank+ " Maxima: " +maxRank+
				"\n***************************************";
	}
}