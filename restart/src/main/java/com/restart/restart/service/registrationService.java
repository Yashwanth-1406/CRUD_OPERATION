package com.restart.restart.service;

import com.restart.restart.entity.Registration;
import com.restart.restart.payload.Registrationdto;
import com.restart.restart.repository.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class registrationService {

    private RegistrationRepository registrationRepository;

    private ModelMapper modelMapper;

    public registrationService(RegistrationRepository registrationRepository, ModelMapper modelMapper) {
        this.registrationRepository = registrationRepository;
        this.modelMapper = modelMapper;
    }

    public List<Registration> listofRegistration() {
        List<Registration> reg = registrationRepository.findAll();
        return reg;
    }

    public Registration createRegistration(Registration registration) {
        Registration saveentity = registrationRepository.save(registration); //it will return back registration entity
        return saveentity;
    }

    public void deleteregistration(long id) {
        registrationRepository.deleteById(id);

    }

    public Registration updateRegistrations(Long id, Registration registration) {
        Registration r = registrationRepository.findById(id).get();
        r.setName(registration.getName());
        r.setMobile(registration.getMobile());
        r.setEmail(registration.getEmail());
        Registration saved = registrationRepository.save(r);
        return saved;
    }


}




