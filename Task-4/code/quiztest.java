package Task_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quiztest extends JFrame implements ActionListener {

	String questions[][] = new String[10][5];
	String answers[][] = new String[10][2];
	String useranswers[][] = new String[10][1];
	JLabel qno, question;
	JRadioButton opt1, opt2, opt3, opt4;
	ButtonGroup groupoptions;
	JButton next, submit, lifeline;

	public static int timer = 30;
	public static int ans_given = 0;
	public static int count = 0;
	public static int score = 0;

	String name;

	quiztest(String name) {
		this.name = name;
		setBounds(50, 0, 1440, 850);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz.jpeg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 1440, 392);
		add(image);

		qno = new JLabel();
		qno.setBounds(100, 450, 50, 30);
		qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(qno);

		question = new JLabel();
		question.setBounds(150, 450, 900, 30);
		question.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(question);

		questions[0][0] = "It was Sunday on 1 jan 2006 .what was the day of the week jan 1, 2010?";
		questions[0][1] = "Sunday";
		questions[0][2] = "Saturday";
		questions[0][3] = "Friday";
		questions[0][4] = "Wednesday";

		questions[1][0] = "what was day of the week on 28th may,2006 ?";
		questions[1][1] = "Thursday";
		questions[1][2] = "Friday";
		questions[1][3] = "Saturday";
		questions[1][4] = "Sunday";

		questions[2][0] = "What was day of the week on 17th june,1998?";
		questions[2][1] = "Monday";
		questions[2][2] = "Tuesday";
		questions[2][3] = "Wednesday";
		questions[2][4] = "Thursday";

		questions[3][0] = "What will be the day of the week 15th August ,2010?";
		questions[3][1] = "Sunday";
		questions[3][2] = "Monday";
		questions[3][3] = "Tuesday";
		questions[3][4] = "Friday";

		questions[4][0] = "Today is Monday.After 61 days ,it will be ?";
		questions[4][1] = "Wednesday";
		questions[4][2] = "Saturday";
		questions[4][3] = "Tuesday";
		questions[4][4] = "Thursday";

		questions[5][0] = "if 6th march 2005 is monday.What was the day of the week on 6th march 2004?";
		questions[5][1] = "Sunday";
		questions[5][2] = "Saturday";
		questions[5][3] = "Tuesday";
		questions[5][4] = "Wednesday";

		questions[6][0] = "How many odd days are there in 2000?";
		questions[6][1] = "0";
		questions[6][2] = "3";
		questions[6][3] = "2";
		questions[6][4] = "1";

		questions[7][0] = "Onwhat dates of April 2001 did wednesday fall?";
		questions[7][1] = "1st,8th,15th,22nd ,29th";
		questions[7][2] = "2nd,9th,16th,23rd,30th";
		questions[7][3] = "3rd,10th,17th,24th";
		questions[7][4] = "4th,11th,18th,25th";

		questions[8][0] = "How many days are there in x weeks x days?";
		questions[8][1] = "7x^2";
		questions[8][2] = "8x";
		questions[8][3] = "14x";
		questions[8][4] = "7";

		questions[9][0] = "The last day of a century cannot be/";
		questions[9][1] = "Monday";
		questions[9][2] = "Wednesday";
		questions[9][3] = "Tuesday";
		questions[9][4] = "Friday";

		answers[0][1] = "Friday";
		answers[1][1] = "Sunday";
		answers[2][1] = "Wednesday";
		answers[3][1] = "Sunday";
		answers[4][1] = "Saturday";
		answers[5][1] = "Sunday";
		answers[6][1] = "0";
		answers[7][1] = "4th,11th,18th,25th";
		answers[8][1] = "8x";
		answers[9][1] = "Tuesday";

		opt1 = new JRadioButton();
		opt1.setBounds(170, 520, 700, 30);
		opt1.setBackground(Color.WHITE);
		opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(opt1);

		opt2 = new JRadioButton();
		opt2.setBounds(170, 560, 700, 30);
		opt2.setBackground(Color.WHITE);
		opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(opt2);

		opt3 = new JRadioButton();
		opt3.setBounds(170, 600, 700, 30);
		opt3.setBackground(Color.WHITE);
		opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(opt3);

		opt4 = new JRadioButton();
		opt4.setBounds(170, 640, 700, 30);
		opt4.setBackground(Color.WHITE);
		opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(opt4);

		groupoptions = new ButtonGroup();
		groupoptions.add(opt1);
		groupoptions.add(opt2);
		groupoptions.add(opt3);
		groupoptions.add(opt4);

		next = new JButton("Next");
		next.setBounds(1100, 550, 200, 40);
		next.setFont(new Font("Tahoma", Font.PLAIN, 22));
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		add(next);

		submit = new JButton("Submit");
		submit.setBounds(1100, 600, 200, 40);
		submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		submit.setEnabled(false);
		add(submit);

		start(count);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == next) {
			repaint();
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);

			ans_given = 1;
			if (groupoptions.getSelection() == null) {
				useranswers[count][0] = "";
			} else {
				useranswers[count][0] = groupoptions.getSelection().getActionCommand();
			}

			if (count == 8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}

			count++;
			start(count);

		} else if (ae.getSource() == submit) {
			ans_given = 1;
			if (groupoptions.getSelection() == null) {
				useranswers[count][0] = "";
			} else {
				useranswers[count][0] = groupoptions.getSelection().getActionCommand();
			}

			for (int i = 0; i < useranswers.length; i++) {
				if (useranswers[i][0].equals(answers[i][1])) {
					score += 10;
				} else {
					score += 0;
				}
			}
			setVisible(false);
			new Score2(name, score);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);

		String time = "Time left - " + timer + " seconds"; // 15
		g.setColor(Color.RED);
		g.setFont(new Font("Tahoma", Font.BOLD, 20));

		if (timer > 0) {
			g.drawString(time, 1100, 500);
		} else {
			g.drawString("Times up!!", 1100, 500);
		}

		timer--; // 14

		try {
			Thread.sleep(1000);
			repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ans_given == 1) {
			ans_given = 0;
			timer = 30;
		} else if (timer < 0) {
			timer = 30;
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);

			if (count == 8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			if (count == 9) { // submit button
				if (groupoptions.getSelection() == null) {
					useranswers[count][0] = "";
				} else {
					useranswers[count][0] = groupoptions.getSelection().getActionCommand();
				}

				for (int i = 0; i < useranswers.length; i++) {
					if (useranswers[i][0].equals(answers[i][1])) {
						score += 10;
					} else {
						score += 0;
					}
				}
				setVisible(false);
				new Score2(name, score);
			} else { // next button
				if (groupoptions.getSelection() == null) {
					useranswers[count][0] = "";
				} else {
					useranswers[count][0] = groupoptions.getSelection().getActionCommand();
				}
				count++; // 0 // 1
				start(count);

			}

		}
	}

	public void start(int count) {
		qno.setText("" + (count + 1) + ". ");
		question.setText(questions[count][0]);
		opt1.setText(questions[count][1]);
		opt1.setActionCommand(questions[count][1]);

		opt2.setText(questions[count][2]);
		opt2.setActionCommand(questions[count][2]);

		opt3.setText(questions[count][3]);
		opt3.setActionCommand(questions[count][3]);

		opt4.setText(questions[count][4]);
		opt4.setActionCommand(questions[count][4]);

		groupoptions.clearSelection();
	}

	public static void main(String[] args) {
		new quiztest("User");
	}
}
