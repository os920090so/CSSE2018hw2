package ha2;

import java.util.Scanner;

/*
 * class UserInterface
 * 
 * UserInterface() //constructor
 * waitForStart()
 * sayHello(String id)
 * waitForCmd()
 */
public class UserInterface {
	private String nowuser;
	private GradeSystem gsys;

	private Scanner reader;

	String tmp;
	/*constructor UserInterface
	 * 
	 * Pseudo code
	 * 1.new GradeSystem()
	 */
	public UserInterface(){
		reader = new Scanner(System.in);
		gsys=new GradeSystem(reader);
	}
	/*method  waitForStart
	 * main 會呼叫這個並去接收知道現在user或是要離開
	 * 
	 * @return 一個布林值 若true則代表user合法並繼續   若 false 則代表離開
	 * 
	 * Pseudo code
	 * 1.use loop get input
	 * 2.if input=='Q' return 
	 * 3. else if input== legal user ID , set nowuser=ID and call UserInterface::sayHello()
	 * 4.check legal by call GradeSystem::checkID(String id)
	 * 5.else puts(wrong id) get input again
	 * 
	 * time complexity:O(nlgn)
	 */
	public void waitForStart() {
		reader = new Scanner(System.in);
		while(true) {
			System.out.println("輸入ID或 Q (結束使用)？");
			tmp=reader.next();
			if(tmp.equals("Q")) {
				System.out.println("結束了");
				return;
			}
			else if(gsys.checkID(tmp)) {
				nowuser=tmp;
				sayHello();
			}
			else {
				System.out.println("Wrong input!! Please try again or \"Q\" for leave");
			}
		}
	}
	/*method sayHello
	 * 
	 * Pseudo code
	 * 1.puts(Welcome "nowuser")
	 * 2.call UserInterface::waitForCmd()
	 * 
	 */
	private void sayHello() {	
		System.out.println("Welcome "+gsys.getnamebyID(nowuser));
		waitForCmd();
	}
	/*method waitForCmd
	 * 
	 * Pseudo code
	 * 1.puts(輸入指令.....)
	 * 2.switch input 
	 * 3.case G call GradeSystem::showGrade(nowuser)
	 * 4.case R call GradeSystem::showRank(nowuser)
	 * 5.case A call GradeSystem::showAverage()
	 * 6.case W call GradeSystem::changeWeight()
	 * 7.case E return 
	 * 8.default puts(wrong command) loop to get input again
	 */
	private void waitForCmd() {
		while(true){
			System.out.println("\n輸入指令 \n1) G 顯示成績 (Grade)\n2) R 顯示排名 (Rank)"
					+ "\n3) A 顯示平均 (Average)\n4) W 更新配分 (Weight)\n"
					+ "5) E 離開選單 (Exit)");
			tmp=reader.next();		
			switch(tmp) {
			case "G":gsys.showGrade(nowuser);break;
			case "R":gsys.showRank(nowuser);break;
			case "A":gsys.showAverage();break;
			case "W":gsys.changeWeight();break;
			case "E":/*reader= new Scanner(System.in)*/;return;
			default:System.out.println("Wrong input!! Please try again or \"E\" for leave");break;
			}
		}
	}
}
