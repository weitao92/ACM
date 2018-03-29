package NCPC2017;

import java.util.*;

/**
 * https://open.kattis.com/problems/gcpc
 * @author weitao92
 *
 */
public class ProblemG {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        Team[] team = new Team[n];
        
        for (int i = 0; i < n; i++) {
            team[i] = new Team(i, 0, 0);
        }
        
        StringBuilder ans = new StringBuilder();
        HashSet<Team> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int idx = scan.nextInt() - 1;
            int p = scan.nextInt();
            team[idx].solved++;
            team[idx].p += p;
            
            if (idx != 0) {
                if (team[idx].solved > team[0].solved) {
                    set.add(team[idx]);
                }
                else if (team[idx].solved == team[0].solved && team[idx].p < team[0].p) {
                    set.add(team[idx]);
                }
            }
            else if (idx == 0) {
                Iterator<Team> it = set.iterator();
                while (it.hasNext()) {
                    Team t = it.next();
                    if (t.solved < team[0].solved) {
                        it.remove();
                    }
                    else if (t.solved == team[0].solved && t.p >= team[0].p) {
                        it.remove();
                    }
                }
            }
            ans.append(set.size() + 1);
            ans.append("\n");
        }
        System.out.print(ans);
    }

    static class Team {
        int index;
        int solved;
        long p;

        public Team(int i, int s, long P) {
            index = i;
            solved = s;
            p = P;
        }

    }

}