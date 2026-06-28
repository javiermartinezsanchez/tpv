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

import es.jamasa.tpv.model.dto.FamiliaDTO;
import es.jamasa.tpv.service.FamiliaService;
import es.jamasa.tpv.service.ImpuestoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/familia")
public class FamiliaController extends BaseCrudController{

	@Autowired
	private FamiliaService familiaService;
	
	@Autowired
	ImpuestoService impuestoService;
	@GetMapping({"","/"})
	public String ListadoGeneral(
	    		@RequestParam Map<String, String> paramsBusqueda,
	            @RequestParam(defaultValue = "0") int page,
	            Model model) {
		setModeloListado(model, "admin/familias", "","/admin/familia/guardar" , "/home");
		model.addAttribute("familia", new FamiliaDTO());
		model.addAttribute("impuestos", impuestoService.lista());
		model.addAttribute("paginacion", familiaService.listadoPaginado(paramsToMap(paramsBusqueda), getParams(page)));
		return model.getAttribute("viewName").toString(); 
	}
	
	@PostMapping("/guardar")
	public String guardar(@AuthenticationPrincipal UserDetails userDetails,
			@Valid @ModelAttribute("familia" ) FamiliaDTO form,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			Model model) {
		if (result.hasErrors()) {
			return "admin/familias";
		}
		familiaService.grabar(form, userDetails.getUsername());
		return "redirect:/admin/familia";
	}
	
	@GetMapping("/{id}")
	public String modifica(Model model, @PathVariable Long id) {
		
		setModeloFormulario(model,"admin/familias", "/admin/familia/guardar", "/admin/familia");
		model.addAttribute("impuestos", impuestoService.lista());
		model.addAttribute("familia", familiaService.get(id));
		return "admin/familias :: formularioFamilia";
	}
}
