package com.calculator.service;

import java.util.List;

import com.calculator.domain.Menu;
import com.calculator.domain.Node;


public interface MenuService {
    public List<Menu> getAllMenus();

    public Menu getMenuById(Long id);

    public void addMenu(Menu train);
    
    public void addPage(Long menuId, Node page);

    public void deleteMenuById(Long id);

    public void deleteAll();

    public void updateMenu(Menu train);

	public void updatePage(Long menuId, Node page);
}
