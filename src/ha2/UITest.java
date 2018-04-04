package ha2;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UITest {
	UserInterface u=null;
	@Before
	public void setUp() throws Exception {
		u=new UserInterface();
	}

	@After
	public void tearDown() throws Exception {
		u=null;
	}
	
	@Test
	public void waitForStartTest1() {
		ByteArrayInputStream in = new ByteArrayInputStream("1111111 Q ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		u.waitForStart();
		assertEquals("��JID�� Q (�����ϥ�)�H\n\r\n"+
					"Wrong input!! Please try again or \"Q\" for leave\n\r\n"+
					"��JID�� Q (�����ϥ�)�H\n\r\n"+
					"�����F\n\r\n"
				, out.toString());
	}
	@Test
	public void waitForStartTest2() {
		ByteArrayInputStream in = new ByteArrayInputStream("962001051 B R E Q ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		u.waitForStart();
		assertEquals("��JID�� Q (�����ϥ�)�H\n\r\n"+
				"Wellcome ���§�\n\r\n"+
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"Wrong input!! Please try again or \"E\" for leave\n\r\n"+
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"���§ʱƦW:4\r\n"+
				"\n��J���O \n1) G ��ܦ��Z (Grade)\n2) R ��ܱƦW (Rank)"
				+ "\n3) A ��ܥ��� (Average)\n4) W ��s�t�� (Weight)\n"
				+ "5) E ���}��� (Exit)\r\n"+
				"��JID�� Q (�����ϥ�)�H\n\r\n"+
				"�����F\n\r\n"
				, out.toString());
	}
}
