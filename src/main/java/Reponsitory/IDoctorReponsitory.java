/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitory;

import java.util.ArrayList;
import user.Doctor;

/**
 *
 * @author son
 */
public interface IDoctorReponsitory {

    void addDoctor();

    void deleteDoctor(String code);

    void searchDoctor();
//    List<Doctor> getAllcandidates();

    void updateBy(String code);
}
