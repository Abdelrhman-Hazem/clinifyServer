package gov.iti.jets.clinify.models.entities;// default package
// Generated 16 Jun 2023, 19:10:03 by Hibernate Tools 6.1.7.Final


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Clinic generated by hbm2java
 */
@Entity
@Table(name="clinic"
    ,catalog="clinify"
    , uniqueConstraints = {@UniqueConstraint(columnNames="email"), @UniqueConstraint(columnNames="phone_number")} 
)
public class Clinic  extends BaseEntity {


     private Integer id;
     private Area area;
     private City city;
     private String username;
     private String password;
     private String name;
     private String phoneNumber;
     private String email;
     private String address;
     private String status;
     private Boolean isDeleted;
     private Set<Doctor> doctors = new HashSet(0);

    public Clinic() {
    }

	
    public Clinic(Area area, City city, String username, String password, String name, String phoneNumber, String email, String address) {
        this.area = area;
        this.city = city;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
    public Clinic(Area area, City city, String username, String password, String name, String phoneNumber, String email, String address, String status, Boolean isDeleted, Set<Doctor> doctors) {
       this.area = area;
       this.city = city;
       this.username = username;
       this.password = password;
       this.name = name;
       this.phoneNumber = phoneNumber;
       this.email = email;
       this.address = address;
       this.status = status;
       this.isDeleted = isDeleted;
       this.doctors = doctors;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="area_id", nullable=false)
    public Area getArea() {
        return this.area;
    }
    
    public void setArea(Area area) {
        this.area = area;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="city_id", nullable=false)
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }

    
    @Column(name="username", nullable=false, length=50)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", nullable=false, length=100)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="name", nullable=false, length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="phone_number", unique=true, nullable=false, length=11)
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    @Column(name="email", unique=true, nullable=false, length=50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="address", nullable=false, length=360)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="status", length=8)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    
    @Column(name="is_deleted")
    public Boolean getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="clinic")
    public Set<Doctor> getDoctors() {
        return this.doctors;
    }
    
    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }


    @Override
    public String toString() {
        return "Clinic{" +
                "id=" + id +
                ", area=" + area+
                ", city=" + city+
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", isDeleted=" + isDeleted +
                ", doctors=" + doctors.stream().map((e)->e.getId()).collect(Collectors.toList()) +
                '}';
    }
}


