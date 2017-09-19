package oficines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/oficina") // This means URL's start with /demo (after Application path)
public class OficinaController {
	
	@Autowired
	private OficinaRepository oficinaRepository;
	
	@GetMapping(path="/allOficines")
	public @ResponseBody Iterable<Oficina> getAllOficines() {
		return oficinaRepository.findAll();
	}
}