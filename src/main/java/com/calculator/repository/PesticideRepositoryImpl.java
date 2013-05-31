package com.calculator.repository;

import org.springframework.stereotype.Repository;

import com.calculator.domain.Pesticide;

@Repository
public class PesticideRepositoryImpl extends BaseRepositoryImpl<Pesticide> implements PesticideRepository {

	public PesticideRepositoryImpl() {
		super(Pesticide.class);
	}

}
