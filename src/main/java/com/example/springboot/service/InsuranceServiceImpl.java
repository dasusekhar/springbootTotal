package com.example.springboot.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.controller.repository.InsuranceRepository;
import com.example.springboot.entity.Insrance;
import com.example.springboot.exception.BusinessException;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	@Autowired
	private InsuranceRepository repository;

	@Override
	public Insrance saveTo(Insrance insur)  {
		
				if(insur.getName().isEmpty()||insur.getName().length()==0)
				{
					throw new BusinessException("601","please send proper name, it blank");
				}
				try
				{
		return repository.save(insur);
				}catch(IllegalArgumentException e)
				{
					throw new BusinessException("602","given employee is null"+e.getMessage());
					
				}catch(Exception e)
				{
					throw new BusinessException("603","something went wrong in service layer"+e.getMessage());
					
				}
				
				
		
	}

	@Override
	public List<Insrance> fetchDetails() {
		
		List<Insrance>emplist=repository.findAll();
		if(emplist.isEmpty())
		{
			throw new BusinessException("604","hey list completely empty, we have nothing to return ");
		}
		try
		{
		return emplist;
		}catch(Exception e)
		{
			throw new BusinessException("605","something went wrong in service layer while  fetching all employees "+e.getMessage());
		}
	}

	@Override
	public Insrance getById(int id) {
		


		return repository.findById(id);
	}


	
	
}
