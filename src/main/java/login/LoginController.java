package login;


import static org.assertj.core.api.Assertions.offset;
import static org.mockito.Matchers.intThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
<<<<<<< HEAD:src/main/java/login/LoginController.java
=======


>>>>>>> 118fc06e0e12b632a553d595c034a5bde6f35a56:src/main/java/login/MainController.java
import org.springframework.web.bind.annotation.CrossOrigin;

import net.minidev.json.JSONObject;


@RestController
@RequestMapping(path="/login")
public class LoginController {
	
	
}

