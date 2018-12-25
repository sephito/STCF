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

import com.jeduce.stcf.app.models.entity.TipoExamen;
import com.jeduce.stcf.app.models.service.ITipoExamenService;
import com.jeduce.stcf.app.util.paginator.PageRender;


@Controller
@Secured({"ROLE_ADMIN"})
@RequestMapping("configuracion/tipoExamen")
//@RequestMapping("configuracion/tipoExamen")
@SessionAttributes("tipoExamen")
public class TipoExamenController {
	@Autowired
	private ITipoExamenService tipoExamenService;

	
	@GetMapping("/listar")
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 10);

		Page<TipoExamen> tipoExamenes = tipoExamenService.findAll(pageRequest);

		PageRender<TipoExamen> pageRender = new PageRender<TipoExamen>("listar", tipoExamenes);
		model.addAttribute("titulo", "Listado de Tipos de Examenes");
		model.addAttribute("tipoExamenes", tipoExamenes);
		model.addAttribute("page", pageRender);
		model.addAttribute("classActiveTipoExamen","active");
		return "tipoExamen/listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		TipoExamen tipoExamen = new TipoExamen();
		model.put("tipoExamen", tipoExamen);
		model.put("titulo", "Crear Tipo de Examen");
		return "tipoExamen/form";
	}

	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		TipoExamen tipoExamen = null;

		if (id > 0) {
			tipoExamen = tipoExamenService.findOne(id);
			if (tipoExamen == null) {
				flash.addFlashAttribute("error", "El ID del Tipo de Examen no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del Tipo de Examen no puede ser cero!");
			return "redirect:/listar";
		}
		model.put("tipoExamen", tipoExamen);
		model.put("titulo", "Editar el Tipo de Examen");
		return "tipoExamen/form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid TipoExamen tipoExamen, BindingResult result, Model model,
			RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Tipo de Examen");
			return "tipoExamen/form";
		}

		

		

		String mensajeFlash = (tipoExamen.getId() != null) ? "Tipo de Examen editado con éxito!" : "Tipo de Examen creado con éxito!";

		tipoExamenService.save(tipoExamen);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/configuracion/tipoExamen/listar";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			//TipoExamen tipoExamen = tipoExamenService.findOne(id);

			tipoExamenService.delete(id);
			flash.addFlashAttribute("success", "Tipo de Examen eliminado con éxito!");


		}
		return "redirect:/configuracion/tipoExamen/listar";
	}
}
