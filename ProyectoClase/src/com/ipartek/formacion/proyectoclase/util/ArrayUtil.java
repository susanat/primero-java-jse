package com.ipartek.formacion.proyectoclase.util;

public class ArrayUtil {
    private Comparable array[];
    private int length;

    public ArrayUtil(final Comparable[] parray) {
	this.array = parray;
	this.length = parray.length;
    }

    public Comparable[] getArray() {
	return this.array;
    }

    public void sort() {

	if (this.array == null || this.length == 0) {
	    return;
	}

	quickSort(0, length - 1);

    }

    private void quickSort(final int lowerIndex, final int higherIndex) {

	int i = lowerIndex;
	int j = higherIndex;
	// calculate pivot number, I am taking pivot as middle index number
	Comparable pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
	// Divide into two arrays
	while (i <= j) {
	    /**
	     * In each iteration, we will identify a number from left side which
	     * is greater then the pivot value, and also we will identify a
	     * number from right side which is less then the pivot value. Once
	     * the search is done, then we exchange both numbers.
	     */
	    while (array[i].compareTo(pivot) < 0) {
		i++;
	    }
	    while (array[i].compareTo(pivot) > 0) {
		j--;
	    }
	    if (i <= j) {
		exchangeNumbers(i, j);
		// move index to next position on both sides
		i++;
		j--;
	    }
	}
	// call quickSort() method recursively
	if (lowerIndex < j)
	    quickSort(lowerIndex, j);
	if (i < higherIndex)
	    quickSort(i, higherIndex);
    }

    private void exchangeNumbers(final Integer i, final Integer j) {
	Comparable temp = array[i];
	array[i] = array[j];
	array[j] = temp;
    }

}
