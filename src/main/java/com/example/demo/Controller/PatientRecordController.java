package com.example.demo.Controller;


import com.example.demo.model.PatientRecord;

import com.example.demo.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin( origins="http://localhost:3000")
public class PatientRecordController {

    @Autowired
    PatientRecordRepository patientRepository;


    @GetMapping("/listpatients")
    public List<PatientRecord> getAllPattientRecords(){
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public PatientRecord getPatientRecord(@PathVariable Integer id){
        return patientRepository.findById(id).get();
    }

    @DeleteMapping("/patient/{id}")
    public List<PatientRecord> deletePatientRecord(@PathVariable Integer id){
        patientRepository.delete(patientRepository.findById(id).get());
        return patientRepository.findAll();
    }

    @PostMapping("/patientrecord")
    public List<PatientRecord> addPatientRecord(@RequestBody PatientRecord patientRecord){
        patientRepository.save(patientRecord);
        return patientRepository.findAll();
    }

    @PutMapping("/patientrecord/{id}")
    public List<PatientRecord> updatePatientRecord(@RequestBody PatientRecord patientRecord, @PathVariable Integer id){
        PatientRecord patientRecordObj = patientRepository.findById(id).get();
        patientRecordObj.setName(patientRecord.getName());
        patientRecordObj.setAddress(patientRecord.getAddress());
        patientRepository.save(patientRecordObj);
        return patientRepository.findAll();
    }
}