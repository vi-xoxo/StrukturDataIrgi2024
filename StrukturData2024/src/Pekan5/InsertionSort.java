package Pekan5;

public class InsertionSort {
void sort (int arr[]) {
	int n = arr.length;
	for (int i = 1; i< n; ++i) {
		int key = arr [i];
		int j = i-1;
		
		

while (j >= 0 && arr[j] > key) {
	arr [j + 1]= arr[j];
	j = j - 1;
	}
arr[j + 1] = key;
}System.out.println();
	
}
static void printArray(int arr[]) {
	int n = arr.length;
	for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
}

//Driver Method
public static void main (String args[]) {
	int arr[] = { 3,10,4,6,8,9,7,2,1,5} ;
	System.out.print("array yang belum terurut: ");
	printArray(arr);
	InsertionSort ob = new InsertionSort ();
	ob.sort(arr);
	System.out.print("array yang sudah terurut: ");
    printArray(arr);
}
}