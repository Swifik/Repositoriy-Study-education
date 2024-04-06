public class Doctor {
    private String specialization;
    private String name;
    private String floor;
    private String cabinet;
    private String username;
    private String password;

    public Doctor(String specialization, String name ) {
        this.specialization = specialization;
        this.name = name;
        this.floor = floor;
        this.cabinet = cabinet;
    }
    {
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getFloor() {
        return floor;
    }

    public String getCabinet() {
        return cabinet;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getSpecialization() {
        return 0;
    }
}