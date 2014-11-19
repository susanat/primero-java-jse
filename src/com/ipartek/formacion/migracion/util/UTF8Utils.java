package com.ipartek.formacion.migracion.util;

public class UTF8Utils {
	/**
	 * Detecta Strings de Java que su contenido no sea UTF-8.
	 * 
	 * @param text
	 *            texto a validar.
	 * @return true si el texto es correcto en UTF8.
	 */
	public static boolean isUTF8Correct(String text) {
		try {
			byte[] utf8 = text.getBytes("UTF-8");
			for (int i = 0; i < utf8.length; i++) {
				// Unexpected continuation byte.
				if (isUTF8Continuation(utf8[i])) {
					return false;
				}

				// Leading ones -> More than one byte involved with its
				// continuations.
				int leadingOne = leadingOnes(utf8[i]);
				for (int j = i + 1; j <= i + leadingOne; j++) {
					if (!isUTF8Continuation(utf8[j])) {
						return false;
					}
				}
				i += leadingOne;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Calculates leading ones in a byte. In utf8, the leading ones mark the
	 * length in bytes of the character.
	 * 
	 * @param code
	 * @return
	 */
	private static int leadingOnes(byte code) {
		int leading = 0;
		while ((code & 0x80) != 0) {
			leading++;
			code = (byte) (code << 2);
		}
		return leading;
	}

	/**
	 * Checks that the given byte is a UTF8 continuation byte.
	 * 
	 * @param code
	 * @return
	 */
	private static boolean isUTF8Continuation(byte code) {
		// If the byte starts with 10xxxxxx this is a one byte length start.
		return ((code & 0x80) == 0x80) && ((~code & 0x40) == 0x40);
	}
}
