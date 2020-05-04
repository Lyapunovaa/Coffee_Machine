package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int waterNow = 400;
    static int milkNow = 540;
    static int beansNow = 120;
    static int cupsNow = 9;
    static int moneyNow = 550;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        state();
        action();
        state();
    }


    public static void state() {
        System.out.println("The coffee machine has:");
        System.out.println(
                waterNow + " of water\n" + milkNow + " of milk\n" + beansNow + " of coffee beans\n" +
                        cupsNow + " of disposable cups\n" + moneyNow + " of money");
    }

    public static void action() {
        System.out.println("Write action (buy, fill, take):");
        String inp = scanner.nextLine();
        switch (inp) {
            case "buy":

                break;
            case "fill":

                break;
            case "take":

                break;
            default:
                System.out.println("error");
        }
    }

    public static void buy() {
        
    }

    public static void fill() {
    }

    public static void take() {
    }

}
