package es.jamasa.tpv.controller;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.jamasa.tpv.model.util.UserUtil;

/**
 * Controlador inicial de la aplicación.
 * 
 * Para acceso inicial anónimo "/" y para el reencaminar al login, registro o modificación de datos.
 */
@Controller
public class HomeController extends BaseCrudController {

	@Autowired 
    SmartValidator validator;
	/**
	 * Acceso a la página principal.
	 * @param modelo Modelo de la vista
	 * @param authentication {@code Authentication} Injectada por Spring
	 * @return Invocamos a la página "home" dependiendo de quién esté accediendo.
	 */
	@GetMapping("/")
	public String handleAnonimousHome(Authentication authentication,
			@RequestParam Map<String, String> paramsBusqueda,
			@RequestParam(name="page", defaultValue = "0") int page,
			Model modelo) {
		modelo.addAttribute("title", "Home");
		String urlUser= "";
		if (authentication !=null) {
		 urlUser =  UserUtil.defineHome(UserUtil.getRoles(authentication));
		 modelo.addAttribute("urlUser", "admin");
			return "redirect:" + urlUser + "/home";
		}
		return urlUser.concat("/home");
	}
	/**
	 * Método que redirige al /home de cada rol.
	 * @param modelo Modelo stándar de Spring.
	 * @param authentication {@link Authentication} del usuario actual.
	 * @return Localización del la página "home" de acuerdo al rol de cada usuario.
	 */
	@GetMapping("/home")
	public String accesoStandard(Authentication authentication, @RequestParam Map<String, String> paramsBusqueda,
			@RequestParam(name="page", defaultValue = "0") int page,Model modelo ) {
		return handleAnonimousHome( authentication, null, 0, modelo);
	}
	@GetMapping("/login")
	public String handleLogin(@RequestParam(required = false) String success,
			Model model) {
		if (success != null) {
			model.addAttribute("success", "mensaje.grabacionOK");
			}
		return "login";
	}
	
	@GetMapping("/admin/home")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String adminHome(Model modelo) {
		return "admin/home";
	}

	@GetMapping("/miperfil")
	public String miperfil(Authentication authentication) {
		return String.format("redirect:%s/miperfil", UserUtil.defineHome(UserUtil.getRoles(authentication)));
	}

}
