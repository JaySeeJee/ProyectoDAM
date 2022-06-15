package com.guarenasapp.proyect.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.guarenasapp.proyect.model.Usuario;
import com.guarenasapp.proyect.service.IUsuariosService;


@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
    
	@Autowired
	private IUsuariosService serviceUsuarios;
    
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
    	List<Usuario> lista = serviceUsuarios.buscarTodas();
    	model.addAttribute("usuarios", lista);
		return "usuarios/listUsuarios";
	}

	@GetMapping("/create")
	public String crear(Usuario usuario, Model model) {
		return "usuarios/formUsuarios";
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()){		
			System.out.println("Existieron errores");
			return "usuarios/formUsuario";
		}	
		
		// Guadamos el objeto usuario en la bd
		serviceUsuarios.guardar(usuario);
		attributes.addFlashAttribute("msg", "Los datos del usuario fueron guardados!");		
		return "redirect:/usuarios/index";
	}
    
    @GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {		    	
		// Eliminamos el usuario
    	serviceUsuarios.eliminar(idUsuario);			
		attributes.addFlashAttribute("msg", "El usuario fue eliminado!.");
		return "redirect:/usuarios/index";
	}
}
