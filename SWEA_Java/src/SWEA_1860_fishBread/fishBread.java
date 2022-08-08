package SWEA_1860_fishBread;

import java.util.Arrays;
import java.util.Scanner;

public class fishBread {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(); // n��
			int m = sc.nextInt(); // m���� �ð��� ���̸�
			int k = sc.nextInt(); // k���� ��
			
			int[] list = new int[n];
			
			for(int i = 0; i < n; i++){
				list[i] = sc.nextInt();
			}
			
			Arrays.sort(list);
			
			int bread = 0;
			int leftsec = 0;
			boolean check = true;
			
			for(int i = 0; i < n; i++){
				if (i == 0) {
					int getsec = list[i] / m;
					bread += k * getsec - 1;
					leftsec = list[i] % m;
				} else {
					int getsec = (list[i] - list[i-1] + leftsec) / m;
					bread += k * getsec - 1;
					leftsec = (list[i] - list[i-1] + leftsec) % m;
				}
				if (bread < 0) {
					check = false;
				}
			}
			
			if (check) System.out.println("#" + t +" Possible");
			else System.out.println("#" + t +" Impossible");
		}
	}
}
