package dev.Daniel.Hospital.service;

import dev.Daniel.Hospital.HospitalApplication;
import dev.Daniel.Hospital.model.Hospital;
import dev.Daniel.Hospital.repository.HospitalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

	private final HospitalRepository HospitalRepository;


	public HospitalService(HospitalRepository HospitalRepository) {
		this.HospitalRepository = HospitalRepository;
	}

	public Hospital save(Hospital hospital){return HospitalRepository.save(hospital);}

	public List<Hospital> getAll(){return HospitalRepository.findAll();}

	public Hospital getById(Long id){
		Hospital hospital =  HospitalRepository.findById(id).orElse(null);

		if (hospital == null){
			throw new EntityNotFoundException();
		}else {
			return hospital;
		}
	}

	public Hospital update(Long id,Hospital hospital){
		Hospital hospitalAtt = getById(id);

		hospitalAtt.setNome(hospitalAtt.getNome());
		hospitalAtt.setTelefone(hospital.getTelefone());
		hospitalAtt.setCnpj(hospital.getCnpj());

		return save(hospitalAtt);

	}

	public void delete(Long id){HospitalRepository.deleteById(id);}

	public void deleteAll(){HospitalRepository.deleteAll();}




}
