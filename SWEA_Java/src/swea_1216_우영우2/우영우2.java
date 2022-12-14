package swea_1216_우영우2;

import java.util.Scanner;

public class 우영우2 {
	static final int TC = 10;
	static final int SIZE = 100;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0; t < TC;) {
			t = sc.nextInt();
			
			char[][] arr = new char[SIZE][SIZE];
			
			for (int r = 0; r < SIZE; r++) {
				String input = sc.next();
				for (int c = 0; c < SIZE; c++) {
					arr[r][c] = input.charAt(c);
				}
			}
			
			int max = Integer.MIN_VALUE;
			for (int r = 0; r < SIZE; r++) {
				for (int c = 0; c < SIZE; c++) {
					// 占쏙옙占쏙옙占� 찾占쏙옙
					// 회占쏙옙 占쏙옙占쏙옙
					find : for (int i = SIZE - c; i > 1; i--) {
						if(i <= max) break find;
						//회占쏙옙 占싯삼옙
						int cntr = 0;
						int cntc = 0;
						for (int j = 0; j < i / 2; j++) {
							if (arr[r][c + j] == arr[r][c + i - 1 - j]) {
								cntr++;
							}
							if (arr[c + j][r] == arr[c + i - 1 - j][r]) {
								cntc++;
							}
							if (cntr == i/2 || cntc == i/2) {
								max = Math.max(max, i);
								break find;
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + max);
		}
		sc.close();
	}
}
