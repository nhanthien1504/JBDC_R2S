package dao;

import config.MySQLConnection;
import entities.AirPlane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AirPlaneDao {
    public static List<AirPlane> getAll() {
        return getAirPlanes("select * from maybay");
    }

    public void insertAirplane() {
        Connection con = MySQLConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Ma May Bay: ");
        String MaMB = scanner.nextLine();
        System.out.print("Enter your Loai may bay: ");
        String Loai = scanner.nextLine();
        System.out.print("Enter your Tam bay: ");
        int TamBay = scanner.nextInt();
        String sql = "INSERT INTO maybay VALUES ('" + MaMB + "','" + Loai + "','" + TamBay + "');";
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

    public void updateAirplaneType() {
        Connection con = MySQLConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Ma May Bay: ");
        int MaMB = scanner.nextInt();

        System.out.print("Enter your Loai may bay: ");
        Scanner scanner2 = new Scanner(System.in);
        String Loai = scanner2.nextLine();
        String sql = "UPDATE maybay " +
                "SET Loai = '" + Loai + "' where MaMB = '" + MaMB + "'";
        System.out.println(sql);
        if (con == null) {
            System.out.println("Can not connect to the DATABASE");
        } else {
            System.out.println("Can connect to Database");
            try {
                Statement statement = con.createStatement();
                statement.executeUpdate(sql);
                statement.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteAirplane() throws SQLException {
        Connection con = MySQLConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Ma May Bay: ");
        int MaMB = scanner.nextInt();

        if (con == null) {
            System.out.println("Can not connect to in database");
        } else {
            try {
                String sql = "delete from maybay" + " where MaMB = "+ MaMB+";";
                Statement stmt = con.createStatement()  ;
                stmt.executeUpdate(sql);
                System.out.println(stmt);
                stmt.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }finally {
                con.close();
            }
        }
    }

    public static List<AirPlane> airPlanesFlyRange10000() {
        return getAirPlanes("select * from maybay where TamBay > 10000");
    }





    private static List<AirPlane> getAirPlanes(String sql) {
        Connection con = MySQLConnection.getConnection();
        List<AirPlane> airPlanes = null;
        if (con == null) {
            System.out.println("Can not connect to the DATABASE");
        } else {
            System.out.println("Can connect to Database");
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                airPlanes = new ArrayList<>();
                while (rs.next()) {
                    AirPlane airPlane = new AirPlane();
                    airPlane.setAirplaneCode(rs.getString(1));
                    airPlane.setAircraftType(rs.getString(2));
                    airPlane.setFlyingRange(rs.getString(3));
                    airPlanes.add(airPlane);
                }
                con.close();
                return airPlanes;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return airPlanes;
            }
        }
        return airPlanes;
    }
}

