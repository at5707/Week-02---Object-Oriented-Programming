import java.util.ArrayList;
import java.util.List;
class Doctor {
    private String name;
    private String specialization;
    private List<Patient> patients;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this); // Ensuring bidirectional relationship
        }
        System.out.println(name + " is consulting patient " + patient.getName());
    }

    public void displayPatients() {
        System.out.println("Dr. " + name + "'s Patients:");
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}
class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void displayDoctors() {
        System.out.println("Patient " + name + "'s Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getName());
        }
    }
}
class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayDoctors() {
        System.out.println("Hospital: " + name + " - Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getName());
        }
    }

    public void displayPatients() {
        System.out.println("Hospital: " + name + " - Patients:");
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}
public class HospitalSystem {
    public static void main(String[] args) {
		Hospital hospital = new Hospital("City Hospital");
		Doctor drSmith = new Doctor("Dr. Smith", "Cardiology");
		Doctor drJones = new Doctor("Dr. Jones", "Neurology");
		Patient alice = new Patient("Alice");
        Patient bob = new Patient("Bob");
		drSmith.consult(alice);
        drSmith.consult(bob);
        drJones.consult(alice);
		hospital.addDoctor(drSmith);
        hospital.addDoctor(drJones);
        hospital.addPatient(alice);
        hospital.addPatient(bob);
		hospital.displayDoctors();
        hospital.displayPatients();
        drSmith.displayPatients();
        drJones.displayPatients();
        alice.displayDoctors();
        bob.displayDoctors();
	}
}
		