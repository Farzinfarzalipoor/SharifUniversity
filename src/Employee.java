public class Employee {
    private int id;
    private Integer spouseId;
    private String name;
    private String lastName;
    private char gender;
    private double latitude;
    private double longitude;


    public Employee(int id, String name, String lastName, char gender, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", spouseId=" + spouseId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public void setSpouseId(int spouseId) {
        this.spouseId = spouseId;
    }

    public boolean isMarried() {
        if (spouseId == null) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public Integer getSpouseId() {
        return spouseId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
