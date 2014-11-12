
package com.ipartek.formacion.sergio.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase de recopilación de funciones útiles para trabajar con fechas
 * 
 * @author baskito
 * @version 03.11.2014
 */
public class ClsUtilsFechas {
    
	/**
	 * Formato utilizado para las fechas en sqlite
	 */
	public static SimpleDateFormat formatoDeFechaSQLite = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        
	/**
	 * Convierte una fecha en formato sqllite a timestamp
	 * @param fecha
	 * @return
	 */
    public static java.sql.Timestamp SqlLiteDateToSql(Date fecha)
    {        
        Timestamp timeStampDate = new Timestamp(fecha.getTime());
        return timeStampDate;
    }
    
    
    public static Date SqlLiteSqlToDate(String fecha){
        try {
            //return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(fecha);        
            return formatoDeFechaSQLite.parse(fecha);
        } catch (ParseException ex) {            
            return null;
        }
    }
    
     /**
      * Metodo usado para obtener la fecha actual
      * @return Retorna un <b>STRING</b> con la fecha actual formato "dd-MM-yyyy"
      */ 
    public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }

    //Metodo usado para obtener la hora actual del sistema
    //@return Retorna un <b>STRING</b> con la hora actual formato "hh:mm:ss"
    public static String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }

    //Sumarle dias a una fecha determinada
    //@param fch La fecha para sumarle los dias
    //@param dias Numero de dias a agregar
    //@return La fecha agregando los dias
    public static java.sql.Date sumarFechasDias(java.sql.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    //Restarle dias a una fecha determinada
    //@param fch La fecha
    //@param dias Dias a restar
    //@return La fecha restando los dias
    public static synchronized java.sql.Date restarFechasDias(java.sql.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, -dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    //Diferencias entre dos fechas
    //@param fechaInicial La fecha de inicio
    //@param fechaFinal  La fecha de fin
    //@return Retorna el numero de dias entre dos fechas
    public static synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }

    //Devuele un java.util.Date desde un String en formato dd-MM-yyyy
    //@param La fecha a convertir a formato date
    //@return Retorna la fecha en formato Date
    public static synchronized java.util.Date deStringToDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {            
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Calcula la diferencia entre dos horas
     * 
     * @param fInicial
     * @param fFinal
     * @return
     */
    public static timeLapse diferenciaHoras(Date fInicial, Date fFinal)
	{		
		// Crear 2 instancias de Calendar
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal1.setTime(fInicial);
		cal2.setTime(fFinal);
		
		// conseguir la representacion de la fecha en milisegundos
        long milis1 = cal1.getTimeInMillis();
        long milis2 = cal2.getTimeInMillis();

        // calcular la diferencia en milisengundos
        long diff = milis2 - milis1;

        // calcular la diferencia en segundos
        long diffSeconds = diff / 1000;

        // calcular la diferencia en minutos
        long diffMinutes = diff / (60 * 1000);

        // calcular la diferencia en horas
        long diffHours = diff / (60 * 60 * 1000);

        // calcular la diferencia en dias
        long diffDays = diff / (24 * 60 * 60 * 1000);

        /*
        System.out.println("En milisegundos: " + diff + " milisegundos.");
        System.out.println("En segundos: " + diffSeconds + " segundos.");
        System.out.println("En minutos: " + diffMinutes + " minutos.");
        System.out.println("En horas: " + diffHours + " horas.");
        System.out.println("En dias: " + diffDays + " dias.");
		*/
        //Log.e("diferenciaHoras", "En milisegundos: " + diff + " milisegundos.");
        //Log.e("diferenciaHoras", "En segundos: " + diffSeconds + " segundos.");
        
        timeLapse tiempo = new timeLapse();
        tiempo.diffMilisegundos = diff;
        tiempo.diffSegundos = diffSeconds;        
        tiempo.diffMinutos = diffMinutes;
        tiempo.diffHoras = diffHours;
        tiempo.diffDias = diffDays;
        
		return tiempo;
	}
    
    public static class timeLapse
    {
    	//TODO un toString para convertir a fecha (date o calendar)
    	
    	private Long diffMilisegundos;
    	private Long diffSegundos;
    	private Long diffMinutos;
    	private Long diffHoras;
    	private Long diffDias;
    	    	
    	
		public Long getDiffMilisegundos() {
			return diffMilisegundos;
		}
		public void setDiffMilisegundos(Long diffMilisegundos) {
			this.diffMilisegundos = diffMilisegundos;
		}
		public Long getDiffSegundos() {
			return diffSegundos;
		}
		public void setDiffSegundos(Long diffSegundos) {
			this.diffSegundos = diffSegundos;
		}
		public Long getDiffMinutos() {
			return diffMinutos;
		}
		public void setDiffMinutos(Long diffMinutos) {
			this.diffMinutos = diffMinutos;
		}
		public Long getDiffHoras() {
			return diffHoras;
		}
		public void setDiffHoras(Long diffHoras) {
			this.diffHoras = diffHoras;
		}
		public Long getDiffDias() {
			return diffDias;
		}
		public void setDiffDias(Long diffDias) {
			this.diffDias = diffDias;
		}    
		
		
    }
    
    public static String milisegundosToTimeString(Long milisegundos)
    {
    	
    	int seconds = (int) (milisegundos / 1000) % 60 ;
		int minutes = (int) ((milisegundos / (1000*60)) % 60);
		int hours   = (int) ((milisegundos / (1000*60*60)) % 24);
		
		String sSeconds = String.valueOf(seconds).length() == 2 ? String.valueOf(seconds) : String.format("%02d", seconds); 
		String sMinutes = String.valueOf(minutes).length() == 2 ? String.valueOf(minutes) : String.format("%02d", minutes);
		String sHours = String.valueOf(hours).length() == 2 ? String.valueOf(hours) : String.format("%02d", hours);
					
		return (sHours + ":" + sMinutes + ":" + sSeconds);		
    	
    }
    
    
}
