package org.airw4lk3r.petcare.model.medicalhistory;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import org.airw4lk3r.petcare.model.pet.Pet;

@Entity(name = "MedicalHistory")
@Table(name = "MedicalHistory")
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mh_sequence")
    @SequenceGenerator(name = "mh_sequence", sequenceName = "seq_mh")
    @Column(name = "medical_history_id")
    private Long id;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name = "pet_id", foreignKey = @ForeignKey(name = "PET_MH_ID_FK"), nullable = false)
    private Pet pet;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "archive", fetch = FetchType.LAZY)
    private List<MedicalRecord> records;

    public List<MedicalRecord> getRecords() {
        return this.records;
    }

    public void setRecords(List<MedicalRecord> records) {
        this.records = records;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public LocalDate getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
