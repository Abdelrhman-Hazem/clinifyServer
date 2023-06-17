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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Patient generated by hbm2java
 */
@Entity
@Table(name="patient"
    ,catalog="clinify"
    , uniqueConstraints = {@UniqueConstraint(columnNames="email"), @UniqueConstraint(columnNames="phone_number")} 
)
public class Patient  implements java.io.Serializable {


     private Integer id;
     private Area area;
     private City city;
     private String phoneNumber;
     private String password;
     private String fullName;
     private String email;
     private Date birthDate;
     private String gender;
     private String address;
     private Integer preperationTime;
     private Boolean isDeleted;
     private Set<PatientDocument> patientDocuments = new HashSet(0);
     private Set<Appointment> appointments = new HashSet(0);

    public Patient() {
    }

	
    public Patient(String phoneNumber, String password, String fullName, String email, Date birthDate, String gender) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
    }
    public Patient(Area area, City city, String phoneNumber, String password, String fullName, String email, Date birthDate, String gender, String address, Integer preperationTime, Boolean isDeleted, Set<PatientDocument> patientDocuments, Set<Appointment> appointments) {
       this.area = area;
       this.city = city;
       this.phoneNumber = phoneNumber;
       this.password = password;
       this.fullName = fullName;
       this.email = email;
       this.birthDate = birthDate;
       this.gender = gender;
       this.address = address;
       this.preperationTime = preperationTime;
       this.isDeleted = isDeleted;
       this.patientDocuments = patientDocuments;
       this.appointments = appointments;
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
    @JoinColumn(name="area_id")
    public Area getArea() {
        return this.area;
    }
    
    public void setArea(Area area) {
        this.area = area;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="city_id")
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }

    
    @Column(name="phone_number", unique=true, nullable=false, length=11)
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    @Column(name="password", nullable=false, length=30)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="full_name", nullable=false, length=100)
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    
    @Column(name="email", unique=true, nullable=false, length=50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="birth_date", nullable=false, length=10)
    public Date getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    
    @Column(name="gender", nullable=false, length=6)
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    
    @Column(name="address", length=360)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="preperation_time")
    public Integer getPreperationTime() {
        return this.preperationTime;
    }
    
    public void setPreperationTime(Integer preperationTime) {
        this.preperationTime = preperationTime;
    }

    
    @Column(name="is_deleted")
    public Boolean getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="patient")
    public Set<PatientDocument> getPatientDocuments() {
        return this.patientDocuments;
    }
    
    public void setPatientDocuments(Set<PatientDocument> patientDocuments) {
        this.patientDocuments = patientDocuments;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="patient")
    public Set<Appointment> getAppointments() {
        return this.appointments;
    }
    
    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }




}


