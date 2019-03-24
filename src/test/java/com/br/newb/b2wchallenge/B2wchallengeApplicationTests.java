package com.br.newb.b2wchallenge;

import static com.jayway.restassured.RestAssured.given;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.newb.b2wchallenge.document.Planet;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.DEFAULT)
public class B2wchallengeApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	HttpHeaders headers = new HttpHeaders();
	
	@Before
	public void createPlanets() throws JSONException {		
		String uriBase = createURLWithPort("/api/planet");		
		List<Planet> planets = new ArrayList<>(); 
		planets.add(new Planet("1","Alderaan","temperate","grasslands, mountains",2));
	    planets.add(new Planet("2","Yavin IV","temperate, tropical","jungle, rainforests",0));
	    planets.add(new Planet("3","Hoth","frozen","tundra, ice caves, mountain ranges",0));
	    planets.add(new Planet("4","Dagobah","murky","swamp, jungles",3));
	    planets.add(new Planet("5","Bespin","temperate","gas giant",1));
	    JSONObject jsonObj;
	    for (int i=0;i<planets.size();i++) {
	    	jsonObj = new JSONObject();
	    	jsonObj.put("id", planets.get(i).getId());
			jsonObj.put("name", planets.get(i).getName());
			jsonObj.put("climate",planets.get(i).getClimate());
			jsonObj.put("terrain", planets.get(i).getTerrain());
			jsonObj.put("qtd_apparitions", planets.get(i).getQtd_apparitions());
			given().relaxedHTTPSValidation().given().contentType(ContentType.JSON).body(jsonObj.toString()).when()
			.put(uriBase).then().statusCode(200);
	    	
	    }		
	}

	@Test
	public void addPlanet() throws URISyntaxException, JSONException {

		String uriBase = createURLWithPort("/api/planet");
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", "6");
		jsonObj.put("name", "TESTINCLU");
		jsonObj.put("climate", "TESTTEMP");
		jsonObj.put("terrain", "TESTTERREN");
		jsonObj.put("qtd_apparitions", 30);
		given().relaxedHTTPSValidation().given().contentType(ContentType.JSON).body(jsonObj.toString()).when()
				.put(uriBase).then().statusCode(200);
	}
	
	
	@Test
	public void updatePlanet() throws URISyntaxException, JSONException {
		String uriBase = createURLWithPort("/api/planet/1");
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", "1");
		jsonObj.put("name", "Alderaan");
		jsonObj.put("climate", "tropical");
		jsonObj.put("terrain", "mountains");
		jsonObj.put("qtd_apparitions", "2");
		
		given()
		  .relaxedHTTPSValidation()
		.given()
		  .contentType(ContentType.JSON).body(jsonObj.toString())
		.when().post(uriBase)
		  .then().statusCode(200);

	}
   
	@Test
	public void getPlanetByName() throws URISyntaxException, JSONException { 
		String uriBase = createURLWithPort("/api/planetn/Alderaan");
		given()
		  .relaxedHTTPSValidation().header("Accept", "*/*")
		.when()
		  .get(uriBase).then().statusCode(200);
	}
    
	@Test
	public void getPlanetById() throws URISyntaxException {
				 
		String uriBase = createURLWithPort("/api/planet/2");
		given()
		  .relaxedHTTPSValidation()
		.when()
		  .get(uriBase).then().statusCode(200);
	}
	
	@Test
	public void deletePlanet() throws URISyntaxException, JSONException {
		
		String uriBase = createURLWithPort("/api/planet/2");				
		given()
		.relaxedHTTPSValidation()
		.when()
		  .delete(uriBase)
	    .then().statusCode(200);

	}
	
	@Test
	public void getAllPlanets() throws URISyntaxException, JSONException { 
		String uriBase = createURLWithPort("/api/planet");
		given()
		  .relaxedHTTPSValidation().header("Accept", "*/*")
		.when()
		  .get(uriBase).then().statusCode(200);
	}
    

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}


}
