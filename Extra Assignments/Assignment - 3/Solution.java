import java.util.*;
public class Solution {

	public Deck[] sort(Deck[] arr) {
			for (int i = 1; i < arr.length; i++) {
				for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
					Deck temp = arr[j-1];
					arr[j-1]  = arr[j];
					arr[j] = temp;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] sval = {1, 2, 3, 4};
		int[] fval = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		// Deck[] arr = new Deck[(sval.length * fval.length) - 1];
		ArrayList<Deck> arr = new ArrayList<Deck> ();
		for (int i = 1; i < sval.length + 1; i++) {
			for (int j = 1; j < fval.length + 1; j++) {
					arr.add(new Deck(i, j));
			}
		}
		Collections.shuffle(arr);
		for (int i = 0; i < arr.size(); i++) {
		}
		Collections.sort(arr);
		Deck[] array = arr.toArray(new Deck[arr.size()]);
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).toString());
		}
	}
}
