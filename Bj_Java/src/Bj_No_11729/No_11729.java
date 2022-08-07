package Bj_No_11729;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class No_11729 {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		bw.write((int)Math.pow(2, n)-1 + "\n");
		
		//�ϳ����� ž
		tower_of_hanoi(n, 1, 3, 2);

		bw.flush();
		bw.close();
	}

	static void tower_of_hanoi(int n, int from, int to, int temp) throws IOException {
		/**nũ���� ž�� �ű�����ؼ� 
		 *n-1ũ���� ž�� ��ǥ�� �ٸ� ������� �ű�� 
		 *n��° ������ ��ǥ������� �ű��
		 *n-1ũ���� ž�� ��ǥ ������� �ű�� �ȴ�.
		 *�̻��� �ڵ�� ��Ÿ���� �Ʒ��� ����.
		 */
		if (n == 1) swap(from, to);
		else {
			tower_of_hanoi(n-1, from, temp, to); // n-1ũ���� ž�� ��ǥ�� �ٸ� ������� �ű��.
			swap(from, to); // n��° ������ ��ǥ������� �ű��.
			tower_of_hanoi(n-1, temp, to, from); // n-1ũ���� ž�� ��ǥ ������� �ű��.
		}
	}
	// ��� �� ��ȯ ���
	static void swap(int a, int b) throws IOException {
		bw.write(a + " " + b + "\n");
	}
}
