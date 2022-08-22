package swea_1873_BattleField;

import java.util.Scanner;

public class BattleField {
	
	static int myr = -1;
	static int myc = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			
			int h = sc.nextInt(); // ����
			int w = sc.nextInt(); // ����
			
			char[][] field = new char[h][w];
			
			for (int r = 0; r < h; r++) {
				String temp = sc.next();
				for (int c = 0; c < w; c++) {
					field[r][c] = temp.charAt(c);
					if (field[r][c] == '>' || field[r][c] == '<' || field[r][c] == '^' || field[r][c] == 'v') {
						myr = r;
						myc = c;
					}
				}
			} // field �Է� �� ���� ��ġ Ȯ��
			
			int comandlength = sc.nextInt(); // ��� ���� Ȯ��
			
			String comands = sc.next(); // ��� �Է�
			
			for (int i = 0; i < comandlength; i ++) {
				control(field, comands.charAt(i), field[myr][myc]);
			} // ����
			
			System.out.print("#" + t + " ");
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					System.out.print(field[r][c]);
				} System.out.println();
			}
		} // �׽�Ʈ ���̽�
		sc.close();
	}
	
	static void control(char[][] field, char comand, char mydir) {
		switch (comand) {
		// ���� ���� ��ȯ �̵� ���ɽ� �̵�
		case 'U' : 
			field[myr][myc] = '^';
			if (myr - 1 >= 0 && ismoveable(field[myr - 1][myc])) {
				field[myr - 1][myc] = field[myr][myc];
				field[myr][myc] = '.';
				myr--;
			}
			break;
		// �Ʒ��� ���� ��ȯ �̵� ���ɽ� �̵�
		case 'D' : 
			field[myr][myc] = 'v';
			if (myr + 1 < field.length && ismoveable(field[myr + 1][myc])) {
				field[myr + 1][myc] = field[myr][myc];
				field[myr][myc] = '.';
				myr++;
			}
			break;
		// �������� ���� ��ȯ �̵� ���ɽ� �̵�
		case 'L' :
			field[myr][myc] = '<';
			if (myc - 1 >= 0 && ismoveable(field[myr][myc - 1])) {
				field[myr][myc - 1] = field[myr][myc];
				field[myr][myc] = '.';
				myc--;
			}
			break;
		// ���������� ���� ��ȯ �̵� ���ɽ� �̵�
		case 'R' :
			field[myr][myc] = '>';
			if (myc + 1 < field[0].length && ismoveable(field[myr][myc + 1])) {
				field[myr][myc + 1] = field[myr][myc];
				field[myr][myc] = '.';
				myc++;
			}
			break;
		//�߻�
		case 'S' : 
			int[] dr = { 1, -1, 0, 0 };
			int[] dc = { 0, 0, 1, -1 };
			
			int i = -1;
			
			if (field[myr][myc] == 'v') i = 0;
			else if (field[myr][myc] == '^') i = 1;
			else if (field[myr][myc] == '>') i = 2;
			else if (field[myr][myc] == '<') i = 3;
			
			int tempr = myr + dr[i];
			int tempc = myc + dc[i];
			// �迭 ������ ����� ������
			while (tempr >= 0 && tempr < field.length && tempc >= 0 && tempc < field[0].length) {
				if (isbreakable(field[tempr][tempc])) {
					field[tempr][tempc] = '.';
					break;
				} else if (isunbreakable(field[tempr][tempc])) break;
				tempr += dr[i];
				tempc += dc[i];
			}
		}
	}
	
	static boolean ismoveable(char input) {
		if (input == '.') return true;
		else return false;
	}
	
	static boolean isbreakable(char input) {
		if (input == '*') return true;
		else return false;
	}
	
	static boolean isunbreakable(char input) {
		if (input == '#') return true;
		else return false;
	}
}
