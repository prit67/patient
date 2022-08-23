package in.ac.charusat.patientmgmtsystem.controller;

import in.ac.charusat.patientmgmtsystem.model.PatientRecord;
import in.ac.charusat.patientmgmtsystem.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class PatientRecordController {

    @Autowired
    PatientRecordRepository patientRecordRepository;



    @GetMapping("/listpatients")
    public List<PatientRecord> getAllPatients() {
        return patientRecordRepository.findAll();
    }


    @GetMapping("/patient/{id}")
    public PatientRecord getPatient(@PathVariable Integer id) {
        return patientRecordRepository.findById(id).get();
    }

    // Delete the student
    @DeleteMapping("/patient/{id}")
    public List<PatientRecord> deletepatient(@PathVariable Integer id) {
        patientRecordRepository.delete(patientRecordRepository.findById(id).get());
        return patientRecordRepository.findAll();
    }


    @PostMapping("/patient")
    public List<PatientRecord> addPatientent(@RequestBody PatientRecord patientRecord) {
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }


    @PutMapping("/patient/{id}")
    public List<PatientRecord> updatepatient(@RequestBody PatientRecord patientRecord, @PathVariable Integer id) {
        PatientRecord patientRecordObj = patientRecordRepository.findById(id).get();
        patientRecordObj.setName(patientRecord.getName());
        patientRecordObj.setAddress(patientRecord.getAddress());
        patientRecordRepository.save(patientRecordObj);
        return patientRecordRepository.findAll();
    }

}
