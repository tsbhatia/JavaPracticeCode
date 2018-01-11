package Problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Print all combinations of points that can compose a given number
// You can win three kinds of basketball points, 1 point, 2 points, and 3 points. 
// Given a total score n, print out all the combination to compose n.
class Solution {

	static String[] braces(String[] values) {
		Map<Character, Character> bracesMap = new HashMap<>();
		bracesMap.put('}', '{');
		bracesMap.put(')', '(');
		bracesMap.put(']', '[');

		ArrayDeque<Character> stack = new ArrayDeque<>();
		String[] result = new String[values.length];
		int r = 0;
		for (int val = 0; val < values.length; val++) {
			for (int i = 0; i < values[val].length(); i++) {
				char c = values[val].charAt(i);
				if (!bracesMap.keySet().contains(c)) {
					stack.addFirst(c);
				} else {
					if (stack.isEmpty() || (!stack.pop().equals(bracesMap.get(c)))) {
						break;
					}
				}
			}
			if(stack.isEmpty()){
				result[r++] = "YES";
			}else {
				result[r++] = "NO";
			}
		}

		return result;
	}

	public static void main(String args[]) {
       Solution sol = new Solution();
       String[] values = {"{{}}","{[]}","((", "", "})"};
       System.out.println(Arrays.toString(Solution.braces(values)));
	}
}
