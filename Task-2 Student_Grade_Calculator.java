
package studentGradCalculator;

import java.util.Scanner;

public class Student_Grade_Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int maxMarksPerSubject = 100;

		System.out.println("Enter Number of subjects:");
		int No_ofSub;
		No_ofSub = scanner.nextInt();

		int totalmarks = 0;
		int subMarks[] = new int[No_ofSub];
		String subject;
		System.out.println(" Enter subject Name ");
		for (int i = 0; i < No_ofSub; i++) {
			subject = scanner.next();
		}

		for (int i = 0; i < No_ofSub; i++) {
			System.out.println(" marks of subject  " + i + "(out of 100) :");
			subMarks[i] = scanner.nextInt();

			if (subMarks[i] < 0 || subMarks[i] > maxMarksPerSubject) {
				System.out.println("Marks should be in the range of 0 to 100.please enter a valid number");
				i--;
			} else {
				// System.out.println("Total marks:");
				totalmarks += subMarks[i];
			}

		}
		System.out.println("totalmarks:" + totalmarks);

		System.out.println(" average Percentage:");
		double percentage = totalmarks / No_ofSub;
		System.out.println(percentage + " ");

		if (percentage >= 91) {
			System.out.println("grade:O");
		} else if (percentage >= 81) {
			System.out.println("grade:A");

		} else if (percentage >= 71) {
			System.out.println("grade:B");
		} else if (percentage >= 61) {
			System.out.println("grade:C");
		} else if (percentage >= 51) {
			System.out.println("grade:D");
		}

		else if (percentage >= 41) {
			System.out.println("grade:E");
		}

		else if (percentage <= 31) {
			System.out.println("grade:Fail");
		}

	}

}
