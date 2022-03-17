package com.example.springboot.service;

import java.util.List;

import com.example.springboot.entity.Insrance;

public interface InsuranceService{


	Insrance saveTo(Insrance insur) ;

	List<Insrance> fetchDetails();

	Insrance getById(int id);

	

}
