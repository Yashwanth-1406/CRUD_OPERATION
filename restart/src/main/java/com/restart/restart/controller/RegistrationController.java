package com.restart.restart.controller;

import com.restart.restart.entity.Registration;
import com.restart.restart.payload.Registrationdto;
import com.restart.restart.repository.RegistrationRepository;
import com.restart.restart.service.registrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/registration")
public class RegistrationController {

    private registrationService registrationService;
    private final RegistrationRepository registrationRepository;

    public RegistrationController(com.restart.restart.service.registrationService registrationService,
                                  RegistrationRepository registrationRepository) {
        this.registrationService = registrationService;
        this.registrationRepository = registrationRepository;
    }

    @GetMapping
    public ResponseEntity<List<Registration>> listofRegistration(){

    List<Registration> reg  = registrationService.listofRegistration();
    return new ResponseEntity<>(reg, HttpStatus.OK);

    }
//    @PostMapping
//    public ResponseEntity<Registration> createRegistration(@RequestBody  Registration registration){
//
//        Registration reg=registrationService.createRegistration(registration);
//        return new ResponseEntity<>(reg,HttpStatus.CREATED);
//
//    }
    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(@RequestParam long id){
        registrationService.deleteregistration(id);
        return new ResponseEntity<>("detleted",HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateregistration(@PathVariable  Long id, @RequestBody Registration registration){
       Registration registration1= registrationService.updateRegistrations(id,registration);
       return new ResponseEntity(registration1,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Registrationdto> createRegistration(@RequestBody  Registrationdto registrationdto){

        Registrationdto reg=registrationService.createRegistration(registrationdto);
        return new ResponseEntity<>(reg,HttpStatus.CREATED);

    }
}
