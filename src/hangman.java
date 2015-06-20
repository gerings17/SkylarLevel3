import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.*;

public class hangman extends JFrame implements KeyListener {
	JFrame frame = new JFrame("Puzzle");
	Stack<String> words = new Stack();
	JLabel display = new JLabel("");
	int numLives = 9;
	JLabel livesLabel = new JLabel(""+ numLives);
	String puzzle = ("");
	ArrayList<JLabel> dashes = new ArrayList<>();
	JPanel panel = new JPanel();
	boolean solved = false;
	String currentAnswer;
	JLabel dash;
	
	public static void main(String[]args){
		hangman a = new hangman();
		a.addPuzzles();
		a.displayPuzzle();
		System.out.println("Enter in a letter that you want to try.");
		a.currentAnswer = a.getCurrentAnswer();
	}
	
	public void addPuzzles(){
		words.push("anonymous");
		words.push("pronunciation");
		words.push("catalyst");
	}
	
	public hangman(){
		super();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(200,200);
		frame.add(display);
		frame.addKeyListener(this);
		frame.add(panel);
		

		//makeWinningPopUp();
		
		//frame.FlowLayout();
		
	}
	public void displayPuzzle(){
		puzzle = words.peek();
		for(int x =0; x <puzzle.length();x++){
			dash = new JLabel("_");
			dashes.add(dash);
			panel.add(dash);
		}
		panel.add(livesLabel);
		livesLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
	}
	private boolean updateSpacesWithUserInput(char keyChar) {
		boolean didFind = false;
		for (int i = 0; i < puzzle.length(); i++) {
			if (puzzle.charAt(i) == keyChar) {
				dashes.get(i).setText("" + keyChar);
				System.out.println("Yay!");
				didFind = true;
			}
		}
		return didFind;
		
	}
	
	public String getCurrentAnswer() {
		StringBuffer answer = new StringBuffer();
		for (JLabel textBox : dashes) {
			answer.append(textBox.getText());
		}
		return answer.toString();
	}
	public void makeWinningPopUp(){
		dashes.clear();
		panel.removeAll();
		puzzle = words.pop();
		displayPuzzle();
		numLives = 9;
		livesLabel.setText("" + numLives);
		JOptionPane.showMessageDialog(null, "Good Job!", "Win",
		        JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void loadNextPuzzle(){
			JOptionPane.showMessageDialog(null, "You lose, try the next puzzle!", "Lose",
            JOptionPane.INFORMATION_MESSAGE);
			dashes.clear();
			panel.removeAll();
			puzzle = words.pop();
			displayPuzzle();
			numLives = 9;
			livesLabel.setText("" + numLives);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		char pressedKey = (char) e.getKeyChar();
		boolean didUpdate = updateSpacesWithUserInput(pressedKey);
			if(didUpdate==false){
				numLives--;
				livesLabel.setText(""+ numLives);
			}

		if(getCurrentAnswer().equals(puzzle)){			
			makeWinningPopUp();
			
		}
		if(numLives == 0){
			loadNextPuzzle();
		}
		
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
}
