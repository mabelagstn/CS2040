import java.util.*;

public class PeaSoup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < number; i++) { // go thru no. of resto
            int menu = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            boolean peaSoup = false;
            boolean pancakes = false;
            
            for (int j = 0; j < menu; j++) { // go thru each resto's menu
                String food = sc.nextLine();
                if (food.equals("pea soup")){
                    peaSoup = true;
                }
                if (food.equals("pancakes")) {
                    pancakes = true;
                }
            }
            if (peaSoup && pancakes) {
                System.out.println(name);
                return;
            }
        }
        System.out.println("Anywhere is fine I guess"); 
    }
}