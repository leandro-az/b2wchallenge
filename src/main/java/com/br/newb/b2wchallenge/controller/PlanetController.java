package com.br.newb.b2wchallenge.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.newb.b2wchallenge.document.Planet;
import com.br.newb.b2wchallenge.repository.DocumentRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="API REST B2W STAR WARS")
@CrossOrigin(origins="*")
public class PlanetController {
	
	@Autowired
	  private DocumentRepository repository;
	
	 @RequestMapping(value = "/planet", method = RequestMethod.GET)
	 @ApiOperation(value="Return a list of planets")
	  public List<Planet> getAllPlanets() {
	    return repository.findAll();
	  }

	  @RequestMapping(value = "/planet/{id}", method = RequestMethod.GET)
	  @ApiOperation(value="Return one planet by id")
	  public Planet getPlanetById(@PathVariable("id") String id) {
	    return repository.findByid(id);
	  }
	  
	  @RequestMapping(value = "/planetn/{name}", method = RequestMethod.GET)
	  @ApiOperation(value="Return one or more planets by name")
	  public List<Planet> getPlanetByName(@PathVariable("name") String name) {
	    return repository.findByname(name);
	  }
	  
	  @RequestMapping(value = "/planet", method = RequestMethod.PUT)
	  @ApiOperation(value="Save one planet")
	  public Planet createPLanet(@Valid @RequestBody Planet planet) {
		if(planet.getId().equals("")) {
			planet.setId(UUID.randomUUID().toString());
		}
	    repository.save(planet);
	    return planet;
	  }
	  
	  @RequestMapping(value = "/planet/{id}", method = RequestMethod.POST)
	  @ApiOperation(value="Update one planet")
	  public Planet modifyPLanetById(@PathVariable("id") String id,@Valid @RequestBody Planet planet) {
		planet.setId(id);   
	    repository.save(planet);
	    return planet;
	  }
	  
	  @RequestMapping(value = "/planet/{id}", method = RequestMethod.DELETE)
	  @ApiOperation(value="Delete one planet")
	  public void deletePet(@PathVariable String id) {
	    repository.delete(repository.findByid(id));
	  }

}
