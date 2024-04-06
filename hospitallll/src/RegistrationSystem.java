import java.util.*;

public class RegistrationSystem {
    private List<Patient> patients;

    public RegistrationSystem() {
        this.patients = new ArrayList<>();
    }

    public void registerPatient(String name, String phoneNumber, String email) {
        Patient newPatient = new Patient(name, phoneNumber, email);
        patients.add(newPatient);
    }

    public List<Patient> getPatients() {
        return patients;
    }
}