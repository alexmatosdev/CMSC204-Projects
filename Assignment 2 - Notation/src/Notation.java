/**
 * This class handles the infix and postfix methods
 * 
 * @author Alex Matos
 * 
 *
 */
public class Notation {

	/**
	 * converts infix to postfix
	 * @param infix
	 * @return returns the postfix
	 * @throws InvalidNotationFormatException
	 */
	public static java.lang.String convertInfixToPostfix(java.lang.String infix) throws InvalidNotationFormatException {
		// TODO Auto-generated method stub
		NotationQueue<Character> solutionQueue = new NotationQueue<>();
		NotationStack<Character> tempStack = new NotationStack<>();
		Character ci = null;
			for (int i = 0; i < infix.length(); i++) {
				ci = infix.charAt(i);
				if (ci=='0'||ci=='1'||ci=='2'||ci=='3'||ci=='4'||ci=='5'||ci=='6'||ci=='7'||ci=='8'||ci=='9') { // if ci equals number
					try { solutionQueue.enqueue(ci); // enqueue to solutionQueue
					} catch (QueueOverflowException e) {}
				}
				else if (ci == '(') { // if ci equals (
					try {tempStack.push(ci); // push ci
					} catch (StackOverflowException e) {}
				}
				else if (ci == '/' || ci == '*') { // if ci equals / or *
					try {
						while (tempStack.top() == '/' || tempStack.top() == '*') // while the top of tempStack has / or * 
							solutionQueue.enqueue(tempStack.pop()); // enqueue pop()
						tempStack.push(ci);// push ci
					} catch (StackUnderflowException | QueueOverflowException | StackOverflowException e) {}
				}
				else if (ci == '+' || ci == '-') { // if ci equals + or -
					try {
						while (tempStack.top() == '/' || tempStack.top() == '*' || tempStack.top() == '+' || tempStack.top() == '-' ) // while top() tempStack has / or * or + or -
							solutionQueue.enqueue(tempStack.pop()); // enqueue pop(top())
						tempStack.push(ci); // push ci
					} catch (StackUnderflowException | QueueOverflowException | StackOverflowException e) {}
				}
				else if (ci == ')') { // if ci equals )
					try {
						while (tempStack.top() != '(' && tempStack.size() != 0)// while top() != (
							solutionQueue.enqueue(tempStack.pop());
						tempStack.pop();// pop() and DISCARD!!
					} catch (StackUnderflowException | QueueOverflowException e) {}
					if (i+1 <= infix.length()-1) 
	 					if ((infix.charAt(i+1) == '/' && tempStack.isEmpty()) || (infix.charAt(i+1) == '*' && tempStack.isEmpty())) 
							throw new InvalidNotationFormatException();
				}
			}
			try {
				while (tempStack.isEmpty() == false)// while isEmpty() equals false
					solutionQueue.enqueue(tempStack.pop());// enqueue pop()
			} catch (QueueOverflowException | StackUnderflowException e) {}
			
		return solutionQueue.toString();
	}
	
	/**
	 * converts postfix to infix
	 * @param postfix
	 * @return returns the infix
	 * @throws InvalidNotationFormatException
	 */
	public static java.lang.String convertPostfixToInfix(java.lang.String postfix) throws InvalidNotationFormatException {
		// TODO Auto-generated method stub
		NotationStack<String> solutionStack = new NotationStack<>();
		Character ci = null;
		String toStack = "";
			for (int i = 0; i < postfix.length(); i++) {
				ci = postfix.charAt(i);
				if (ci=='0'||ci=='1'||ci=='2'||ci=='3'||ci=='4'||ci=='5'||ci=='6'||ci=='7'||ci=='8'||ci=='9') { // if ci is a number
					try {solutionStack.push(""+ci); // push it to stack
					} catch (StackOverflowException e) {}
				}
				else if (ci == '/' || ci == '*' || ci == '+' || ci == '-') {// if ci is + - / *
					if (solutionStack.size() <= 1)
						throw new InvalidNotationFormatException();
					try {
						String first = solutionStack.pop();
						String second = solutionStack.pop();
						toStack = "(" + second + ci + first + ")";
					} catch (StackUnderflowException e) {}
					
					// grab 2 opearnds from stack format correctly with operator
					try {
						solutionStack.push(toStack);
					} catch (StackOverflowException e) {}
				}
			}
 		return solutionStack.toString();
	}

	/**
	 * This method takes a postfix expression and evaluates it to return the answer
	 * @param postfixExpr
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(java.lang.String postfixExpr) throws InvalidNotationFormatException {
		// TODO Auto-generated method stub
		NotationStack<String> solutionStack = new NotationStack<>();
		Character ci = null;
			for (int i = 0; i < postfixExpr.length(); i++) {
				ci = postfixExpr.charAt(i);
				if (ci=='0'||ci=='1'||ci=='2'||ci=='3'||ci=='4'||ci=='5'||ci=='6'||ci=='7'||ci=='8'||ci=='9'||ci == '(') { // if ci is a number
					try {
						solutionStack.push(""+ci);
					} catch (StackOverflowException e) {}
				}
				else if (ci == '*') {
					if (solutionStack.size() <= 1)
						throw new InvalidNotationFormatException();
					try {
					double first = Double.parseDouble(solutionStack.pop());
					double second = Double.parseDouble(solutionStack.pop());
					solutionStack.push("" + (second * first));
					} catch (StackUnderflowException | StackOverflowException e) {}
				}
				else if (ci == '/') {
					if (solutionStack.size() <= 1)
						throw new InvalidNotationFormatException();
					try {
					double first = Double.parseDouble(solutionStack.pop());
					double second = Double.parseDouble(solutionStack.pop());
					solutionStack.push("" + (second / first));
					} catch (StackUnderflowException | StackOverflowException e) {}
				}
				else if (ci == '+') {
					if (solutionStack.size() <= 1)
						throw new InvalidNotationFormatException();
					try {
					double first = Double.parseDouble(solutionStack.pop());
					double second = Double.parseDouble(solutionStack.pop());
					solutionStack.push("" + (second + first));
					} catch (StackUnderflowException | StackOverflowException e) {}
				}
				else if (ci == '-') {
					if (solutionStack.size() <= 1)
						throw new InvalidNotationFormatException();
					try {
					double first = Double.parseDouble(solutionStack.pop());
					double second = Double.parseDouble(solutionStack.pop());
					solutionStack.push("" + (second - first));
					} catch (StackUnderflowException | StackOverflowException e) {}
				}
			}
		return Double.parseDouble(solutionStack.get(0));
		
	}

}
