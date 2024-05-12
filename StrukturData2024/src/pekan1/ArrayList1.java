package pekan1;

import java.util.ArrayList;

public class ArrayList1 {
public static void main(String[] args) {
// Ukuran Daftar Array		
int n = 5;
// Mendeklarasikan ArrayList dengan ukuran awal n
ArrayList<Integer> arrli = new ArrayList<Integer> (n) ;
// Menambahkan elemen baru di akhir daftar
for (int i = 1; i <= n; i++)
arrli.add(i);
// Printing elements
System.out.println(arrli);
// Hapus elemen di indeks 3
arrli.remove(3);
System.out.println(arrli);
for (int i = 0 ; i < arrli.size(); i++)
	System.out.print(arrli.get(i) + " ");

	}

}
