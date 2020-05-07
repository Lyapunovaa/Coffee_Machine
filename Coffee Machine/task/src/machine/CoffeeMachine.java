package machine;

import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);

    static String inputString() {
        String empty = scanner.nextLine();
        return empty;
    }

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine(400, 540, 120, 9, 550, State.ACTION) { };
        cm.state();
        State inp = State.of(scanner.nextLine());
        cm.action(inp);
    }
}


public class CoffeeMachine {
    int waterNow;
    int milkNow;
    int beansNow;
    int cupsNow;
    int moneyNow;
    State state;



    public CoffeeMachine(int waterNow, int milkNow, int beansNow, int cupsNow, int moneyNow, State state) {
        this.waterNow = waterNow;
        this.milkNow = milkNow;
        this.beansNow = beansNow;
        this.cupsNow = cupsNow;
        this.moneyNow = moneyNow;
        this.state = State.ACTION;
    }

    void state(){
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }






    void raw_state() {
        System.out.println("The coffee machine has:");
        System.out.println(
                waterNow + " of water\n" + milkNow + " of milk\n" + beansNow + " of coffee beans\n" +
                        cupsNow + " of disposable cups\n" + moneyNow + " of money");
    }

    void action(State inp) {
        switch (inp) {
            case BUY:
                buy();
                action(State.ACTION);
                break;
            case FILL:
                fill();
                action(State.ACTION);
                break;
            case TAKE:
                take();
                action(State.ACTION);
                break;
            case REMAINING:
                raw_state();;
                action(State.ACTION);
                break;
            case EXIT:
                break;

        }
    }

    void buy() {
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


    void fill() {
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

    void filled(int waterD, int milkD, int beanD, int cupsD) {
        this.waterNow += waterD;
        this.milkNow += milkD;
        this.beansNow += beanD;
        this.cupsNow += cupsD;
    }


    void take() {
        System.out.println("I gave you $" + this.moneyNow + "\n");
        this.moneyNow = 0;

    }

}

class Raw {
    int addWater;
    int addMilk;
    int addBean;
    int addCups;

    public Raw(int addWater, int addMilk, int addBean, int addCups) {
        this.addWater = addWater;
        this.addMilk = addMilk;
        this.addBean = addBean;
        this.addCups = addCups;
    }


}

enum State {
    ACTION("action"),
    BUY("buy"),
    TAKE("take"),
    FILL("fill"),
    REMAINING("remaining"),
    EXIT("exit");


    String input;

    State(String input) {
        this.input = input;
    }

    public static State of(String input){
        for(State value : values()) {
            if (input.equals(value.input)){
                return value;
            }
        } return ACTION;
    }

}

enum Coffe {
    ESPRESSO("espresso", 1, 250, 0, 16, 4),
    LATTE("latte", 2, 350, 75, 20, 7),
    CAPPUCCINO("cappuccino", 3, 200, 100, 12, 6);

    String name;
    int typNum;
    int useWater;
    int useMilk;
    int useBeans;
    int price;

    Coffe(String name, int typNum, int useWater, int useMilk, int useBeans, int price) {
        this.name = name;
        this.typNum = typNum;
        this.useWater = useWater;
        this.useMilk = useMilk;
        this.useBeans = useBeans;
        this.price = price;
    }

    public static Coffe findByTypeNum(int numOftype) {
        Coffe[] coffee = Coffe.values();
        Coffe coffeeSelected = coffee[numOftype - 1];
        return coffeeSelected;
    }
}

