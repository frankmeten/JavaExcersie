package learnJavaUtil;

import java.util.Stack;

public class StairsS {

	public static void main(String[] args) {

		int[] NUMBERS = { 1, 2, 4, 7 };
		int totalNumber = 2;
		int maxNumber = NUMBERS[totalNumber - 1];
		int minNumber = NUMBERS[0];
		int index = 0;

		int count = 0;
		Stack<Integer> s = new Stack<Integer>();
		int StairNum = 19;
		int sumSteps = 0;
		s.push(new Integer(minNumber));
		sumSteps = sumSteps + s.peek().intValue();

		Integer popedNode = new Integer(minNumber);
		Integer peekNode = new Integer(minNumber);
		try {
			while ((sumSteps < StairNum && !s.empty()) || (s.empty() && popedNode.intValue() != maxNumber)) {
				s.push(new Integer(NUMBERS[index]));
				index = 0;
				sumSteps = sumSteps + s.peek().intValue();
				while (sumSteps >= StairNum && !s.empty()) {
					// printStack(s);
					if (sumSteps == StairNum) {
						count = count + 1;
						System.out.print("Way #" + count + ":");
						printStack(s);
					}
					// 退栈
					popedNode = s.pop();
					sumSteps = sumSteps - popedNode.intValue();
					peekNode = s.peek();
					while (!s.empty() && popedNode.intValue() == maxNumber && peekNode.intValue() == maxNumber) {
						popedNode = s.pop();
						if (!s.empty()) {
							peekNode = s.peek();
						}
						sumSteps = sumSteps - popedNode.intValue();
					}
					if (!s.empty() && popedNode.intValue() == minNumber) {
						popedNode = s.pop();
						sumSteps = sumSteps - popedNode.intValue();

						if (s.empty() && popedNode.intValue() == maxNumber) {

						} else if (popedNode.intValue() < maxNumber) {
							index = indexInArray(popedNode.intValue(), NUMBERS);
							s.push(new Integer(NUMBERS[index + 1]));
							sumSteps = sumSteps + s.peek().intValue();

						} else if (popedNode.intValue() == maxNumber) {
							while (!s.empty() && popedNode.intValue() == maxNumber
									&& peekNode.intValue() == maxNumber) {
								popedNode = s.pop();
								if (!s.empty()) {
									peekNode = s.peek();
								}
								sumSteps = sumSteps - popedNode.intValue();
							}

							index = indexInArray(popedNode.intValue(), NUMBERS);
							if (index + 1 < totalNumber) {
								s.push(new Integer(NUMBERS[index + 1]));
								sumSteps = sumSteps + s.peek().intValue();
							} else {
								if (!s.empty()) {
									popedNode = s.pop();
									sumSteps = sumSteps - popedNode.intValue();
									index = indexInArray(peekNode.intValue(), NUMBERS);
									index = index + 1;
								}
							}
						}

					} else if (!s.empty() && popedNode.intValue() == maxNumber) {
						popedNode = s.pop();
						sumSteps = sumSteps - popedNode.intValue();

						index = indexInArray(popedNode.intValue(), NUMBERS);
						s.push(new Integer(NUMBERS[index + 1]));
						sumSteps = sumSteps + s.peek().intValue();

					} else if (!s.empty() && popedNode.intValue() < maxNumber && popedNode.intValue() > minNumber) {
						popedNode = s.pop();
						sumSteps = sumSteps - popedNode.intValue();

						index = indexInArray(popedNode.intValue(), NUMBERS);
						if (index + 1 < totalNumber) {
							s.push(new Integer(NUMBERS[index + 1]));
							sumSteps = sumSteps + s.peek().intValue();
							index = 0;
						} else {
							if (!s.empty()) {
								popedNode = s.pop();
								sumSteps = sumSteps - popedNode.intValue();
								index = indexInArray(popedNode.intValue(), NUMBERS);
								index = index + 1;
							}
						}

					} else {
						System.out.println(
								"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
					}
				}
			}
		} catch (Exception e) {
			printStack(s);
			e.printStackTrace();
		}
		System.out.println("Total Ways:" + count);
	}

	static void printStack(Stack<Integer> s) {
		System.out.println(s.toString());
	}

	static int indexInArray(int value, int[] array) {
		int i = 0;
		for (; i < array.length; i++) {
			if (value == array[i])
				return i;
		}
		return 0;
	}

}
