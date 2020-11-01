package model;

public class Center{
	private static final int MAX_PATIENT = 300;	
	private String name;
	private String phoneNumber;
	private String emailAddress;
	
	private Patient[] patients;
	
	public Center(String name, String phoneNumber, String emailAddress){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		patients = new Patient[MAX_PATIENT];	
	}
	
	public Patient findPatient(String id){
		Patient objSearch = null;
		boolean findPa = false;
		for(int i = 0; i < MAX_PATIENT && !findPa; i++){
			if(patients[i] != null && patients[i].getId().equalsIgnoreCase(id)){
				objSearch = patients[i];
				findPa = true;
			}
		}
		return objSearch;	
	}
	
	public String addPatient(String name, String lastName, int age, String id, String phone, String doctorName, String doctorPhone, String license){
		String message = "El paciente fue agregado";
		boolean added = false;
		Patient objSearch = findPatient(id);
		if(objSearch == null){
			for(int i = 0; i < MAX_PATIENT && !added; i++){
				if(patients[i] == null){
					patients[i] = new Particular(name, lastName, age, id, phone, doctorName, doctorPhone, license);
					//getAmountPar();
					added = true;
				}
			}
			if (added == false){
				message = "No se puede agregar mas pacientes";
			}
		}
		else{
			message = "El paciente ya existe";
		}
		return message;
	}
	
	public String addPatient(String name, String lastName, int age, String id, String epsName, int orderNumber){
		String message = "El paciente fue agregado";
		boolean added = false;
		Patient objSearch = findPatient(id);
		if(objSearch == null){
			for(int i = 0; i < MAX_PATIENT && !added; i++){
				if(patients[i] == null){
					patients[i] = new EPS(name, lastName, age, id, epsName, orderNumber);
					//getAmountEPS();
					added = true;
				}
			}
			if (added == false){
				message = "No se puede agregar mas pacientes";
			}
		}
		else{
			message = "El paciente ya existe";
		}
		return message;
	}
	
	public String addPatient(String name, String lastName, int age, String id, int affiliationNumber, String entityName, int entityNumber){
		String message = "El paciente fue agregado";
		boolean added = false;
		Patient objSearch = findPatient(id);
		if(objSearch == null){
			for(int i = 0; i < MAX_PATIENT && !added; i++){
				if(patients[i] == null){
					patients[i] = new Prepagada(name, lastName, age, id, affiliationNumber, entityName, entityNumber);
					//getAmountOther();
					added = true;
				}
			}
			if (added == false){
				message = "No se puede agregar mas pacientes";
			}
		}
		else{
			message = "El paciente ya existe";
		}
		return message;
	}
	
	public String addPatient(String name, String lastName, int age, String id, int affiliationNumber, String entityName, int entityNumber, int pCategory){
		String message = "El paciente fue agregado";
		boolean added = false;
		Patient objSearch = findPatient(id);
		if(objSearch == null){
			Category category = null;
			switch(pCategory){
			    case 1: category = Category.PLATINO;
			        break;
			    case 2: category = Category.ORO;
			        break;
			    case 3: category = Category.ORO_PLUS;
			    	break;
			}
			for(int i = 0; i < MAX_PATIENT && !added; i++){
				if(patients[i] == null){
					patients[i] = new Coomeva(name, lastName, age, id, affiliationNumber, entityName, entityNumber, category);
					//getAmountCoomeva();
					added = true;
				}
			}
			if (added == false){
				message = "No se puede agregar mas pacientes";
			}
		}
		else{
			message = "El paciente ya existe";
		}
		return message;
	}
	
	public String addPatient(String name, String lastName, int age, String id, int affiliationNumber, String entityName, int entityNumber, int minimunRank, int maxRank){
		String message = "El paciente fue agregado";
		boolean added = false;
		Patient objSearch = findPatient(id);
		if(objSearch == null){
			for(int i = 0; i < MAX_PATIENT && !added; i++){
				if(patients[i] == null){
					patients[i] = new Sura(name, lastName, age, id, affiliationNumber, entityName, entityNumber, minimunRank, maxRank);
					//getAmountSura();
					added = true;
				}
			}
			if (added == false){
				message = "No se puede agregar mas pacientes";
			}
		}
		else{
			message = "El paciente ya existe";
		}
		return message;
	}
	
	public int getAmountPar() {
		int amountPar = 0;
		for(int i = 0; i < MAX_PATIENT; i++){
			if(patients[i] != null){
				if(patients[i] instanceof Particular) {
					amountPar++;
				}
			}
		}
		return amountPar;
	}
	
	public int getAmountEPS() {
		int amountEPS = 0;
		for(int i = 0; i < MAX_PATIENT; i++){
			if(patients[i] != null){
				if(patients[i] instanceof EPS) {
					amountEPS++;
				}
			}
		}
		return amountEPS;
	}
	
	public int getAmountCoomeva() {
		int amountCoomeva = 0;
		for(int i = 0; i < MAX_PATIENT; i++){
			if(patients[i] != null){
				if(patients[i] instanceof Coomeva) {
					amountCoomeva++;
				}
			}
		}
		return amountCoomeva;
	}
	
	public int getAmountSura() {
		int amountSura = 0;
		for(int i = 0; i < MAX_PATIENT; i++){
			if(patients[i] != null){
				if(patients[i] instanceof Sura) {
					amountSura++;
				}
			}
		}
		return amountSura;
	}
	
	public int getAmountOther() {
		int amountOther = 0;
		for(int i = 0; i < MAX_PATIENT; i++){
			if(patients[i] != null){
				if(patients[i] instanceof Prepagada) {
					if(!(patients[i] instanceof Coomeva)) {
						if(!(patients[i] instanceof Sura)) {
							amountOther++;
						}
					}
				}
			}
		}
		return amountOther;
	}
	
	public int totalPatients() {
		int amountPar = getAmountPar();
		int amountEPS = getAmountEPS();
		int amountCoomeva = getAmountCoomeva();
		int amountSura = getAmountSura();
		int amountOther = getAmountOther();
		
		int totalP = amountPar + amountEPS + amountCoomeva + amountSura + amountOther;
		return totalP;
	}
	
	public String getPatient(String id) {
		boolean found = false;
		String out = "";
		for(int i = 0; i < MAX_PATIENT && !found; i++) {
			if(patients[i] != null) {
				if(id.equals(patients[i].getId())) {
					out = patients[i].toString();
					found = true;
				}
			}
		}
		return out;
	}
	
	public void getAllPatient() {
		for(int i = 0; i < MAX_PATIENT; i++) {
			if(patients[i] != null) {
				System.out.println(patients[i].toString());
			}
		}
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmailAddress(){
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}

	public String toString() {
		return "\n***************************************" +
				"\nCentro de vacunacion: " +name+ "\nN. de Telefono: " +phoneNumber+ "\nEmail: " +emailAddress+
				"\n***************************************";
	}
	
}