package entities;


import javax.persistence.*;


@Entity
@Table(name = "nhanvien")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "MaNV")
    private String staffCode;

    @Column(name = "Ten")
    private String name;

    @Column(name = "Luong")
    private int salary;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffCode='" + staffCode + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
