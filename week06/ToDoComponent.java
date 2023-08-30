package week06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ToDoComponent extends JPanel {

	private JPanel parentPanel;
	private JTextField toDoTextField;
	private JButton editButton, deleteButton;
	private int id;
	
	public ToDoComponent(int id, String toDoText, JPanel parentPanel) {
		this.id = id;
		this.parentPanel = parentPanel;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		toDoTextField = new JTextField(toDoText);
		toDoTextField.setEnabled(false);
		
		editButton = new JButton("Edit");
		
		deleteButton = new JButton("Delete");
		
		this.add(toDoTextField);
		this.add(editButton);
		this.add(deleteButton);
		editToDoListener();
		removeToDoListener();
	}
	
	public void removeToDoListener() {
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeToDo();
			}
			
		});
	}
	
	public void removeToDo() {
		try {
			DatabaseHandler.deleteTodo(this.id);
			parentPanel.remove(this);
			parentPanel.revalidate();
			parentPanel.repaint();
			DatabaseHandler.closeConnection();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void editToDoListener() {
		editButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editToDo();
			}
			
		});
	}
	
	public void editToDo() {
		if(toDoTextField.isEnabled() == false) {
			toDoTextField.setEnabled(true);
		} else {
			try {
				DatabaseHandler.editTodo(this.id, toDoTextField.getText());
				toDoTextField.setEnabled(false);
				DatabaseHandler.closeConnection();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		this.revalidate();
		this.repaint();
	}
	
}
