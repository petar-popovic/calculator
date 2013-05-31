package com.calculator.controller;

import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.calculator.domain.Pesticide;
import com.calculator.service.PesticideService;

@Controller
@RequestMapping("/pesticides")
public class PesticideController {

    @Autowired
    private PesticideService pesticideService;

    @RequestMapping("pesticideslist.json")
    public @ResponseBody List<Pesticide> getPesticideList() {
        return pesticideService.getAll();
    }
   
    @RequestMapping(value = "/uploadImage/{id}", method = RequestMethod.POST)
    public @ResponseBody void uploadImage(@PathVariable("id") Long id, @RequestBody FileUpload file) {
    	//pesticideService.add(pesticide);
    }
    
    @RequestMapping(value = "/addPesticide", method = RequestMethod.POST)
    public @ResponseBody void addPesticide(@RequestBody Pesticide pesticide) {
    	pesticideService.add(pesticide);
    }
    
    @RequestMapping(value = "/updatePesticide", method = RequestMethod.PUT)
    public @ResponseBody void updateMenu(@RequestBody Pesticide pesticide) {
        pesticideService.update(pesticide);
    }
    
    @RequestMapping(value = "/removePesticide/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removePesticide(@PathVariable("id") Long id) {
        pesticideService.deletePesticideById(id);
    }

    @RequestMapping(value = "/removeAllPesticides", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllPesticides() {
    	pesticideService.deleteAll();
    }

    @RequestMapping("/layout")
    public String getPesticidePartialPage(ModelMap modelMap) {
        return "pesticides/layout";
    }

	public PesticideService getPesticideService() {
		return pesticideService;
	}

	public void setPesticideService(PesticideService pesticideService) {
		this.pesticideService = pesticideService;
	}   

}
