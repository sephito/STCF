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

import com.jeduce.stcf.app.models.entity.TiempoDescuento;
import com.jeduce.stcf.app.models.service.ITiempoDescuentoService;
import com.jeduce.stcf.app.util.paginator.PageRender;


@Controller
@Secured({"ROLE_ADMIN"})
@RequestMapping("configuracion/tiempoDescuento")
@SessionAttributes("tiempoDescuento")
public class TiempoDescuentoController {
	@Autowired
	private ITiempoDescuentoService tiempoDescuentoService;


	@GetMapping("/listar")
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest =  PageRequest.of(page, 10);

		Page<TiempoDescuento> tiempoDescuentos = tiempoDescuentoService.findAll(pageRequest);

		PageRender<TiempoDescuento> pageRender = new PageRender<TiempoDescuento>("listar", tiempoDescuentos);
		model.addAttribute("titulo", "Listado de Tiempos de Descuentos");
		model.addAttribute("tiempoDescuentos", tiempoDescuentos);
		model.addAttribute("page", pageRender);
		model.addAttribute("classActiveSettings","active");
		return "tiempoDescuento/listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		TiempoDescuento tiempoDescuento = new TiempoDescuento();
		model.put("tiempoDescuento", tiempoDescuento);
		model.put("titulo", "Crear Tiempo Descuento");
		return "tiempoDescuento/form";
	}

	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") String id, Map<String, Object> model, RedirectAttributes flash) {

		TiempoDescuento tiempoDescuento = null;

		if (id != "" || id != null) {
			tiempoDescuento = tiempoDescuentoService.findOne(id);
			if (tiempoDescuento == null) {
				flash.addFlashAttribute("error", "El ID del Tiempo Descuento no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del Tiempo Descuento no puede ser cero!");
			return "redirect:/listar";
		}
		model.put("tiempoDescuento", tiempoDescuento);
		model.put("titulo", "Editar el Tiempo de Descuento");
		return "tiempoDescuento/form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid TiempoDescuento tiempoDescuento, BindingResult result, Model model,
			RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Tiempo Descuento");
			return "tiempoDescuento/form";
		}

		

		

		String mensajeFlash = (tiempoDescuento.getCubigeoCod()!= null) ? "Tiempo Descuento editado con éxito!" : "Tiempo Descuento creado con éxito!";

		tiempoDescuentoService.save(tiempoDescuento);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/configuracion/tiempoDescuento/listar";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") String id, RedirectAttributes flash) {

		if (id != "" || id != null) {
			//TiempoDescuento tiempoDescuento = tiempoDescuentoService.findOne(id);

			tiempoDescuentoService.delete(id);
			flash.addFlashAttribute("success", "Tipo de Examen eliminado con éxito!");


		}
		return "redirect:/configuracion/tiempoDescuento/listar";
	}
}
