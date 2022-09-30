package com.HamuraBank.internetional.Sp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class SimpleRest {

	public User[] listWantedPersons() {

		RestTemplate template = new RestTemplate();

		UriComponents uri = UriComponentsBuilder.newInstance().scheme("https").host("jsonplaceholder.typicode.com")
				.path("users").build();

		ResponseEntity<User[]> personsArray = template.getForEntity(uri.toUriString(), User[].class);

		return personsArray.getBody();
	}

}
