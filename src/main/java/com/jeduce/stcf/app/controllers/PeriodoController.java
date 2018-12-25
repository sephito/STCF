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

import com.jeduce.stcf.app.models.entity.Periodo;
import com.jeduce.stcf.app.models.service.IPeriodoService;
import com.jeduce.stcf.app.util.paginator.PageRender;

@Controller
@Secured({"ROLE_ADMIN"})
@RequestMapping("configuracion/periodo")
@SessionAttributes("periodo")
public class PeriodoController {

	@Autowired
	private IPeriodoService periodoService;	
	
	@GetMapping("/listar")
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 10);

		Page<Periodo> periodos = periodoService.findAll(pageRequest);

		PageRender<Periodo> pageRender = new PageRender<Periodo>("listar", periodos);
		model.addAttribute("titulo", "Listado de Periodos");
		model.addAttribute("periodos", periodos);
		model.addAttribute("page", pageRender);
		model.addAttribute("classActivePeriodo","active");
		return "periodo/listar";
	}	
	
	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Periodo periodo = new Periodo();
		model.put("periodo", periodo);
		model.put("titulo", "Crear Periodo");
		return "periodo/form";
	}	
	
	
	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") String id, Map<String, Object> model, RedirectAttributes flash) {

		Periodo periodo = null;

		if (id != "" || id != null) {
			periodo = periodoService.findOne(id);
			if (periodo == null) {
				flash.addFlashAttribute("error", "El ID del Periodo no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del Periodo no puede ser cero!");
			return "redirect:/listar";
		}
		model.put("periodo", periodo);
		model.put("titulo", "Editar el periodo");
		return "periodo/form";
	}	
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Periodo periodo, BindingResult result, Model model,
			RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Periodo");
			return "periodo/form";
		}

		

		

		String mensajeFlash = (periodo.getCperiodoCod() != null) ? "Periodo editado con éxito!" : "Periodo creada con éxito!";

		periodoService.save(periodo);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/configuracion/periodo/listar";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") String id, RedirectAttributes flash) {

		if (id != "" || id != null) {		
			//Periodo periodo = periodoService.findOne(id);

			periodoService.delete(id);
			flash.addFlashAttribute("success", "Periodo eliminado con éxito!");


		}
		return "redirect:/configuracion/periodo/listar";
	}	
	
}
