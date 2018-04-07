package ha2;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/*
 * ��X���զ��Z�t��
 * �Ψ��ǥͪ�ID�]�p�ⵧ���P������
 * �]�A�Ҧ����\��H�ο��~�T��������
 */
public class integrationTest {
	hw2 h=null;
	@Before
	public void setUp() throws Exception {
		h =new hw2();
	}

	@After
	public void tearDown() throws Exception {
		h=null;
	}

	/*
	 * ��J���~�Ǹ�-->�t����ܿ��~
	 * ��J���§ʾǸ�-->welcome���§�
	 * ��J���~���O-->�t����ܿ��~
	 * ��ܱƦW
	 * ��ܦ��Z
	 * ��ܥ���
	 * ��weight
	 * 		�令20 20 20 20 20 
	 * 		�Ϯ�
	 * 		�令10 10 10 20 50
	 * ���� 
	 */
	@Test
	public void test1() {
		ByteArrayInputStream in = new ByteArrayInputStream("1111111 962001051 B R G A W 20 20 20 20 20 N 10 10 10 20 50 Y E Q ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		h.main(null);
		assertEquals("��JID�� Q (�����ϥ�)�H\r\n"+
				"Wrong input!! Please try again or \"Q\" for leave\r\n"+"��JID�� Q (�����ϥ�)�H\r\n"+
				"Welcome ���§�\r\n"+
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"Wrong input!! Please try again or \"E\" for leave\r\n"+
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"���§ʱƦW:4\r\n"+
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"���§ʦ��Z:lab1:     81\r\n"+ 
				"      lab2:     32*\r\n"+ 
				"      lab3:     50*\r\n"+ 
				"      mid-term :  90\r\n"+ 
				"      final exam : 93\r\n"+ 
				"      total grade : 81\r\n" +
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"lab1 : 88.5\nlab2 : 77.0\nlab3 : 79.25\nmid-term : 85.0\nfinal exam : 90.75\ntotal : 86.28"+
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
				"recheck?:\r\nlab1 = 20.0%\nlab2 = 20.0%\nlab3 = 20.0%\nmid-term = 20.0%\nfinal exam = 20.0%\r\n"+
				"�H�W���T��? Y (Yes) �� N (No)\r\n"+
				"old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
				"recheck?:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 20.0%\nfinal exam = 50.0%\r\n"+
				"�H�W���T��? Y (Yes) �� N (No)\r\n"+
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"��JID�� Q (�����ϥ�)�H\r\n"+
				"�����F\r\n"
				, out.toString());
	}
	/*
	 * ��J���~�Ǹ�-->�t����ܿ��~
	 * ��J���E�Ǹ�-->welcome���E
	 * ��J���~���O-->�t����ܿ��~
	 * ��ܱƦW
	 * ��ܦ��Z
	 * ��ܥ���
	 * ��weight
	 * 		�令20 20 20 10 30 
	 * 		�Ϯ�
	 * 		�令20 20 20 20 20
	 * ���� 
	 */
	@Test
	public void test2() {
		ByteArrayInputStream in = new ByteArrayInputStream("12321212 985002016 B R G A W 20 20 20 10 30 N 20 20 20 20 20 Y E Q ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		h.main(null);
		assertEquals("��JID�� Q (�����ϥ�)�H\r\n"+
				"Wrong input!! Please try again or \"Q\" for leave\r\n"+
				"��JID�� Q (�����ϥ�)�H\r\n"+
				"Welcome ���E\r\n"+
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"Wrong input!! Please try again or \"E\" for leave\r\n"+
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"���E�ƦW:3\r\n"+
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"���E���Z:lab1:     97\r\n"+ 
				"      lab2:     96\r\n"+ 
				"      lab3:     89\r\n"+ 
				"      mid-term :  85\r\n"+ 
				"      final exam : 80\r\n"+ 
				"      total grade : 86\r\n" +
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"lab1 : 88.5\nlab2 : 77.0\nlab3 : 79.25\nmid-term : 85.0\nfinal exam : 90.75\ntotal : 86.28"+
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
				"recheck?:\r\nlab1 = 20.0%\nlab2 = 20.0%\nlab3 = 20.0%\nmid-term = 10.0%\nfinal exam = 30.0%\r\n"+
				"�H�W���T��? Y (Yes) �� N (No)\r\n"+
				"old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
				"recheck?:\r\nlab1 = 20.0%\nlab2 = 20.0%\nlab3 = 20.0%\nmid-term = 20.0%\nfinal exam = 20.0%\r\n"+
				"�H�W���T��? Y (Yes) �� N (No)\r\n"+
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"��JID�� Q (�����ϥ�)�H\r\n"+
				"�����F\r\n"
				, out.toString());
	}
	/*
	@Test
	public void test2() {
		ByteArrayInputStream in = new ByteArrayInputStream("1111111 962001051 A W 20 20 20 20 20 Y E Q ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		h.main(null);
		assertEquals("��JID�� Q (�����ϥ�)�H\r\n"+
					"Wrong input!! Please try again or \"Q\" for leave\r\n"+
					"��JID�� Q (�����ϥ�)�H\r\n"+
					"Welcome ���§�\r\n"+
					"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
					+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
					+ "5) E ���}��� (Exit)\r\n"+
					"lab1 : 88.5\nlab2 : 77.0\nlab3 : 79.25\nmid-term : 85.0\nfinal exam : 90.75\ntotal : 86.28"+
					"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
					+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
					+ "5) E ���}��� (Exit)\r\n"+
					"old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
					"recheck?:\r\nlab1 = 20.0%\nlab2 = 20.0%\nlab3 = 20.0%\nmid-term = 20.0%\nfinal exam = 20.0%\r\n"+
					"�H�W���T��? Y (Yes) �� N (No)\r\n"+
					"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
					+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
					+ "5) E ���}��� (Exit)\r\n"+
					"��JID�� Q (�����ϥ�)�H\r\n"+
					"�����F\r\n"
				, out.toString());
	}
	
	@Test
	public void test2() {
		ByteArrayInputStream in = new ByteArrayInputStream("962001051 W 20 20 20 20 20 Y E Q ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		h.main(null);
		assertEquals("��JID�� Q (�����ϥ�)�H\r\n"+
					"Welcome ���§�\r\n"+
					"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
					+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
					+ "5) E ���}��� (Exit)\r\n"+
					"old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
					"recheck?:\r\nlab1 = 20.0%\nlab2 = 20.0%\nlab3 = 20.0%\nmid-term = 20.0%\nfinal exam = 20.0%\r\n"+
					"�H�W���T��? Y (Yes) �� N (No)\r\n"+
					"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
					+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
					+ "5) E ���}��� (Exit)\r\n"+
					"��JID�� Q (�����ϥ�)�H\r\n"+
					"�����F\r\n"
				, out.toString());
	}
	*/
}
