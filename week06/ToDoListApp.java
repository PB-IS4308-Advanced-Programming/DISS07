package week06;

import javax.swing.JFrame;

public class ToDoListApp {

	public static JFrame primaryWindow;
	
	public static void main(String[] args) throws Exception {
		DatabaseHandler.initialise();
		primaryWindow = new JFrame("ToDo List App");
		primaryWindow.getContentPane().add(new LoginPage());
		primaryWindow.setSize(800, 600);
		primaryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		primaryWindow.setVisible(true);
	}
	
}
