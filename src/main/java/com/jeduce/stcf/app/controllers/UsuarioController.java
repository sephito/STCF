package com.jeduce.stcf.app.controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeduce.stcf.app.models.entity.Periodo;
import com.jeduce.stcf.app.models.entity.Tcf;
import com.jeduce.stcf.app.models.entity.TcfyDet;
import com.jeduce.stcf.app.models.entity.TipoExamen;
import com.jeduce.stcf.app.models.entity.Unidad;
import com.jeduce.stcf.app.models.entity.UsuPer;
import com.jeduce.stcf.app.models.entity.Usuario;
import com.jeduce.stcf.app.models.service.IExamenService;
import com.jeduce.stcf.app.models.service.IPeriodoService;
import com.jeduce.stcf.app.models.service.IUsuarioService;
import com.jeduce.stcf.app.util.paginator.PageRender;

@Controller
@Secured({ "ROLE_ADMIN" })
@RequestMapping("configuracion/usuario")
@SessionAttributes("usuario")
public class UsuarioController {
	static Connection connection = null;

	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IPeriodoService periodoService;
	
	@Autowired
	private IExamenService examenService;
	

	@GetMapping("/listar")
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		Pageable pageRequest = PageRequest.of(page, 50);

		Page<Usuario> usuarios = usuarioService.findAll(pageRequest);

		PageRender<Usuario> pageRender = new PageRender<Usuario>("listar", usuarios);
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("page", pageRender);
		model.addAttribute("classActiveUsuario", "active");
		return "usuario/listar";
	}

	@GetMapping("/ver")
	public String ver(Map<String, Object> model) {

		

		model.put("titulo", "Listado de unidades");
		List<Unidad> unidad = usuarioService.ByUnidad();
		model.put("unidades", unidad);

		model.put("classActiveUsuario", "active");
		return "usuario/ver";
	}

	@RequestMapping(value = "/unidad/{id}")
	public String verPersonal(@PathVariable(value = "id") String id, Map<String, Object> model,
			RedirectAttributes flash) {

		List<Tcf> tcf = null;
		List<TcfyDet> tcfydet = null;

		if (id != "" || id != null) {
			tcf = usuarioService.ByTcf(id);
			if (tcf == null) {
				flash.addFlashAttribute("error", "El Codigo de la unidad no existe en la BBDD!");
				return "redirect:/ver";
			}
		} else {
			flash.addFlashAttribute("error", "El Codigo de la unidad no puedeservacio!");
			return "redirect:/ver";
		}
		model.put("tcfs", tcf);
		model.put("titulo", "Listado de Personal");
		List<TipoExamen> tipoExamenes = examenService.findAllTipoExamen();
		model.put("tipoExamenes", tipoExamenes);
		return "usuario/personal";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		model.put("titulo", "Crear Usuario");
		return "usuario/form";
	}

	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Usuario usuario = null;

		if (id > 0) {
			usuario = usuarioService.findOne(id);
			if (usuario == null) {
				flash.addFlashAttribute("error", "El ID del usuario no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del usuario no puede ser cero!");
			return "redirect:/listar";
		}
		model.put("usuario", usuario);
		model.put("titulo", "Editar Usuario");
		return "usuario/form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario del Usuario");
			return "usuario/form";
		}

		String mensajeFlash = (usuario.getId() != null) ? "Usuario editado con éxito!" : "Usuario creado con éxito!";

		usuarioService.save(usuario);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/configuracion/usuario/listar";

	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			// Usuario usuario = usuarioService.findOne(id);

			usuarioService.delete(id);
			flash.addFlashAttribute("success", "Usuario eliminado con éxito!");

		}
		return "redirect:/configuracion/usuario/listar";
	}

	@RequestMapping(value = "/impMilitares", method = RequestMethod.POST)
	public String impMilitaresS(@ModelAttribute UsuPer usuper) throws SQLException {
		conection();

		CallableStatement cstmt = connection.prepareCall("{ ? = call F_PERSONAL_IMP(?) }");
		System.out.println(usuper.getCodigo());
		cstmt.registerOutParameter(1, Types.VARCHAR);
		cstmt.setString(2, usuper.getCodigo());
		cstmt.executeUpdate();
		float acctBal = cstmt.getFloat(1);
		System.out.println(acctBal);
		
		CallableStatement cstmt1 = connection.prepareCall("{ ? = call F_INSERTAR_TCFDET(?) }");
		System.out.println(usuper.getCodigo());
		cstmt1.registerOutParameter(1, Types.VARCHAR);
		cstmt1.setString(2, "201811A");
		cstmt1.executeUpdate();
		float acctBal2 = cstmt1.getFloat(1);
		System.out.println(acctBal2);

		return "redirect:/configuracion/usuario/listar";
	}

	@RequestMapping(value = "/insTcfdet", method = RequestMethod.POST)
	public String insTcfdet(@ModelAttribute UsuPer usuper) throws SQLException {
		conection();

		CallableStatement cstmt = connection.prepareCall("{ ? = call F_INSERTAR_TCFDET(?) }");
		System.out.println(usuper.getCodigo());
		cstmt.registerOutParameter(1, Types.VARCHAR);
		cstmt.setString(2, "201811A");
		cstmt.executeUpdate();
		float acctBal = cstmt.getFloat(1);
		System.out.println(acctBal);
		
		return "redirect:/configuracion/usuario/listar";
	}

	
	
	@RequestMapping(value = "/impMilitares")
	public String impMilitares(Model model) {
		String codigo = "";
		model.addAttribute("usuper", new UsuPer());
		model.addAttribute("titulo", "Importar Militares");
		List<Periodo> periodos = periodoService.findAll();
		model.addAttribute("periodos", periodos);
		return "usuario/impMilitares";
	}

	
	@RequestMapping(value = "/selectPeriodo")
	public String selectPeriodo(Model model) {
		String codigo = "";
		model.addAttribute("usuper", new UsuPer());
		model.addAttribute("titulo", "Importar Milistares");
		List<Periodo> periodos = periodoService.findAll();
		model.addAttribute("periodos", periodos);
		return "usuario/selectPeriodo";
	}

	@RequestMapping(value = "/selectPeriodo", method = RequestMethod.POST)
	public String selectPeriodo( Model model, RedirectAttributes flash,
			SessionStatus status) {


		return "redirect:/configuracion/usuario/listar";

	}
	
	public static Statement conection() throws SQLException {
		try {

			Class.forName("oracle.jdbc.OracleDriver");
			//
			connection = DriverManager.getConnection("jdbc:oracle:thin:@10.64.3.24:1522:DOCTRINA", "DOC_STCF",
					"123456789");
			System.out.println("Conectado a la Base de datos POS BARARED-Oracle");
		} catch (Exception e) {
			System.out.println("Error: Imposible realizar la conexion a BD.");
			e.printStackTrace();
		}

		return null;

	}

}
