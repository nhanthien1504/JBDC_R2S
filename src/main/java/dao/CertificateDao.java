package dao;


import config.MySQLConnection;
import entities.Certificate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CertificateDao {
    public List<Certificate> getAll() {
        return getCertificates("select * from chungnhan");
    }


    public static void insertCertificate() {
        //MaNV, MaMB
        Connection con = MySQLConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your MaNV: ");
        String MaNV = scanner.nextLine();
        System.out.print("Enter your MaMB: ");
        int MaMB = scanner.nextInt();
        String sql = "insert into chungnhan values(?, ?)";
        if (con == null) {
            System.out.println("Can not connect to the DATABASE");
        } else {
            System.out.println("Can connect to Database");
            try {
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1,MaNV);
                st.setInt(2,MaMB);
                st.executeUpdate();
                st.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Certificate> getCertificates(String sql) {
        Connection con = MySQLConnection.getConnection();
        List<Certificate> certificates = null;
        if (con == null) {
            System.out.println("Can not connect to database");
            return certificates;
        } else {
            System.out.println("Can connect to database");
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                certificates = new ArrayList<>();
                while (rs.next()) {
                    Certificate certificate = new Certificate();
                    certificate.setStaffCode(rs.getString(1));
                    certificate.setAirplaneCode(rs.getString(2));
                    certificates.add(certificate);
                }
                con.close();
                return certificates;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return certificates;
    }

}
