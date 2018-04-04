package ha2;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeSystemTest {
	GradeSystem g=null;
	Scanner sc=null;
	@Before
	public void setUp() throws Exception {
		sc=new Scanner(System.in);
		g=new GradeSystem(sc);
	}

	@After
	public void tearDown() throws Exception {
		g=null;
		sc=null;
	}

	/*
	 * 962001051 §õ«Â§Ê 81 32 50 90 93 --> total=80.5-->81
	 */
	@Test
	public void showGradeTest1() {
		ByteArrayOutputStream str=new ByteArrayOutputStream();
		System.setOut (new PrintStream (str));
		g.showGrade("962001051");
		assertEquals("§õ«Â§Ê¦¨ÁZ:lab1:     81\r\n"+ 
				"      lab2:     32*\r\n"+ 
				"      lab3:     50*\r\n"+ 
				"      mid-term :  90\r\n"+ 
				"      final exam : 93\r\n"+ 
				"      total grade : 81\r\n" 
				, str.toString());
	}
	/*
	 * 985002016 ¤ý²E 97 96 89 85 80 --> total=85.7-->86
	 */
	@Test
	public void showGradeTest2() {
		ByteArrayOutputStream str=new ByteArrayOutputStream();
		System.setOut (new PrintStream (str));
		g.showGrade("985002016");
		assertEquals("¤ý²E¦¨ÁZ:lab1:     97\r\n"+ 
				"      lab2:     96\r\n"+ 
				"      lab3:     89\r\n"+ 
				"      mid-term :  85\r\n"+ 
				"      final exam : 80\r\n"+ 
				"      total grade : 86\r\n" 
				, str.toString());
	}
	
	/*
	 * 962001051 §õ«Â§Ê Rank=4
	 */
	@Test
	public void showRankTest1() {
		ByteArrayOutputStream str=new ByteArrayOutputStream();
		System.setOut (new PrintStream (str));
		g.showRank("962001051");
		assertEquals("§õ«Â§Ê±Æ¦W:4\r\n", str.toString());
	}
	/*
	 * 985002016 ¤ý²E Rank=3
	 */
	@Test
	public void showRankTest2() {
		ByteArrayOutputStream str=new ByteArrayOutputStream();
		System.setOut (new PrintStream (str));
		g.showRank("985002016");
		assertEquals("¤ý²E±Æ¦W:3\r\n", str.toString());
	}
	/*
	 * 
	 */
	@Test
	public void showAverageTest() {
		ByteArrayOutputStream str=new ByteArrayOutputStream();
		System.setOut (new PrintStream (str));
		g.showAverage();
		assertEquals("lab1 : 89.0\nlab2 : 77.0\nlab3 : 79.0\nmid-term : 85.0\nfinal exam : 90.75\ntotal : 86.0"
				, str.toString());
	}
	/*
	 * 962001051 §õ«Â§Ê
	 */
	@Test
	public void getnamebyIDTest1() {
		assertEquals("§õ«Â§Ê", g.getnamebyID("962001051"));
	}
	/*
	 * 985002016 ¤ý²E
	 */
	@Test
	public void getnamebyIDTest2() {
		assertEquals("¤ý²E", g.getnamebyID("985002016"));
	}
	/*
	 * 962001051 §õ«Â§Ê
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
	 * 
	 */
	@Test
	public void changeWeightTest1() {
		//
	}
	/*
	 * 
	 */
	@Test
	public void changeWeightTest2() {
		//
	}
}
