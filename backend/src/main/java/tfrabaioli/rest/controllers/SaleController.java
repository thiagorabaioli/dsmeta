package tfrabaioli.rest.controllers;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tfrabaioli.rest.entity.Sale;
import tfrabaioli.rest.services.SaleService;
import tfrabaioli.rest.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@Autowired
	private SmsService smsService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Sale>> findAll(){
		List<Sale> list = service.findSales();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/pages",method = RequestMethod.GET)
	public Page<Sale> findSales (
		@RequestParam(value="minDate", defaultValue = "")String minDate, 
		@RequestParam(value="maxDate", defaultValue = "")String maxDate, 
		Pageable pagaeble){
		return service.findSales(minDate,maxDate,pagaeble);
		
	}
	
	@RequestMapping(value="/notification", method = RequestMethod.GET)
	public void notifySms() {
		smsService.sendSms();
	}
	

}
