package week03;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class LoginPage extends JPanel {

	private JLabel titleLabel, usernameLabel, passwordLabel,
		showPasswordLabel;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JCheckBox showPasswordCheckBox;
	private JButton loginButton, registerButton;
	private JPanel usernamePanel, passwordPanel, buttonPanel;
	
	public LoginPage() {
		Dimension textFieldDimension = new Dimension(400, 50);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		usernamePanel = new JPanel();
		usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.X_AXIS));
		passwordPanel = new JPanel();
		passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		titleLabel = new JLabel("Welcome to ToDo List App");
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		Font titleFont = new Font(Font.SERIF, Font.BOLD, 22);
		titleLabel.setFont(titleFont);
		this.add(titleLabel);
		
		usernameLabel = new JLabel("Username");
		usernamePanel.add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setMinimumSize(textFieldDimension);
		usernameTextField.setMaximumSize(textFieldDimension);
		usernamePanel.add(usernameTextField);
		
		this.add(usernamePanel);
		
		passwordLabel = new JLabel("Password");
		passwordPanel.add(passwordLabel);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setMinimumSize(textFieldDimension);
		passwordTextField.setMaximumSize(textFieldDimension);
		passwordPanel.add(passwordTextField);
		
		this.add(passwordPanel);
		
		showPasswordCheckBox = new JCheckBox("Show Password");
		showPasswordCheckBox.setAlignmentX(CENTER_ALIGNMENT);
		this.add(showPasswordCheckBox);
		
		loginButton = new JButton("Login");
		buttonPanel.add(loginButton);
		
		registerButton = new JButton("Register");
		buttonPanel.add(registerButton);
		
		this.add(buttonPanel);
		
		addLoginListener();
		addShowPasswordListener();
	}
	
	public void addLoginListener() {
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(usernameTextField.getText().equals("abc") &&
						String.valueOf(passwordTextField.getPassword()).equals("123")) {
					System.out.println("Lurus");
				} else {
					System.out.println("Salah");
				}
			}
			
		});
	}
	
	public void addShowPasswordListener() {
		showPasswordCheckBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(showPasswordCheckBox.isSelected()) {
					passwordTextField.setEchoChar((char) 0);
				} else {
					passwordTextField.setEchoChar('*');
				}
			}
			
		});
	}
	
}
