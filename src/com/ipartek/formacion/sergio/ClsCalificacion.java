package com.ipartek.formacion.sergio;

import java.sql.Timestamp;
import java.util.Date;

public class ClsCalificacion {

		private String asignatura;
		private float nota;
		private Timestamp fecha;
				
		public ClsCalificacion(String asignatura, float nota, Timestamp fecha) {
			super();
			this.asignatura = asignatura;
			this.nota = nota;
			this.fecha = fecha;
		}
		public String getAsignatura() {
			return asignatura;
		}
		public void setAsignatura(String asignatura) {
			this.asignatura = asignatura;
		}
		public float getNota() {
			return nota;
		}
		public void setNota(float nota) {
			this.nota = nota;
		}
		public Timestamp getFecha() {
			return fecha;
		}
		public void setFecha(Timestamp fecha) {
			this.fecha = fecha;
		}
		
		
		
		
		
}
