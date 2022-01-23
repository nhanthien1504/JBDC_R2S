package org.example;


import dao.FlightDao;

public class SampleProjectIntelliJApplication {
    public static void main(String[] args) {
        FlightDao dao = new FlightDao();
        dao.updateFlight();
    }


}
