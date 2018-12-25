package com.jeduce.stcf.app.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeduce.stcf.app.models.entity.TiempoDescuento;
import com.jeduce.stcf.app.util.paginator.PageRender;

@Controller
public class TestController {

	@GetMapping("/test")
	public String test() {

		return "test";
	}
	
}
