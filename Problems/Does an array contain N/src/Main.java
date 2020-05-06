import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        boolean ans = false;
        int find = scanner.nextInt();
        for (int find1 : array) {
            if (find1 == find) {
                ans = true;
            }
        }
        System.out.println(ans);
    }
}