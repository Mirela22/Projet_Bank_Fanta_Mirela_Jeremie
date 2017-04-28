package com.ib.client;

public class ListeCompte {
	
	private int account_customer_id;
	private String account_type; 
	private int person_id;
	private String person_external_id;
	
	public ListeCompte(){
		
	}
	
	public ListeCompte ( int account_customer_id, String account_type, int person_id, String person_external_id ){
		
		this.account_customer_id=account_customer_id;
		this.account_type= account_type;
		this.person_id=person_id;
		this.person_external_id=person_external_id;
		
	}

	public int getAccount_customer_id() {
		return account_customer_id;
	}

	public void setAccount_customer_id(int account_customer_id) {
		this.account_customer_id = account_customer_id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getPerson_external_id() {
		return person_external_id;
	}

	public void setPerson_external_id(String person_external_id) {
		this.person_external_id = person_external_id;
	}

	
	
	
	
	

}
