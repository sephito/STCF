package com.jeduce.stcf.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeduce.stcf.app.models.entity.Prueba;
import com.jeduce.stcf.app.models.service.IPruebaService;
import com.jeduce.stcf.app.util.paginator.PageRender;

@Controller
@Secured({"ROLE_ADMIN"})
@RequestMapping("configuracion/prueba")
@SessionAttributes("prueba")
public class PruebaController {

	@Autowired
	private IPruebaService pruebaService;	
	
	@GetMapping("/listar")
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 10);

		Page<Prueba> pruebas = pruebaService.findAll(pageRequest);

		PageRender<Prueba> pageRender = new PageRender<Prueba>("listar", pruebas);
		model.addAttribute("titulo", "Listado de Pruebas");
		model.addAttribute("pruebas", pruebas);
		model.addAttribute("page", pageRender);
		model.addAttribute("classActivePrueba","active");
		return "prueba/listar";
	}	
	
	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Prueba prueba = new Prueba();
		model.put("prueba", prueba);
		model.put("titulo", "Crear Tipo de Examen");
		return "prueba/form";
	}	
	
	
	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Prueba prueba = null;

		if (id > 0) {
			prueba = pruebaService.findOne(id);
			if (prueba == null) {
				flash.addFlashAttribute("error", "El ID de la Prueba no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID de la Prueba no puede ser cero!");
			return "redirect:/listar";
		}
		model.put("prueba", prueba);
		model.put("titulo", "Editar la prueba");
		return "prueba/form";
	}	
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Prueba prueba, BindingResult result, Model model,
			RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Prueba");
			return "prueba/form";
		}

		

		

		String mensajeFlash = (prueba.getId() != null) ? "Prueba editado con éxito!" : "Prueba creada con éxito!";

		pruebaService.save(prueba);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/configuracion/prueba/listar";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			//Prueba prueba = pruebaService.findOne(id);

			pruebaService.delete(id);
			flash.addFlashAttribute("success", "Tipo de Prueba eliminado con éxito!");


		}
		return "redirect:/configuracion/prueba/listar";
	}	
	
}
