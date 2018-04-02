package ha2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/*
 * class GradeSystem
 * 
 * GradeSystem() //constructor
 * showGrade(String id)
 * showRank(String id)
 * showAverage(String id)
 * changeWeight(String id)
 * checkID(String id)
 */
public class GradeSystem {
	private double[] weight={0.1,0.1,0.1,0.3,0.4};
	private double[] avg=new double[6];
	private Mycompare c;
	private HashMap<String,Grades> map=new HashMap<String, Grades>();
	private ArrayList<String> rankArray = new ArrayList<String>();
	private Boolean weight_update;
	Scanner scanner;
	DecimalFormat df;
	/*
	 * constructor GradeSystem
	 * 
	 * Pseudo code
	 * 1.read data from file
	 * 2.initialize map
	 * 3.initialize rank array
	 * 4.new Mycompare
	 * 5.calculate average for all and keep it 
	 * 6.�N rank array sort�@�M, �]�NGrades.rank update
	 * 6.set weight_update = false
	 */
	public GradeSystem(Scanner sc) {
		scanner=sc;
		df = new DecimalFormat("##.00");
		try {
			setMap();
		} catch (IOException e) {
			System.out.println("read file wrong");
			e.printStackTrace();
		}
		c=new Mycompare();
		sortmap();
		weight_update=false;
		//selftest();
	}
//	private void selftest() {
//		for(Entry<String, Grades> a:map.entrySet()) {
//			Grades tmp=a.getValue();
//			//System.out.println(a.getKey()+" : "+tmp.name+" "+tmp.grades[0]+" "+tmp.rank+"\n");
//		}
//	}
	private void setMap() throws IOException {
		map=new HashMap<>();
		int total=0;
		//FileReader fr = new FileReader("src/gradeinput");
		FileReader fr = new FileReader("test/input.txt");
		BufferedReader br = new BufferedReader(fr);
		while (br.ready()) {
			System.out.println(total);
			String[] str=br.readLine().split(" ");
			//System.out.println(str[0]+"  "+str[1]+"  \n");
			Grades g=new Grades(str[0],str[1]);
			for(int i=0;i<5;i++) {
				g.grades[i]=Integer.valueOf(str[i+2]);
				avg[i]+=g.grades[i];
			}
			map.put(str[0],g);
			rankArray.add(str[0]);
			total++;
		}
		//calculate avg
		for(int i=0;i<5;i++)
			avg[i]=Double.parseDouble(df.format(avg[i]/total));
		fr.close();
	}
	/*
	 * method showGrade
	 * 
	 * @param id �ΨӬd�ߦ��Z��id
	 * 
	 *  Pseudo code
	 *  1.��mapŪid ���o�ҭn��Grades class
	 *  2.���쪺Grades �̾�weight �p�⧹�A��X���Z
	 */
	public void showGrade(String id){
		Grades user = map.get(id);
		if(user.grades[0]>59)System.out.println(user.name+"���Z:lab1:     "+user.grades[0]);
		else System.out.println(user.name+"���Z:lab1:     "+user.grades[0]+"*");
		if(user.grades[1]>59)System.out.println("      lab2:     "+user.grades[1]);
		else System.out.println("      lab2:     "+user.grades[1]+"*");
		if(user.grades[2]>59)System.out.println("      lab3:     "+user.grades[2]);
		else System.out.println("      lab3:     "+user.grades[2]+"*");
		if(user.grades[3]>59)System.out.println("      mid-term :  "+user.grades[3]);
		else System.out.println("      mid-term :  "+user.grades[3]+"*");
		if(user.grades[4]>59)System.out.println("      final exam : "+user.grades[4]);
		else System.out.println("      final exam : "+user.grades[4]+"*");
		double total=0;
		for(int i=0;i<5;i++)
			total+=user.grades[i]*weight[i];
		total=Double.parseDouble(df.format(total));
//		user.countEachTotal(weight);
		if(total>59)System.out.println("      total grade : "+total);
		else System.out.println("      total grade : "+total+"*");
	}
	/*method showRank
	 * 
	 * @param id �ΨӬd�߱ƦW��id
	 * 
	 * Pseudo code
	 * 1.���P�_weight_update
	 * 2.false  : ��map������Grades ��Xrank
	 * 3.true   : ���ǥ�Collection.sort�Nrank array�ƧǦn
	 * 4.        �Narray�̧ǹ�map���C�ӤH��rank����s
	 * 6.        �J��PID�ۦP�h��X�ƦW
	 * 7.        set weight_update=false
	 */
	public void showRank(String id){
		if(weight_update) {
			sortmap();
		}
		Grades tmp=map.get(id);
		System.out.println(tmp.name+"�ƦW:"+tmp.rank);
	}
	private void sortmap() {
		Collections.sort(rankArray,c);
		for(int i=0;i<rankArray.size();i++) {
			map.get(rankArray.get(i)).rank=i+1;
		}
	}
	/*method showAverage
	 * 
	 * @param id �ΨӬd�߱ƦW��id
	 * 
	 * Pseudo code
	 * 1.use weight*average score to calculate again
	 * 2.print it
	 */
	public void showAverage(){
		double t=0;
		for(int i=0;i<5;i++)
			t+=avg[i]*weight[i];
		System.out.print("lab1 : "+avg[0]+"\nlab2 : "+avg[1]+"\nlab3 : "
				+avg[2]+"\nmid-term : "+avg[3]+"\nfinal exam : "+avg[4]
				+"\ntotal : "+Double.parseDouble(df.format(t)));
	}
	/*method changeWeight
	 * 
	 * @param id �ΨӬd�߱ƦW��id
	 * 
	 * Pseudo code
	 * 1.show old weight and wait for user new weight input
	 * 2.show user weight input and ask user to recheck  , if wrong back to 1 
	 * 3.check if new weight = old weight
	 * 4.     false : weight_update = true
	 * 5.     true  : (nothing)
	 * 
	 */
	public void changeWeight(){
		String tmp;
		Boolean keep=true;
		while(keep) {
			System.out.println("old:\n");
			printWeight();
			for(int i=0;i<5;i++) {
				weight[i]=scanner.nextInt()*0.01;
			}
			System.out.println("recheck?:\n");
			printWeight();
			while(true) {
				System.out.println("�H�W���T��? Y (Yes) �� N (No)\n");
				tmp=scanner.next();
				if(tmp.equals("Y")) {
					keep=false;
					break;
				}
				else if(tmp.equals("N")) {
					keep=true;
					break;
				}
			}
		}
		weight_update=true;
		
	}
	private void printWeight() {
		System.out.println("lab1 = "+weight[0]*100+"%\nlab2 = "
	+weight[1]*100+"%\nlab3 = "+weight[2]*100+"%\nmid-term = "+weight[3]*100
	+"%\nfinal exam = "+weight[4]*100+"%\n");
	}
	/*method checkID
	 * 
	 * @param id the id used to check it's existence 
	 * @return Boolean the id exist in map or not
	 * 
	 * Pseudo code
	 * 1.if map.get(id)!=null return true, else false
	 * 
	 */
	public Boolean checkID(String id) {
		if(map.get(id) != null)
			return true;
		else
			return false;
	}
	public String getnamebyID(String id) {
		return map.get(id).name;
	}
	/*
	 * use id to get Grades by map
	 * and compare them use weight[5] * Grades.score[5]
	 */
	public class Mycompare implements Comparator<String>{
		
		@Override
		public int compare(String a, String b) {
			// TODO Auto-generated method stub
			Double ta=0.0,tb=0.0;
			Grades ga=map.get(a);
			Grades gb=map.get(b);
			for(int i=0;i<5;i++) {
				ta+=ga.grades[i]*weight[i];
				tb+=gb.grades[i]*weight[i];
			}
			if(ta>tb)
				return 1;
			else if(ta.equals(tb))
				return 0;
			else
				return -1;
		}
		
	}
}
