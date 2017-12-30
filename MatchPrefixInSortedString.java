import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Varient #4 of 11.1 of EPI Java book. Write a program which tests if p is a
 * prefix of a string in an array of sorted strings.
 * 
 * @author taran
 *
 */
class MatchPrefixInSortedString {

	public static int getMatchPrefixInSortedStrings(List<String> str, String prefix) {
		int L = 0, U = str.size() - 1;
		while (L <= U) {
			int mid = L + ((U - L) / 2);
			if (str.get(mid).startsWith(prefix)) {
				return mid;
			} else if (str.get(mid).compareTo(prefix) < 0) {
				L = mid + 1;
			} else {
				U = mid - 1;
			}
		}
		return -1;

	}

	public static void main(String args[]) {
		List<String> str = Arrays.asList("ab", "abd", "adb", "abcd", "aced", "bcde", "abdc");
		System.out.println("Original input: " + str);
		Collections.sort(str);
		System.out.println("Sorted input: " + str);
		Scanner sc = new Scanner(System.in);
		System.out.println("Input prefix to be matched");
		String prefix = sc.nextLine();
		sc.close();
		System.out.println("Index of string contains prefix: "
				+ MatchPrefixInSortedString.getMatchPrefixInSortedStrings(str, prefix));
	}

}
