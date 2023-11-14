package week10;

import javax.swing.JFrame;

public class MainApp {

	public static JFrame primaryFrame;
	
	public static void main(String[] args) {
		primaryFrame = new JFrame();
		
		AdditionQuiz quiz = new AdditionQuiz();
		primaryFrame.getContentPane().add(quiz);
		
		primaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		primaryFrame.pack();
		primaryFrame.setVisible(true);
	}
	
}
