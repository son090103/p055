
package Reponsitory;

import common.Validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import user.Doctor;

public class DoctorRespository implements IDoctorReponsitory {

 private List<Doctor> doctorList;
    private Validation validation = new Validation();
    private Scanner scanner = new Scanner(System.in);

    public DoctorRespository() {
        doctorList = new ArrayList<>();
    }

    @Override
    public void addDoctor() {
        String code = validation.checkInputString("Enter code: ");
        if (isCodeExists(code)) {
            System.err.println("Code already exists.");
            return;
        }

        String name = validation.checkInputString("Enter name:");
        String specialization = validation.checkInputString("Enter specialization:");
        int availability = validation.checkInputInt("Enter availability:");

        Doctor newDoctor = new Doctor(code, name, specialization, availability);
        doctorList.add(newDoctor);
        System.err.println("Add successful.");
    }

    @Override
    public void deleteDoctor(String code) {
        Doctor doctorToDelete = getDoctorByCode(code);
        if (doctorToDelete == null) {
            System.err.println("Doctor not found.");
            return;
        }

        doctorList.remove(doctorToDelete);
        System.err.println("Delete successful.");
    }

    @Override
    public void searchDoctor() {
        String nameSearch = validation.checkInputString("Enter name: ");
        List<Doctor> foundDoctors = listFoundByName(nameSearch);

        if (foundDoctors.isEmpty()) {
            System.err.println("No doctors found with the given name.");
        } else {
            displayDoctorList(foundDoctors);
        }
    }

    @Override
    public void updateBy(String code) {
        Doctor doctorToUpdate = getDoctorByCode(code);
        if (doctorToUpdate == null) {
            System.err.println("Doctor not found.");
            return;
        }

        String newCode = validation.checkInputString("Enter new code:");
        String name = validation.checkInputString("Enter new name:");
        String specialization = validation.checkInputString("Enter new specialization:");
        int availability = validation.checkInputInt("Enter new availability:");

        if (!validation.checkChangeInfo(doctorToUpdate, newCode, name, specialization, availability)) {
            System.err.println("No changes made.");
            return;
        }

        doctorToUpdate.setCode(newCode);
        doctorToUpdate.setName(name);
        doctorToUpdate.setSpecialization(specialization);
        doctorToUpdate.setAvailability(availability);
        System.err.println("Update successful.");
    }

    public Doctor getDoctorByCode(String code) {
        for (Doctor existingDoctor : doctorList) {
            if (existingDoctor.getCode().equalsIgnoreCase(code)) {
                return existingDoctor;
            }
        }
        return null;
    }

    public List<Doctor> listFoundByName(String name) {
        List<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor existingDoctor : doctorList) {
            if (existingDoctor.getName().toLowerCase().contains(name.toLowerCase())) {
                listFoundByName.add(existingDoctor);
            }
        }
        return listFoundByName;
    }

    public boolean isCodeExists(String code) {
        for (Doctor existingDoctor : doctorList) {
            if (existingDoctor.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public void displayDoctorList(List<Doctor> doctors) {
        System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                "Specialization", "Availability");
        for (Doctor doctor : doctors) {
            System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                    doctor.getName(), doctor.getSpecialization(),
                    doctor.getAvailability());
        }
    }
}
