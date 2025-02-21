import java.util.*;

class Runner {
    String name;
    double firstTime;
    double otherTime;

    Runner(String name, double firstTime, double otherTime) {
        this.name = name;
        this.firstTime = firstTime;
        this.otherTime = otherTime;
    }
}

public class BestRelayTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Runner[] runners = new Runner[n];
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            runners[i] = new Runner(input[0], Double.parseDouble(input[1]), Double.parseDouble(input[2]));
        }

        Arrays.sort(runners, new Comparator<Runner>() {
            public int compare(Runner a, Runner b) {
                return Double.compare(a.firstTime, b.firstTime);
            }
        });

        double fastestTime = Double.MAX_VALUE;
        String[] bestRelayTeam = new String[4];

        for (int i = 0; i < n; i++) {
            Runner firstRunner = runners[i];
            Runner[] remaining = new Runner[n - 1];
            int index = 0;

            for (int j = 0; j < n; j++) {
                if (j != i) {
                    remaining[index] = runners[j];
                    index++;
                }
            }

            Arrays.sort(remaining, new Comparator<Runner>() {
                public int compare(Runner a, Runner b) {
                    return Double.compare(a.otherTime, b.otherTime);
                }
            });

            double totalTime = firstRunner.firstTime + remaining[0].otherTime + remaining[1].otherTime + remaining[2].otherTime;

            if (totalTime < fastestTime) {
                fastestTime = totalTime;
                bestRelayTeam[0] = firstRunner.name;
                bestRelayTeam[1] = remaining[0].name;
                bestRelayTeam[2] = remaining[1].name;
                bestRelayTeam[3] = remaining[2].name;
            }
        }

        System.out.println(fastestTime);
        for (int i = 0; i < 4; i++) {
            System.out.println(bestRelayTeam[i]);
        }
    }
}
