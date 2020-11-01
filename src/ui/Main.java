package ui;

import java.util.Scanner;
import model.Center;

public class Main {
	
	private Scanner sc;
	private Center mainCenter;
	
	public Main() {
		sc = new Scanner(System.in);
		createCenter();
	}
	
	public static void main(String[] args) {
		Main objMain = new Main();
		objMain.menu();	
	}
	
	public void createCenter() {
		System.out.println("Ingrese el nombre del Centro de Vacunacion:");
		String name = sc.nextLine();
		System.out.println("Ingrese el numero de telefono:");
		String phoneNumber = sc.nextLine();
		System.out.println("Ingrese la direccion de Email:");
		String emailAddress = sc.nextLine();
		mainCenter = new Center(name, phoneNumber, emailAddress);
	}
	
	public void createPatient(int option) {
		System.out.println("Ingrese el nombre del paciente:");
		String name = sc.nextLine();
		System.out.println("Ingrese el apellido del paciente:");
		String lastName = sc.nextLine();
		System.out.println("Ingrese la edad:");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el Id del paciente:");
		String id = sc.nextLine();
		if(option == 1) {
			createPatientPar(name, lastName, age, id);
		}
		else if(option == 2) {
			createPatientEPS(name, lastName, age, id);
		}
		else if(option == 3) {
			createPatientPre(name, lastName, age, id);
		}
	}
	
	public void createPatientPar(String name, String lastName, int age, String id) {
		System.out.println("Ingrese el numero de telefono de contacto:");
		String phone = sc.nextLine();
		System.out.println("Ingrese el nombre del doctor tratante:");
		String doctorName = sc.nextLine();
		System.out.println("Ingrese el numero de telefono del doctor:");
		String doctorPhone = sc.nextLine();
		System.out.println("Ingrese el numero de licencia del doctor:");
		String license = sc.nextLine();
		String message = mainCenter.addPatient(name, lastName, age, id, phone, doctorName, doctorPhone, license);
		System.out.println(message);
	}
	
	public void createPatientEPS(String name, String lastName, int age, String id) {	
		System.out.println("Ingrese el nombre de la EPS:");
		String epsName = sc.nextLine();
		System.out.println("Imgrese el numero de la orden:");
		int orderNumber = sc.nextInt();
		sc.nextLine();
		String message = mainCenter.addPatient(name, lastName, age, id, epsName, orderNumber);
		System.out.println(message);
	}	
		
	public void createPatientPre(String name, String lastName, int age, String id) {
		System.out.println("Ingrese a que entidad prestadora de salud pertenece el paciente: Coomeva o Sura, sino escriba: Otra");
		String entity = sc.nextLine();
		System.out.println("Ingrese el numero de afiliacion:");
		int affiliationNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nombre de la entidad:");
		String entityName = sc.nextLine();
		System.out.println("Ingrese el numero de telefono de la entidad:");
		int entityNumber = sc.nextInt();
		sc.nextLine();
		if(entity.equalsIgnoreCase("Coomeva")) {
			System.out.println("\nQue categoria tiene el paciente? Ingrese el numero de la categoria:\n" +
								"(1) PLATINO\n" + 
								"(2) ORO\n" +
								"(3) ORO PLUS\n" 
								);
			int category = sc.nextInt();
			String message = mainCenter.addPatient(name, lastName, age, id, affiliationNumber, entityName, entityNumber, category);
			System.out.println(message);
		}
		else if(entity.equalsIgnoreCase("Sura")) {
			System.out.println("Rango de cubrimiento de la poliza:");
			System.out.println("Valor minimo:");
			int minimunRank = sc.nextInt();
			System.out.println("Valor maximo:");
			int maxRank = sc.nextInt();
			sc.nextLine();
			String message = mainCenter.addPatient(name, lastName, age, id, affiliationNumber, entityName, entityNumber, minimunRank, maxRank);
			System.out.println(message);
			}
		else if(entity.equalsIgnoreCase("Otra")) {
			String message = mainCenter.addPatient(name, lastName, age, id, affiliationNumber, entityName, entityNumber);
			System.out.println(message);
		}	
	}
	
	public void findPatient() {
		System.out.println("Digite el ID del paciente a buscar:");
		String id = sc.nextLine();
		System.out.println(mainCenter.getPatient(id));
	}
	
	public void showStatistics() {
		System.out.println("\n**********************************************************************************" +
							"\nTotal de pacientes atendidos actualmente: " +mainCenter.totalPatients()+
							"\nPacientes particulares: " +mainCenter.getAmountPar()+
							"\nPacientes por EPS: " +mainCenter.getAmountEPS()+
							"\nPacientes por prepagada:  Coomeva: " +mainCenter.getAmountCoomeva()+ " || SURA: " +mainCenter.getAmountSura()+ " || Otras: " +mainCenter.getAmountOther()+
							"\n**********************************************************************************"
							);
	}
	
	public void showInfo() {
		System.out.println(mainCenter.toString());
		showStatistics();
		mainCenter.getAllPatient();
	}

	public void menu() {
		boolean menu = true;
		while(menu) {
			System.out.println(
					"\n****************************************************************************\n" +
					"Digite la opcion deseada:\n" +
					"(1) Agregar un nuevo paciente\n" +
					"(2) Mostrar la cantidad de pacientes que atiende el centro de vacunación\n" +
					"(3) Buscar paciente\n" +
					"(4) Mostrar toda la informacion del centro de vacunacion\n" +  
					"(0) Para salir\n" +
					"****************************************************************************\n"
					);
			int option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				case 1:	menu2();
					break;
				case 2:	showStatistics();
					break;
				case 3:	findPatient();
					break;
				case 4:	showInfo();
					break;
				case 0:	System.out.println("Bye!");
						menu = false;
					break;
				default: System.out.println("Opcion no valida");
			}
		}
	}
	
	public void menu2() {
		boolean menu = true;
		while(menu) {
			System.out.println(
					"\n************************************************************\n" +
					"Digite la opcion deseada:\n" +
					"(1) Agregar un nuevo paciente particular\n" +
					"(2) Agregar un nuevo paciente de EPS\n"+
					"(3) Agregar un nuevo paciente de medicina prepagada\n"+
					"(0) Para volver\n" +
					"************************************************************\n"
					);
			int option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				case 1:	createPatient(option);
					break;
				case 2:	createPatient(option);
					break;
				case 3:	createPatient(option);
					break;
				case 0:	menu = false;
					break;
				default: System.out.println("Opcion no valida");
			}
		}
	}
	
}