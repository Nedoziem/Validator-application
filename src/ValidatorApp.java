/*
 * Validator Application
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ValidatorApp {
	public static ArrayList<Passenger> processPassengerFile(){
		ArrayList<Passenger> passenger = new ArrayList<Passenger>();
		String [] info = null;

		try{
			File passengersFile = new File("PassengersInfo.txt");
			Scanner fileReader = new Scanner(passengersFile);

			while(fileReader.hasNextLine()){
				String line = fileReader.nextLine();
				info = line.split(" ");
				String tempName = info[0];
				String tempBirthDate = info[1];
				String tempAddress = info[2];
				String tempPassportNum = info[3];
				String tempBoardingPassId = info[4];

				Passenger p = new Passenger(tempName, tempBirthDate,  tempAddress, tempPassportNum, tempBoardingPassId);	

				passenger.add(p);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to read Passenger File");
		}
		return passenger;

	}

	public static ArrayList<Pilot> processPilotFile(){
		ArrayList<Pilot> pilot = new ArrayList<Pilot>();
		String [] info = null;

		try{
			File pilotsFile = new File("PilotsInfo.txt");
			Scanner fileReader = new Scanner(pilotsFile);

			while(fileReader.hasNextLine()){
				String line = fileReader.nextLine();
				info = line.split(" ");
				String tempName = info[0];
				String tempBirthDate = info[1];
				String tempAddress = info[2];
				String tempId = info[3];
				String tempACNum = info[4];

				Pilot p = new Pilot(tempName, tempBirthDate, tempAddress, tempId, tempACNum);	
				pilot.add(p);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to read PilotsInfo file");
		}
		return pilot;
	}

	public static ArrayList<FlightAttendant> processFlightAttendantFile(){
		ArrayList<FlightAttendant> flightAttendant = new ArrayList<FlightAttendant>();
		String[] info = null;

		try {
			File FlightAttendantInfoFile = new File("FlightAttendantsInfo.txt");
			Scanner fileReader = new Scanner(FlightAttendantInfoFile);

			while(fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				info = line.split(" ");

				String tempName = info[0];
				String tempBirthDate = info[1];
				String tempAddress = info[2];
				String tempIdNum = info[3];
				String tempFlightNum = info[4];
				String tempExpDate = info[5];

				FlightAttendant f = new FlightAttendant(tempName, tempBirthDate,  tempAddress, tempIdNum, tempFlightNum, tempExpDate);	
				flightAttendant.add(f);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to read FlightAttendantInfo file");
		}
		return flightAttendant;
	}


	public static ArrayList<CustomerServiceAgent> processCustomerServiceAgentFile(){
		ArrayList<CustomerServiceAgent> customerServiceAgent = new ArrayList<CustomerServiceAgent>();

		try{
			File customerServiceAgentFile = new File("CustomerServiceAgentInfo.txt");
			Scanner fileReader = new Scanner(customerServiceAgentFile);

			while(fileReader.hasNextLine()){
				String line = fileReader.nextLine();
				String[] info = line.split(" ");
				String tempName = info[0];
				String tempBirthDate = info[1];
				String tempAddress = info[2];
				String tempBadgeNum = info[3];
				String tempCode = info[4];

				CustomerServiceAgent c = new CustomerServiceAgent(tempName, tempBirthDate, tempAddress, tempBadgeNum, tempCode);	
				customerServiceAgent.add(c);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to read CustomerServiceAgentInfo file");
		}
		return customerServiceAgent;

	}

	public static void authenticationPassenger(Passenger r, ArrayList<Passenger> p){

		for(int i = 0; i < p.size(); i++) {
			if(p.get(i).authenticatePassenger(r)) {
				return;
			}
		}
		System.out.println(r.getName() + " could not be validated");
	}

	public static void authenticationPilot( Pilot r, ArrayList<Pilot> p){

		for(int i = 0; i < p.size(); i++) {
			if(p.get(i).authenticatePilot(r)) {
				return;
			}
		}
		System.out.println(r.getName() + " could not be validated");
	}

	public static void authenticationFlightAttendant(FlightAttendant r, ArrayList<FlightAttendant> p){

		for(int i = 0; i < p.size(); i++) {
			if(p.get(i).authenticateFlightAttendant(r)) {
				return;
			}
		}
		System.out.println(r.getName() + " could not be validated");
	}

	public static void authenticationCustomerServiceAgent(CustomerServiceAgent r, ArrayList<CustomerServiceAgent> p){

		for(int i = 0; i < p.size(); i++) {
			if(p.get(i).authenticateCustomerServiceAgent(r)) {
				return;
			}
		}
		System.out.println(r.getName() + " could not be validated");
	}

	public static ArrayList<Person> processInputFile() {
		ArrayList<Person> peopleList = new ArrayList<Person>();

		try {
			File infoFile = new File("SampleInputFile.txt");
			Scanner fileReader = new Scanner(infoFile);
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				String[] info = line.split(" ");

				if (info[0].equals("P")) {
					String tempName = info[1];
					String tempBirthDate = info[2];
					String tempAddress = info[3];
					String tempLicenseId = info[4];
					String tempAircraftNum = info[5];

					Pilot pt = new Pilot(tempName, tempBirthDate, tempAddress, tempLicenseId, tempAircraftNum);
					peopleList.add(pt);

				} else if(info[0].equals("F")) {
					String tempName = info[1];
					String tempBirthDate = info[2];
					String tempAddress = info[3];
					String tempIdNum = info[4];
					String tempFlightNum = info[5];
					String tempExpDate = info[6];

					FlightAttendant fa = new FlightAttendant(tempName, tempBirthDate, tempAddress, tempIdNum, tempFlightNum, tempExpDate);
					peopleList.add(fa);

				} else if(info[0].equals("C")) {
					String tempName = info[1];
					String tempBirthDate = info[2];
					String tempAddress = info[3];
					String tempCode = info[4];
					String tempBatchNum = info[5];

					CustomerServiceAgent c = new CustomerServiceAgent(tempName, tempBirthDate, tempAddress, tempCode, tempBatchNum);
					peopleList.add(c);

				} else if(info[0].equals("PA")) {
					String tempName = info[1];
					String tempBirthDate = info[2];
					String tempAddress = info[3];
					String tempPassportNum = info[4];
					String tempBoardingPassId = info[5];

					Passenger pa = new Passenger(tempName, tempBirthDate, tempAddress, tempPassportNum, tempBoardingPassId);
					peopleList.add(pa);

				} else {
					System.out.println("Unrecognized person type, unable to process data");
				}
			} 
			fileReader.close();

		} catch(FileNotFoundException e) {
			System.out.println("Unable to import people's info from file");
		}
		return peopleList;
	}

	public static void main(String[] args) {
		ArrayList<Person> doc = processInputFile();
		for (int i = 0; i < doc.size(); i++) {
			if (doc.get(i) instanceof Pilot) {
				authenticationPilot((Pilot)doc.get(i), processPilotFile());
			} else if(doc.get(i) instanceof Passenger) {
				authenticationPassenger((Passenger)doc.get(i), processPassengerFile());
			} else if(doc.get(i) instanceof CustomerServiceAgent) {
				authenticationCustomerServiceAgent((CustomerServiceAgent)doc.get(i), processCustomerServiceAgentFile());
			} else if(doc.get(i) instanceof FlightAttendant) {
				authenticationFlightAttendant((FlightAttendant)doc.get(i),processFlightAttendantFile());
			} else {
				System.out.println("Could not be recognized");
			}
		}
	}
}
