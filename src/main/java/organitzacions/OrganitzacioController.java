package organitzacions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/organitzacio") // This means URL's start with /demo (after Application path)
public class OrganitzacioController {
	
	@Autowired
	private OrganitzacioRepository organitzacioRepository;
	
	@RequestMapping(path="/allOrganitzacions", method=RequestMethod.GET)
	public @ResponseBody Iterable<Organitzacio> getAllOrganitzacions() {
		return organitzacioRepository.findAll();
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
	
<<<<<<< HEAD
	@RequestMapping(path="/deleteOrganitzacio", method=RequestMethod.DELETE)
	public @ResponseBody String deleteOrganitzacio(@RequestParam Long id){
		
		organitzacioRepository.delete(id);	
		
		return "deleted";
	}

=======
	@GetMapping(path="/allServeis")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
<<<<<<< HEAD:src/main/java/hello/MainController.java
	}
	
	@GetMapping(path="/addOficina")
	public @ResponseBody String addNewOficina(@RequestParam Integer id, @RequestParam Integer Codi, @RequestParam String Poblacio, @RequestParam String provincia, @RequestParam String Direccio){
		
	}
=======
	}*/
>>>>>>> 9fc6bbff759e19b4f7b8825805c0461fdf2b17db:src/main/java/organitzacions/OrganitzacioController.java
>>>>>>> 118fc06e0e12b632a553d595c034a5bde6f35a56
}
