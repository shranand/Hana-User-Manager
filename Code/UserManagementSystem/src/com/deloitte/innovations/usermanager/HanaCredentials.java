package com.deloitte.innovations.usermanager;

public class HanaCredentials {

	String hanaHost;
	String hanaPort;
	String hanaUsername;
	String hanaTechPwd;
	
	
	
	
	
	public HanaCredentials(String hANA_HOST, String hANA_PORT, String hANA_TECH_USERNAME, String hANA_TECH_PWD) {
		super();
		hanaHost = hANA_HOST;
		hanaPort = hANA_PORT;
		hanaUsername = hANA_TECH_USERNAME;
		hanaTechPwd = hANA_TECH_PWD;
	}
	
	public HanaCredentials() {
		super();
		
	}
	public String getHANA_HOST() {
		return hanaHost;
	}
	public void setHANA_HOST(String hANA_HOST) {
		hanaHost = hANA_HOST;
	}
	public String getHANA_PORT() {
		return hanaPort;
	}
	public void setHANA_PORT(String hANA_PORT) {
		hanaPort = hANA_PORT;
	}
	public String getHANA_TECH_USERNAME() {
		return hanaUsername;
	}
	public void setHANA_TECH_USERNAME(String hANA_TECH_USERNAME) {
		hanaUsername = hANA_TECH_USERNAME;
	}
	public String getHANA_TECH_PWD() {
		return hanaTechPwd;
	}
	public void setHANA_TECH_PWD(String hANA_TECH_PWD) {
		hanaTechPwd = hANA_TECH_PWD;
	}
	
	
}
