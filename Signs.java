import java.util.*;

public class SignsA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        SignComparator signComp = new SignComparator();
        Arrays.sort(arr, signComp);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}

class SignComparator implements Comparator<String> {
    public String middleLetter(String sign) {
        if (sign.length() % 2 != 0) {
            return sign.substring(sign.length()/2, sign.length()/2 + 1);
        }
        else {
            return sign.substring(sign.length()/2 - 1, sign.length()/2 + 1);
        }
    }
    @Override
    public int compare(String sign1, String sign2) {
        return middleLetter(sign1).compareTo(middleLetter(sign2));
    }
}