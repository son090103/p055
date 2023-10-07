
import controller.DoctorManager;

public class Main {

    public static void main(String[] args) {
        String title = "Doctor Management ";
        String[] s = new String[]{"Add Doctor", "Update Doctor",
            "Delete Doctor", "Search Doctor", "Exit"};
        DoctorManager menu = new DoctorManager(title, s);
        menu.run();
    }
}
