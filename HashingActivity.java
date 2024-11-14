
public class HashingActivity {

    public static void main(String[] args) {
        // Replace with your 7-digit ADU ID
        String id = "1088000";

        // Step 1: Convert ADU ID to binary representation
        String binaryString = convertToBinary(id);
        System.out.println("Binary Representation of " + id + ": " + moreReadable(binaryString));

        // Step 2: Generate hash using the two-half method with 28 rounds
        String originalHash = generateHash(binaryString);
        System.out.println("Final Hash after 28 rounds for 1088000: " + originalHash);

        // Step 3: Modify one bit and generate a second hash
        String anotherId = convertToBinary("1088001");
        String modifiedHash = generateHash(anotherId);
        System.out.println("Final Modified Hash after 28 rounds for 1088001: " + modifiedHash);

        // Step 4: Compare the two hashes and count differing bits
        int differingBits = countDifferingBits(originalHash, modifiedHash);
        System.out.println("Number of differing bits between hashes: " + differingBits);
    }

    private static String convertToBinary(String id) {
        String binary = "";
        for (int i = 0; i < id.length(); i++) {
            switch (id.charAt(i)) {
                case '1':
                binary += "0001";
                break;

                case '8':
                binary += "1000";
                break;

                case '0':
                binary += "0000";
                break;
            }
        }
        return binary;
    }

    private static String generateHash(String binaryString) {
        String currentString = binaryString;
        for (int i = 1; i <= 1000000 ; i++) {
            System.out.println("\nRound " + i);
            if (i == 1) 

            System.out.println("Current Binary String: \t    " + moreReadable(currentString));

            String shiftedString = rightCircularShift(currentString, 1);
            System.out.println("After Right Circular Shift: " + moreReadable(shiftedString));

            currentString = xorStrings(currentString, shiftedString);
            System.out.println("After XOR Operation: \t    " + moreReadable(currentString));
        }
        return currentString;
    }

    private static String moreReadable(String text) {
        return text.substring(0, 4) + " "
                + text.substring(4, 8) + " "
                + text.substring(8, 12) + " "
                + text.substring(12, 16) + " "
                + text.substring(16, 20) + " "
                + text.substring(20, 24) + " "
                + text.substring(24, 28);
    }

    private static String rightCircularShift(String str, int shift) {
        // String shiftedString = "";
        // for (int i = 0; i < 8; i++) {
        //     String eachFourBit = str.substring(i * 4, i * 4 + 4);
        //     shiftedString += eachFourBit.charAt(3) + eachFourBit.substring(0, eachFourBit.length()-1);
   
        // }

        // return shiftedString;
        int len = str.length();
        return str.substring(len - shift) + str.substring(0, len - shift);
    }

    private static String xorStrings(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            result.append(str1.charAt(i) == str2.charAt(i) ? '0' : '1');
        }
        return result.toString();
    }

    private static int countDifferingBits(String hash1, String hash2) {
        int count = 0;
        for (int i = 0; i < hash1.length(); i++) {
            if (hash1.charAt(i) != hash2.charAt(i)) {
                count++;
            }
        }
        return count; 
    }
}
