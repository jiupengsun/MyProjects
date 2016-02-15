package com.samy.algorithm;

public class Sort {

	public static void quickSort(int[] a, int st, int en, boolean asc) {
		if (st >= en)
			return;
		int i = st, j = en, sentinel = a[st];
		while (i < j) {
			while (i < j && (a[j] <= sentinel ^ asc))
				j--;
			if (i < j) {
				a[i] = a[j];
				i++;
			}
			while (i < j && (a[i] > sentinel ^ asc))
				i++;
			if (i < j) {
				a[j] = a[i];
				j--;
			}
		}
		a[i] = sentinel;
		quickSort(a, st, i - 1, asc);
		quickSort(a, i + 1, en, asc);
	}

	public static void bubbleSort(int[] a, int st, int en, boolean asc) {
		for (int i = en; i > 0; i--)
			for (int j = 0; j < i; j++) {
				if (a[j] < a[j + 1] ^ asc) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
	}

	public static void print(int[] a) {
		for (int i : a)
			System.out.print(i + " ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[] a = { 1, 5, 6, 23, 8, 3, 7, 9, 213 };
		int[] a = { 2, 3, 1, 4 };

		bubbleSort(a, 0, a.length - 1, false);

		print(a);
	}

}
