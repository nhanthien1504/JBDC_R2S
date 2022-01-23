package entities;

import util.Validator;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table (name = "chuyenbay")
public class Flight {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "MaCB")
    private String flightCode;

    @Column(name = "GaDi")
    private String departStation;

    @Column(name = "GaDen")
    private String ArriveAtStation;

    @Column(name = "GioDi")
    private Time departureTime;

    @Column(name = "GioDen")
    private Time endTime;

    @Column(name = "DoDai")
    private int flyingRange;

    @Column(name = "ChiPhi")
    private int price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }


    public String getDepartStation() {
        return departStation;
    }

    public void setDepartStation(String departStation) {
        this.departStation = departStation;
    }

    public String getArriveAtStation() {
        return ArriveAtStation;
    }

    public void setArriveAtStation(String arriveAtStation) {
        ArriveAtStation = arriveAtStation;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        try {
            if (Validator.isDate(departureTime)) {
                this.departureTime = departureTime;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        try {
            if (Validator.isDate(departureTime)) {
                this.endTime = endTime;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getFlyingRange() {
        return flyingRange;
    }
    public void setFlyingRange(int flyingRange) {
        this.flyingRange = flyingRange;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightCode='" + flightCode + '\'' +
                ", departStation='" + departStation + '\'' +
                ", ArriveAtStation='" + ArriveAtStation + '\'' +
                ", departureTime=" + departureTime +
                ", endTime=" + endTime +
                ", flyingRange='" + flyingRange + '\'' +
                '}';
    }
}
