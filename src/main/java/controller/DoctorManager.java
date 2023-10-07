/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Reponsitory.DoctorRespository;
import java.util.ArrayList;
import java.util.Scanner;
import menu.Menu;
import user.Doctor;

/**
 *
 * @author son
 */
public class DoctorManager extends Menu<String> {

    private DoctorRespository list = new DoctorRespository();
    static Scanner sc = new Scanner(System.in);

    public DoctorManager(String title, String[] s) {
        super(title, s);
    }

    @Override
    public void execute(int n) {
        switch (n) {  // Corrected the switch statement to use the value of 'n'.
            case 1:
                list.addDoctor();
                break;
            case 2:
                System.out.println("Enter code: ");
                list.updateBy(sc.nextLine());
                break;
            case 3:
                System.out.println("Enter code: ");
                list.deleteDoctor(sc.nextLine());
                break;
            case 4:
                list.searchDoctor();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
