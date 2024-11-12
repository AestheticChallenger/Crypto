
import java.util.Scanner;

public class ECC_1 {
    static Scanner input = new Scanner(System.in);
    static int a;
    static int b;
    static int p;
    static int x;
    static int y;

    public static void main(String[] args) {
        System.out.print("Enter the following values"
                + "Enter 'a' value: ");
        a = input.nextInt();

        System.out.print("Enter 'b' value: ");
        b = input.nextInt();

        System.out.print("Enter 'p' value: ");
        p = input.nextInt();

        System.out.print("Enter 'x' value: ");
        x = input.nextInt();

        System.out.print("Enter 'y' value: ");
        y = input.nextInt();

        System.out.print("Enter the scalar value / the number of repetition: ");
        int n = input.nextInt();

        getAllPoints(n, a, b, p, x, y);
    }

    public static int getModInverse(int x, int p) {
        int i;
        if (x < 0) {
            i = getModInverse(Math.abs(x), p) + p;
            return i;
        }

        for (i = 0; i < p; i++) {
            if ((x * i) % p == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void getAllPoints(int n, int a, int b, int p, int x, int y) {
        int x1 = x;
        int y1 = y;
        int x2 = x;
        int y2 = y;

        for (int i = 1; i < n; i++) {
            int s = 0;
            int numerator = 0;
            int denominator = 0;

            if (x1 == x2 && y1 == y2) {
                numerator = (3 * x1 * x1 + a); // 3x^2 + a
                denominator = (2 * y1); // 2y

            } else {
                numerator = (y2 - y1);
                denominator = (x2 - x1);
            }

            if (numerator < 0 && denominator < 0) {
                numerator = numerator * -1;
                denominator = denominator * -1;
            }

            int denominatorInv = getModInverse(denominator, p);
            if (denominatorInv == -1) {
                System.out.println("No modular inverse for denominator. Stopping.");
                break;
            }

            s = (numerator * denominatorInv) % p;

            int x3 = ((s * s) - x1 - x2) % p;
            if (x3 < 0)
                x3 += p;

            int y3 = ((s * (x1 - x3)) - y1) % p;
            if (y3 < 0)
                y3 += p;

            System.out.println((i + 1) + "P = (" + x3 + ", " + y3 + ")");

            // Updates tthe x, and y
            x2 = x3;
            y2 = y3;

            // if (n % 2)
        }

        getAllPoints(n, a, b, p, x2, y2);
    }
}
