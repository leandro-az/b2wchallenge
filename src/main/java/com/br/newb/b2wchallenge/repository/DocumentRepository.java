package com.br.newb.b2wchallenge.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.newb.b2wchallenge.document.Planet;

public interface DocumentRepository extends MongoRepository<Planet,String>{
	Planet findByid(String id);
	List<Planet> findByname(String name);

}
