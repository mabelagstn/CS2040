// Mabel Augustine Anggoro A0284680W

import java.util.*;

public class CoconutSplat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();

        List<Hand> lives = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lives.add(new Hand(i, 1));
        }
        int index = 0;
        while (lives.size() > 1) {
            index = (index + s - 1) % lives.size();
            Hand currentPlayer = lives.get(index);
            if (currentPlayer.folded()) {
                currentPlayer.update();
                lives.add(index + 1, new Hand(currentPlayer.getPlayer(), 2));
            } else if (currentPlayer.fist()) {
                currentPlayer.update();
                index++;
            } else {
                lives.remove(index);
            }
        }
        System.out.println(lives.get(0).getPlayer() + 1);
    }
}

class Hand {
    int player;
    int lives;

    Hand(int player, int lives) {
        this.player = player;
        this.lives = lives;
    }

    int getPlayer() {
        return player;
    }

    void update() {
        lives++;
    }

    boolean folded() {
        return lives == 1;
    }

    boolean fist() {
        return lives == 2;
    }
}


