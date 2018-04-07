package ha2;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/*
 * 整合測試成績系統
 * 用兩位學生的ID設計兩筆不同的測資
 * 包括所有的功能以及錯誤訊息的提示
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
	 * 輸入錯誤學號-->系統顯示錯誤
	 * 輸入李威廷學號-->welcome李威廷
	 * 輸入錯誤指令-->系統顯示錯誤
	 * 顯示排名
	 * 顯示成績
	 * 顯示平均
	 * 改weight
	 * 		改成20 20 20 20 20 
	 * 		反悔
	 * 		改成10 10 10 20 50
	 * 結束 
	 */
	@Test
	public void test1() {
		ByteArrayInputStream in = new ByteArrayInputStream("1111111 962001051 B R G A W 20 20 20 20 20 N 10 10 10 20 50 Y E Q ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		h.main(null);
		assertEquals("輸入ID或 Q (結束使用)？\r\n"+
				"Wrong input!! Please try again or \"Q\" for leave\r\n"+"輸入ID或 Q (結束使用)？\r\n"+
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
				"李威廷成績:lab1:     81\r\n"+ 
				"      lab2:     32*\r\n"+ 
				"      lab3:     50*\r\n"+ 
				"      mid-term :  90\r\n"+ 
				"      final exam : 93\r\n"+ 
				"      total grade : 81\r\n" +
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"lab1 : 88.5\nlab2 : 77.0\nlab3 : 79.25\nmid-term : 85.0\nfinal exam : 90.75\ntotal : 86.28"+
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
				"recheck?:\r\nlab1 = 20.0%\nlab2 = 20.0%\nlab3 = 20.0%\nmid-term = 20.0%\nfinal exam = 20.0%\r\n"+
				"以上正確嗎? Y (Yes) 或 N (No)\r\n"+
				"old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
				"recheck?:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 20.0%\nfinal exam = 50.0%\r\n"+
				"以上正確嗎? Y (Yes) 或 N (No)\r\n"+
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"輸入ID或 Q (結束使用)？\r\n"+
				"結束了\r\n"
				, out.toString());
	}
	/*
	 * 輸入錯誤學號-->系統顯示錯誤
	 * 輸入王淳學號-->welcome王淳
	 * 輸入錯誤指令-->系統顯示錯誤
	 * 顯示排名
	 * 顯示成績
	 * 顯示平均
	 * 改weight
	 * 		改成20 20 20 10 30 
	 * 		反悔
	 * 		改成20 20 20 20 20
	 * 結束 
	 */
	@Test
	public void test2() {
		ByteArrayInputStream in = new ByteArrayInputStream("12321212 985002016 B R G A W 20 20 20 10 30 N 20 20 20 20 20 Y E Q ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		h.main(null);
		assertEquals("輸入ID或 Q (結束使用)？\r\n"+
				"Wrong input!! Please try again or \"Q\" for leave\r\n"+
				"輸入ID或 Q (結束使用)？\r\n"+
				"Welcome 王淳\r\n"+
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"Wrong input!! Please try again or \"E\" for leave\r\n"+
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"王淳排名:3\r\n"+
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"王淳成績:lab1:     97\r\n"+ 
				"      lab2:     96\r\n"+ 
				"      lab3:     89\r\n"+ 
				"      mid-term :  85\r\n"+ 
				"      final exam : 80\r\n"+ 
				"      total grade : 86\r\n" +
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"lab1 : 88.5\nlab2 : 77.0\nlab3 : 79.25\nmid-term : 85.0\nfinal exam : 90.75\ntotal : 86.28"+
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
				"recheck?:\r\nlab1 = 20.0%\nlab2 = 20.0%\nlab3 = 20.0%\nmid-term = 10.0%\nfinal exam = 30.0%\r\n"+
				"以上正確嗎? Y (Yes) 或 N (No)\r\n"+
				"old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
				"recheck?:\r\nlab1 = 20.0%\nlab2 = 20.0%\nlab3 = 20.0%\nmid-term = 20.0%\nfinal exam = 20.0%\r\n"+
				"以上正確嗎? Y (Yes) 或 N (No)\r\n"+
				"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
				+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
				+ "5) E 離開選單 (Exit)\r\n"+
				"輸入ID或 Q (結束使用)？\r\n"+
				"結束了\r\n"
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
		assertEquals("輸入ID或 Q (結束使用)？\r\n"+
					"Wrong input!! Please try again or \"Q\" for leave\r\n"+
					"輸入ID或 Q (結束使用)？\r\n"+
					"Welcome 李威廷\r\n"+
					"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
					+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
					+ "5) E 離開選單 (Exit)\r\n"+
					"lab1 : 88.5\nlab2 : 77.0\nlab3 : 79.25\nmid-term : 85.0\nfinal exam : 90.75\ntotal : 86.28"+
					"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
					+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
					+ "5) E 離開選單 (Exit)\r\n"+
					"old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
					"recheck?:\r\nlab1 = 20.0%\nlab2 = 20.0%\nlab3 = 20.0%\nmid-term = 20.0%\nfinal exam = 20.0%\r\n"+
					"以上正確嗎? Y (Yes) 或 N (No)\r\n"+
					"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
					+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
					+ "5) E 離開選單 (Exit)\r\n"+
					"輸入ID或 Q (結束使用)？\r\n"+
					"結束了\r\n"
				, out.toString());
	}
	
	@Test
	public void test2() {
		ByteArrayInputStream in = new ByteArrayInputStream("962001051 W 20 20 20 20 20 Y E Q ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		h.main(null);
		assertEquals("輸入ID或 Q (結束使用)？\r\n"+
					"Welcome 李威廷\r\n"+
					"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
					+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
					+ "5) E 離開選單 (Exit)\r\n"+
					"old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
					"recheck?:\r\nlab1 = 20.0%\nlab2 = 20.0%\nlab3 = 20.0%\nmid-term = 20.0%\nfinal exam = 20.0%\r\n"+
					"以上正確嗎? Y (Yes) 或 N (No)\r\n"+
					"\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
					+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
					+ "5) E 離開選單 (Exit)\r\n"+
					"輸入ID或 Q (結束使用)？\r\n"+
					"結束了\r\n"
				, out.toString());
	}
	*/
}
