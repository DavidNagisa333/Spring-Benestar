package org.benestar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.benestar.repositories.*;
import org.benestar.classes.*;



@Controller    // This means that this class is a Controller
@RequestMapping(path="/serveis") // This means URL's start with /demo (after Application path)
public class ServeisController {
	@Autowired
	private PrestacionsRepository prestacionsRepository;
	
	@Autowired
	private ServeisSocialsRepository serveisSocialsRepository;
	
	@Autowired
	private CopagamentsRepository copagamentsRepository;
	
	
///////////////////////////////////////////////////////////////////////////////////////////////ADD	
	@RequestMapping(path="/addPrestacio", method = RequestMethod.POST) // Map ONLY GET Requests
	public @ResponseBody String addPrestacio (@RequestParam Long tipus, @RequestParam String descripcio) {
		Prestacions n = new Prestacions(); //nom .java
		n.setTipus(tipus);
		n.setDescripcio(descripcio);
		prestacionsRepository.save(n);
		return "Saved";
	}
	
	@RequestMapping(path="/addCopagament", method = RequestMethod.POST) // Map ONLY GET Requests
	public @ResponseBody String addCopagament (@RequestParam Long tipus, @RequestParam String descripcio) {
		Copagaments n = new Copagaments();
		n.setTipus(tipus);
		n.setDescripcio(descripcio);
		copagamentsRepository.save(n);
		return "Saved";
	}
	
	@RequestMapping(path="/addServeiSocial", method = RequestMethod.POST) // Map ONLY GET Requests
	public @ResponseBody String addServeiSocial (@RequestParam Long tipus, @RequestParam String descripcio) {
		ServeisSocials n = new ServeisSocials();
		n.setTipus(tipus);
		n.setDescripcio(descripcio);
		serveisSocialsRepository.save(n);
		return "Saved";
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////DEL	
	@RequestMapping(path="/delPrestacio", method = RequestMethod.DELETE)
	public @ResponseBody String delPrestacio (@RequestParam Long id) {
		prestacionsRepository.delete(id);
		return "Deleted";
	}
	

	@RequestMapping(path="/delCopagament", method = RequestMethod.DELETE)
	public @ResponseBody String delCopagament (@RequestParam Long id) {
		copagamentsRepository.delete(id);
		return "Deleted";
	}
	

	@RequestMapping(path="/delServeiSocial", method = RequestMethod.DELETE)
	public @ResponseBody String delServeiSocial (@RequestParam Long id) {
		serveisSocialsRepository.delete(id);
		return "Deleted";
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////PUT
	
	@RequestMapping(path="/putPrestacio",method = RequestMethod.PUT)
	public @ResponseBody Object putPrestacio (@RequestParam Long id, @RequestParam Long tipus, @RequestParam String descripcio) {
		Prestacions e = prestacionsRepository.findOne(id);
		e.setId(id);
		e.setTipus(tipus);
		e.setDescripcio(descripcio);
		prestacionsRepository.save(e);
		return "Updated";
	}
 
	@RequestMapping(path="/putCopagament",method = RequestMethod.PUT)
	public @ResponseBody Object putCopagament (@RequestParam Long id, @RequestParam Long tipus, @RequestParam String descripcio) {
		Copagaments e = copagamentsRepository.findOne(id);
		e.setId(id);
		e.setTipus(tipus);
		e.setDescripcio(descripcio);
		copagamentsRepository.save(e);
		return "Updated";
	}
 
	@RequestMapping(path="/putServeiSocial",method = RequestMethod.PUT)
	public @ResponseBody Object putServeiSocial (@RequestParam Long id, @RequestParam Long tipus, @RequestParam String descripcio){
		ServeisSocials e = serveisSocialsRepository.findOne(id);
		e.setId(id);
		e.setTipus(tipus);
		e.setDescripcio(descripcio);
		serveisSocialsRepository.save(e);
		return "Updated";
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////ALL

	@GetMapping(path="/allPrestacio")
	public @ResponseBody Iterable<Prestacions> getAllPrestacions() {
		// This returns a JSON or XML with the users
		return prestacionsRepository.findAll();
	}
	
	@GetMapping(path="/allCopagament")
	public @ResponseBody Iterable<Copagaments> getAllCopagaments() {
		// This returns a JSON or XML with the users
		return copagamentsRepository.findAll();
	}
	
	@GetMapping(path="/allServeiSocial")
	public @ResponseBody Iterable<ServeisSocials> getAllServeiSocial() {
		// This returns a JSON or XML with the users
		return serveisSocialsRepository.findAll();
	}
}
