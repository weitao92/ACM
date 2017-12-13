package ECNA2016;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class B {
	static int whiteTime = 0;
	static int blackTime = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayDeque<String> q = new ArrayDeque<>();
		ArrayDeque<Player> white = new ArrayDeque<>();
		ArrayDeque<Player> black = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			String player = scan.next();
			if (i == 0 || i == 2) {
				white.add(new Player(player, whiteTime++));
			}
			else if (i == 1 || i == 3) {
				black.add(new Player(player, blackTime++));
			}
			else {
				q.add(player);
			}
		}
		String game = scan.next();
		int wins = 0;
		boolean isWhiteWin = false;
		boolean hasAdded = false;
		boolean isFirst = true;
		ArrayList<Team> teams = new ArrayList<>();
		int bestWins = -1;
		for (int i = 0; i < game.length(); i++) {
			if (game.charAt(i) == 'W') {
				if (!isWhiteWin) {
					isWhiteWin = true;
					if (wins > 0 && wins >= bestWins) {
						bestWins = wins;
						teams.add(new Team(black.getFirst(), black.getLast(), wins));
					}
					wins = 1;
				}
				else {
					isFirst = false;
					wins++;
				}
				white.add(white.poll());
				q.add(black.removeLast().name);
				black.addFirst(new Player(q.poll(), blackTime++));
			}
			else {
				if (isWhiteWin) {
					isWhiteWin = false;
					
					if (wins > 0 && wins >= bestWins) {
						bestWins = wins;
						teams.add(new Team(white.getFirst(), white.getLast(), wins));
					}
					wins = 1;
				}
				else {
					isFirst = false;
					wins++;
					
				}
				black.add(black.poll());
				q.add(white.removeLast().name);
				white.addFirst(new Player(q.poll(), whiteTime++));
			}
		}
		if (wins >= bestWins) {
			bestWins = wins;
			if (isWhiteWin) {
				teams.add(new Team(white.getFirst(), white.getLast(), wins));
			}
			else {
				teams.add(new Team(black.getFirst(), black.getLast(), wins));
			}
		}
		
//		Collections.sort(teams, (a, b) -> Integer.compare(a.wins, b.wins));
		StringBuilder ans = new StringBuilder();
		for (Team t : teams) {
			if (t.wins == bestWins) {
				ans.append(t.p1 + " " + t.p2 + "\n");
			}
		}
		System.out.print(ans);
	}
	
	static class Player {
		String name;
		int time;
		public Player(String name, int t) {
			this.name = name;
			time = t;
		}
	}

	static class Team {
		public String p1;
		public String p2;
		public int wins;
		public Team(Player n1, Player n2, int w) {
			if (n1.time < n2.time) {
				p1 = n1.name;
				p2 = n2.name;
			}
			else {
				p1 = n2.name;
				p2 = n1.name;
			}
			wins = w;
		}
	}

}