package com.example.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Insrance;
import com.example.springboot.exception.BusinessException;
import com.example.springboot.exception.ControllerException;
import com.example.springboot.service.InsuranceService;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
	@Autowired
	private InsuranceService service;
	
	Logger log=LoggerFactory.getLogger(InsuranceController.class);
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createInsurance(@RequestBody Insrance insur){
		try {
		Insrance insuranceCreated=service.saveTo(insur);
		log.debug("response {}"+insuranceCreated);
		return new ResponseEntity<>(insuranceCreated,HttpStatus.CREATED);
		
		}catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e)
		{
			ControllerException ce=new ControllerException(" 611","something went wrong in controllerlayer ");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
			
		}
	}
	@GetMapping("/fetch")
public ResponseEntity<?> fetchDetails()
	{
		
		try {
		List<Insrance> detailsFetched=service.fetchDetails();
		log.info("fetch details method is calling");
		return new ResponseEntity<List<?>>(detailsFetched,HttpStatus.OK);
		}catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.NOT_FOUND);
			
		}catch(Exception e)
		{
			ControllerException ce=new ControllerException("612","prombelem in controller layeer fetching the detials");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/insur/{id}")
	public ResponseEntity<Insrance> getById(@PathVariable("id") int id)
	{
		Insrance getByIds=service.getById(id);
		return new ResponseEntity<Insrance>(getByIds,HttpStatus.OK);
	}
	
	
	

}
