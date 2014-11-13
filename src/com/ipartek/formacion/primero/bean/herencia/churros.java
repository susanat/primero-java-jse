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
		this.setCalorias(calorias); 
	}

	@Override
	public float getPeso() {		
		return calorias;
	}
	
	
	
	
	
	@Override
	public boolean equals(Object obj) {		
		return super.equals(obj);
	}



	


	@Override
	public String toString() {
		return "churros [Calorias()=" + getCalorias() + ", Peso()="
				+ getPeso() + "]";
	}






	/**
	 * Enumeración para los ordenamientos de las listas
	 *
	 *
	 */
	static enum ObjetoComparator implements Comparator<IOrdenable> {

		SORT_PESO {
			@Override
			public int compare(IOrdenable o1, IOrdenable o2) {
				return Float.compare(o1.getPeso(), o2.getPeso());
			}
		};
	

		/**
		 * Compara en orden descendente por tipo y luego por nombre
		 *
		 * @param other
		 * @return
		 */
		public static Comparator<IOrdenable> decending(final Comparator<IOrdenable> other) {
			return new Comparator<IOrdenable>() {
				public int compare(IOrdenable o1, IOrdenable o2) {
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
		public static Comparator<IOrdenable> ascending(final Comparator<IOrdenable> other) {
			return new Comparator<IOrdenable>() {
				public int compare(IOrdenable o1, IOrdenable o2) {
					return other.compare(o1, o2);
				}
			};
		}
	
		public static Comparator<IOrdenable> getComparator(
				final ObjetoComparator... multipleOptions) {
			return new Comparator<IOrdenable>() {
				public int compare(IOrdenable o1, IOrdenable o2) {
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

}
