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
		assertEquals("輸入ID或 Q (結束使用)？\n\r\n"+
					"Wrong input!! Please try again or \"Q\" for leave\n\r\n"+
					"輸入ID或 Q (結束使用)？\n\r\n"+
					"結束了\n\r\n"
				, out.toString());
	}
	@Test
	public void waitForStartTest2() {
		ByteArrayInputStream in = new ByteArrayInputStream("962001051 B R E Q ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		u.waitForStart();
		assertEquals("輸入ID或 Q (結束使用)？\n\r\n"+
				"Wellcome 李威廷\n\r\n"+
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"Wrong input!! Please try again or \"E\" for leave\n\r\n"+
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"李威廷排名:4\r\n"+
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"輸入ID或 Q (結束使用)？\n\r\n"+
				"結束了\n\r\n"
				, out.toString());
	}
}
