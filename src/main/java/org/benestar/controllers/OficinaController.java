package org.benestar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.benestar.repositories.OficinaRepository;
import org.benestar.classes.*;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/oficina") // This means URL's start with /demo (after Application path)
public class OficinaController {
	
	@Autowired
	private OficinaRepository oficinaRepository;
	
	@GetMapping(path="/allOficines")
	public @ResponseBody Iterable<Oficina> getAllOficines() {
		return oficinaRepository.findAll();
	}
	@RequestMapping(path="/addOficina", method=RequestMethod.POST)
	public @ResponseBody String addOficina(@RequestParam Long id, @RequestParam Integer codiPostal, @RequestParam String poblacio, @RequestParam String provincia, @RequestParam String direccio){
		
		Oficina o = new Oficina();		
		o.setId(id);
		o.setCodiPostal(codiPostal);
		o.setPoblacio(poblacio);
		o.setProvincia(provincia);
		o.setDireccio(direccio);	
		
		oficinaRepository.save(o);
		
		return "saved";
	}
	@RequestMapping(path="/updateOficina", method=RequestMethod.PUT)
	public @ResponseBody String updateOficina(@RequestParam Long id, @RequestParam Integer codiPostal, @RequestParam String poblacio, @RequestParam String provincia, @RequestParam String direccio){
		
		Oficina o = oficinaRepository.findOne(id);			
		//o.setId(id);
		o.setCodiPostal(codiPostal);
		o.setPoblacio(poblacio);
		o.setProvincia(provincia);
		o.setDireccio(direccio);
		
		oficinaRepository.save(o);
		
		return "updated";
	}
	@RequestMapping(path="/deleteOficina", method=RequestMethod.DELETE)
	public @ResponseBody String deleteOficina(@RequestParam Long id){
		
		oficinaRepository.delete(id);	
		
		return "deleted";
	}
}