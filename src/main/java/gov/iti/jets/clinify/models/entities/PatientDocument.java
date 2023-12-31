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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Date;

/**
 * PatientDocument generated by hbm2java
 */
@Entity
@Table(name="patient_document"
    ,catalog="clinify"
)
public class PatientDocument  extends BaseEntity {


     private Integer id;
     private Patient patient;
     private Date date;
     private String documentUrl;
     private String description;

    public PatientDocument() {
    }

	
    public PatientDocument(Patient patient, Date date, String documentUrl) {
        this.patient = patient;
        this.date = date;
        this.documentUrl = documentUrl;
    }
    public PatientDocument(Patient patient, Date date, String documentUrl, String description) {
       this.patient = patient;
       this.date = date;
       this.documentUrl = documentUrl;
       this.description = description;
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
    @JoinColumn(name="patient_id", nullable=false)
    public Patient getPatient() {
        return this.patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date", nullable=false, length=10)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    
    @Column(name="document_url", nullable=false, length=500)
    public String getDocumentUrl() {
        return this.documentUrl;
    }
    
    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    
    @Column(name="description", length=500)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "PatientDocument{" +
                "id=" + id +
                ", patient=" + patient.getId() +
                ", date=" + date +
                ", documentUrl='" + documentUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


