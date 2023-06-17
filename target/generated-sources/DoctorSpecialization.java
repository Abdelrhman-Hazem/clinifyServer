// default package
// Generated 16 Jun 2023, 20:42:23 by Hibernate Tools 6.1.7.Final


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
public class DoctorSpecialization  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set doctors = new HashSet(0);

    public DoctorSpecialization() {
    }

	
    public DoctorSpecialization(String name) {
        this.name = name;
    }
    public DoctorSpecialization(String name, Set doctors) {
       this.name = name;
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

    
    @Column(name="name", nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="doctorSpecialization")
    public Set getDoctors() {
        return this.doctors;
    }
    
    public void setDoctors(Set doctors) {
        this.doctors = doctors;
    }




}


