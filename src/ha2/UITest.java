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
 * 測試UI這個test的所有public method
 * 
 * 包括:
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
	 * 傳入錯誤的學號-->系統顯示錯誤訊息
	 * 傳入Q-->系統正常結束
	 */
	@Test
	public void waitForStartTest1() {
		ByteArrayInputStream in = new ByteArrayInputStream("1111111 Q ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		u=new UserInterface();
		u.waitForStart();
		assertEquals("輸入ID或 Q (結束使用)？\r\n"+
					"Wrong input!! Please try again or \"Q\" for leave\r\n"+
					"輸入ID或 Q (結束使用)？\r\n"+
					"結束了\r\n"
				, out.toString());
	}
	/*
	 * 傳入李威廷學號-->welcome 李威廷
	 * 傳入錯誤指令-->顯示錯誤訊息
	 * 要求showRank-->show 李威廷的排名
	 * 結束 
	 */
	@Test
	public void waitForStartTest2() {
		ByteArrayInputStream in = new ByteArrayInputStream("962001051 B R E Q ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		u=new UserInterface();
		u.waitForStart();
		assertEquals("輸入ID或 Q (結束使用)？\r\n"+
				"Welcome 李威廷\r\n"+
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"Wrong input!! Please try again or \"E\" for leave\r\n"+
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"李威廷排名:4\r\n"+
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"輸入ID或 Q (結束使用)？\r\n"+
				"結束了\r\n"
				, out.toString());
	}
}
