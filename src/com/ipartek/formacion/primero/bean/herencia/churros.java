package com.ipartek.formacion.primero.bean.herencia;

import java.util.Comparator;



public class churros implements IOrdenable {

	private int calorias;
		
	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public churros(int calorias) {
		
	}

	@Override
	public float getPeso() {		
		return calorias;
	}
	
	/**
	 * Enumeración para los ordenamientos de las listas
	 *
	 *
	 */
	enum ObjetoComparator implements Comparator<churros> {

		SORT_PESO {
			@Override
			public int compare(churros o1, churros o2) {
				return Float.compare(o1.getPeso(), o2.getPeso());
			}
		}
	};

	/**
	 * Compara en orden descendente por tipo y luego por nombre
	 *
	 * @param other
	 * @return
	 */
	public static Comparator<churros> decending(final Comparator<churros> other) {
		return new Comparator<churros>() {
			public int compare(churros o1, churros o2) {
				return -1 * other.compare(o1, o2);
			}
		};
	}

	/**
	 * Compara en orden ascendendente por tipo y luego por nombre
	 *
	 * @param other
	 * @return
	 */
	public static Comparator<churros> ascending(final Comparator<churros> other) {
		return new Comparator<churros>() {
			public int compare(churros o1, churros o2) {
				return other.compare(o1, o2);
			}
		};
	}

	public static Comparator<churros> getComparator(
			final ObjetoComparator... multipleOptions) {
		return new Comparator<churros>() {
			public int compare(churros o1, churros o2) {
				for (ObjetoComparator option : multipleOptions) {
					int result = option.compare(o1, o2);
					if (result != 0) {
						return result;
					}
				}
				return 0;
			}
		};
	}

}
