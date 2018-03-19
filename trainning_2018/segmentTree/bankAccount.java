package segmentTree;

import java.util.Scanner;

/**
 * a max segmentTree.
 * @author weitao92
 *
 */
public class bankAccount {
	
	static class MaxSegmentTree
	{
		int left; 
		int right;
		int value;
		
		MaxSegmentTree leftTree;
		MaxSegmentTree rightTree;
		
		public MaxSegmentTree(int _left, int _right, int[] values)
		{
			left = _left; // if left == right, then it's leaf, which store the value
			right = _right;
			if(_left != _right) {
				leftTree = new MaxSegmentTree(_left, (_left + _right)/2, values);
				rightTree = new MaxSegmentTree((_left + _right)/2 +1, _right, values);
				value = Math.max(leftTree.value, rightTree.value);
			}
			else{
				value = values[_left];
			}
		}
		
		public int query(int _left, int _right){
			if(_left <= left && _right >= right){
				return value;
			}
			if(right < _left || left >_right){
				return Integer.MIN_VALUE;
			}
			return Math.max(leftTree.query(_left, _right), rightTree.query(_left, _right));
		}
	
	    public void puts(int pos, int val){
	    	if(left != right)
	    	{
	    		if(pos >= left && pos <= right)
	    		{
	    			leftTree.puts(pos,val);
	    			rightTree.puts(pos,val);
	    			value = Math.max(leftTree.value, rightTree.value);
	    		}
	    	}
	    	else
	    	{
	    		if (left == pos)
	    		{
	    			value = value + val;
	    		}
	    	}
	    }    	
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//int[] amount = new int[n];
		int[] arr = new int[n];
		MaxSegmentTree tree = new MaxSegmentTree(0,n-1,arr);
		int m = in.nextInt();

		
		for(int i = 0; i < m; i++)
		{
			String c = in.next();
			if(c.startsWith("A"))
			{
				int index = in.nextInt();
				int value = in.nextInt();
				//System.out.println(amount[index]);
				tree.puts(index, value);
				//tree.print();
			}
			else
			{
				
				int start = in.nextInt();
				int end = in.nextInt();
				System.out.println(tree.query(start, end));
			}
		}
		in.close();
	}

}
