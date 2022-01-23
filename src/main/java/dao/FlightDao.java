package dao;

import config.MySQLConnection;
import entities.Flight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightDao {
    public List<Flight> getAll() {
        Connection con = MySQLConnection.getConnection();
        List<Flight> flights = null;
        if (con == null) {
            System.out.println("Can not connect to database");
            return flights;
        } else {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from chuyenbay");
                flights = new ArrayList<>();
                while (rs.next()) {
                    Flight flight = new Flight();
                    flight.setFlightCode(rs.getString(1));
                    flight.setDepartStation(rs.getString(2));
                    flight.setArriveAtStation(rs.getString(3));
                    flight.setFlyingRange(rs.getInt(4));
                    flight.setDepartureTime(rs.getTime(5));
                    flight.setEndTime(rs.getTime(6));
                    flights.add(flight);
                }
                con.close();
                return flights;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return flights;
    }

    public void insertFlight() {
        Connection con = MySQLConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your MaCB: ");
        String MaCB = scanner.nextLine();
        System.out.print("Enter your GaDi: ");
        String GaDi = scanner.nextLine();
        System.out.print("Enter your GaDen: ");
        String GaDen = scanner.nextLine();
        System.out.print("Enter your DoDai: ");
        int DoDai = scanner.nextInt();
        System.out.println("Enter your GioDi: ");
        scanner.nextLine();
        String GioDi = scanner.nextLine();
        System.out.print("Enter your GioDen: ");
        String GioDen = scanner.nextLine();
        System.out.print("Enter your ChiPhi: ");
        String ChiPhi = scanner.nextLine();
        String sql = "INSERT INTO chuyenbay VALUES ('" + MaCB + "'," +
                "'" + GaDi + "'," +
                "'" + GaDen + "'," +
                "'" + DoDai + "'," +
                "'" + GioDi + "'," +
                "'" + GioDen + "'," +
                "'" + ChiPhi+"'"+")" +
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


    public void updateFlight() {
        Connection con = MySQLConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your MaCB: ");
        String MaCB = scanner.nextLine();

        System.out.print("Enter your GaDi: ");
        String GaDi = scanner.nextLine();
        System.out.print("Enter your GaDen: ");
        String GaDen = scanner.nextLine();
        System.out.print("Enter your DoDai: ");
        int DoDai = scanner.nextInt();
        System.out.println("Enter your GioDi: ");
        scanner.nextLine();
        String GioDi = scanner.nextLine();
        System.out.print("Enter your GioDen: ");
        String GioDen = scanner.nextLine();
        System.out.print("Enter your chi phi: ");
        int ChiPhi = scanner.nextInt();
        String sql =
                "UPDATE chuyenbay Set GaDi = ?, GaDen = ?, DoDai = ?, GioDi = ?, GioDen = ?, ChiPhi = ? where MaCB = ?";
        System.out.println(sql);
        if (con == null) {
            System.out.println("Can not connect to the DATABASE");
        } else {
            System.out.println("Can connect to Database");
            try {
                PreparedStatement preparedstatement = con.prepareStatement(sql);
                preparedstatement.setString(1,GaDi);
                preparedstatement.setString(2,GaDen);
                preparedstatement.setInt(3,DoDai);
                preparedstatement.setString(4,GioDi);
                preparedstatement.setString(5,GioDen);
                preparedstatement.setInt(6,ChiPhi);
                preparedstatement.setString(7,MaCB);
                preparedstatement.executeUpdate();
                System.out.println(sql);
                con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteFlight() throws SQLException {
        Connection con = MySQLConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your MaCB: ");
        String MaCB = scanner.nextLine();

        if (con == null) {
            System.out.println("Can not connect to in database");
        } else {
            try {
                String sql = "delete from chuyenbay" + " where MaCB = '"+ MaCB+"';";
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

    public List<Flight> getFlightsDaLat() {
        return getFlights("select * from chuyenbay where GaDen = 'DAD'");
    }

    public List<Flight> getFlightsFlyRange8000_10000() {
        return getFlights("select * from chuyenbay where DoDai between 8000 and 10000");
    }


    private List<Flight> getFlights(String sql) {
        Connection con = MySQLConnection.getConnection();
        List<Flight> flights = null;
        if (con == null) {
            System.out.println("Can not connect to database");
            return flights;
        } else {
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                flights = new ArrayList<>();
                while (rs.next()) {
                    Flight flight = new Flight();
                    flight.setFlightCode(rs.getString(1));
                    flight.setDepartStation(rs.getString(2));
                    flight.setArriveAtStation(rs.getString(3));
                    flight.setFlyingRange(rs.getInt(4));
                    flight.setDepartureTime(rs.getTime(5));
                    flight.setEndTime(rs.getTime(6));
                    flights.add(flight);
                }
                con.close();
                return flights;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return flights;
    }

}
