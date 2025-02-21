// Mabel Augustine Anggoro A0284680W

import java.util.*;

public class T9Spelling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = { "2", "22", "222", "3", "33", "333", "4", "44", "444",
                "5", "55", "555", "6", "66", "666", "7", "77", "777", "7777",
                "8", "88", "888", "9", "99", "999", "9999", "0" };

        for (int i = 1; i <= n; i++) {
            String message = sc.nextLine();
            String seq = "";

            for (int j = 0; j < message.length(); j++) {
                String keyPress;

                if (message.charAt(j) != ' ') {
                    keyPress = arr[message.charAt(j) - 'a'];
                } else {
                    keyPress = arr[26];
                }

                if (seq.length() > 0 && seq.charAt(seq.length() - 1) == keyPress.charAt(0)) {
                    seq += " ";
                }
                seq += keyPress;
            }
            System.out.println("Case #" + i + ": " + seq);
        }
    }
}