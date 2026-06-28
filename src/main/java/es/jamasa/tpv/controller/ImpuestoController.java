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

import es.jamasa.tpv.model.dto.ImpuestoDTO;
import es.jamasa.tpv.service.ImpuestoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/impuesto")
public class ImpuestoController extends BaseCrudController{

	@Autowired
	private ImpuestoService impuestoService;
	
	@GetMapping({"","/"})
	public String ListadoGeneral(
	    		@RequestParam Map<String, String> paramsBusqueda,
	            @RequestParam(defaultValue = "0") int page,
	            Model model) {
		setModeloListado(model, "admin/impuestos", "","/admin/impuesto/guardar" , "/home");
		model.addAttribute("impuesto", new ImpuestoDTO());
		model.addAttribute("paginacion", impuestoService.listadoPaginado(paramsToMap(paramsBusqueda), getParams(page)));
		return model.getAttribute("viewName").toString(); 
	}
	
	@PostMapping("/guardar")
	public String guardar(@AuthenticationPrincipal UserDetails userDetails,
			@Valid @ModelAttribute("impuesto") ImpuestoDTO form,
			BindingResult result,
			RedirectAttributes redirecAttributes,
			Model model) {
		if (result.hasErrors()) {
			return "admin/impuestos";
		}
		impuestoService.grabar(form,userDetails.getUsername());
		return "redirect:/admin/impuesto";
	}
	
	@GetMapping("/{id}")
	public String modifica(Model model, @PathVariable Long id) {
		setModeloFormulario(model,"admin/impuestos", "/admin/impuesto/guardar", "/admin/impuesto");
		model.addAttribute("impuesto", impuestoService.get(id));
		return "admin/impuestos :: formularioImpuesto";
	}


			
			
			
			
	
}
