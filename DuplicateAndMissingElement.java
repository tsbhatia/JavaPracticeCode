import java.util.Arrays;

/**
 * 11.10 EPI in Java. Find the duplicate and missing element. Problem statement:
 * If an array contains n integers, each between 0 and n-1 inclusive with
 * exactly one element appearing twice, implying that exactly one number between
 * 0 and n-1 is missing from the array. How would you compute the duplicate and
 * missing numbers?
 * This algorithm use Xor bitwise operation.
 * @author taran
 *
 */
class DuplicateAndMissingElement {

	private static class DuplicateAndMissing {
		public int duplicate;
		public int missing;

		public DuplicateAndMissing(int duplicate, int missing) {
			this.duplicate = duplicate;
			this.missing = missing;
		}
	}

	public static DuplicateAndMissing findDuplicateMissing(int[] arr) {
		// Compute the XOR of all members from 0 to |arr| - 1 and all entries in
		// arr.
		int missXorDup = 0;
		for (int i = 0; i < arr.length; i++) {
			missXorDup ^= i ^ arr[i];
		}
		System.out.println("missXorDup: " + missXorDup);
		// we need to find the a bit that's set to 1 in missXorDup.
		// Such a bit must exist if there is a single missing number
		// and a single duplicated number in arr.
		int differBit = missXorDup & ~(missXorDup - 1);
		System.out.println("differBit: " + differBit);
		int missOrDup = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & differBit) != 0) {
				missOrDup ^= arr[i];
			}
			if ((i & differBit) != 0) {
				missOrDup ^= i;
			}
		}
		System.out.println("missorDup: " + missOrDup);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == missOrDup) {
				return new DuplicateAndMissing(missOrDup, missOrDup ^ missXorDup);
			}
		}
		return new DuplicateAndMissing(missOrDup ^ missXorDup, missOrDup);
	}

	public static void main(String args[]) {
		int[] arr = { 5, 3, 0, 3, 1, 2 };
		System.out.println("Input array: " + Arrays.toString(arr));
		DuplicateAndMissing dm = DuplicateAndMissingElement.findDuplicateMissing(arr);
		System.out.println("Duplicate element: " + dm.duplicate);
		System.out.println("Missing element: " + dm.missing);
	}

}
