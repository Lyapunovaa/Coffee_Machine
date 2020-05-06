import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = scanner.nextInt();
        }

        int counter = 1;
        int max = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] <= a[i + 1]) {
                counter++;
                if (counter > max) {
                    max = counter;
                }
            } else {
                counter = 1;
            }
        }
        System.out.println(max);

    }
}