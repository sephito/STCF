package com.jeduce.stcf.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.jeduce.stcf.app.models.entity.Repeticion;
import com.jeduce.stcf.app.models.entity.TcfyDet;
import com.jeduce.stcf.app.models.entity.Unidad;
import com.jeduce.stcf.app.models.service.IUsuarioService;




@Controller
@Secured({ "ROLE_ADMIN" })
@RequestMapping("registro")
@SessionAttributes("registro")
public class RegistroController {

	private static List<TcfyDet> tcfydets = new ArrayList<TcfyDet>();
	
	@Autowired
	private IUsuarioService usuarioService;
	
	
	@GetMapping("/menores_40")
	public String listarMen40( Map<String, Object> model) {

		 List<Repeticion> list = new ArrayList<Repeticion>();
		 list.add( new Repeticion("Sin Nota",-1) );
		 list.add( new Repeticion("1",1) );
		 list.add( new Repeticion("2",2) );
		 list.add( new Repeticion("3",3) );
		 list.add( new Repeticion("4",4) );
		 list.add( new Repeticion("5",5) );
		 list.add( new Repeticion("6",6) );
		 list.add( new Repeticion("7",7) );
		 list.add( new Repeticion("8",8) );
		 list.add( new Repeticion("9",9) );
		 list.add( new Repeticion("10",10) );
		 list.add( new Repeticion("11",11) );
		 list.add( new Repeticion("12",12) );
		 list.add( new Repeticion("13",13) );
		 list.add( new Repeticion("14",14) );
		 list.add( new Repeticion("15",15) );
		 list.add( new Repeticion("16",16) );
		 list.add( new Repeticion("17",17) );
		 list.add( new Repeticion("18",18) );
		 list.add( new Repeticion("19",19) );
		 list.add( new Repeticion("20",20) );
		 list.add( new Repeticion("21",21) );
		 list.add( new Repeticion("22",22) );
		 list.add( new Repeticion("23",23) );
		 list.add( new Repeticion("24",24) );
		 list.add( new Repeticion("25",25) );
		 list.add( new Repeticion("26",26) );
		 list.add( new Repeticion("27",27) );
		 list.add( new Repeticion("28",28) );
		 list.add( new Repeticion("29",29) );
		 list.add( new Repeticion("30",30) );
		 list.add( new Repeticion("31",31) );
		 list.add( new Repeticion("32",32) );
		 list.add( new Repeticion("33",33) );
		 list.add( new Repeticion("34",34) );
		 list.add( new Repeticion("35",35) );
		 list.add( new Repeticion("36+",36) );
		 
		 List<Repeticion> listii = new ArrayList<Repeticion>();
		 listii.add( new Repeticion("Sin Nota",-1) );
		 listii.add( new Repeticion("1",1) );
		 listii.add( new Repeticion("2",2) );
		 listii.add( new Repeticion("3",3) );
		 listii.add( new Repeticion("4",4) );
		 listii.add( new Repeticion("5",5) );
		 listii.add( new Repeticion("6",6) );
		 listii.add( new Repeticion("7",7) );
		 listii.add( new Repeticion("8",8) );
		 listii.add( new Repeticion("9",9) );
		 listii.add( new Repeticion("10",10) );
		 listii.add( new Repeticion("11",11) );
		 listii.add( new Repeticion("12",12) );
		 listii.add( new Repeticion("13",13) );
		 listii.add( new Repeticion("14",14) );
		 listii.add( new Repeticion("15",15) );
		 listii.add( new Repeticion("16",16) );
		 listii.add( new Repeticion("17",17) );
		 listii.add( new Repeticion("18",18) );
		 listii.add( new Repeticion("19",19) );
		 listii.add( new Repeticion("20",20) );
		 listii.add( new Repeticion("21",21) );
		 listii.add( new Repeticion("22",22) );
		 listii.add( new Repeticion("23",23) );
		 listii.add( new Repeticion("24",24) );
		 listii.add( new Repeticion("25",25) );
		 listii.add( new Repeticion("26",26) );
		 listii.add( new Repeticion("27",27) );
		 listii.add( new Repeticion("28",28) );
		 listii.add( new Repeticion("29",29) );
		 listii.add( new Repeticion("30",30) );
		 listii.add( new Repeticion("31",31) );
		 listii.add( new Repeticion("32",32) );
		 listii.add( new Repeticion("33",33) );
		 listii.add( new Repeticion("34",34) );
		 listii.add( new Repeticion("35",35) );
		 listii.add( new Repeticion("36",36) );
		 listii.add( new Repeticion("37",37) );
		 listii.add( new Repeticion("38",38) );
		 listii.add( new Repeticion("39",39) );
		 listii.add( new Repeticion("40",40) );
		 listii.add( new Repeticion("41",41) );
		 listii.add( new Repeticion("42",42) );
		 listii.add( new Repeticion("43",43) );
		 listii.add( new Repeticion("44",44) );
		 listii.add( new Repeticion("45",45) );
		 listii.add( new Repeticion("46",46) );
		 listii.add( new Repeticion("47",47) );
		 listii.add( new Repeticion("48",48) );
		 listii.add( new Repeticion("49",49) );
		 listii.add( new Repeticion("50",50) );
		 listii.add( new Repeticion("51",51) );
		 listii.add( new Repeticion("52",52) );
		 listii.add( new Repeticion("53",53) );
		 listii.add( new Repeticion("54",54) );
		 listii.add( new Repeticion("55",55) );
		 listii.add( new Repeticion("56",56) );
		 listii.add( new Repeticion("57",57) );
		 listii.add( new Repeticion("58",58) );
		 listii.add( new Repeticion("59",59) );
		 listii.add( new Repeticion("60",60) );
		 listii.add( new Repeticion("61",61) );
		 listii.add( new Repeticion("62",62) );
		 listii.add( new Repeticion("63",63) );		 		 
		 listii.add( new Repeticion("64+",64) );	
		 
		 List<Repeticion> list_min = new ArrayList<Repeticion>();
		 list_min.add( new Repeticion("Sin Nota",-1) );
		 list_min.add( new Repeticion("1",1) );
		 list_min.add( new Repeticion("2",2) );
		 list_min.add( new Repeticion("3",3) );
		 list_min.add( new Repeticion("4",4) );
		 list_min.add( new Repeticion("5",5) );
		 list_min.add( new Repeticion("6",6) );
		 list_min.add( new Repeticion("7",7) );
		 list_min.add( new Repeticion("8",8) );
		 list_min.add( new Repeticion("9",9) );
		 list_min.add( new Repeticion("10",10) );
		 list_min.add( new Repeticion("11",11) );
		 list_min.add( new Repeticion("12",12) );
		 list_min.add( new Repeticion("13",13) );
		 list_min.add( new Repeticion("14",14) );
		 list_min.add( new Repeticion("15",15) );
		 list_min.add( new Repeticion("16",16) );
		 list_min.add( new Repeticion("17",17) );
		 list_min.add( new Repeticion("18",18) );
		 list_min.add( new Repeticion("19",19) );
		 list_min.add( new Repeticion("20",20) );
		 list_min.add( new Repeticion("21",21) );
		 list_min.add( new Repeticion("22",22) );
		 list_min.add( new Repeticion("23",23) );
		 list_min.add( new Repeticion("24",24) );
		 list_min.add( new Repeticion("25",25) );
		 list_min.add( new Repeticion("26",26) );
		 list_min.add( new Repeticion("27",27) );
		 list_min.add( new Repeticion("28",28) );
		 list_min.add( new Repeticion("29",29) );
		 list_min.add( new Repeticion("30",30) );
		 list_min.add( new Repeticion("31",31) );
		 list_min.add( new Repeticion("32",32) );
		 list_min.add( new Repeticion("33",33) );
		 list_min.add( new Repeticion("34",34) );
		 list_min.add( new Repeticion("35",35) );
		 list_min.add( new Repeticion("36",36) );
		 list_min.add( new Repeticion("37",37) );
		 list_min.add( new Repeticion("38",38) );
		 list_min.add( new Repeticion("39",39) );
		 list_min.add( new Repeticion("40",40) );
		 list_min.add( new Repeticion("41",41) );
		 list_min.add( new Repeticion("42",42) );
		 list_min.add( new Repeticion("43",43) );
		 list_min.add( new Repeticion("44",44) );
		 list_min.add( new Repeticion("45",45) );
		 list_min.add( new Repeticion("46",46) );
		 list_min.add( new Repeticion("47",47) );
		 list_min.add( new Repeticion("48",48) );
		 list_min.add( new Repeticion("49",49) );
		 list_min.add( new Repeticion("50",50) );
		 list_min.add( new Repeticion("51",51) );
		 list_min.add( new Repeticion("52",52) );
		 list_min.add( new Repeticion("53",53) );
		 list_min.add( new Repeticion("54",54) );
		 list_min.add( new Repeticion("55",55) );
		 list_min.add( new Repeticion("56",56) );
		 list_min.add( new Repeticion("57",57) );
		 list_min.add( new Repeticion("58",58) );
		 list_min.add( new Repeticion("59",59) );
		 
		 List<Repeticion> list_sec = new ArrayList<Repeticion>();
		 list_sec.add( new Repeticion("Sin Nota",-1) );
		 list_sec.add( new Repeticion("1",1) );
		 list_sec.add( new Repeticion("2",2) );
		 list_sec.add( new Repeticion("3",3) );
		 list_sec.add( new Repeticion("4",4) );
		 list_sec.add( new Repeticion("5",5) );
		 list_sec.add( new Repeticion("6",6) );
		 list_sec.add( new Repeticion("7",7) );
		 list_sec.add( new Repeticion("8",8) );
		 list_sec.add( new Repeticion("9",9) );
		 list_sec.add( new Repeticion("10",10) );
		 list_sec.add( new Repeticion("11",11) );
		 list_sec.add( new Repeticion("12",12) );
		 list_sec.add( new Repeticion("13",13) );
		 list_sec.add( new Repeticion("14",14) );
		 list_sec.add( new Repeticion("15",15) );
		 list_sec.add( new Repeticion("16",16) );
		 list_sec.add( new Repeticion("17",17) );
		 list_sec.add( new Repeticion("18",18) );
		 list_sec.add( new Repeticion("19",19) );
		 list_sec.add( new Repeticion("20",20) );
		 list_sec.add( new Repeticion("21",21) );
		 list_sec.add( new Repeticion("22",22) );
		 list_sec.add( new Repeticion("23",23) );
		 list_sec.add( new Repeticion("24",24) );
		 list_sec.add( new Repeticion("25",25) );
		 list_sec.add( new Repeticion("26",26) );
		 list_sec.add( new Repeticion("27",27) );
		 list_sec.add( new Repeticion("28",28) );
		 list_sec.add( new Repeticion("29",29) );
		 list_sec.add( new Repeticion("30",30) );
		 list_sec.add( new Repeticion("31",31) );
		 list_sec.add( new Repeticion("32",32) );
		 list_sec.add( new Repeticion("33",33) );
		 list_sec.add( new Repeticion("34",34) );
		 list_sec.add( new Repeticion("35",35) );
		 list_sec.add( new Repeticion("36",36) );
		 list_sec.add( new Repeticion("37",37) );
		 list_sec.add( new Repeticion("38",38) );
		 list_sec.add( new Repeticion("39",39) );
		 list_sec.add( new Repeticion("40",40) );
		 list_sec.add( new Repeticion("41",41) );
		 list_sec.add( new Repeticion("42",42) );
		 list_sec.add( new Repeticion("43",43) );
		 list_sec.add( new Repeticion("44",44) );
		 list_sec.add( new Repeticion("45",45) );
		 list_sec.add( new Repeticion("46",46) );
		 list_sec.add( new Repeticion("47",47) );
		 list_sec.add( new Repeticion("48",48) );
		 list_sec.add( new Repeticion("49",49) );
		 list_sec.add( new Repeticion("50",50) );
		 list_sec.add( new Repeticion("51",51) );
		 list_sec.add( new Repeticion("52",52) );
		 list_sec.add( new Repeticion("53",53) );
		 list_sec.add( new Repeticion("54",54) );
		 list_sec.add( new Repeticion("55",55) );
		 list_sec.add( new Repeticion("56",56) );
		 list_sec.add( new Repeticion("57",57) );
		 list_sec.add( new Repeticion("58",58) );
		 list_sec.add( new Repeticion("59",59) );		
		

		model.put("titulo", "Listado de usuarios");		
		
		List<TcfyDet> tcfydets = usuarioService.ByTcfyDetMM();
		
		model.put("list", list);
		model.put("listii", listii);
		model.put("list_min", list_min);
		model.put("list_sec", list_sec);
		
		model.put("tcfydets", tcfydets);
		model.put("classActiveUsuario", "active");
		return "registro/menores_40";
	}

	@GetMapping("/menores_36")
	public String  listarMen36( Map<String, Object> model) {


		model.put("titulo", "Listado de usuarios");		
		List<TcfyDet> tcfydets = usuarioService.ByTcfyDetFM();
		 			
		
	
		model.put("tcfydets", tcfydets);
		
		model.put("classActiveUsuario", "active");		
		return "registro/menores_36";
	}	
	

	
	@GetMapping("/mayores_36")
	public String listarMay36( Map<String, Object> model) {


		 List<Repeticion> list = new ArrayList<Repeticion>();
		 list.add( new Repeticion("Sin Nota",-1) );
		 list.add( new Repeticion("1",1) );
		 list.add( new Repeticion("2",2) );
		 list.add( new Repeticion("3",3) );
		 list.add( new Repeticion("4",4) );
		 list.add( new Repeticion("5",5) );
		 list.add( new Repeticion("6",6) );
		 list.add( new Repeticion("7",7) );
		 list.add( new Repeticion("8",8) );
		 list.add( new Repeticion("9",9) );
		 list.add( new Repeticion("10",10) );
		 list.add( new Repeticion("11",11) );
		 list.add( new Repeticion("12",12) );
		 list.add( new Repeticion("13",13) );
		 list.add( new Repeticion("14",14) );
		 list.add( new Repeticion("15",15) );
		 list.add( new Repeticion("16",16) );
		 list.add( new Repeticion("17",17) );
		 list.add( new Repeticion("18",18) );
		 list.add( new Repeticion("19",19) );
		 list.add( new Repeticion("20",20) );
		 list.add( new Repeticion("21",21) );
		 list.add( new Repeticion("22",22) );
		 list.add( new Repeticion("23",23) );
		 list.add( new Repeticion("24",24) );
		 list.add( new Repeticion("25",25) );
		 list.add( new Repeticion("26",26) );
		 list.add( new Repeticion("27",27) );
		 list.add( new Repeticion("28",28) );
		 list.add( new Repeticion("29",29) );
		 list.add( new Repeticion("30",30) );
		 list.add( new Repeticion("31",31) );
		 list.add( new Repeticion("32",32) );
		 list.add( new Repeticion("33",33) );
		 list.add( new Repeticion("34",34) );
		 list.add( new Repeticion("35",35) );
		 list.add( new Repeticion("36+",36) );
		
		model.put("titulo", "Listado de usuarios");		
		List<TcfyDet> tcfydets = usuarioService.ByTcfyDetFMA();
		model.put("list", list);
		
		model.put("tcfydets", tcfydets);
		model.put("classActiveUsuario", "active");
		return "registro/mayores_36";
	}		
	
	@GetMapping("/mayores_40")
	public String listarMay40(  Map<String, Object> model) {


		model.put("titulo", "Listado de usuarios");		
		List<TcfyDet> tcfydets = usuarioService.ByTcfyDetMMA();
		
		model.put("tcfydets", tcfydets);
		model.put("classActiveUsuario", "active");
		return "registro/mayores_40";
	}		
	
	@GetMapping("/fuerzas_especiales")
	public String listarFueEsp( Map<String, Object> model) {


		model.put("titulo", "Listado de usuarios");		
	List<TcfyDet> tcfydets = usuarioService.ByTcfyDetFE();
		
		model.put("tcfydets", tcfydets);
		model.put("classActiveUsuario", "active");
		return "registro/fuerzas_especiales";
	}			
	
}
