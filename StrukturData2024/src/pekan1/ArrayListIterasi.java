package pekan1;

import java.util.ArrayList;

public class ArrayListIterasi {
public static void main(String[] args) {
ArrayList<String> al = new ArrayList <>() ;
al.add("saya");
al.add("informatika");
al.add(1, "mahasiswa");

for (int i = 0; i < al.size() ; i++) {
	System.out.print(al.get(i)+" ");
}
System.out.println();
//Using the for each loop
for (String str : al)
System.out.print(str + " ");
System.out.println();
//printing all elements of ArrayList
System.out.println("Initial ArrayList " + al);
//Removing element from above ArrayList
al.remove(1);
//Printing the updated ArrayList elements
System.out.println("After the Index Removal " + al);
//Removing this word element in ArrayList
al.remove("saya");
//now printing update ArrayList
System.out.println("After the Object Removal" + al);
} }