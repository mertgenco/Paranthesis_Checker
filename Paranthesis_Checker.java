
/**
 * MERT GENCO
 * 17.11.2019 
 * This a program that checks parentheses if they are used correctly or not in a code snippet. 
 * Also shows current stack situation and reports if size of stack has been changed.
 */

import java.util.*;

public class mert_genco {

	private static Scanner in;

	static boolean ParanthesesCheck(String enter) {
		myStack<Character> stack = new myStack<Character>();

		for (int i = 0; i < enter.length(); i++) {

			if (enter.charAt(i) == '(' || enter.charAt(i) == '{') { /** Recognizes parentheses and pushes them to stack */
				stack.push(enter.charAt(i));
				System.out.println("\n");
				stack.forEach(System.out::print); /** Prints elements in the stack */

			}
			if (enter.charAt(i) == ')' || enter.charAt(i) == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				char topcharacter = stack.pop(); /** Removes matched parentheses from the stack with pop operation  */
				if ((topcharacter == '(' && enter.charAt(i) != ')')
						|| (topcharacter == '{' && enter.charAt(i) != '}')) {
					return false;
				}
			}

		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {

		System.out.println("Please write here: ");
		in = new Scanner(System.in);
		String input = in.nextLine();

		if (ParanthesesCheck(input)) {
			System.out.println("Parentheses are correct");
		} else {
			System.out.println("\n\nParentheses do not match!");
		}

	}

}
