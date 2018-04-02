package ha2;

import java.io.IOException;

public class Grades {
	public String ID;
	public String name;
	public int[] grades;
	public int rank;
	/*
	 * constructor Grades
	 * grade[0] = lab1
	 * grade[1] = lab2
	 * grade[2] = lab3
	 * grade[3] = mid-term
	 * grade[4] = final exam
	 */
	public Grades() {
		ID=null;
		name=null;
		grades=new int[5];
		for(int i=0;i<5;i++) grades[i]=-1;
		rank=-1;
	}

	
	public Grades(String id,String n) throws IOException {
		ID=id;
		name=n;
		grades=new int[5];
		for(int i=0;i<5;i++) grades[i]=-1;
		rank=-1;
	}
}
