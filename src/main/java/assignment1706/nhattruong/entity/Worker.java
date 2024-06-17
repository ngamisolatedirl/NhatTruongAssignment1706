package assignment1706.nhattruong.entity;

import assignment1706.nhattruong.jpaRepository.annotation.Column;
import assignment1706.nhattruong.jpaRepository.annotation.Entity;
import assignment1706.nhattruong.jpaRepository.annotation.Id;
import lombok.*;

@Getter
@Setter
@Builder
//@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(tableName = "student")
public class Worker {

    @Id(name = "id") // meaning id : primary key
    private Long id;
    @Column(columnName = "fullname")
    private String fullname;
    @Column(columnName = "birthday")
    private String birthday;
    @Column(columnName = "address")
    private String address;
    @Column(columnName = "position")
    private String position;
    @Column(columnName = "department")
    private String department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", position=" + position +
                ", department='" + department + '\'' +
                '}';
    }
}