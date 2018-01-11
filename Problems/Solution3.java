package Problems;

import java.util.Arrays;

//Print all combinations of points that can compose a given number
// You can win three kinds of basketball points, 1 point, 2 points, and 3 points. 
// Given a total score n, print out all the combination to compose n.
class Solution3 {

	/*
     * Complete the function below.
     */
    static int[] connectedCities(int n, int g, int[] originCities, int[] destinationCities) {
        int[] result = new int[destinationCities.length];
    	for (int i = 0; i < destinationCities.length; i++) {
			int start = originCities[i];
			int end = destinationCities[i];
			int gcdN = gcd(start,end);
            System.out.println("start: "+ start+ "  end: "+ end+"  GCD: "+ gcdN);
			if(gcd(start,end) > g){
				result[i] = 1;
			}else{
				result[i] = 0;
			}
		}        
    	return result;
    }
    

    private static int gcd(int start, int end) {
		if(start == 0 || end == 0)
			return 0;
		if(start == end)
			return end;
		
		return (start>end)?gcd(start-end,end):gcd(start, end-start);
	}


	// longest palindrome subsequence length
    static int getLengthPalindrom(String s, int left, int right){
    	System.out.println("String : "+s+ "  left: "+ left+ "  right: "+right);
        // Found no palindrom
        if(left > right)
            return 0;
        
        // Found single character
        if(left == right)
            return 1;
        
        if(s.charAt(left)==s.charAt(right)){
            return getLengthPalindrom(s, left + 1, right - 1) + 2;
        }
        
        int leftSub = getLengthPalindrom(s, left+1, right);
        int rightSub = getLengthPalindrom(s, left, right-1);
        return leftSub > rightSub?leftSub:rightSub;
       
    }
    
    static int getPalindromeLength(String s){
    	return getLengthPalindrom(s, 0, s.length()-1);
    }
    static int getScore(String s) {
        // Lets see if i can finish this... looks lengthy
        // Algo will be as follow:
        // 1) Divide the string into prefix and suffic subsequences for partition index at i =0 ... n-1
        // 2) Compute the length of longest palindrome in prefix and suffic subsequence.
        // 3) Check if it is max
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
			String sLeft = s.substring(0, i);
			System.out.println("sleft: "+sLeft);
			String sRight = s.substring(i);
			System.out.println("sRight: "+sRight);
			int leftSize = getPalindromeLength(sLeft);
			int rightSize = getPalindromeLength(sRight);
			if((leftSize*rightSize) > max )
				max = leftSize*rightSize;
		}
        return max;

    }
    
	public static void main(String args[]) {
		String input = "acdapmpomp";
		//System.out.println(Solution3.getScore(input));
		int[] origin = {10,4,3,6};
		int[] dest = {3,6,2,9};
		int[] result = Solution3.connectedCities(10, 1, origin, dest);
	    System.out.println(Arrays.toString(result));
	}
}
