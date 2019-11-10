import java.util.Scanner;
/**
 * class ransomNote to check the ransomNote.
 * @author Ankith.
 * @param <Key> generic type.
 * @param <Value> generic type.
 */
public class RansomNote<Key extends Comparable<Key>, Value> {
    /**
     *main method the program execution will start from here.
     * @param args args.
     * in this method we read the sesntense and we split that into words of magzine.
     * if the word is already in the table we increase the count and if
     *  not we insert that word into table with initial count as 1.
     * then we read a sentense and split that into words adn we check with the ransomnot words.
     * if the words in the sentense maches with the
     *  count in the words magzine the nn we print yes else no.
     */
public static void main(String[] args) {
    LinearProbingHashST<String, Integer> obj = new LinearProbingHashST<>();
    System.out.println("Enter words in to magzine");
    Scanner sc = new Scanner(System.in);
    String sentense = sc.nextLine();
    String[] wordsMagzine = sentense.split(" ");
    for(int i = 0; i < wordsMagzine.length; i++) {
        if (obj.get(wordsMagzine[i]) == null) {
            obj.put(wordsMagzine[i],1);
        } else {
            obj.put(wordsMagzine[i], obj.get(wordsMagzine[i]) + 1);
        }
    }
    System.out.println("enter a sentense");
    String sent = sc.nextLine();
    String[] words = sent.split(" ");
    boolean flag = true;
    for (String string : words) {
        if (obj.get(string) != null) {
            obj.put(string,obj.get(string) - 1);
            if (obj.get(string) < 0) {
                flag = false;
                break;
            }
        } else {
            flag = false;
        }
    }
     if (flag) {
        System.out.println("YES");
    } else {
        System.out.println("NO");
    }
  }   
}