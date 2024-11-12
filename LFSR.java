
/**
 * Aysha Hira - 1088000
 * Afrah Noor Salim - 1090111
 */
import java.util.ArrayList;
import java.util.Scanner;

public class LFSR {

    static ArrayList<String> generatedValues = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int i = 0;
        while (i < 2) {
            System.out.print("Enter Number: ");
            int id = input.nextInt();
            LFSR(id);
            i++;
            System.out.println();
        }
    }

    public static void LFSR(int id) {
        String binary_id = convertToBinary(Integer.toString(id));
        generatedValues.add(binary_id);
        System.out.println(binary_id);

        while (true) {
            char result = '1';
            // gets the 7th and 6th digits and XORs them
            if (binary_id.charAt(1) == binary_id.charAt(0)) {
                result = '0';
            }

            // shifts the digits by 1 to the right and adds XORed value
            binary_id = result + binary_id.substring(0, binary_id.length() - 1);

            if (generatedValues.contains(binary_id)) {
                generatedValues.clear(); // empties the list
                break;

            }

            generatedValues.add(binary_id);
            System.out.println(binary_id);
        }
    }

    public static String convertToBinary(String id) {
        String idInBinary = "";
        for (int index = 0; index < id.length(); index++) {
            switch ((int) (id.charAt(index)) % 2) {
                case 0:
                    idInBinary += 0;
                    break;
                case 1:
                    idInBinary += 1;
                    break;
            }
        }
        return idInBinary;
    }
}