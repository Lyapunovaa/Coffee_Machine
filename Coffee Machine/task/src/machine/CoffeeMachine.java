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
        action();
    }


    public static void state() {
        System.out.println("The coffee machine has:");
        System.out.println(
                waterNow + " of water\n" + milkNow + " of milk\n" + beansNow + " of coffee beans\n" +
                        cupsNow + " of disposable cups\n" + moneyNow + " of money");
    }

    public static void action() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String inp = scanner.nextLine();
        switch (inp) {
            case "buy":
                buy();
                action();
                break;
            case "fill":
                fill();
                action();
                break;
            case "take":
                take();
                action();
                break;
            case "remaining":
                state();
                action();
                break;
            case "exit":
                break;
            default:
                action();
                break;
        }
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String take = scanner.nextLine();
        switch (take) {
            case "1":
                if (waterNow >= 250) {
                    if (beansNow >= 16) {
                        if (cupsNow >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            waterNow -= 250;
                            beansNow -= 16;
                            cupsNow -= 1;
                            moneyNow += 4;
                            break;
                        } else {
                            System.out.println("Sorry, not enough cups!");
                            break;
                        }
                    } else {
                        System.out.println("Sorry, not enough beans!");
                        break;
                    }
                } else {
                    System.out.println("Sorry, not enough water!");
                    break;
                }

            case "2":
                if (waterNow >= 350) {
                    if (milkNow >= 75) {
                        if (beansNow >= 20) {
                            if (cupsNow >= 1) {
                                System.out.println("I have enough resources, making you a coffee!");
                                waterNow -= 350;
                                milkNow -= 75;
                                beansNow -= 20;
                                cupsNow -= 1;
                                moneyNow += 7;
                                break;
                            } else {
                                System.out.println("Sorry, not enough cups!");
                                break;
                            }
                        } else {
                            System.out.println("Sorry, not enough beans!");
                            break;
                        }
                    } else {
                        System.out.println("Sorry, not enough milk!");
                        break;
                    }
                } else {
                    System.out.println("Sorry, not enough water!");
                    break;
                }


            case "3":
                if (waterNow >= 200) {
                    if (milkNow >= 100) {
                        if (beansNow >= 12) {
                            if (cupsNow >= 1) {
                                System.out.println("I have enough resources, making you a coffee!");
                                waterNow -= 200;
                                milkNow -= 100;
                                beansNow -= 12;
                                cupsNow -= 1;
                                moneyNow += 6;
                                break;
                            } else {
                                System.out.println("Sorry, not enough cups!");
                                break;
                            }
                        } else {
                            System.out.println("Sorry, not enough beans!");
                            break;
                        }
                    } else {
                        System.out.println("Sorry, not enough milk!");
                        break;
                    }
                } else {
                    System.out.println("Sorry, not enough water!");
                    break;
                }


            case "back":
                break;

        }

    }

    static String inputString() {
        String input = scanner.nextLine();
        return input;
    }

    public static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        int waterD = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milkD = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int beanD = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cupsD = scanner.nextInt();
        inputString();
        filled(waterD, milkD, beanD, cupsD);

    }

    static void filled(int waterD, int milkD, int beanD, int cupsD) {
        waterNow += waterD;
        milkNow += milkD;
        beansNow += beanD;
        cupsNow += cupsD;

    }


    public static void take() {
        System.out.println("I gave you $" + moneyNow + "\n");
        moneyNow = 0;

    }

}
