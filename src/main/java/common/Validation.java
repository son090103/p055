/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.ArrayList;
import java.util.Scanner;
import user.Doctor;

/**
 *
 * @author son
 */
public class Validation {

    public final static Scanner sc = new Scanner(System.in);
    ArrayList<Doctor> ld = new ArrayList<>();

    public int checkInputLimit(int min, int max) {
        // int min ,int max
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (Exception e) {
                System.out.println("please input number in rage [" + min + ", " + max + " ]");
                System.out.println("Enter again: ");
            }
        }
    }
   

    public String checkInputString(String mess) {
        System.out.println(mess);
        return sc.nextLine();
    }
    
     public static int checkInputInt(String mess) {
         System.out.println(mess);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number integer");
                System.out.print("Enter again: ");
            }
        }
    }
    public boolean checkInputYN() {
        while (true) {
            String result = checkInputString(" Please input y/Y or n/N.");
            if (result.equalsIgnoreCase("y")) {
                return true;
            }
            if (result.equalsIgnoreCase("n")) {
                return false;
            }
            System.out.println("Enter again: ");
        }
    }

    public static Integer getInt(String promt, int min, int max) {
        Integer a = null;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= min && a <= max) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + min + " and " + max);
            }
        }
        return a;
    }

    public  boolean checkCodeExist(ArrayList<Doctor> ld, String code) {
        //check from first to last list doctor
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return false;
            }
        }
        return true;
    }
     public boolean checkDuplicate(ArrayList<Doctor> ld, String code,
            String name, String specialization, int availability) {
        //check from first to last list doctor
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())
                    && name.equalsIgnoreCase(doctor.getName())
                    && specialization.equalsIgnoreCase(doctor.getSpecialization())
                    && availability == doctor.getAvailability()) {
                return false;
            }
        }
        return true;
    }
     public  boolean checkChangeInfo(Doctor doctor, String code,
            String name, String specialization, int availability) {
        if (doctor.getCode().equalsIgnoreCase(code)
                && doctor.getName().equalsIgnoreCase(name)
                && doctor.getSpecialization().equalsIgnoreCase(specialization)
                && doctor.getAvailability() == availability) {
            return false;
        }
        return true;
    }
}
