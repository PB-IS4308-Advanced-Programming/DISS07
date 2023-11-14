package week10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YouSolvedIt extends JPanel {

	JButton yesButton = new JButton("Yes"),
			noButton = new JButton("No");
	
	public YouSolvedIt() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel("YOU DID IT! Try Again?"));
		this.add(yesButton);
		this.add(noButton);
		yes();
		no();
	}
	
	public void yes() {
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdditionQuiz additionQuiz = new AdditionQuiz();
				MainApp.primaryFrame.getContentPane()
					.removeAll();
				MainApp.primaryFrame.getContentPane()
					.add(additionQuiz);
				MainApp.primaryFrame.getContentPane()
					.revalidate();
				MainApp.primaryFrame.getContentPane()
					.repaint();
			}
		});
	}
	
	public void no() {
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
}
