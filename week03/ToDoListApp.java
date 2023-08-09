package week03;

import javax.swing.JFrame;

public class ToDoListApp {

	public static JFrame primaryWindow;
	
	public static void main(String[] args) {
		primaryWindow = new JFrame("ToDo List App");
		primaryWindow.getContentPane().add(new LoginPage());
		primaryWindow.setSize(800, 600);
		primaryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		primaryWindow.setVisible(true);
	}
	
}
