package Serveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Serveis.Prestacions;
import Serveis.PrestacionsRepository;
import Serveis.ServeisSocials;
import Serveis.ServeisSocialsRepository;
import Serveis.CopagamentsRepository;
import Serveis.Copagaments;



@Controller    // This means that this class is a Controller
@RequestMapping(path="/serveis") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired
	private PrestacionsRepository prestacionsRepository;
	
	@Autowired
	private ServeisSocialsRepository serveisSocialsRepository;
	
	@Autowired
	private CopagamentsRepository copagamentsRepository;
	
	
	
	@GetMapping(path="/addPrestacio") // Map ONLY GET Requests
	public @ResponseBody String addPrestacio (@RequestParam Long tipus, @RequestParam String descripcio) {
		Prestacions n = new Prestacions(); //nom .java
		n.setTipus(tipus);
		n.setDescripcio(descripcio);
		prestacionsRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/addCopagament") // Map ONLY GET Requests
	public @ResponseBody String addCopagament (@RequestParam Long tipus, @RequestParam String descripcio) {
		Copagaments n = new Copagaments();
		n.setTipus(tipus);
		n.setDescripcio(descripcio);
		copagamentsRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/addServeiSocial") // Map ONLY GET Requests
	public @ResponseBody String addServeiSocial (@RequestParam Long tipus, @RequestParam String descripcio) {
		ServeisSocials n = new ServeisSocials();
		n.setTipus(tipus);
		n.setDescripcio(descripcio);
		serveisSocialsRepository.save(n);
		return "Saved";
	}
	
	/*
	@GetMapping(path="/allServeis")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}*/
}
