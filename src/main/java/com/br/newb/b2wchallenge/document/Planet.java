package com.br.newb.b2wchallenge.document;


//import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="starweb")
public class Planet {
	@Id
	private String id;
	private String name;
	private String climate;
	private String terrain;
	private int qtd_apparitions;
	

		
	public Planet(String id, String name, String climate, String terrain,int qtd_apparitions ) {
		this.id=id;
		this.name = name;
		this.climate = climate;
		this.terrain = terrain;
		this.qtd_apparitions=qtd_apparitions;
	}
	
	public int getQtd_apparitions() {
		return qtd_apparitions;
	}
	public void setQtd_apparitions(int qtd_apparitions) {
		this.qtd_apparitions = qtd_apparitions;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	

}
