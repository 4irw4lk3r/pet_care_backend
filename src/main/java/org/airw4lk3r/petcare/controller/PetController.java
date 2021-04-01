package org.airw4lk3r.petcare.controller;

import java.util.List;

import javax.validation.Valid;

import org.airw4lk3r.petcare.model.pet.Pet;
import org.airw4lk3r.petcare.service.PetService;
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
 * PetController
 */
@Transactional
@RestController
@RequestMapping("/pet/api")
@CrossOrigin(origins = "http://localhost:8081")
public class PetController {

    @Autowired
    PetService petService;

    @RequestMapping(value="/v1/", method=RequestMethod.GET)
    public ResponseEntity<List<Pet>> getAllPets(){
        List<Pet> pets = petService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(pets);
    }

    @RequestMapping(value="/v1/{id}", method=RequestMethod.GET)
    public ResponseEntity<Pet> getPetById(@PathVariable final Long id){
        Pet pet = petService.getById(id);

        return ResponseEntity.ok().body(pet);
    }
    
    @RequestMapping(value="/v1/", method=RequestMethod.POST)
    public void saveOrUpdatePet(@Valid @RequestBody final Pet pet){
        petService.createOrModify(pet);
    }
}