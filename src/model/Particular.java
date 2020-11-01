package model;

public class Particular extends Patient{
	
	private String phone;
	private String doctorName;
	private String doctorPhone;
	private String license;
	
	public Particular(String name, String lastName, int age, String id, String phone, String doctorName, String doctorPhone, String license){
		super(name, lastName, age, id);
		this.phone = phone;
		this.doctorName = doctorName;
		this.doctorPhone = doctorPhone;
		this.license = license;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public String getDoctorName(){
		return doctorName;
	}
	
	public void setDoctorName(String doctorName){
		this.doctorName = doctorName;
	}
	
	public String getDoctorPhone(){
		return doctorPhone;
	}
	
	public void setDoctorPhone(String doctorPhone){
		this.doctorPhone = doctorPhone;
	}
	
	public String getLicense(){
		return license;
	}
	
	public void setLicense(String license){
		this.license = license;
	}
	
	public String toString() {
		return "\n***************************************" +
				"\nNombre: " +getName()+ "\nApellido: " +getLastName()+ "\nEdad: " +getAge()+ "\nID: " +getId()+ "\nContacto: " +phone+ "\nDoctor: " +doctorName+ "\nTelefono del doctor: " +doctorPhone+ "\nLicencia: " +license+
				"\n***************************************";
	}
}