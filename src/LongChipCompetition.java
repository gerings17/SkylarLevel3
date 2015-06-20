
import java.util.ArrayList;
import java.util.Random;

public class LongChipCompetition {

	
	public static void main(String[] args){
		
		new LongChipCompetition().start();
		
		
			
	}
	public void start(){
		String finalName= "";
		double finalMax = 0;
		double max;
		initializeBeatles();
		for(Beatle a : theBeatles){
			max = findMax(a.getChips());
			if(max>finalMax){
				finalName = a.getName();
				finalMax = max;
			}
		}
		System.out.println(finalName);
	}
	public double findMax(ArrayList<Chip> chips){
		double max = 0;
		Chip bigChip;
		for(Chip b: chips){
			if(b.getLength()> max){
				max = b.getLength();
				bigChip = b;
			}
		}
		return max;
		
	}
	

	/**
	 * The Beatles are eating lunch and playing a game to see who has the longest chip. (In England, french fries are called "chips".)
	 * 
	 * Find the Beatle with the longest chip. You may not edit the Chip or Beatle classes. Make sure to initialize The Beatles before you start your
	 * search.
	 * 
	 * **/

	private ArrayList<Beatle> theBeatles = new ArrayList<Beatle>();

	private void initializeBeatles() {
		Beatle george = new Beatle("George");
		Beatle john = new Beatle("John");
		Beatle paul = new Beatle("Paul");
		Beatle ringo = new Beatle("Ringo");

		theBeatles.add(george);
		theBeatles.add(john);
		theBeatles.add(paul);
		theBeatles.add(ringo);
	}
}

class Beatle {
	private String name;
	private ArrayList<Chip> chips = new ArrayList<Chip>();

	public Beatle(String name) {
		this.name = name;
		initializePlateOfChips();
	}

	private void initializePlateOfChips() {
		int numberOfChips = new Random().nextInt(100);
		for (int i = 0; i < numberOfChips; i++) {
			chips.add(new Chip(new Random().nextDouble() * 10));
			if (this.name.contains("in")) chips.add(new Chip(10));
		}
	}

	public ArrayList<Chip> getChips() {
		return this.chips;
	}

	public String getName() {
		return this.name;
	}

}

class Chip {
	private double length;

	public double getLength() {
		return length;
	}

	Chip(double d) {
		this.length = d;
	}
}

