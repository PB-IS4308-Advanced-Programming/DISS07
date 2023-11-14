package week10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdditionQuiz extends JPanel {
	
	JPanel equationPanel = new JPanel();
	JLabel leftValueLabel = new JLabel(), 
			rightValueLabel = new JLabel(),
			counterLabel = new JLabel("" + 0);
	JTextField answerTextField = new JTextField();
	JButton answerButton = new JButton("Answer");
	Random random = new Random();
	
	public AdditionQuiz() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		equationPanel.setLayout(new BoxLayout(equationPanel,
				BoxLayout.X_AXIS));
		initialise();
		equationPanel.add(leftValueLabel);
		equationPanel.add(new JLabel("+"));
		equationPanel.add(rightValueLabel);
		equationPanel.add(new JLabel("="));
		equationPanel.add(answerTextField);
		this.add(equationPanel);
		this.add(answerButton);
		this.add(new JLabel("Current consecutive correct answer"));
		this.add(counterLabel);
		answer();
	}
	
	int leftValue, rightValue, counter;
	
	public void initialise() {
		leftValue = random.nextInt(10);
		rightValue = random.nextInt(10);
		leftValueLabel.setText("" + leftValue);
		rightValueLabel.setText("" + rightValue);
	}
	
	public void answer() {
		answerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answerString = answerTextField.getText();
				int answer = Integer.parseInt(answerString);
				if(answer == (leftValue + rightValue)) {
					counter++;
					if(counter >= 5) {
						YouSolvedIt youSolvedIt = new YouSolvedIt();
						MainApp.primaryFrame.getContentPane()
							.removeAll();
						MainApp.primaryFrame.getContentPane()
							.add(youSolvedIt);
						MainApp.primaryFrame.getContentPane()
							.revalidate();
						MainApp.primaryFrame.getContentPane()
							.repaint();
					}
				} else {
					counter = 0;
				}
				counterLabel.setText("" + counter);
				leftValue = random.nextInt(10);
				rightValue = random.nextInt(10);
				leftValueLabel.setText("" + leftValue);
				rightValueLabel.setText("" + rightValue);
				answerTextField.setText("");
			}
		});
	}

}
