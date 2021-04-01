package org.airw4lk3r.petcare.controller;

import java.util.List;

import javax.validation.Valid;

import org.airw4lk3r.petcare.model.pet.Owner;
import org.airw4lk3r.petcare.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * OwnerController
 */
@RestController
@RequestMapping("/owner/api")
@CrossOrigin(origins = "http://localhost:8081")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @RequestMapping(value="/v1/", method=RequestMethod.GET)
    public ResponseEntity<List<Owner>> getAllOwners(){
        List<Owner> owners = ownerService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(owners);
    }

    @RequestMapping(value = "/v1/{id}", method = RequestMethod.GET)
    public ResponseEntity<Owner> getOwnerById(@PathVariable final Long id){
        Owner owner = ownerService.getById(id);
        return ResponseEntity.ok().body(owner);
    }

    @RequestMapping(value = "/v1/", method = RequestMethod.POST)
    public void saveOrUpdateOwner(@Valid @RequestBody final Owner owner){
        ownerService.createOrModify(owner);
    }
}