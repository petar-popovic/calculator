package com.calculator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.calculator.domain.Menu;
import com.calculator.domain.Node;
import com.calculator.service.MenuService;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:22 AM
 */
@Controller
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("menuslist.json")
    public @ResponseBody List<Menu> getMenuList() {
        return menuService.getAllMenus();
    }

    @RequestMapping("orderslist.json")
    public @ResponseBody List<Integer> getOrderList() {
    	List<Integer> results = new ArrayList<Integer>();
    	results.add(1);
    	results.add(3);
    	results.add(5);
        return results;
    }
    
    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    public @ResponseBody void addMenu(@RequestBody Menu menu) {
        menuService.addMenu(menu);
    }
    
    @RequestMapping(value = "/{id}/addPage", method = RequestMethod.POST)
    public @ResponseBody void addMenuPage(@PathVariable("id") Long id, @RequestBody Node page) {
        menuService.addPage(id, page);
    }

    @RequestMapping(value = "/updateMenu", method = RequestMethod.PUT)
    public @ResponseBody void updateMenu(@RequestBody Menu menu) {
        menuService.updateMenu(menu);
    }

    @RequestMapping(value = "/{id}/updatePage", method = RequestMethod.PUT)
    public @ResponseBody void updateMenuPage(@PathVariable("id") Long menuId, @RequestBody Node page) {
        menuService.updatePage(menuId, page);
    }
    
    @RequestMapping(value = "/removeMenu/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeMenu(@PathVariable("id") Long id) {
        menuService.deleteMenuById(id);
    }

    @RequestMapping(value = "/removeAllMenus", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllMenus() {
        menuService.deleteAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Long id) {
        return "menus/view";
    }

    @RequestMapping("/layout")
    public String getMenuPartialPage(ModelMap modelMap) {
        return "menus/layout";
    }
    
    @RequestMapping("/list")
    public String getMenuListpage(ModelMap modelMap) {
        return "menus/list";
    }
}
