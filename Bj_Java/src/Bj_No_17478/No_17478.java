package Bj_No_17478;

import java.util.Scanner;

public class No_17478 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		what_is(n, 0);
	}
	
	private static void what_is(int n, int m) {
		if (m == 0) System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		
		String[] qa = {"\"����Լ��� ������?\"", 
				"\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.", 
				"���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.", 
				"���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"", 
				"\"����Լ��� ������?\"", 
				"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"", 
				"��� �亯�Ͽ���."};

		for (int i = 0; i < 4; i++) {
			final StringBuilder under = new StringBuilder();
			for (int j = 0; j < m; j++) {
				under.append("____");
			}
			under.append(qa[i]);
			final String unders_with_qa = under.toString();
			System.out.println(unders_with_qa);
		}
		
		if (n-1 != m) what_is(n, m+1);
		
		for (int i = 4; i < 7; i++) {
			final StringBuilder under = new StringBuilder();
			for (int j = 0; j < m+1; j++) {
				under.append("____");
			}
			under.append(qa[i]);
			final String unders_with_qa = under.toString();
			if (i < 6 && n-1 == m) System.out.println(unders_with_qa);
			if (i > 5) System.out.println(unders_with_qa);
		}
		
		if (m == 0) System.out.println(qa[6]);
	}
}
