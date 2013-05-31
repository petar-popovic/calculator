package com.calculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.calculator.domain.Pesticide;
import com.calculator.repository.PesticideRepository;

@Service("pesticideService")
@Transactional
public class PesticideServiceImpl implements PesticideService {
	@Autowired
	private PesticideRepository pesticideRepository;

	@Override
	public List<Pesticide> getAll() {
		return pesticideRepository.getAll();
	}

	@Override
	public Pesticide getById(Long id) {
		return pesticideRepository.getById(id);
	}

	@Override
	public void add(Pesticide pesticide) {
		pesticideRepository.save(pesticide);
		
	}

	@Override
	public void deletePesticideById(Long id) {
		pesticideRepository.deleteById(id);
		
	}

	@Override
	public void deleteAll() {
		pesticideRepository.deleteAll();		
	}

	@Override
	public void update(Pesticide pesticide) {
		pesticideRepository.update(pesticide);
		
	}

	public PesticideRepository getPesticideRepository() {
		return pesticideRepository;
	}
	
	public void setPesticideRepository(PesticideRepository pesticideRepository) {
		this.pesticideRepository = pesticideRepository;
	}
}
