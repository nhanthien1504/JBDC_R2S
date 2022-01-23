package entities;

import javax.persistence.*;

@Entity
@Table(name = "chungnhan")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "MaNV")
    private String staffCode;

    @Column(name = "MaMB")
    private String airplaneCode;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getAirplaneCode() {
        return airplaneCode;
    }

    public void setAirplaneCode(String airplaneCode) {
        this.airplaneCode = airplaneCode;
    }

    @Override
    public String toString() {
        return "certificate{" +
                "staffCode='" + staffCode + '\'' +
                ", airplaneCode='" + airplaneCode + '\'' +
                '}';
    }
}
