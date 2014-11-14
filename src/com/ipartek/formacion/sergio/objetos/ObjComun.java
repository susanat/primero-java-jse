package com.ipartek.formacion.sergio.objetos;

import java.sql.Timestamp;
import java.util.Calendar;



public class ObjComun {

	public static final int DEFAULT_VERSION = 1;
	public static final int DEFAULT_STATUS = 0;
	public static final int DEFAULT_ID = 0;
	
	protected int id;
	protected long created_date;
	protected long modified_date;
	protected int version;
	protected int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public long getCreated_date() {
		return created_date;
	}

	public void setCreated_date(long created_date) {
		this.created_date = created_date;
	}

	public long getModified_date() {
		return modified_date;
	}

	public void setModified_date(long modified_date) {
		this.modified_date = modified_date;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * Obtiene el estado del objeto
	 * @return boolean 
	 */
	public boolean isStatus() {
		return this.status == 1 ? true : false;
	}

	/**
	 * Asigna el estado del objeto
	 * @param status boolean 
	 */
	public void setStatus(boolean status){
		this.status = (status ? 1 : 0);
	}
	
	/**
	 * Asigna el estado del objeto numéricamente:
	 * 0 - false, 1 - true
	 * 
	 * @param status int 0 para false y 1 para true
	 * @throws Exception Si el número es distinto a 0 o 1
	 * 
	 */
	public void setStatus(int status) throws Exception {
		if(id != 0 || id !=1 ){
			throw new Exception("No es un valor válido para el estado. 0 ó 1");
		}else{
			this.status = status;
		}
	}	

	public ObjComun() {
		//inicializo los valores
		this.id = 0;
		this.created_date = 0;
		this.modified_date = 0;
		this.version = DEFAULT_VERSION;
		//TODO ¿Status Dejarlo a int o cambiarlo a boolean?
		this.status = DEFAULT_STATUS;
	}

	/**
	 * Constructor to create comun object.
	 * 
	 * @param id id for object
	 * @param created_date Long (Timestamp) Created date for object
	 * @param modified_date Long (Timestamp) Modified date for object
	 * @param version int Version for object
	 * @param status int Status for object
	 */
	public ObjComun(
			int id, 
			long created_date, 
			long modified_date, 
			int version,
			boolean status) {
		this();
		
		this.id = id;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.version = version;
		this.setStatus(status);
	}
	
	/**
	 * Constructor to create comun object (without id).
	 * 
	 * @param created_date Long (Timestamp) Created date for object
	 * @param modified_date Long (Timestamp) Modified date for object
	 * @param version int Version for object
	 * @param status int Status for object
	 */
	public ObjComun( 
			long created_date, 
			long modified_date, 
			int version,
			boolean status)
	{
		this(DEFAULT_ID, created_date, modified_date, version, status);
		
	}
	
	
	public void initCreatedDate(){
		Timestamp timestampNow = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.created_date = timestampNow.getTime();
	}
	
	public void initModifiedDate(){
		Timestamp timestampNow = new Timestamp(Calendar.getInstance().getTime().getTime());
		this.modified_date = timestampNow.getTime();
	}
	
	

}
