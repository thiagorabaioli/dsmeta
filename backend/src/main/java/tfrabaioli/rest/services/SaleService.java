package tfrabaioli.rest.services;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tfrabaioli.rest.entity.Sale;
import tfrabaioli.rest.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepo;
	
	public List<Sale> findSales() {
		
		return saleRepo.findAll();
		
	}
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable){
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? today.minusDays(365) :  LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		return saleRepo.findSales(min,max, pageable);
	}

}
