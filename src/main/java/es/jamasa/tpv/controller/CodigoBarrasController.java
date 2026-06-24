package es.jamasa.tpv.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.jamasa.tpv.service.CodeBarWriterService;

@Controller
@RequestMapping("/admin/codigobarras")
public class CodigoBarrasController extends BaseCrudController {

	@Autowired 
	CodeBarWriterService cbService;
	@GetMapping({"","/"})
	public String ListadoGeneral(
	    		@RequestParam Map<String, String> paramsBusqueda,
	            @RequestParam(defaultValue = "0") int page,
	            Model model) {
		
		return "home";
	}
	
	@GetMapping("/preview")
    public String previewBarcodes(Model model) {
        // Ejemplo: Lista de 12 dígitos (ZXing añadirá el 13º dígito de control)
        List<String> listaProductos = List.of(
            "200000000001", "200000000002", "200000000003", "200000000004"
        );
        model.addAttribute("barcodes", cbService.genCodeBarEAN12Base64(listaProductos));
        return "admin/barcode/barcode-preview";
	}
}
