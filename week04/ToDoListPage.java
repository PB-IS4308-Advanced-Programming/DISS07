package week04;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ToDoListPage extends JPanel {

	private JTextField newToDoTextField;
	private JButton addButton;
	private JPanel newToDoPanel, toDoListPanel;
	private JScrollPane toDoListScroll;
	
	public ToDoListPage() {
		this.setLayout(new BorderLayout());
		newToDoPanel = new JPanel();
		newToDoPanel.setLayout(new BoxLayout(newToDoPanel, BoxLayout.X_AXIS));
		
		toDoListPanel = new JPanel();
		toDoListPanel.setLayout(new BoxLayout(toDoListPanel, BoxLayout.Y_AXIS));
		
		newToDoTextField = new JTextField();
		newToDoTextField.setMinimumSize(new Dimension(700, 50));
		newToDoTextField.setMaximumSize(new Dimension(700, 50));
		
		addButton = new JButton("Add");
		addButton.setMinimumSize(new Dimension(100, 50));
		addButton.setMaximumSize(new Dimension(100, 50));
		
		newToDoPanel.add(newToDoTextField);
		newToDoPanel.add(addButton);
		
		toDoListScroll = new JScrollPane(toDoListPanel);
		
		this.add(newToDoPanel, BorderLayout.NORTH);
		this.add(toDoListScroll, BorderLayout.CENTER);
		
		addToDoListener();
	}
	
	public void addToDoListener() {
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(newToDoTextField.getText().equals("") == false) {					
					toDoListPanel.add(new ToDoComponent(newToDoTextField.getText(), toDoListPanel));
					toDoListPanel.revalidate();
					toDoListPanel.repaint();
				}
			}
			
		});
	}
	
}
