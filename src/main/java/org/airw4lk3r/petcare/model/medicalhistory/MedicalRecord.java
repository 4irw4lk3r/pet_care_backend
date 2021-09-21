package org.airw4lk3r.petcare.model.medicalhistory;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.airw4lk3r.petcare.model.enums.ProcedureEnum;

@Entity(name = "MedicalRecord")
@Table(name = "MedicalRecord")
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mr_sequence")
    @SequenceGenerator(name = "mr_sequence", sequenceName = "seq_mr")
    @Column(name = "record_id")
    private Long id;

    @Column(name = "weight")
    private Double weight;

    @ElementCollection(targetClass = ProcedureEnum.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "procedures")
    @JoinTable(name = "records_procedures", joinColumns = { @JoinColumn(name = "record_id") })
    private List<ProcedureEnum> procedures;

    @Column(name = "observations")
    private String observations;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "medical_history_id")
    private MedicalHistory archive;

    public MedicalHistory getArchive() {
        return this.archive;
    }

    public void setArchive(MedicalHistory archive) {
        this.archive = archive;
    }

    public String getObservations() {
        return this.observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProcedureEnum> getProcedures() {
        return this.procedures;
    }

    public void setProcedures(List<ProcedureEnum> procedures) {
        this.procedures = procedures;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
