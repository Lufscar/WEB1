package br.ufscar.dc.dsw.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.ufscar.dc.dsw.domain.Teste;
import br.ufscar.dc.dsw.service.spec.IRestClientService;

@Service
public class RestClientService implements IRestClientService {

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Override
	public Long create(Teste t) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Teste> entity = new HttpEntity<Teste>(t, headers);
		String url = "http://jsonplaceholder.typicode.com/posts";
		ResponseEntity<Teste> res = restTemplate.postForEntity(url, entity, Teste.class);
		Teste t1 = res.getBody();

		System.out.println("\n                                         Criou !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		return t1.getUserId();
	}
	
	@Override
	public List<Teste> get() {
		String url = "http://jsonplaceholder.typicode.com/posts";
		Teste[] t = restTemplate.getForObject(url, Teste[].class);
		
		System.out.println("\n                                         Retornou uma lista !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		return Arrays.asList(t);
	}
	
	@Override
	public Teste get(Long id) {
		String url = "http://jsonplaceholder.typicode.com/posts/" + id;
		
		System.out.println("\n                                         Retornou um objeto !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		return restTemplate.getForObject(url, Teste.class);
	}
	
	@Override
	public boolean update(Teste t) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Teste> entity = new HttpEntity<Teste>(t, headers);
		String url = "http://jsonplaceholder.typicode.com/posts/" + t.getUserId();
		ResponseEntity<Teste> res = restTemplate.exchange(url, HttpMethod.PUT, entity, Teste.class);
		
		System.out.println("\n                                         Atualizou !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		return res.getStatusCode() == HttpStatus.OK;
	}
	
	@Override
	public boolean delete(Long id) {
		try {
			String url = "http://jsonplaceholder.typicode.com/posts/" + id;
			restTemplate.delete(url);
			
			System.out.println("\n                                         Deletou !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
			return true;
		} catch (RestClientException e) {
			System.out.println("\n                                         NÃO deletou !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
			return false;
		}
	}
}