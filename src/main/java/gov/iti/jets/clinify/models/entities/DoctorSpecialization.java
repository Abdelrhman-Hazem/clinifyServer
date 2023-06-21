package gov.iti.jets.clinify.models.entities;// default package
// Generated 16 Jun 2023, 19:10:03 by Hibernate Tools 6.1.7.Final


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * DoctorSpecialization generated by hbm2java
 */
@Entity
@Table(name="doctor_specialization"
    ,catalog="clinify"
)
public class DoctorSpecialization extends BaseEntity {

     private String name;
     private Set<Doctor> doctors = new HashSet(0);

    public DoctorSpecialization() {
    }

	
    public DoctorSpecialization(String name) {
        this.name = name;
    }
    public DoctorSpecialization(String name, Set<Doctor> doctors) {
       this.name = name;
       this.doctors = doctors;
    }
   

    
    @Column(name="name", nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="doctorSpecialization")
    public Set<Doctor> getDoctors() {
        return this.doctors;
    }
    
    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }




}


