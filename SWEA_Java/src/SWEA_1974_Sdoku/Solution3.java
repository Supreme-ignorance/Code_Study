package SWEA_1974_Sdoku;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution3 {

	static int n = 9;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> check = new HashSet<Integer>();
		int o = 1;

		int testcase = sc.nextInt();
		
		test: for (int tc = 0; tc < testcase; tc++) {
			int[][] arr = new int[n][n];

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			for (int r = 0; r < n; r++) {
				check.clear();
				o = 1;
				for (int c = 0; c < n; c++) {
					check.add(arr[r][c]);
					if (check.size() != o++) {
						System.out.println("#" + (tc + 1) + " 0");
						continue test;
					}
				}
			}

			for (int c = 0; c < n; c++) {
				check.clear();
				o = 1;
				for (int r = 0; r < n; r++) {
					check.add(arr[r][c]);
					if (check.size() != o++) {
						System.out.println("#" + (tc + 1) + " 0");
						continue test;
					}
				}
			}

			for (int br = 0; br < n; br += 3) {
				for (int bc = 0; bc < n; bc += 3) {
					check.clear();
					o = 1;
					for (int r = br; r < br + 3; r++) {
						for (int c = bc; c < bc + 3; c++) {
							check.add(arr[r][c]);
							if (check.size() != o++) {
								System.out.println("#" + (tc + 1) + " 0");
								continue test;
							}
						}
					}
				}
			}
			System.out.println("#" + (tc + 1) + " 1");
		}
		sc.close();
	}
}
