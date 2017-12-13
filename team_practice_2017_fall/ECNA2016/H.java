package ECNA2016;

import java.util.*;

/**
 * https://open.kattis.com/problems/vindiagrams
 * @author weitao92
 *
 */
public class H {
    
    static class point implements Comparable<point>
    {
        int row;
        int col;
        
        public point(int a, int b)
        {
            row = a;
            col = b;
        }
        
        @Override
        public int compareTo(point o) {
            if(row == o.row)
            {
                return Integer.compare(col, o.col);
            }
            else
            {
                return Integer.compare(row, o.row);
            }
        }
        
        public boolean equals(Object o)
        {
            point another = (point)o;
            
            return row == another.row && col == another.col;
        }
    }
    
    static int n;
    static int m;
    static int[][] world;
    static point inter1;
    static point inter2;
    static ArrayList<point> intersections = new ArrayList<point>();
    public static void main(String Args[])
    {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        world = new int[n][m];
        point A = null;
        point B = null;
        
        for(int i = 0; i < n; i++)
        {
            String line = in.next();
        
            for(int j = 0; j < m; j++)
            {
                char c = line.charAt(j);
                if(c == 'X')
                {
                    world[i][j] = 1;
                }
                else if(c == '.')
                {
                    world[i][j] = 0;
                }
                else if(c == 'A')
                {
                    world[i][j] = -1;
                    A = new point(i,j);
                }
                else
                {
                    world[i][j] = -2;
                    B = new point(i,j);
                }
            }
        }

        ArrayList<point> AP = new ArrayList<point>();
        ArrayList<point> BP = new ArrayList<point>();
        cal(AP,A);
        cal(BP,B);
       
        int sumA = sum(AP);
        int sumB = sum(BP);
        intersections.add(inter1);
        intersections.add(inter2);
        //System.out.println(sumA + " " + sumB);
        
        int total = sum(intersections);
        //System.out.println(total);
        
        
        
        System.out.println((sumA - total) + " " + (sumB - total) + " " + total);
    }
    
    private static int sum(ArrayList<point> list)
    {
        int result = 0;
        Collections.sort(list);
        point smallest = list.get(0);
        point start = new point(smallest.row+1, smallest.col+1);
        
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<point> queue = new ArrayDeque<point>();
        visited[start.row][start.col] = true;
        queue.add(start);
        while(!queue.isEmpty())
        {
        	point current = queue.removeFirst();
        	int r = current.row;
        	int c = current.col;
        	if(world[r][c] == 0)
        	{
        		result++;
        	}
        	else
        	{
        		intersections.add(current);
        	}
        	
        	if((world[r-1][c] == 0 || Collections.binarySearch(list, new point(r-1,c)) < 0) 
        			&& !visited[r-1][c])
        	{
        		visited[r-1][c] = true;
        		queue.add(new point(r-1,c));
        	}
        	if((world[r][c+1] == 0 || Collections.binarySearch(list, new point(r,c+1)) < 0)
        			&& !visited[r][c+1])
        	{
        		visited[r][c+1] = true;
        		queue.add(new point(r,c+1));
        	}
        	if((world[r+1][c] == 0 || Collections.binarySearch(list, new point(r+1,c)) < 0)
        			&& !visited[r+1][c])
        	{
        		visited[r+1][c] = true;
        		queue.add(new point(r+1,c));
        	}
        	if((world[r][c-1] == 0 || Collections.binarySearch(list, new point(r,c-1)) < 0)
        			&& !visited[r][c-1])
        	{
        		visited[r][c-1] = true;
        		queue.add(new point(r,c-1));
        	}
        }
        
        return result;
    }
    
    private static void cal(ArrayList<point> list, point origin)
    {
        point prev = origin;
        point current = null;
        
        boolean[][] visited = new boolean[n][m];
        
        while(current == null || !current.equals(origin))
        {
            if(current != null && current.equals(prev))
            {
                return;
            }
            
            if(current != null)
            {
                visited[current.row][current.col] = true;
            }
            else
            {
                current = origin;
            }
            list.add(current);
            
            
            if(isInter(current))
            {
            	if(inter1 == null)
            	{
            		inter1 = current;
            	}
            	else
            	{
            		inter2 = current;
            	}
                if(prev.row == current.row)
                {
                    if(current.col > prev.col)
                    {
                        point next = new point(current.row, current.col + 1);
                        prev = current;
                        current = next;
                        continue;
                    }
                    else
                    {
                        point next = new point(current.row, current.col - 1);
                        prev = current;
                        current = next;
                        continue;
                    }
                }
                else
                {
                    if(current.row > prev.row)
                    {
                        point next = new point(current.row + 1, current.col);
                        prev = current;
                        current = next;
                        continue;
                    }
                    else
                    {
                        point next = new point(current.row - 1, current.col);
                        prev = current;
                        current = next;
                        continue;
                    }
                }
            }
            else
            {
                if ((current.row - 1) >= 0 && !visited[current.row-1][current.col] && !origin.equals(new point(current.row-1, current.col))&& world[current.row-1][current.col] != 0) 
                {
                    point next = new point(current.row-1, current.col);
                    prev = current;
                    current = next;
                    continue;
                }
                
                if((current.col + 1) < m && !visited[current.row][current.col + 1] && !origin.equals(new point(current.row, current.col+1)) && world[current.row][current.col+1] != 0)
                {
                    point next = new point(current.row, current.col+1);
                    prev = current;
                    current = next;
                    continue;
                }
                
                if((current.row + 1) < n && !visited[current.row+1][current.col] && !origin.equals(new point(current.row+1, current.col)) && world[current.row+1][current.col] != 0)
                {
                    point next = new point(current.row+1, current.col);
                    prev = current;
                    current = next;
                    continue;
                }
                
                if((current.col-1) >= 0 && !visited[current.row][current.col-1] && !origin.equals(new point(current.row, current.col-1))&& world[current.row][current.col-1] != 0)
                {
                    point next = new point(current.row, current.col-1);
                    prev = current;
                    current = next;
                    continue;
                }
                
                if(origin.equals(new point(current.row, current.col-1)) || origin.equals(new point(current.row+1, current.col))
                        || origin.equals(new point(current.row, current.col+1)) || origin.equals(new point(current.row-1, current.col)))
                {
                    return;
                }
            }
        }
    }
    
    private static boolean isInter(point p)
    {
        if((p.row - 1) < 0 || p.col+1 >= m || p.row + 1 >= n || p.col-1 < 0)
        {
            return false;
        }
        if ((p.row - 1) >= 0 && world[p.row-1][p.col] == 0) 
        {
            return false;
        }
        
        if((p.col + 1) < m && world[p.row][p.col + 1] == 0)
        {
            return false;
        }
        
        if((p.row + 1) < n && world[p.row+1][p.col] == 0)
        {
            return false;
        }
        
        if((p.col-1) >= 0 && world[p.row][p.col-1] == 0)
        {
            return false;
        }
        
        return true;
    }
    

}