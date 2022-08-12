package swea_1213_findtext;

import java.util.Scanner;

public class FindText {
	static final int TC = 10;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t < TC;) {
			
			t = sc.nextInt();
			char[] find = (sc.next()).toCharArray();
			char[] string = (sc.next()).toCharArray();
			
			int i = 0;
			int j = 0;
			int result = 0;
			int f = find.length;
			
			while (i < string.length + 1 - f) {
				
				if (string[i+j] != find[j]) {
					i++; // ���� ���ڿ� ���� ã��
					j = -1; // j�� 0�� �ǵ���
				} 
				
				j++;
				
				if (j == f) {
					i += j; // ���ڰ� ��ġ�� �κ��� ã�� �ʿ� ����.
					result++; // ī��Ʈ
					j = 0;
				}
			} // ���� ã��
			System.out.println("#" + t + " "+ result); // ��� ���
		} // �׽�Ʈ ���̽�
	}
}
