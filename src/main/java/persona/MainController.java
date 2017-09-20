package persona;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.Persona;
import hello.PersonaRepository;

@Controller
@RequestMapping(path="/benestar")
public class MainController {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -   
	// A F E G I R   U N A   P E R S O N A
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// http://localhost:8080/benestar/addPersona?nom="cc"&cognoms="cc"&correu="cc"&telefon="cc"&mobil="cc"&adreca="cc"&localitat="cc"&comarca="ff"
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

	/*@RequestMapping(method=RequestMethod.GET, path="/llistarPersones")
	public @ResponseBody Iterable<Persona> llistarPersones() {
		
		return personaRepository.findAll();
	}*/
	
	
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -   
	// L L I S T A R   "X"   P E R S O N E S,   S E G O N S   A T R I B U T
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	@RequestMapping(method=RequestMethod.GET, path="/llistarXpersones")
	public @ResponseBody Iterable<Persona> llistarXpersones(@RequestParam String atribut, String valor) {
		
		Iterable<Persona> persones;
		
		switch(atribut) {
			case "id": persones = personaRepository.findById(Long.parseLong(valor)); break;
			case "nom": persones = personaRepository.findByNom(valor); break;
			case "cognoms": persones = personaRepository.findByCognoms(valor); break;
			case "correu": persones = personaRepository.findByCorreu(valor); break;
			case "telefon": persones = personaRepository.findByTelefon(valor); break;
			case "mobil": persones = personaRepository.findByMobil(valor); break;
			case "adreca": persones = personaRepository.findByAdreca(valor); break;
			case "localitat": persones = personaRepository.findByLocalitat(valor); break;
			case "comarca": persones = personaRepository.findByComarca(valor); break;
			default: persones = null;
		}
		
		return persones;
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
	
	
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -   
	// E S B O R R A R   "X"   P E R S O N E S,   S E G O N S   A T R I B U T
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	@RequestMapping(method=RequestMethod.DELETE, path = "/esborrarPersones")
	public @ResponseBody void esborrarPersones (@RequestParam String atribut, @RequestParam String valor) {

		
		if(atribut != "id") {
			Iterable<Persona> persones;
			
			persones = llistarXpersones(atribut, valor);
			
			for (Persona p : persones){
				long id = p.getId();
				personaRepository.delete(id);
			}
		} else
			personaRepository.delete(Long.parseLong(valor));
	}	
}
