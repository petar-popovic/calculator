package com.calculator.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.calculator.domain.Menu;

@Repository
public class MenuRepositoryImpl extends BaseRepositoryImpl<Menu> implements MenuRepository {

	public MenuRepositoryImpl() {
		super(Menu.class);
	}

	public void addMenu(Menu menu) {
		save(menu);
	}
	
	public List<Menu> getAll() {
		return getAll();
	}

}
