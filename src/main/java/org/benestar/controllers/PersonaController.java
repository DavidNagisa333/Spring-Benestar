package org.benestar.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.benestar.repositories.PersonaRepository;
import org.benestar.classes.Persona;

@Controller
@RequestMapping(path="/benestar")
public class PersonaController {
	
	@Autowired
	private PersonaRepository personaRepository;

	
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -   
	// A F E G I R   U N A   P E R S O N A
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@RequestMapping(method=RequestMethod.POST, path="/afegirPersona")
	public @ResponseBody void afegirPersona(@RequestParam String nom, @RequestParam String cognoms, /*@RequestParam LocalDate naixement,*/ @RequestParam String correu,
										   @RequestParam String telefon, @RequestParam String mobil, @RequestParam String adreca, @RequestParam String localitat,
										   @RequestParam String comarca) {
		
		System.out.print("\n\nnom" + nom + "\n\ncognoms" + cognoms + "\n\ncorreu" + correu + "\n\ntelefon" + telefon + "\n\nmobil" + mobil + "\n\nadreca" + adreca + "\n\nlocalitat" + localitat + "\n\ncomarca" + comarca);
		
		LocalDate avui = LocalDate.now();
		
		Persona persona = new Persona();
		
		persona.setNom(nom);
		persona.setCognoms(cognoms);
		//persona.setNaixement(naixement);
		persona.setNaixement(avui);
		persona.setCorreu(correu);
		persona.setTelefon(telefon);
		persona.setMobil(mobil);
		persona.setAdreca(adreca);
		persona.setLocalitat(localitat);
		persona.setComarca(comarca);
		
		personaRepository.save(persona);
	}
	
	
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -   
	// L L I S T A R   T O T E S   L E S   P E R S O N E S
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	@RequestMapping(method=RequestMethod.GET, path="/llistarPersones")
	public @ResponseBody Map<String, Object> llistarPersones(@RequestParam int ipp) {
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		Iterable<Persona> persones = personaRepository.findAll();
		
		responseMap.put("persones", persones);
		
		int num_persones = 0;
		
		for(Persona p : persones){
			num_persones = num_persones + 1;
		}
		
		Long pagines = Math.round(Math.ceil(num_persones / ipp));
		
		responseMap.put("npersones", pagines);
		
		return responseMap;
	}
	
	
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -   
	// M O D I F I C A R   U N   A T R I B U T   D ' U N A   P E R S O N A
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	@RequestMapping(method=RequestMethod.PUT, path = "/modPersona")
	public @ResponseBody void modPersona (@RequestParam Long id, @RequestParam String nom, @RequestParam String cognoms, @RequestParam String correu, @RequestParam String telefon,
										  @RequestParam String mobil, @RequestParam String adreca, @RequestParam String localitat, @RequestParam String comarca) {
		
		LocalDate avui = LocalDate.now();
		
		Persona persona = personaRepository.findOne(id);
		
		persona.setNom(nom);
		persona.setCognoms(cognoms);
		//persona.setNaixement(naixement);
		persona.setNaixement(avui);
		persona.setCorreu(correu);
		persona.setTelefon(telefon);
		persona.setMobil(mobil);
		persona.setAdreca(adreca);
		persona.setLocalitat(localitat);
		persona.setComarca(comarca);
		
		personaRepository.save(persona);		
	}
	
	
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -   
	// E S B O R R A R   U N A   P E R S O N A
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	@RequestMapping(method=RequestMethod.DELETE, path = "/esborrarPersona")
	public @ResponseBody void esborrarPersona (@RequestParam Long id) {

		personaRepository.delete(id);
	}	
}
