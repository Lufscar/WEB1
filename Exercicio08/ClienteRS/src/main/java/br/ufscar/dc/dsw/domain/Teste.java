package br.ufscar.dc.dsw.domain;

public class Teste {

	private Long userId;
	
	private String body;
	
	private String title;

	public Teste() {
	}
	
	public Teste(String body, String title, Long userId) {
		this.body = body;
		this.title = title;
		this.userId = userId;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}