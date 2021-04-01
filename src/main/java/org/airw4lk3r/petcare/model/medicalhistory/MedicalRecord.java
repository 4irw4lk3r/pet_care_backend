package org.airw4lk3r.petcare.model.medicalhistory;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;

import org.airw4lk3r.petcare.model.enums.ProcedureEnum;

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
    @JoinTable(name = "appointment_procedures", joinColumns = { @JoinColumn(name = "appointment_id") })
    private List<ProcedureEnum> procedures;

    @Column(name = "obervations")
    private String observations;
}
