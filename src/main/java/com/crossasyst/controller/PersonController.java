package com.crossasyst.controller;

import com.crossasyst.model.PersonRequest;
import com.crossasyst.model.PersonResponse;
import com.crossasyst.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Log4j2
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/persons/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRequest> getPersons(@PathVariable Long personId) {
        log.info("fetching " + personId + " from the database........");
        return new ResponseEntity<>(personService.getPersons(personId), HttpStatus.OK);
    }
    @GetMapping(path = "/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonRequest>> getAllPersons() {
        log.info("fetching persons from the database........");
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest personRequest) {
        log.info("creating new resource .......................");
        return new ResponseEntity<>(personService.createPerson(personRequest), HttpStatus.OK);
    }

    @PutMapping(path = "/persons/{personId}")
    public ResponseEntity<PersonRequest> updatePerson(@PathVariable Long personId,
                                                      @RequestBody PersonRequest personRequest) {
        log.info("updating existing resource "+personId+" .......................");
        return new ResponseEntity<>(personService.updatePerson(personId, personRequest),HttpStatus.OK);
    }

    @DeleteMapping(path = "/persons/{personId}")
    public ResponseEntity deletePerson(@PathVariable Long personId) {
        log.info("Deleting the person "+personId);
        personService.deletePerson(personId);
        return ResponseEntity.ok("Person Is deleted");
    }


}
