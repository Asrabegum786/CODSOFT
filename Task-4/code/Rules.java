package Task_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

	String name;
	JButton start, back;

	Rules(String name) {
		this.name = name;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel heading = new JLabel("Welcome " + name + " to It's Quiz time!");
		heading.setBounds(50, 20, 700, 30);
		heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
		heading.setForeground(new Color(30, 144, 254));
		add(heading);

		JLabel rules = new JLabel();
		rules.setBounds(20, 90, 700, 350);
		rules.setFont(new Font("Tahoma", Font.PLAIN, 16));

		rules.setText("<html>" + "1. welcome to It's Quiz time!" + "<br></br>"
				+ "2. Each question must be answered within  a specific time limit(ex:15seconds per question)"
				+ "<br></br>" + "3.Each correct answer earns points" + "<br>+<br>"
				+ "4.No points are deducted for wrong answers unless specified" + "<br></br>"
				+ "5.No use of external aids including books ,internet or help from others" + "<br></br>" + "</html>");

		add(rules);

		back = new JButton("back");
		back.setBounds(250, 500, 100, 30);
		back.setBackground(new Color(30, 144, 254));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);

		start = new JButton("start");
		start.setBounds(400, 500, 100, 30);
		start.setBackground(new Color(30, 144, 254));
		start.setForeground(Color.WHITE);
		start.addActionListener(this);
		add(start);

		setSize(800, 650);
		setLocation(350, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == start) {
			setVisible(false);
			new quiztest(name);
		} else if (ae.getSource() == back) {
			setVisible(false);
			new Login();
		}
	}

	public static void main(String[] arg) {

		new Rules("user");

	}
}
