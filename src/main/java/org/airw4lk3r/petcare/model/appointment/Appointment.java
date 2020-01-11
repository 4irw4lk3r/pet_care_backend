package org.airw4lk3r.petcare.model.appointment;

import java.time.LocalDate;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.airw4lk3r.petcare.model.pet.Owner;
import org.airw4lk3r.petcare.model.pet.Pet;


/**
 * Appointment
 */
@Entity(name = "appointment")
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "appointment_sequence")
    @SequenceGenerator(name="appointment_sequence", sequenceName="seq_appointment")
    @Column(name = "appointment_id")
    private Long id;

    private LocalDate appointmentDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JoinColumn(name = "pet_id")
    private List<Pet> pets;

    private String observations;

    @ElementCollection(targetClass = Procedure.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "procedures")
    @JoinTable(
        name = "appointment_procedures",
        joinColumns = {@JoinColumn(name="appointment_id")}
    )
    private List<Procedure> procedures;

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

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Pet> getPets() {
        return this.pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public String getObservations() {
        return this.observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public List<Procedure> getProcedures() {
        return this.procedures;
    }

    public void setProcedures(List<Procedure> procedures) {
        this.procedures = procedures;
    }

}