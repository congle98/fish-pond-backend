package com.fishpond.controller;

import com.fishpond.model.AquaticInformation;
import com.fishpond.model.Device;
import com.fishpond.model.dto.AquaticInformationOfDevice;
import com.fishpond.repository.AquaticInformationRepository;
import com.fishpond.service.AquaticInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/aquatic-information")
public class AquaticInformationController {
    @Autowired
    private AquaticInformationService aquaticInformationService;

    @Autowired
    private AquaticInformationRepository aquaticInformationRepository;

    @GetMapping()
    public ResponseEntity<Page<AquaticInformation>> getAll(@PageableDefault(page = 0, size = 10) Pageable pageable,
                                                           @RequestParam (required = false,defaultValue = "") String search){
        return new ResponseEntity<>(aquaticInformationService.findAll(search,pageable), HttpStatus.OK);
    }
    @GetMapping("/of-device-last-update")
    public ResponseEntity<Page<AquaticInformation>> getAllOfDeviceLastUpdate(@PageableDefault(page = 0, size = 10) Pageable pageable,
                                                                                @RequestParam (required = false,defaultValue = "") String search){
        return new ResponseEntity<>(aquaticInformationService.findAllOfDeviceLastUpdate(search,pageable),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AquaticInformation> getById(@PathVariable Long id){
        return new ResponseEntity<>(aquaticInformationService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<Page<AquaticInformation>> getAllByUser(Principal principal,
                                                                 @PageableDefault(page = 0, size = 10) Pageable pageable,
                                                                 @RequestParam (required = false,defaultValue = "") String search){
        return new ResponseEntity<>(aquaticInformationService.findAllByUser(principal.getName(),search,pageable), HttpStatus.OK);
    }

    @GetMapping("/device/{id}")
    public ResponseEntity<Page<AquaticInformation>> getAllByDeviceId(
                                                                 @PageableDefault(page = 0, size = 10) Pageable pageable,
                                                                 @PathVariable Long id){
        return new ResponseEntity<>(aquaticInformationService.findAllByDeviceId(id,pageable), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AquaticInformation> save(@RequestBody AquaticInformationOfDevice aquaticInformationOfDevice){
        return new ResponseEntity<>(aquaticInformationService.save(aquaticInformationOfDevice), HttpStatus.OK);
    }

//    @PostMapping("/sync")
//    public void sync(){
//        List<AquaticInformation> aquaticInformations = new ArrayList<>();
//        for (Long i = 1L; i < 16L; i++) {
//            AquaticInformation aquaticInformation = new AquaticInformation();
//            Device device = new Device();
//            device.setId( i);
//            aquaticInformation.setEvaluation("tốt");
//            aquaticInformation.setTemperature(30.7);
//            aquaticInformation.setPh(4.9);
//            aquaticInformation.setHumidity(87.8);
//            aquaticInformation.setDissolvedOxygen(8.2);
//            aquaticInformation.setDevice(device);
//            aquaticInformation.setCreateDate(LocalDateTime.now().minusMinutes(5));
//
//
//
//            AquaticInformation aquaticInformation2 = new AquaticInformation();
//            Device device2 = new Device();
//            device2.setId(i);
//            aquaticInformation2.setEvaluation("bình thường");
//            aquaticInformation2.setTemperature(22.6);
//            aquaticInformation2.setPh(6.5);
//            aquaticInformation2.setHumidity(58.9);
//            aquaticInformation2.setDissolvedOxygen(7.2);
//            aquaticInformation2.setDevice(device2);
//            aquaticInformation2.setCreateDate(LocalDateTime.now().minusMinutes(18));
//
//
//
//            AquaticInformation aquaticInformation3 = new AquaticInformation();
//            Device device3 = new Device();
//            device3.setId(i);
//            aquaticInformation3.setEvaluation("cảnh báo");
//            aquaticInformation3.setTemperature(40.2);
//            aquaticInformation3.setPh(4.8);
//            aquaticInformation3.setHumidity(60.7);
//            aquaticInformation3.setDissolvedOxygen(8.8);
//            aquaticInformation3.setDevice(device3);
//            aquaticInformation3.setCreateDate(LocalDateTime.now().minusMinutes(28));
//            System.out.println(aquaticInformation3);
//            //            aquaticInformationRepository.save(aquaticInformation2);
//            //            aquaticInformationRepository.save(aquaticInformation);
////            aquaticInformationRepository.save(aquaticInformation3);
//            aquaticInformations.add(aquaticInformation);
//            aquaticInformations.add(aquaticInformation2);
//            aquaticInformations.add(aquaticInformation3);
//        }
//
//        aquaticInformationRepository.saveAll(aquaticInformations);
//
//
//    }


}
