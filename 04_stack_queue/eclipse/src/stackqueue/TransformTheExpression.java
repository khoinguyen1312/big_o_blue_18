package stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TransformTheExpression {
	public static void main(String args[]) {
    	Scanner scanner = new Scanner(System.in);
    	
    	int numberOfProblem = scanner.nextInt();
    	List<String> problems = new ArrayList<>();
    	
    	for (int i = 0; i < numberOfProblem; i++) {
    		problems.add(scanner.next());
    	}
    	
    	scanner.close();
    	
    	List<String> answers = new ArrayList<>();
    	
    	for (String problem : problems) {
    		TransformTheExpression solution = new TransformTheExpression(problem);
    		answers.add(solution.convertReversePolishNotation());
    	}
		
    	for (String answer : answers) {
    		System.out.println(answer);
    	}
	}
	
	private Stack<Character> operator; 
	private String input;
	
	TransformTheExpression(String input) {
		this.input = input;
		operator = new Stack<>();
	}
	
	public String convertReversePolishNotation() {
		StringBuilder outputBuilder = new StringBuilder();
		
		char[] inputCharArray = input.toCharArray();
		
		for (char character : inputCharArray) {
			switch (character) {
				case '(':
					break;
				case ')':
					outputBuilder.append(operator.pop());
					break;
				case '+':
					addToOperaterStack('+');
					break;
				case '-':
					addToOperaterStack('-');
					break;
				case '*':
					addToOperaterStack('*');
					break;
				case '/':
					addToOperaterStack('/');
					break;
				case '^':
					addToOperaterStack('^');
					break;
				default:
					outputBuilder.append(character);
			}
		}
		
		return outputBuilder.toString();
	}

	private void addToOperaterStack(char operator) {
		this.operator.add(operator);
	}
}
