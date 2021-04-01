package org.airw4lk3r.petcare.controller;

import java.util.List;

import javax.validation.Valid;

import org.airw4lk3r.petcare.model.appointment.Appointment;
import org.airw4lk3r.petcare.model.pet.Pet;
import org.airw4lk3r.petcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * AppointmentController
 */
@Transactional
@RestController
@RequestMapping("/appointment/api")
@CrossOrigin(origins = "http://localhost:8081")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @RequestMapping(value="/v1/", method=RequestMethod.GET)
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        List<Appointment> appointments = appointmentService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(appointments);
    }

    @RequestMapping(value = "/v1/{id}", method = RequestMethod.GET)
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable final Long id){
        Appointment appointment = appointmentService.getById(id);
        return ResponseEntity.ok().body(appointment);
    }

    @RequestMapping(value = "/v1/", method = RequestMethod.POST)
    public void saveOrUpdateAppointment(@Valid @RequestBody final Appointment appointment){
        appointmentService.createOrModify(appointment);
    }

    @RequestMapping(value = "/v1/pet/", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> getAllAppointmentsByPet(@Valid @RequestBody final Pet pet){
        List<Appointment> appointments = appointmentService.getAllByPetId(pet.getId());
        return ResponseEntity.status(HttpStatus.OK).body(appointments);
    }
    
}