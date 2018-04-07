package ha2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
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
	private double[] weight;
	private double[] avg;
	private Mycompare c;
	private HashMap<String,Grades> map;
	private ArrayList<String> rankArray;
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
	 * 6.將 rank array sort一遍, 也將Grades.rank update
	 * 6.set weight_update = false
	 */
	public GradeSystem(Scanner sc) {
		map=new HashMap<String, Grades>();
		rankArray = new ArrayList<String>();
		scanner=sc;
		avg=new double[6];
		weight=new double[] {0.1,0.1,0.1,0.3,0.4};
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
	}
	private void setMap() throws IOException {
		int total=0;
		FileReader fr = new FileReader("src/testcase");
		//FileReader fr = new FileReader("src/imput");
		BufferedReader br = new BufferedReader(fr);
		while (br.ready()) {
			String[] str=br.readLine().split(" ");
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
	 * @param id 用來查詢成績的id
	 * 
	 *  Pseudo code
	 *  1.用map讀id 取得所要的Grades class
	 *  2.把選到的Grades 依據weight 計算完再輸出成績
	 *  
	 *  time complexity:O(1)
	 */
	public void showGrade(String id){
		Grades user = map.get(id);
		if(user.grades[0]>59)System.out.println(user.name+"成績:lab1:     "+user.grades[0]);
		else System.out.println(user.name+"成績:lab1:     "+user.grades[0]+"*");
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
		BigDecimal bd= new BigDecimal(total);   
		bd=bd.setScale(0, BigDecimal.ROUND_HALF_UP);
		if(total>59)System.out.println("      total grade : "+bd);
		else System.out.println("      total grade : "+bd+"*");
	}
	/*method showRank
	 * 
	 * @param id 用來查詢排名的id
	 * 
	 * Pseudo code
	 * 1.先判斷weight_update
	 * 2.false  : 取map中對應Grades 輸出rank
	 * 3.true   : 先藉由Collection.sort將rank array排序好
	 * 4.        將array依序對map內每個人的rank做更新
	 * 6.        遇到與ID相同則輸出排名
	 * 7.        set weight_update=false
	 * 
	 * time complexity:O(nlgn)
	 */
	public void showRank(String id){
		if(weight_update) {
			sortmap();
		}
		Grades tmp=map.get(id);
		System.out.println(tmp.name+"排名:"+tmp.rank);
	}
	private void sortmap() {
		Collections.sort(rankArray,c);
		for(int i=0;i<rankArray.size();i++) {
			map.get(rankArray.get(i)).rank=i+1;
		}
	}
	/*method showAverage
	 * 
	 * @param id 用來查詢排名的id
	 * 
	 * Pseudo code
	 * 1.use weight*average score to calculate again
	 * 2.print it
	 * 
	 * time complexity:O(1)
	 */
	public void showAverage(){
		double t=0;
		for(int i=0;i<5;i++)
			t+=avg[i]*weight[i];
		BigDecimal bd= new BigDecimal(t);   
		bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.print("lab1 : "+avg[0]+"\nlab2 : "+avg[1]+"\nlab3 : "
				+avg[2]+"\nmid-term : "+avg[3]+"\nfinal exam : "+avg[4]
				+"\ntotal : "+bd);
	}
	/*method changeWeight
	 * 
	 * @param id 用來查詢排名的id
	 * 
	 * Pseudo code
	 * 1.show old weight and wait for user new weight input
	 * 2.show user weight input and ask user to recheck  , if wrong back to 1 
	 * 3.check if new weight = old weight
	 * 4.     false : weight_update = true
	 * 5.     true  : (nothing)
	 * 
	 * time complexity:O(1)
	 */
	public void changeWeight(){
		String tmp;
		Boolean keep=true;
		double t[]=new double[5];
		//Scanner s=new Scanner(System.in);
		
		if(scanner==null) {
			scanner=new Scanner(System.in);	
		}
			
		while(keep) {
			System.out.println("old:");
			printWeight(weight);
			for(int i=0;i<5;i++) {
				String s=scanner.next();
				t[i]=Integer.valueOf(s)*0.01;
			}
			System.out.println("recheck?:");
			printWeight(t);
			while(true) {
				System.out.println("以上正確嗎? Y (Yes) 或 N (No)");
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
		updateweight(t);
		
	}
	private void updateweight(double []t) {
		Boolean same=true;
		for(int i=0;i<5;i++) {
			if(same&&t[i]!=weight[i])
				same = false;
			weight[i]=t[i];
		}
		weight_update=(same)?false:true;
	}
	private void printWeight(double[] w) {
		System.out.println("lab1 = "+w[0]*100+"%\nlab2 = "
	+w[1]*100+"%\nlab3 = "+w[2]*100+"%\nmid-term = "+w[3]*100
	+"%\nfinal exam = "+w[4]*100+"%");
	}
	/*method checkID
	 * 
	 * @param id the id used to check it's existence 
	 * @return Boolean the id exist in map or not
	 * 
	 * Pseudo code
	 * 1.if map.get(id)!=null return true, else false
	 * 
	 * time complexity:O(1)
	 */
	public Boolean checkID(String id) {
		if(map.get(id) != null)
			return true;
		else
			return false;
	}
	/*method getnamebyID
	 * 
	 * @param id the id used to get name
	 * @return the name of id
	 * 
	 * Pseudo code
	 * 1.return map.get(id).name
	 * 
	 * time complexity:O(1)
	 */
	public String getnamebyID(String id) {
		return map.get(id).name;
	}
	/*
	 * use id to get Grades by map
	 * and compare them use weight[5] * Grades.score[5]
	 * 
	 * time complexity:O(1)
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
				return -1;
			else if(ta.equals(tb))
				return 0;
			else
				return 0;
		}
		
	}
}
