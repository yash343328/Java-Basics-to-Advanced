import java.util.Scanner;

class DiamondPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int space = 1; space <= rows - i; space++)
                System.out.print(" ");
            for (int star = 1; star <= (2 * i - 1); star++)
                System.out.print("*");
            System.out.println();
        }

        for (int i = rows - 1; i >= 1; i--) {
            for (int space = 1; space <= rows - i; space++)
                System.out.print(" ");
            for (int star = 1; star <= (2 * i - 1); star++)
                System.out.print("*");
            System.out.println();
        }
    }
}
