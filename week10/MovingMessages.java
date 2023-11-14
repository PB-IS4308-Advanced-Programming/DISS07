package week10;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MovingMessages {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Move Where?");
		
		frame.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_A) {
					label.setText("Start Moving Left");
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					label.setText("Start Moving Down");
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					label.setText("Start Moving Right");
				}
			}
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_A) {
					label.setText("Stop Moving Left");
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					label.setText("Stop Moving Down");
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					label.setText("Stop Moving Right");
				}
			}
		});
		
		frame.add(label);
		frame.pack();
		frame.setVisible(true);
	}
	
}
