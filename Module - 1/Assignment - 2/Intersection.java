public class Intersection {
    public static void main(String[] args) {
        int[] arrOne = {1, 3, 5, 7, 9, 10, 16};
        int[] arrTwo = {2, 3, 4, 9, 10, 16, 22};
        int i = 0;
        int j = 0;
        while (i < arrOne.length && j < arrTwo.length) {
            if (arrOne[i] > arrTwo[j]) {
                j++;
            }
            else if (arrOne[i] < arrTwo[j]) {
                i++;
            } else {
                System.out.println(arrOne[i]);
                i++;
                j++;
            }
        }
    }
}