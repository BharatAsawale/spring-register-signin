package com.bezkoder.spring.jwt.mongodb.payload.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private String profilepic;
	private String coverpic;
	private List<String> roles;

	public JwtResponse(String accessToken, String id, String firstname, String lastname, String email, String profilepic, String coverpic, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email = email;
		this.profilepic = profilepic;
		this.coverpic = coverpic;
		this.roles = roles;
	}

    public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfilepic() { return profilepic; }

	public void setProfilepic(String profilepic) { this.profilepic = profilepic; }

	public String getCoverpic() { return coverpic; }

	public void setCoverpic(String coverpic) { this.coverpic = coverpic; }

	public List<String> getRoles() {
		return roles;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
