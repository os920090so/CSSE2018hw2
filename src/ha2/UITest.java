package ha2;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/*
 * class UITest
 * 
 * ����UI�o��test���Ҧ�public method
 * 
 * �]�A:
 * waitForStart()
 * 
 */
public class UITest {
	UserInterface u=null;
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		u=null;
	}
	
	/*
	 * �ǤJ���~���Ǹ�-->�t����ܿ��~�T��
	 * �ǤJQ-->�t�Υ��`����
	 */
	@Test
	public void waitForStartTest1() {
		ByteArrayInputStream in = new ByteArrayInputStream("1111111 Q ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		u=new UserInterface();
		u.waitForStart();
		assertEquals("��JID�� Q (�����ϥ�)�H\r\n"+
					"Wrong input!! Please try again or \"Q\" for leave\r\n"+
					"��JID�� Q (�����ϥ�)�H\r\n"+
					"�����F\r\n"
				, out.toString());
	}
	/*
	 * �ǤJ���§ʾǸ�-->welcome ���§�
	 * �ǤJ���~���O-->��ܿ��~�T��
	 * �n�DshowRank-->show ���§ʪ��ƦW
	 * ���� 
	 */
	@Test
	public void waitForStartTest2() {
		ByteArrayInputStream in = new ByteArrayInputStream("962001051 B R E Q ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		u=new UserInterface();
		u.waitForStart();
		assertEquals("��JID�� Q (�����ϥ�)�H\r\n"+
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
				"��JID�� Q (�����ϥ�)�H\r\n"+
				"�����F\r\n"
				, out.toString());
	}
}
