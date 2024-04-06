import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Doctor> doctors;

    public Department(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
}