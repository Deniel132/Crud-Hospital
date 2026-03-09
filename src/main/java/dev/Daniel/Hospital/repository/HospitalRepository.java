package dev.Daniel.Hospital.repository;

import dev.Daniel.Hospital.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {


}
