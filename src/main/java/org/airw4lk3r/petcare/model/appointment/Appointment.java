package org.airw4lk3r.petcare.model.appointment;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import org.airw4lk3r.petcare.model.enums.ProcedureEnum;
import org.airw4lk3r.petcare.model.pet.Pet;

/**
 * Appointment
 */
@Entity(name = "appointment")
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_sequence")
    @SequenceGenerator(name = "appointment_sequence", sequenceName = "seq_appointment")
    @Column(name = "appointment_id")
    private Long id;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate appointmentDate;

    @ManyToOne
    @JoinColumn(name = "pet_id", foreignKey = @ForeignKey(name = "PET_ID_FK"), nullable = false)
    private Pet pet;//*/

    private String observations;

    @ElementCollection(targetClass = ProcedureEnum.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "procedures")
    @JoinTable(name = "appointment_procedures", joinColumns = { @JoinColumn(name = "appointment_id") })
    private List<ProcedureEnum> procedures;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAppointmentDate() {
        return this.appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }//*/

    public String getObservations() {
        return this.observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public List<ProcedureEnum> getProcedures() {
        return this.procedures;
    }

    public void setProcedures(List<ProcedureEnum> procedures) {
        this.procedures = procedures;
    }

}