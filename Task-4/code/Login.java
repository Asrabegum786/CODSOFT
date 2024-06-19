package Task_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

	JButton next, rules, back;
	JTextField tfname;

	Login() {

		getContentPane().setBackground(Color.WHITE);

		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("login.jpeg"));

		JLabel image = new JLabel(i1);
		image.setBounds(600, 0, 600, 500);
		add(image);

		JLabel heading = new JLabel("It's Quiz time!");
		heading.setBounds(150, 60, 300, 45);
		heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
		heading.setForeground(new Color(30, 144, 254));
		add(heading);

		JLabel name = new JLabel("Enter your name");
		name.setBounds(200, 150, 300, 20);
		name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		name.setForeground(new Color(30, 99, 54));
		add(name);

		tfname = new JTextField();
		tfname.setBounds(150, 200, 300, 25);
		tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(tfname);

		next = new JButton("next");
		next.setBounds(100, 270, 120, 25);
		next.setBackground(new Color(30, 144, 254));
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		add(next);

		back = new JButton("back");
		back.setBounds(300, 270, 120, 25);
		back.setBackground(new Color(30, 144, 254));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);

		setSize(1200, 500);
		setLocation(200, 150);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == next) {
			String name = tfname.getText();
			setVisible(false);

			new Rules(name);

		} else if (ae.getSource() == back) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Login();

	}

}
