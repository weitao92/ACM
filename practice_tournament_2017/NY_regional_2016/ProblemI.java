package NY_regional_2016;

import java.util.Scanner;

/**
 * https://open.kattis.com/problems/amazing
 * @author weitao92
 *
 */
public class ProblemI {
    static Scanner scan;
    static P[][] arr = new P[220][220];
    static boolean[][] visited = new boolean[220][220];

    static class P {
        public boolean U;
        public boolean D;
        public boolean L;
        public boolean R;

        public P() {
            U = false;
            D = false;
            L = false;
            R = false;
        }
    }

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        arr[105][105] = new P();
        System.out.println("up");
        System.out.flush();

        visited[105][105] = true;
        
        // UP
        arr[105][105].U = true;
        traverse('U', 105, 106);

        // DOWN
        if (!arr[105][105].D) {
            System.out.println("down");
            System.out.flush();
            arr[105][105].D = true;
            traverse('D', 105, 104);
        }

        // LEFT
        if (!arr[105][105].L) {
            System.out.println("left");
            System.out.flush();
            arr[105][105].L = true;
            traverse('L', 104, 105);
        }

        // RIGHT
        if (!arr[105][105].R) {
            System.out.println("right");
            System.out.flush();
            arr[105][105].R = true;
            traverse('R', 106, 105);
        }

        System.out.println("no way out");
        scan.next();

        System.exit(0);
    }

    static void traverse(char dir, int x, int y) {
        String s = scan.next();

        if (arr[x][y] == null) {
            arr[x][y] = new P();
        }

        if (s.equals("wall")) {
            visited[x][y] = false;
            return;
        }

        if (s.equals("solved")) {
            System.exit(0);
        }

        // UP
        if (dir != 'D' && !arr[x][y].U && !visited[x][y + 1]) {
            System.out.println("up");
            System.out.flush();
            arr[x][y].U = true;
            visited[x][y + 1] = true;
            traverse('U', x, y + 1);
        }

        // DOWN
        if (dir != 'U' && !arr[x][y].D && !visited[x][y - 1]) {
            System.out.println("down");
            System.out.flush();
            arr[x][y].D = true;
            visited[x][y - 1] = true;
            traverse('D', x, y - 1);
        }

        // LEFT
        if (dir != 'R' && !arr[x][y].L && !visited[x - 1][y]) {
            System.out.println("left");
            System.out.flush();
            arr[x][y].L = true;
            visited[x - 1][y] = true;
            traverse('L', x - 1, y);
        }

        // RIGHT
        if (dir != 'L' && !arr[x][y].R && !visited[x + 1][y]) {
            System.out.println("right");
            System.out.flush();
            arr[x][y].R = true;
            visited[x + 1][y] = true;
            traverse('R', x + 1, y);
        }

        // BACKTRACK
        if (dir == 'U') {
            System.out.println("down");
            arr[x][y].D = true;
            System.out.flush();
        }
        else if (dir == 'D') {
            System.out.println("up");
            arr[x][y].U = true;
            System.out.flush();
        }
        else if (dir == 'L') {
            System.out.println("right");
            arr[x][y].R = true;
            System.out.flush();
        }
        else {
            System.out.println("left");
            arr[x][y].L = true;
            System.out.flush();
        }
        scan.next(); // we know backtracking is ok
    }
}
