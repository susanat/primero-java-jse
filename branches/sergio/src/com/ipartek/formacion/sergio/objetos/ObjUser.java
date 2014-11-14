package com.ipartek.formacion.sergio.objetos;

public class ObjUser extends ObjComun{
	
	private String username = "";
	private String password = "";
	private String email = "";
	
	
	public ObjUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ObjUser(
			int id, 
			long created_date, 
			long modified_date, 
			int version,
			boolean status
			) {
		super(
				id, 
				created_date, 
				modified_date, 
				version, 
				status);
		// TODO Auto-generated constructor stub
	}
	public ObjUser(long created_date, long modified_date, int version,
			boolean status) {
		super(created_date, modified_date, version, status);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
