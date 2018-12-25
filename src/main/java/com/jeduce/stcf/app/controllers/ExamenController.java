package com.jeduce.stcf.app.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
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

import com.jeduce.stcf.app.models.entity.Examen;
import com.jeduce.stcf.app.models.entity.Prueba;
import com.jeduce.stcf.app.models.entity.TipoExamen;
import com.jeduce.stcf.app.models.service.IExamenService;
import com.jeduce.stcf.app.util.paginator.PageRender;

@Controller
@Secured("ROLE_ADMIN") 
@RequestMapping("configuracion/examen")
@SessionAttributes("examen")
public class ExamenController {

	protected final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private IExamenService examenService;

	@GetMapping("/listar")
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model,
			Authentication authentication,
			HttpServletRequest request) {

		if (authentication != null) {
			logger.info("Hola usuario autenticado, tu username es : ".concat(authentication.getName()));
		}

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			logger.info(
					"Utilizando de forma estatica SecurityContextHolder.getContext().getAuthentication(); Usuario autenticado, tu username es : "
							.concat(auth.getName()));
		}

		if(hasRole("ROLE_ADMIN")) {
			logger.info("Hola ".concat(auth.getName()).concat(" tienes acceso!"));
		}else {
			logger.info("Hola ".concat(auth.getName()).concat(" No tienes acceso!"));
		}
		
		
		SecurityContextHolderAwareRequestWrapper securityContext= new SecurityContextHolderAwareRequestWrapper(request,"ROLE_");
		
		if(securityContext.isUserInRole("ADMIN")) {
			logger.info("Forma usando SecurityContextHolderAwareRequestWrapper: Hola ".concat(auth.getName()).concat("Tienes acceso"));
		}else {
			logger.info("Forma usando SecurityContextHolderAwareRequestWrapper: Hola ".concat(auth.getName()).concat("No tienes acceso!"));
		}
		
		if(request.isUserInRole("ROLE_ADMIN")) {
			logger.info("Forma usando HttpServletRequest: Hola ".concat(auth.getName()).concat("Tienes acceso"));
		}else {
			logger.info("Forma usando HttpServletRequest: Hola ".concat(auth.getName()).concat("No tienes acceso!"));
		}		
		
		Pageable pageRequest = PageRequest.of(page, 10);

		// Page<Examen> examenes = examenService.findAll(pageRequest);
		Page<Examen> examenes = examenService.fetchByIdWithExamenWhithTipoExamenWithPrueba(pageRequest);

		PageRender<Examen> pageRender = new PageRender<Examen>("listar", examenes);
		model.addAttribute("titulo", "Listado de Examenes");
		model.addAttribute("examenes", examenes);
		model.addAttribute("page", pageRender);
		model.addAttribute("classActiveExamen","active");
		return "examen/listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Examen examen = new Examen();
		model.put("examen", examen);
		model.put("titulo", "Crear Examen");
		List<Prueba> pruebas = examenService.findAllPrueba();
		model.put("pruebas", pruebas);
		List<TipoExamen> tipoExamenes = examenService.findAllTipoExamen();
		model.put("tipoExamenes", tipoExamenes);
		return "examen/form";
	}

	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Examen examen = null;

		if (id > 0) {
			examen = examenService.findOne(id);
			if (examen == null) {
				flash.addFlashAttribute("error", "El ID del Examen no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del Examen no puede ser cero!");
			return "redirect:/listar";
		}
		model.put("examen", examen);
		model.put("titulo", "Editar el examen");
		List<Prueba> pruebas = examenService.findAllPrueba();
		model.put("pruebas", pruebas);
		List<TipoExamen> tipoExamenes = examenService.findAllTipoExamen();
		model.put("tipoExamenes", tipoExamenes);
		return "examen/form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Examen examen, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Examen");
			List<TipoExamen> tipoExamenes = examenService.findAllTipoExamen();
			model.addAttribute("tipoExamenes", tipoExamenes);
			List<Prueba> pruebas = examenService.findAllPrueba();
			model.addAttribute("pruebas", pruebas);
			return "examen/form";
		}

		String mensajeFlash = (examen.getId() != null) ? "Examen editado con éxito!" : "Examen creada con éxito!";

		examenService.save(examen);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/configuracion/examen/listar";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			// Examen examen = examenService.findOne(id);

			examenService.delete(id);
			flash.addFlashAttribute("success", "Tipo de Examen eliminado con éxito!");

		}
		return "redirect:/configuracion/examen/listar";
	}

	private boolean hasRole(String role) {

		SecurityContext context = SecurityContextHolder.getContext();

		if (context == null) {
			return false;
		}

		Authentication auth = context.getAuthentication();

		if (auth == null) {
			return false;
		}

		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

		return authorities.contains(new SimpleGrantedAuthority(role));

		/*
		 * for(GrantedAuthority authority: authorities) {
		 * if(role.equals(authority.getAuthority())) {
		 * logger.info("Hola usuario ".concat(auth.getName()).concat(" tu role es: "
		 * .concat(authority.getAuthority()))); return true; } }
		 * 
		 * return false;
		 */

	}

}
