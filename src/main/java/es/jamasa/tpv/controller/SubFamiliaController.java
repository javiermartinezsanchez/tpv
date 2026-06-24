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

import es.jamasa.tpv.dto.SubFamiliaDTO;
import es.jamasa.tpv.service.SubFamiliaService;
import jakarta.validation.Valid;
@Controller
@RequestMapping("/admin/subfamilia")
public class SubFamiliaController extends BaseCrudController {

	@Autowired
	private SubFamiliaService subFamiliaService;
	
	@GetMapping({"","/"})
	public String ListadoGeneral(@RequestParam Map<String, String> paramsBusqueda,
            @RequestParam(defaultValue = "0") int page,
            Model model) {
		setModeloListado(model, "admin/subfamilias", "","/admin/subfamilia/guardar" , "/home");
		model.addAttribute("subFamilia", new SubFamiliaDTO());
		model.addAttribute("paginacion", subFamiliaService.listadoPaginado(paramsToMap(paramsBusqueda), getParams(page)));
	return model.getAttribute("viewName").toString(); 
	}
	
	@PostMapping("/guardar")
	public String guardar(@AuthenticationPrincipal UserDetails userDetails,
			@Valid @ModelAttribute("subFamilia") SubFamiliaDTO form,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			Model model) {
		if (result.hasErrors()) {
			return "admin/subfamilias";
		}
		subFamiliaService.grabar(form,  userDetails.getUsername());
		return "redirect:/admin/subfamilia";
	}	

	@GetMapping("/{id}")
	public String modifica(Model model, @PathVariable Long id) {
		
		setModeloFormulario(model,"admin/familias", "/admin/familia/guardar", "/admin/familia");
		model.addAttribute("subFamilia", subFamiliaService.get(id));
		return "admin/subfamilias :: formularioSubFamilia";
	}
}
