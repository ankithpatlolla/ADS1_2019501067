/**
 * main class solution.
 * @author Ankith.
 */
class Solution{
	/**
	 * swap method to swap elememts in an array.
	 * 
	 * @param arr array which elements to be swapped.
	 * @param i index.
	 * @param j index.
	 */
	public void swap (Team[] arr, int i, int j) {
		Team temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	/**
	 * sort method to sort the given array based on the wins, losses, draws.
	 * I used selection sort to sort the teams array.
	 * @param teams Team array that is to be sorted.
	 * @return sorted team arrayy.
	 */
	public Team[] sort(Team[] teams){
		// your code goes here
		for (int i = 0; i < teams.length; i++) {
			int max = i;
			for (int j = i+1; j < teams.length; j++) {
				if (teams[j].compareTo(teams[max]) == 1) {
					max = j;
				}
			}
			// Team temp = teams[max];
			// teams[max] = teams[i];
			// teams[i] = temp;
			swap (teams, max, i);
		}
		return teams;
	}
}
/**
 * class Team to create a team object.
 * 
 */
class Team implements Comparable<Team> {
	String teamName;
	int noOfWins;
	int noOfLosses;
	int noOfDraws;
	/**
	 * constructoe for team object.
	 * @param name name of the team.
	 * @param wins no of wins by the team
	 * @param losses no of losses by the team.
	 * @param draws no of draws by the team
	 */
	Team(String name, int wins, int losses, int draws){
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}
	/**
	 * toString method to display the output.
	 */
	public String toString(){
		//retrun all the attributes as a string but appending with ", "
        return this.teamName + ", " + this.noOfWins + ", " + this.noOfLosses + ", " + this.noOfDraws;
	}
	/**
	 * compareTo method which is implemented from comparable class.
	 * use to compare the objects based on wins losses draws.
	 * @param that the object which is to compare with another object.
	 */
	public int compareTo (Team that) {
		if (this.noOfWins > that.noOfWins) {
			return 1;
		}
		else if (this.noOfWins < that.noOfWins) {
			return -1;
		}
		else {
			if (this.noOfLosses > that.noOfLosses) return -1;
			else if (this.noOfLosses < that.noOfLosses) return 1;
			else {
				if (this.noOfDraws > that.noOfDraws) return 1;
				else if (this.noOfDraws < that.noOfDraws) return -1;
				else return 0;
			}
		}
	}
}