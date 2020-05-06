
public class Main {

    public static void main(String[] args) {
        int dd = 0;
        String a;
        for (Secret s : Secret.values()) {
            a = s.toString();
            if (a.startsWith("STAR")) {
                dd++;
            }

        }
        System.out.println(dd);

    }
}
