package tfrabaioli.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tfrabaioli.rest.entity.Sale;
import tfrabaioli.rest.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Sale>> findAll(){
		List<Sale> list = service.findSales();
		return ResponseEntity.ok().body(list);
	}

}
