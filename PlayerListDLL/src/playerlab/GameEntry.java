package playerlab;

// modified implementation from Java book
public class GameEntry {

	private String name;
	private int score; 
	
	public GameEntry(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int newScore) {
		score = newScore; 
	}
	
	public int equals(GameEntry sec) {
		if(this.getName().equals(sec.getName()) && this.getScore() 
			== sec.getScore()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public String toString() {
		return "Name: " + name + "    Score: " + score;
	}
}
