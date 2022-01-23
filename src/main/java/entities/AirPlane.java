package entities;


import javax.persistence.*;

@Entity
@Table (name = "maybay")
public class AirPlane{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "MaMB")
    private String airplaneCode;

    @Column(name = "Loai")
    private String aircraftType;

    @Column(name = "TamBay")
    private String flyingRange;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAirplaneCode() {
        return airplaneCode;
    }

    public void setAirplaneCode(String airplaneCode) {
        this.airplaneCode = airplaneCode;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getFlyingRange() {
        return flyingRange;
    }

    public void setFlyingRange(String flyingRange) {
        this.flyingRange = flyingRange;
    }

    @Override
    public String toString() {
        return "AirPlane{" +
                "airplaneCode='" + airplaneCode + '\'' +
                ", aircraftType='" + aircraftType + '\'' +
                ", flyingRange='" + flyingRange + '\'' +
                '}';
    }
}
