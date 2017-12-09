/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repository;

import com.dbutil.javaConnect;
import com.model.AdminModel;
import com.model.AppointmentModel;
import com.model.DoctorModel;
import com.model.DrugModel;
import com.model.PatientModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Subik
 */
public class RepositoryClass {

    Connection conn = javaConnect.ConnecrDb();
    ResultSet rs = null;
    PreparedStatement pst = null;

    public byte[] returnImage(AdminModel Am) {
        try {
            String sql = "select image from demo.admin where UserName = '" + Am.getName() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                byte[] imagedata = rs.getBytes("image");
                return imagedata;
            } else {
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ResultSet InBillDrug(int S, String D, int I) {

        try {

            String sql;

            sql = "select cost from demo.drug where DrugName = '" + D + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                int cost = Integer.parseInt(rs.getString("Cost"));
                sql = "insert into demo.Bill(SN,DrugName,No,Cost) value(?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setInt(1, S);
                pst.setString(2, D);
                pst.setInt(3, I);
                pst.setInt(4, cost);
                pst.execute();
            }

            sql = "update demo.bill set TotalCost = No * Cost";
            pst = conn.prepareStatement(sql);
            pst.execute();
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;

        }

    }

    public void DeleteBill() {
        try {
            String sql = "Delete from demo.Bill";

            pst = conn.prepareStatement(sql);
            pst.execute();

        } catch (Exception e) {
        }
    }

    public ResultSet checkDrug(String S) {
        try {
            String sql = "select * from demo.drug  where DrugName = '" + S + "'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ResultSet returnDate() {
        try {
            String sql = "select DrugName,ExDate from demo.drug";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ResultSet checkAdmin(AdminModel A) {
        try {
            String sql = "select * from demo.admin where Name = '" + A.getName() + "' and Password = '" + A.getPassword() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void insertInPatient(PatientModel P) {
        try {

            String sql = "Insert into demo.inpatient (Name,Age,Sex,OpNo,DateOfAdmission,DrugsAllergy,FamilyName,Address,ContactNo,FContactNo,TimeOfAdmission) value(?,?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, P.getName());
            pst.setInt(2, P.getAge());
            pst.setString(3, P.getSex());
            pst.setInt(4, P.getOpNo());
            pst.setString(5, P.getDOA());
            pst.setString(6, P.getAllergy());
            pst.setString(7, P.getFName());
            pst.setString(8, P.getAddress());
            pst.setInt(9, P.getContact());
            pst.setInt(10, P.getFContact());
            pst.setString(11, P.getTOA());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Saved");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void insertDoctor(DoctorModel D) {
        try {
            String sql = "Insert into demo.doctor (Did,DoctorName,Address,Age,Day,InTime,OutTime,Speciality,Contact,Sex) value(?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, D.getDid());
            pst.setString(2, D.getDoctorName());
            pst.setString(3, D.getAddress());
            pst.setInt(4, D.getAge());
            pst.setString(5, D.getDay());
            pst.setString(6, D.getInTime());
            pst.setString(7, D.getOutTime());
            pst.setString(8, D.getSpeciality());
            pst.setInt(9, D.getContact());
            pst.setString(10, D.getSex());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public ResultSet viewDoctor(int Id) {
        try {
            String sql = "select * from demo.doctor where Did = '" + Id + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
      public ResultSet viewDoctorCombo() {
        try {
            String sql = "select DoctorName from demo.doctor ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ResultSet viewDoctorTable() {
        try {
            String sql = "select Did,DoctorName,Day,InTime,OutTime,Speciality from demo.doctor ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ResultSet viewAppointmentTable() {
        try {
            String sql = "select AId,DoctorName,DateAppointment,PatientName,Time,Slot from demo.appointment ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ResultSet returnDoctorName(int i) {
        try {
            String sql = "select Did,DoctorName from demo.doctor where Did = '" + i + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void insertAppointment(AppointmentModel A) {
        try {
            String sql = "Insert into demo.appointment(DoctorName,Did,DateAppointment,Time,PatientName) value(?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, A.getDoctorName());

            pst.setInt(2, A.getDid());
            pst.setString(3, A.getDateAppointment());
            pst.setString(4, A.getTime());
            pst.setString(5, A.getPName());
            pst.execute();

            sql = "update demo.appointment set slot = slot + 1 where DoctorName='" + A.getDoctorName() + "' and DateAppointment='" + A.getDateAppointment() + "' ";

            pst = conn.prepareStatement(sql);
            pst.execute();
            sql = "select max(slot) as max from demo.appointment where DoctorName='" + A.getDoctorName() + "' and DateAppointment='" + A.getDateAppointment() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("max");
                JOptionPane.showMessageDialog(null, "Saved" + " Slot No: " + add1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public void checkIn(int Aid, int Pid) {

        try {
            String sql = "select * from demo.appointment where AId = '" + Aid + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {

                String add1 = rs.getString("DoctorName");

                int add2 = Integer.parseInt(rs.getString("Did"));
                String add3 = rs.getString("PatientName");

                sql = "Insert into demo.checkin (DoctorName,Did,PatientName,Pid) value(?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, add1);
                pst.setInt(2, add2);
                pst.setString(3, add3);
                pst.setInt(4, Pid);

                pst.execute();
                JOptionPane.showMessageDialog(null, "Saved");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void deleteApp(int Aid) {
        try {
            String sql = "delete from demo.appointment where AId= ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, Aid);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deleted"); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    public ResultSet viewInPatient(int i)
    {
       try {
            String sql = "select * from demo.inpatient where  OpNo = '" + i + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } 
    }
    public void insertOutPatient(PatientModel P) {
        try {

            String sql = "Insert into demo.outpatient (Name,Age,Sex,OpNo,DateOfDischarge,Diagnosis,DateOfAdmission,FName,Address,Contact,FContact,DoctorName) value(?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, P.getName());
            pst.setInt(2, P.getAge());
            pst.setString(3, P.getSex());
            pst.setInt(4, P.getOpNo());
            pst.setString(5, P.getDOD());
            pst.setString(6, P.getDiagnosis());
            pst.setString(7, P.getDOA());
            pst.setString(8, P.getFName());
            pst.setString(9, P.getAddress());
            pst.setInt(10, P.getContact());
            pst.setInt(11, P.getFContact());
            pst.setString(12, P.getDName());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Saved");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    public void insertDrug(DrugModel D)
    {
         try {

            String sql = "Insert into demo.drug (DrugName,istock,ExDate,Cost,RegDate) value(?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, D.getDrugName());
            pst.setInt(2, D.getStock());
            pst.setString(3, D.getExDate());
            pst.setInt(4, D.getCost());
            pst.setString(5, D.getRegDate());
         
            pst.execute();
            JOptionPane.showMessageDialog(null, "Saved");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
}
