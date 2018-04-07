package ha2;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * class GradeSystemTest
 * 
 * ����GradeSystemTest�o��test���Ҧ�public method
 * 
 * �]�A:
 * showGrade(String id)
 * showRank(String id)
 * showAverage(String id)
 * getnamebyID(String id)
 * checkID(String id)
 * changeWeight(String id)
 * 
 */
public class GradeSystemTest {
	GradeSystem g=null;
	Scanner sc=null;
	@Before
	public void setUp() throws Exception {
		//sc=new Scanner(System.in);
		g=new GradeSystem(sc);
	}

	@After
	public void tearDown() throws Exception {
		g=null;
		sc=null;
	}

	/*
	 * 962001051 ���§� 81 32 50 90 93 --> total=80.5-->81
	 */
	@Test
	public void showGradeTest1() {
		ByteArrayOutputStream str=new ByteArrayOutputStream();
		System.setOut (new PrintStream (str));
		g.showGrade("962001051");
		assertEquals("���§ʦ��Z:lab1:     81\r\n"+ 
				"      lab2:     32*\r\n"+ 
				"      lab3:     50*\r\n"+ 
				"      mid-term :  90\r\n"+ 
				"      final exam : 93\r\n"+ 
				"      total grade : 81\r\n" 
				, str.toString());
	}
	/*
	 * 985002016 ���E 97 96 89 85 80 --> total=85.7-->86
	 */
	@Test
	public void showGradeTest2() {
		ByteArrayOutputStream str=new ByteArrayOutputStream();
		System.setOut (new PrintStream (str));
		g.showGrade("985002016");
		assertEquals("���E���Z:lab1:     97\r\n"+ 
				"      lab2:     96\r\n"+ 
				"      lab3:     89\r\n"+ 
				"      mid-term :  85\r\n"+ 
				"      final exam : 80\r\n"+ 
				"      total grade : 86\r\n" 
				, str.toString());
	}
	
	/*
	 * 962001051 ���§� Rank=4
	 */
	@Test
	public void showRankTest1() {
		ByteArrayOutputStream str=new ByteArrayOutputStream();
		System.setOut (new PrintStream (str));
		g.showRank("962001051");
		assertEquals("���§ʱƦW:4\r\n", str.toString());
	}
	/*
	 * 985002016 ���E Rank=3
	 */
	@Test
	public void showRankTest2() {
		ByteArrayOutputStream str=new ByteArrayOutputStream();
		System.setOut (new PrintStream (str));
		g.showRank("985002016");
		assertEquals("���E�ƦW:3\r\n", str.toString());
	}
	/*
	 * ��ܥ��Z����
	 */
	@Test
	public void showAverageTest() {
		ByteArrayOutputStream str=new ByteArrayOutputStream();
		System.setOut (new PrintStream (str));
		g.showAverage();
		assertEquals("lab1 : 88.5\nlab2 : 77.0\nlab3 : 79.25\nmid-term : 85.0\nfinal exam : 90.75\ntotal : 86.28"
				, str.toString());
	}
	/*
	 * 962001051 ���§�
	 */
	@Test
	public void getnamebyIDTest1() {
		assertEquals("���§�", g.getnamebyID("962001051"));
	}
	/*
	 * 985002016 ���E
	 */
	@Test
	public void getnamebyIDTest2() {
		assertEquals("���E", g.getnamebyID("985002016"));
	}
	/*
	 * 962001051 ���§�
	 */
	@Test
	public void checkIDTest1() {
		assertEquals(true, g.checkID("985002016"));
	}
	/*
	 * 985002066 null
	 */
	@Test
	public void checkIDTest2() {
		assertEquals(false, g.checkID("985002066"));
	}
	/*
	 * ���weight�� 20 20 20 20 20
	 */
	@Test
	public void changeWeightTest1() {
		ByteArrayInputStream in = new ByteArrayInputStream("20 20 20 20 20 Y ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		g.changeWeight();
		assertEquals("old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
				"recheck?:\r\nlab1 = 20.0%\nlab2 = 20.0%\nlab3 = 20.0%\nmid-term = 20.0%\nfinal exam = 20.0%\r\n"+
				"�H�W���T��? Y (Yes) �� N (No)\r\n"
				, out.toString());
	}
	/*
	 * ���weight�� 20 20 20 30 10
	 * �Ϯ�
	 * ���weight�� 20 20 20 20 20
	 */
	@Test
	public void changeWeightTest2() {
		ByteArrayInputStream in = new ByteArrayInputStream("20 20 20 30 10 N 20 20 20 20 20 Y ".getBytes());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setIn(in);
		System.setOut(new PrintStream(out));
		g.changeWeight();
		assertEquals("old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
				"recheck?:\r\nlab1 = 20.0%\nlab2 = 20.0%\nlab3 = 20.0%\nmid-term = 30.0%\nfinal exam = 10.0%\r\n"+
				"�H�W���T��? Y (Yes) �� N (No)\r\n"+
				"old:\r\nlab1 = 10.0%\nlab2 = 10.0%\nlab3 = 10.0%\nmid-term = 30.0%\nfinal exam = 40.0%\r\n"+
				"recheck?:\r\nlab1 = 20.0%\nlab2 = 20.0%\nlab3 = 20.0%\nmid-term = 20.0%\nfinal exam = 20.0%\r\n"+
				"�H�W���T��? Y (Yes) �� N (No)\r\n"
				, out.toString());
	}
}
