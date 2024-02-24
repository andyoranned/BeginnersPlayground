import java.util.Scanner;

class Score {
	private int p1Point;
	private int p2Point;
	protected Game round;
	
	//constructor.......................................................................
	public Score(Game round) {
		this.p1Point=0;
		this.p2Point=0;
		this.round=round;
	}
	
	//methods............................................................................
	//getters for fields
	public int getP1Point() {
		return p1Point;
		}
	
	public int getP2Point() {
		return p2Point;
		}
	
	//setters for fields
	public void setP1Point(int p1Point) {
		this.p1Point=p1Point;
	}
	
	public void setP2Point(int p2Point) {
		this.p2Point=p2Point;
	}
}//end Score class________________________________________________________________________________]

/* Keeps track of the score of one game. If we had to keep track of match scores as well, there
 * would be a MatchScore class that extends Score. 
 */
class GameScore extends Score {
	
	//constructor........................................................................
	public GameScore(Game round) {
		super(round);
	}
	
	//methods............................................................................	
	//if the original server scores a point, calculate new score based on tennis scoring rules
	public void p1ScoresPoint() {
		Player serverP1 = round.getServer(); 	//original server
		String p1Name = serverP1.getName();
		Player p2P = round.getReceiver();
		String p2Name = p2P.getName();
		String str;
		Scanner kbd=new Scanner(System.in);
		
		int p1= getP1Point();
		int p2= getP2Point();
		
		if (p1 <=15 ){
			p1+=15;
			setP1Point(p1);
			System.out.printf("%s scores.\n%s's score: %d %s's score: %d\n %s serves next\n",p1Name,p1Name, p1, p2Name, p2, p1Name);
			System.out.println("Press [ENTER] to continue...");
			str=kbd.nextLine();
			return;
		}
		else if (p1==30 && p2!=40) {
			p1+=10;
			setP1Point(p1);
			System.out.printf("%s scores.\n%s's score: %d %s's score: %d\n %s serves next\n",p1Name,p1Name, p1, p2Name, p2, p1Name);
			System.out.println("Press [ENTER] to continue...");
			str=kbd.nextLine();
			return;
		}	
		else if (p1==30 && p2 ==40) {
			p1+=10;
			setP1Point(p1);
			System.out.printf("%s scores: DEUCE\n%s serves next\n",p1Name, p1Name);
			System.out.println("Press [ENTER] to continue...");
			str=kbd.nextLine();
			return;
		}
		else if (p1 >=40 && p1==p2) {
			p1+=10;
			setP1Point(p1);
			System.out.printf("%s scores: ADVANTAGE\n%s serves next\n",p1Name,p1Name);
			return;
		}
		else if (p1 >= 40 && p1>p2) {
			System.out.printf("%s scores: GAME\n%s wins the game\n",p1Name, p1Name);
			System.out.println("Press [ENTER] to continue...");
			str=kbd.nextLine();
			round.setIsOver(true);
			return;
		}
		else if (p1>=40 && p1<p2) {
			p1+=10;
			setP1Point(p1);
			System.out.printf("%s scores: DEUCE\n%s serves next\n",p1Name, p1Name);
			System.out.println("Press [ENTER] to continue...");
			str=kbd.nextLine();
			return;
		}	
	}//end p1ScoresPoint() method

	//if the original receiver scores a point, calculate new score based on tennis scoring rules
	public void p2ScoresPoint() {
		Player receiverP2 = round.getReceiver();
		String p2Name = receiverP2.getName();
		Player p1P = round.getReceiver();
		String p1Name = p1P.getName();
		String str;
		Scanner kbd=new Scanner(System.in);
		
		int p1= getP1Point();
		int p2= getP2Point();
		
		if (p2 <=15 ){
			p2+=15;
			setP2Point(p2);
			System.out.printf("%s scores.\n%s's score: %d %s's score: %d\n %s serves next\n",p2Name,p1Name, p1, p2Name,p2, p2Name);
			System.out.println("Press [ENTER] to continue...");
			str=kbd.nextLine();
			return;
		}
		else if (p2==30 && p1!=40) {
			p2+=10;
			setP2Point(p2);
			System.out.printf("%s scores.\n%s's score: %d %s's score: %d\n %s serves next\n",p2Name,p1Name, p1, p2Name,p2, p2Name);
			System.out.println("Press [ENTER] to continue...");
			str=kbd.nextLine();
			return;
		}
		else if (p2==30 && p1 ==40) {
			p2+=10;
			setP2Point(p2);
			System.out.printf("%s scores: DEUCE\n%s serves next\n",p2Name,p2Name);
			System.out.println("Press [ENTER] to continue...");
			str=kbd.nextLine();
			return;
		}
		else if (p2 >=40 && p1==p2) {
			p2+=10;
			setP2Point(p2);
			System.out.printf("%s scores: ADVANTAGE\n%s serves next\n",p2Name, p2Name);
			System.out.println("Press [ENTER] to continue...");
			str=kbd.nextLine();
			return;
		}
		else if (p2 >= 40 && p2>p1) {
			System.out.printf("%s scores: GAME\n%s wins the game\n",p2Name, p2Name);
			System.out.println("Press [ENTER] to continue...");
			str=kbd.nextLine();
			round.setIsOver(true);
			return;
		}
		else if (p2>=40 && p2<p1) {
			p2+=10;
			setP2Point(p2);
			System.out.printf("%s scores: DEUCE\n%s serves next\n",p2Name, p2Name);
			System.out.println("Press [ENTER] to continue...");
			str=kbd.nextLine();
			return;
		}	
	}//end p2ScoresPoint() method
}//end GameScore class____________________________________________________________________________]

