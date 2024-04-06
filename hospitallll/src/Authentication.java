import java.util.ArrayList;
import java.util.List;

public class Authentication {
    private List<Doctor> doctors;

    public Authentication() {
        doctors = new ArrayList<>();
        doctors.add(new Doctor("Терапевт", "123"));
        doctors.add(new Doctor("Хирург", "123"));
        doctors.add(new Doctor("Окулист", "123"));
    }

    public Doctor login(String username, String password) {
        for (Doctor doctor : doctors) {
            if (doctor.getUsername().equals(username) && doctor.getPassword().equals(password)) {
                return doctor;
            }
        }
        return null;
    }
}