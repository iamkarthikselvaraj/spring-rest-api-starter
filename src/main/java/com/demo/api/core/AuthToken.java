/**
 * @author Karthik Selvaraj
 *
 * 
 */
package com.demo.api.core;

public class AuthToken {

	private String token;

	public AuthToken() {

	}

	public AuthToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
