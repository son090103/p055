
package user;

public class Doctor {
    public String code;
    public String name;
    public String  Specialization;
    public int Availability;

    public Doctor() {
    }

    public Doctor(String code, String name, String Specialization, int Availability) {
        this.code = code;
        this.name = name;
        this.Specialization = Specialization;
        this.Availability = Availability;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public int getAvailability() {
        return Availability;
    }

    public void setAvailability(int Availability) {
        this.Availability = Availability;
    }

    @Override
    public String toString() {
        return "code: " + code + ", name: " + name + ", Specialization: " + Specialization + ", Availability: " + Availability ;
    }
    
}
