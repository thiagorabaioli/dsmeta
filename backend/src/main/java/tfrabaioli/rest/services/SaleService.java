package tfrabaioli.rest.services;


import java.time.LocalDate;
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
		
		List<Sale> list = new ArrayList<>();
		return saleRepo.findAll();
		
	}
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable){
		
		LocalDate min = LocalDate.parse(minDate);
		LocalDate max = LocalDate.parse(maxDate);
		
		return saleRepo.findAll(pageable);
	}

}
