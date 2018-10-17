package learnJavaUtil;

import java.util.Stack;

public class Stairs {

	public static void main(String[] args) {
		int count = 0;
		Stack<Integer> s = new Stack<Integer>();
		int StairNum = 20;
		int sumSteps = 0;
		s.push(new Integer(1));
		sumSteps = sumSteps + s.peek().intValue();

		while (sumSteps < StairNum && !s.empty()) {
			s.push(new Integer(1));
			sumSteps = sumSteps + s.peek().intValue();
			while (sumSteps >= StairNum && !s.empty()) {
				if (sumSteps == StairNum) {
					printStack(s);
					count = count + 1;
				}
				// 退栈
				Integer popedNode = s.pop();
				sumSteps = sumSteps - popedNode.intValue();
				Integer peekNode = s.peek();
				while (!s.empty() && popedNode.intValue() == 2 && peekNode.intValue() == 2) {
					popedNode = s.pop();
					if (!s.empty()) {
						peekNode = s.peek();
					}
					sumSteps = sumSteps - popedNode.intValue();
				}
				if (!s.empty() && popedNode.intValue() == 1) {
					popedNode = s.pop();
					sumSteps = sumSteps - popedNode.intValue();
					while (!s.empty() && popedNode.intValue() == 2) {
						popedNode = s.pop();
						sumSteps = sumSteps - popedNode.intValue();
					}

					if (s.empty() && popedNode.intValue() == 2) {

					} else {
						s.push(new Integer(2));
						sumSteps = sumSteps + s.peek().intValue();

					}

				} else if (!s.empty() && popedNode.intValue() == 2) {
					popedNode = s.pop();
					sumSteps = sumSteps - popedNode.intValue();
					while (!s.empty() && popedNode.intValue() == 2) {
						popedNode = s.pop();
						sumSteps = sumSteps - popedNode.intValue();
					}
					if (s.empty() && popedNode.intValue() == 2) {

					} else {
						s.push(new Integer(2));
						sumSteps = sumSteps + s.peek().intValue();

					}
				}
			}
		}
		System.out.println("Total Ways:" + count);
	}

	static void printStack(Stack s) {
		System.out.println(s.toString());
	}

}
