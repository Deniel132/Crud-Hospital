package dev.Daniel.Hospital.controller;


import dev.Daniel.Hospital.model.Hospital;
import dev.Daniel.Hospital.service.HospitalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	private final HospitalService hospitalService;

	public HospitalController(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}


	@PostMapping
	public Hospital save(@RequestBody Hospital hospital){return this.hospitalService.save(hospital);}

	@GetMapping
	public List<Hospital> getAll(){return this.hospitalService.getAll();}

	@GetMapping("/encontrar/{id}")
	public Hospital getByID(@PathVariable Long id){return this.hospitalService.getById(id);}

	@PutMapping("/atualizar/{id}")
	public Hospital atualizar(@PathVariable Long id,@RequestBody Hospital hospital){return this.hospitalService.update(id,hospital);}


	@DeleteMapping("/deletar/{id}")
	public void deleteById(@PathVariable Long id){ this.hospitalService.delete(id);}

	@DeleteMapping("/deletar/all")
	public void deleteAll(){this.hospitalService.deleteAll();}

}
