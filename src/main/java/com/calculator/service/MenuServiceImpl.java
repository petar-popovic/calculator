package com.calculator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.calculator.domain.Menu;
import com.calculator.domain.Node;
import com.calculator.repository.MenuRepository;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	private static List<Menu> menuList;
	private static Long id = 0L;
	
	@Autowired
	private MenuRepository menuRepository;

	public List<Menu> getAllMenus() {
		if (menuList == null)
			menuList = new ArrayList<Menu>();
		
		return menuRepository.getAll();
	}

	public Menu getMenuById(Long id) {
		return findMenuById(id);
	}

	@Transactional("transactionManager")
	public void addMenu(Menu menu) {
		//menu.setId(++id);
		menuList.add(menu);
		Menu menu1 = new Menu();
		menu1.setName(menu.getName());
		menu1.setOrderId(menu.getOrderId());
		menuRepository.save(menu);
	}

	public void deleteMenuById(Long id) {
		Menu foundMenu = findMenuById(id);
		if (foundMenu != null) {
			menuList.remove(foundMenu);
			id--;
		}
	}

	public void deleteAll() {
		menuList.clear();
		id = 0L;
	}

	public void updateMenu(Menu menu) {
		Menu foundMenu = findMenuById(menu.getId());
		if (foundMenu != null) {
			menuList.remove(foundMenu);
			menuList.add(menu);
		}
	}

	private Menu findMenuById(Long id) {
		for (Menu menu : menuList) {
			if (menu.getId() == id) {
				return menu;
			}
		}

		return null;
	}

	public void addPage(Long menuId, Node page) {
		Menu menu = findMenuById(menuId);
		if (menu.getPages() == null)
			menu.setPages(new ArrayList<Node>());
		menu.getPages().add(page);

	}

	public void updatePage(Long menuId, Node p) {
		Node page = findPageById(menuId, p.getId());
		page.setName(p.getName());

	}

	private Node findPageById(Long menuId, Long id) {
		Menu menu = findMenuById(menuId);
		if(menu == null)
			return null;
		List<Node> pageList = menu.getPages();
		for (Node page : pageList) {
			if (page.getId() == id) {
				return page;
			}
		}

		return null;
	}

	public MenuRepository getMenuRepository() {
		return menuRepository;
	}

	public void setMenuRepository(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}
}
