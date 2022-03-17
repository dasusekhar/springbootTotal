package com.example.springboot.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Insrance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insrance,Integer> {

	Insrance findById(int id);

	Insrance findByAddress(String address);

	Insrance findByName(String name);

}
