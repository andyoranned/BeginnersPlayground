import java.util.Random;

class Game {
	private Player serverP1;
	private Player receiverP2;
	static Random rando;
	private Boolean isOver;
	private Score theScore;
	
	//constructor.......................................................................
	public Game (Player x, Player y) {
		rando = new Random();
		coinFlip(x, y);	//set the starting server & receiver
		this.isOver=false;
		this.theScore=new GameScore(this); //POLYMORPHISM --this is unnecessary, just illustrating principles of OOP 
	}
	
	//methods............................................................................
	//setters for fields
	public void setIsOver(boolean isOver) {
		this.isOver=isOver;
	}
	//getters for fields
	public Player getServer() {
		return this.serverP1;
	}
	public Player getReceiver() {
		return this.receiverP2;
	}

	//generate a random number 0-10 used to quantify how good of a serve 
	public int serve() {
		
		int serveQuality = rando.nextInt(11);
		
		return serveQuality;
	}
	
	//blocking a serve is successful if the random number, 0-10, is more than the serve quality
	public boolean isBlocked (int serveQuality) {
		
		int blockQuality = rando.nextInt(11);
		
		if (blockQuality>serveQuality)
			return true;
		else
			return false;
	}
	
	//Loop through serving and blocking until a block is unsuccessful. Continue until scoring point is achieved
	public Player playGame() {
		int serve= 0;
		
		int playCount=0;
		Player winner=null;
		while(!isOver) {				//continue the back and forth until someone wins
			serve=serve();				//here serve means hit it over the net. could just be a return serve or starting serve
			if (isBlocked(serve)) { 	//blocked point
				playCount++;
			}
			else if (playCount%2==0) {	//original server scores point
				((GameScore) theScore).p1ScoresPoint();
				if(isOver)
					winner=serverP1;
				playCount=0;			//original server, serves again next round
			}
			else {						//receiver scores point
				((GameScore) theScore).p2ScoresPoint();
				if(isOver)
					winner=receiverP2;
				playCount=1;			//original receiver starting serve next round	
			}//end if/else
		}//end while loop
		return winner;
	}//end playGame()
	
	//simulates a coin toss. 
	public void coinFlip(Player x, Player y) {
		int flip=rando.nextInt(1);
		int playXCallsIt=rando.nextInt(1);//First player calls head/tails(0/1)
		
		if (flip==playXCallsIt){ //if right, they're the server
			this.serverP1=x;
			this.receiverP2=y;
		}
		else
		{
			this.serverP1=y;
			this.receiverP2=x;
		}
	}//end coinFlip()
}//end game class___________________________________________________________________________________]
