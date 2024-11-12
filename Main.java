public class Main {

    /// n % 2 == 0
    /// 10 % 2 == 0
    /// 10 / 2 = 5
    /// 5 % 2 == 1
    /// 5 - 1 = 4
    /// 4 % 2 == 0
    /// 4 / 2 = 2
    /// 2 % 2 == 0
    /// 2 / 2 == 1

    public static void main(String[] args) {
        System.out.println(getModInverse(-3, 23));
        int n = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            }

            else {
                n -= 1;
            }
        }
    }

    public static int getModInverse(int x, int p) {
        if (x < 0)
            x = Math.abs(x);

        for (int i = 0; i < p; i++)
            if ((x * i) % p == 1)
                return i;

        return -1;

    }

}

// import java.util.Scanner;

// public class ECC {
// static Scanner input = new Scanner(System.in);

// public static void main(String[] args) {
// System.out.print("Enter the following values"
// + "Enter 'a' value: ");
// int a = input.nextInt();

// System.out.print("Enter 'b' value: ");
// int b = input.nextInt();

// System.out.print("Enter 'p' value: ");
// int p = input.nextInt();

// System.out.print("Enter 'x' value: ");
// int x = input.nextInt();

// System.out.print("Enter 'y' value: ");
// int y = input.nextInt();

// System.out.print("Enter the scalar value / the number of repetition: ");
// int n = input.nextInt();

// getAllPoints(n, a, b, p, x, y);
// }

// public static int getModInverse(int x, int p) {
// int i;
// if (x < 0) {
// i = getModInverse(Math.abs(x), p) + p;
// return i;
// }

// for (i = 0; i < p; i++) {
// if ((x * i) % p == 1) {
// return i;
// }
// }

// return -1;
// }

// public static void getAllPoints(int n, int a, int b, int p, int x, int y) {
// int x1 = x;
// int y1 = y;
// int x2 = x;
// int y2 = y;

// for (int i = 1; i < n; i++) {
// int s = 0;
// int numerator = 0;
// int denominator = 0;

// if (x1 == x2 && y1 == y2) {
// numerator = (3 * x1 * x1 + a); // 3x^2 + a
// denominator = (2 * y1); // 2y

// } else {
// numerator = (y2 - y1);
// denominator = (x2 - x1);
// }

// if (numerator < 0 && denominator < 0) {
// numerator = numerator * -1;
// denominator = denominator * -1;
// }

// int denominatorInv = getModInverse(denominator, p);
// if (denominatorInv == -1) {
// System.out.println("No modular inverse for denominator. Stopping.");
// continue;
// }

// s = (numerator * denominatorInv) % p;

// int x3 = ((s * s) - x1 - x2) % p;
// int y3 = ((s * (x1 - x3)) - y1) % p;

// if (x3 < 0)
// x3 += p;

// if (y3 < 0)
// y3 += p;

// System.out.println((i + 1) + "P = (" + x3 + ", " + y3 + ")");

// // Updates tthe x, and y
// x2 = x3;
// y2 = y3;
// }
// }
// }
