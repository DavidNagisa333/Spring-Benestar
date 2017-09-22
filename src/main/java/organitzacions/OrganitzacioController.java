package organitzacions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import persona.Persona;


@Controller 
@RequestMapping(path="/organitzacio")
public class OrganitzacioController {
	
	@Autowired
	private OrganitzacioRepository organitzacioRepository;
	
	
	
	
	@RequestMapping(path="/listOrganitzacions", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAllOrganitzacions(@RequestHeader("token") String token,@RequestParam int itemsPerPage) {
		
		System.out.println(token);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		Iterable<Organitzacio> organitzacions = organitzacioRepository.findAll();
		
		responseMap.put("organitzacions", organitzacions);
		
		int num_organitzacions = 0;
		
		for(Organitzacio o : organitzacions){
			num_organitzacions = num_organitzacions + 1;
		}
		
		Long pagines = Math.round(Math.ceil(num_organitzacions / itemsPerPage));
		
		responseMap.put("pagines",pagines);
		
		return responseMap;
	}
	
	
	
	
	
	@RequestMapping(path="/addOrganitzacio", method=RequestMethod.POST)
	public @ResponseBody String addOrganitzacio(@RequestParam Long id, @RequestParam String nom, @RequestParam String telefon){
		
		Organitzacio o = new Organitzacio();		
		o.setId(id);
		o.setNom(nom);
		o.setTelefon(telefon);		
		
		organitzacioRepository.save(o);
		
		return "saved";
	}
	
	@RequestMapping(path="/updateOrganitzacio", method=RequestMethod.PUT)
	public @ResponseBody String updateOrganitzacio(@RequestParam Long id, @RequestParam String nom, @RequestParam String telefon){
		
		Organitzacio o = organitzacioRepository.findOne(id);			
		o.setNom(nom);
		o.setTelefon(telefon);		
		
		organitzacioRepository.save(o);
		
		return "updated";
	}
	

	@RequestMapping(path="/deleteOrganitzacio", method=RequestMethod.DELETE)
	public @ResponseBody String deleteOrganitzacio(@RequestParam Long id){
		
		organitzacioRepository.delete(id);	
		
		return "deleted";
	}
<<<<<<< HEAD
}
=======


/*
	@GetMapping(path="/allServeis")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();

	}
	
	@GetMapping(path="/addOficina")
	public @ResponseBody String addNewOficina(@RequestParam Integer id, @RequestParam Integer Codi, @RequestParam String Poblacio, @RequestParam String provincia, @RequestParam String Direccio){
		
	}
	*/
	}

>>>>>>> c8f9f105eedb848b65f17e14a1ee0c20c1d4d56d
