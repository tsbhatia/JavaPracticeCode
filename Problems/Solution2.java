package Problems;

//Print all combinations of points that can compose a given number
// You can win three kinds of basketball points, 1 point, 2 points, and 3 points. 
// Given a total score n, print out all the combination to compose n.
class Solution2 {

	static int[][] zombieMap;
	static boolean[][] connectedMap;
	static int networkSize;

	static void initializeMap(String[] zombies) {
		networkSize = zombies.length;
		zombieMap = new int[networkSize][networkSize];
		connectedMap = new boolean[networkSize][networkSize];
		for (int i = 0; i < networkSize; i++) {
			String str = zombies[i];
			for (int j = 0; j < networkSize; j++) {
				if (str.charAt(j) == '1')
					zombieMap[i][j] = 1;
				else
					zombieMap[i][j] = 0;
			}
		}
	}

	static int zombieCluster(String[] zombies) {
		initializeMap(zombies);
		int count = 0;
		for (int i = 0; i < networkSize; i++) {
			for (int j = 0; j < networkSize; j++) {
				// check if this is first time saw this zombie
				if ((zombieMap[i][j] == 1) && !connectedMap[i][j]) {
					checkNetwork(i, j);
					count++;
				}
			}
		}
		return count;
	}

	private static void checkNetwork(int i, int j) {
		// Mark this point as known
		connectedMap[i][j] = true;
		// we can to look in all direction. up, down, left,right and diagonals;
		int[] rows = { -1, 1, 0, 0 };
		int[] cols = {  0, 0,-1, 1 };

		// recursively check for infection in connected network.
		for (int k = 0; k < 4; k++) {
			int newR = i + rows[k];
			int newC = j + cols[k];
			if (newR >= 0 && newR < networkSize && newC >= 0 && newC < networkSize) {
				if (zombieMap[newR][newC] == 1 && !connectedMap[newR][newC]) {
					checkNetwork(newR, newC);
				}
			}
		}
	}

	public static void main(String args[]) {
		Solution2 sol = new Solution2();
		String[] values = { "1100", "1110", "0110", "0001" };
		System.out.println(Solution2.zombieCluster(values));
	}
}
