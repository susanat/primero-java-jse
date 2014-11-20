package com.inpartek.formacion.proyectojava.util;

public class UtilTime {

	public static String calculateTime(final long timeInMilis) {
		int minutes = (int) (timeInMilis / (60 * 1000));
		int seconds = (int) (timeInMilis / 1000 % 60);
		String str = String.format("%d:%02d", minutes, seconds);

		return str;
	}
}
