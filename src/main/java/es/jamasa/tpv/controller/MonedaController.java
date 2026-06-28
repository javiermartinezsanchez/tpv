package es.jamasa.tpv.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.jamasa.tpv.model.dto.MonedaDTO;
import es.jamasa.tpv.service.MonedaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/moneda")
public class MonedaController extends BaseCrudController{

	@Autowired
	private MonedaService monedaService;
	
	@GetMapping({"","/"})
	public String ListadoGeneral(
	    		@RequestParam Map<String, String> paramsBusqueda,
	            @RequestParam(defaultValue = "0") int page,
	            Model model) {
		setModeloListado(model, "admin/monedas", "admin/moneda/new","/admin/moneda/guardar" , "/home");
		model.addAttribute("moneda", new MonedaDTO());
		model.addAttribute("paginacion", monedaService.listadoPaginado(getParams(page), paramsToMap(paramsBusqueda)));
		return model.getAttribute("viewName").toString(); 
	}
	
	@PostMapping("/guardar")
	public String guardar(@AuthenticationPrincipal UserDetails userDetails,
			 @Valid @ModelAttribute("moneda") MonedaDTO form,
		        BindingResult result,
		        RedirectAttributes redirectAttributes, 
		        Model model) {
		if (result.hasErrors()) {
			return "admin/monedas";
		}
		var monedaGrabada = monedaService.grabar(form, userDetails.getUsername());
		return "redirect:/admin/moneda/";
	}
	@GetMapping("/{id}")
	public String modifica(Model model, @PathVariable Long id) {
		setModeloFormulario(model,"admin/monedas", "/admin/moneda/guardar", "/admin/moneda");
		model.addAttribute("moneda", monedaService.get(id));
		return "admin/monedas :: formularioMoneda";
	}
}
