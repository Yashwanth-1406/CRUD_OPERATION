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

    public List<Registration>  listofRegistration(){
        List<Registration> reg = registrationRepository.findAll();

        return  reg;
   }

//    public Registration createRegistration(Registration registration) {
//       Registration saveentity= registrationRepository.save(registration); //it will return back registration entity
//       return saveentity;
//    }

    public void deleteregistration(long id) {
        registrationRepository.deleteById(id);

    }

    public Registrationdto updateRegistrations(Long id, Registrationdto registrationdto) {
        Registration reg=maptoEntity(registrationdto);
          Registration r=registrationRepository.findById(id).get();
          r.setName(registrationdto.getName());
          r.setMobile(registrationdto.getMobile());
          r.setEmail(registrationdto.getEmail());
         Registration saved= registrationRepository.save(r);
        Registrationdto registrationdto1
                =maptodto(saved);
         return registrationdto1;
    }


    public Registrationdto createRegistration(Registrationdto registrationdto) {
       Registration regg= maptoEntity(registrationdto);
//        Registration regg=new Registration();
//      regg.setName(registrationdto.getName());
//        regg.setEmail(registrationdto.getEmail());
//        regg.setMobile(registrationdto.getMobile());
        Registration savedentity=registrationRepository.save(regg);
//        Registrationdto reg=new Registrationdto();
//        reg.setName(savedentity.getName());
//        reg.setEmail(savedentity.getEmail());
//        reg.setMobile(savedentity.getMobile());
        Registrationdto registrationdto1
                =maptodto(savedentity);
        return registrationdto1;
    }



    Registration maptoEntity(Registrationdto registrationdto){


       Registration reg= modelMapper.map(registrationdto,Registration.class);



//        Registration reg=new Registration ();
//        reg.setName(registrationdto.getName());
//        reg.setEmail(registrationdto.getEmail());
//        reg.setMobile(registrationdto.getMobile());

        return reg;
    }
    Registrationdto maptodto(Registration registration){
      Registrationdto dto=  modelMapper.map(registration,Registrationdto.class);
//        Registrationdto dto=new Registrationdto();
//        dto.setName(registration.getName());
//        dto.setEmail(registration.getEmail());
//        dto.setMobile(registration.getMobile());
        return dto;
    }
}
