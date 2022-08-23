package in.ac.charusat.patientmgmtsystem.repository;

import in.ac.charusat.patientmgmtsystem.model.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRecordRepository extends JpaRepository<PatientRecord, Integer> {
}
