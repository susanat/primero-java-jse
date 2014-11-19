package personas10k.utils;

public class Utilidades {

	public Utilidades() {
		// TODO Auto-generated constructor stub

	}

	public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";

	/**
	 * Devuelve un NIF completo a partir de un DNI. Es decir, añade la letra del
	 * NIF
	 * 
	 * @param dni
	 *            dni al que se quiere añadir la letra del NIF
	 * @return NIF completo.
	 */
	public static String letraDNI(int dni) {
		return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
	}

	public static boolean validDNI(String dni) {
		if (dni.length() != 9) {
			return false;
		} else
			return letraDNI(Integer.parseInt(dni.substring(0, 8)))
					.equalsIgnoreCase(dni);
	}

	public static boolean validEdad(String edad) {
		try {
			Integer e = Integer.parseInt(edad);
			if (e <= 99 && e >= 18) {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}
}
