package segmentTree;

import java.util.Scanner;

/**
 * a min-segmentTree which support range update.
 * @author weitao92
 *
 */
public class circular {
	
	static class minSegmentTree
	{
		int left; 
		int right;
		int value;
		int delta;
		minSegmentTree leftTree;
		minSegmentTree rightTree;
		
		public minSegmentTree(int _left, int _right, int[] values)
		{
			left = _left;
			right = _right;
			if(_left != _right) {
				leftTree = new minSegmentTree(_left, (_left + _right)/2, values);
				rightTree = new minSegmentTree((_left + _right)/2 +1, _right, values);
				value = Math.min(leftTree.value, rightTree.value);
				delta = 0;
			}
			else{
				value = values[_left];
				delta = 0;
			}
		}
		
		public int query(int _left, int _right){
			if(_left <= left && _right >= right){
				return value + delta;
			}
			if(right < _left || left >_right){
				return Integer.MAX_VALUE;
			}
			return delta + Math.min(leftTree.query(_left, _right), rightTree.query(_left, _right));
		}
	
		public void increase(int l, int r, int inc_v) // a node add value to delta 
		//iff all its childen in update range.
		{
			
				if (l <= this.right && r >= this.left){ 
					//Subtree range intersects with update range
					if(l <= this.left && this.right <= r){	
						// Update range completely covers subtree range
						delta += inc_v;	
					} else {
						leftTree.increase(l, r, inc_v);
						rightTree.increase(l,r, inc_v);
						value = Math.min(leftTree.value +
							leftTree.delta, rightTree.value +
							rightTree.delta);
					}
				}
			
		}  	
	}

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = in.nextInt();
		}
		minSegmentTree tree = new minSegmentTree(0,n-1,arr);
		int m = in.nextInt();
		in.nextLine();
		for(int i = 0; i < m; i++)
		{
			String line = in.nextLine();
			String[] splited = line.split(" ");
			//System.out.println(splited.length);
			int first = Integer.parseInt(splited[0]);
			int second = Integer.parseInt(splited[1]);
	
			if(splited.length == 2)
			{
				if(first <= second)
				{
					System.out.println(tree.query(first, second));
				}
				else
				{
					int result = Math.min(tree.query(first, n-1),
							tree.query(0, second));
					System.out.println(result);
				}
			}
			else
			{
				int v = Integer.parseInt(splited[2]);
				if(first <= second)
				{
					tree.increase(first, second, v);
				}
				else
				{
					tree.increase(first, n-1, v);
					tree.increase(0, second, v);
				}
			}
		}
		in.close();
	}
}
