package swea_1228_Cipher1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Cipher1 {
	static final int tc = 10;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= tc; t++) {
			List<Integer> Cipher = new LinkedList<Integer>();
			
			int n = sc.nextInt(); // �Է� ���� ��ȣ�� ����
			
			for (int i = 0; i < n; i++) {
				Cipher.add(sc.nextInt());
			}
			
			n = sc.nextInt(); // �Է� ���� ��ɾ��� ����
			
			for (int i = 0; i < n; i++) {
				char c = sc.next().charAt(0);
				
				if (c == 'I') {
					int x = sc.nextInt(); // x�ε�����
					int y = sc.nextInt(); // y����ŭ
					
					for(int j = 0; j < y; j++) {
						Cipher.add(x+j, sc.nextInt());
					} // �߰��Ѵ�.
				} // ���� ����̶��
			}
			
			System.out.print("#" + t);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + Cipher.get(i));
			}System.out.println();
		}
		sc.close();
	}
}
