import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

class Tournament {
	private ArrayList<Player> participants; //all the players in tournament
	
	//constructor...............................................................
	public Tournament() {
		participants=new ArrayList<Player>();
		setBeginParticipants();
	}
	
	//methods...................................................................

	//Build initial roster of players. only for use inside constructor
	private void setBeginParticipants() {
		Scanner kbd = new Scanner(System.in);
		
		//gather the names of all players and add to the roster
		for(int i=0; i<8; i++) {
			System.out.printf("Input player %d's name: ", (i+1));
			String name= kbd.nextLine();
			Player temp= new Player(name);
			participants.add(temp);
		}
	}//end setBeginParticipants()
	
	public void holdTennisTournament() {
		Player[] results= new Player[2];
		
		while(!participants.isEmpty()) {
			ArrayList<Player> winners = new ArrayList<Player>();
			Player[][] teams = dividePlayersRandomly();
			
			//play a new game for each group of players, record the winner of each
			for (int i=0; i<teams.length;i++) {
				Game match=new Game(teams[i][0], teams[i][1]);
				Player matchWinner = match.playGame();
				winners.add(matchWinner);
			}
			
			if (participants.size()!=2) {		//not at the end, save the participants that made it to next round
				participants.clear();
				for(Player winner : winners) {
					participants.add(winner);
				}
			}
			else {								//at end. Get winners in correct order 1st/2nd
				results[0] = winners.remove(0);
				for (Player participant : participants) {
					if (!participant.getName().equals(results[0].getName())) {
						results[1]=participant;
					}
				}
				participants.clear();
			}
		}//end while loop
		
		printResults(results);
	}//end holdTennisTounament
	
	private void printResults(Player[] results) {
		System.out.printf("%-13s %s \n%-13s %s\n","First place:", results[0].getName(),"Second Place:", results[1].getName());
	}//end printResults()
	
	public Player[][] dividePlayersRandomly(){
		int groupNum=participants.size() / 2;
		Player[][] groups= new Player[groupNum][2];
		ArrayList<Player> pList = new ArrayList<Player>();
		Random rando = new Random();
		
		//copy participant roster
		for (Player person : participants) {
			pList.add(person);
		}
		
		//assign players to groups randomly
		for (int i=0; i<groupNum; i++) {
			int randomPick = rando.nextInt(pList.size());
			groups[i][0] =pList.remove(randomPick);
			randomPick = rando.nextInt(pList.size());
			groups[i][1]=pList.remove(randomPick);
		}
		return groups;
	}//end dividePlayersRandomly()
}//end tournament___________________________________________________________________________________]
