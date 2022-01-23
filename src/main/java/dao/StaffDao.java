package dao;


import config.MySQLConnection;
import entities.AirPlane;
import entities.Certificate;
import entities.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffDao {

    public List<Staff> getAll() {
        return getStaffs("select * from nhanvien");
    }

    public static void insertStaff(){
        // MaNV, Ten, Luong
        Connection con = MySQLConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your MaNV: ");
        String MaNV = scanner.nextLine();
        System.out.print("Enter your Ten: ");
        String Ten = scanner.nextLine();
        System.out.print("Enter your luong: ");
        int Luong = scanner.nextInt();
        String sql = "INSERT INTO nhanvien VALUES (" +
                "'" + MaNV + "'," +
                "'" + Ten + "'," +
                "'" + Luong+"'"+")" +
                ";";
        if (con == null) {
            System.out.println("Can not connect to the DATABASE");
        } else {
            System.out.println("Can connect to Database");
            try {
                Statement statement = con.prepareStatement(sql);
                statement.executeUpdate(sql);
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public List<Staff> getStaffSalaryLessThan10000() {
        return getStaffs("select * from nhanvien where Luong <= 10000");
    }


    private List<Staff> getStaffs(String sql) {
        Connection con = MySQLConnection.getConnection();
        List<Staff> staffs = null;
        if (con == null) {
            System.out.println("Can not connect to the DATABASE");
        } else {
            try {
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                staffs = new ArrayList<>();
                while (rs.next()) {
                    Staff staff = new Staff();
                    staff.setStaffCode(rs.getString(1));
                    staff.setName(rs.getString(2));
                    staff.setSalary(rs.getInt(3));
                    staffs.add(staff);
                }
                con.close();
                return staffs;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return staffs;
            }

        }
        return staffs;
    }
}
