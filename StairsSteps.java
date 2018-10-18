package learnJavaUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;

public class StairsSteps {

	public static void main(String[] args) throws IOException {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();
		// Using DateFormat format method we can create a string
		// representation of a date with the defined format.
		String reportDate = df.format(today);

		String fileName = "stairs_" + reportDate + ".txt";
		FileWriter fw = new FileWriter(fileName);

		int count = 0;
		int loopnum = 0;

		int summarySteps = 0;

		int TotalStairs = 22;

		int steps[] = { 1, 2, 4, 7 };

		int stepsNum = 4;

		Stack<Integer> s = new Stack<Integer>();

		int pIndex = 0;

		int maxStep = steps[stepsNum - 1];
		int minStep = steps[0];

		Integer lastPoped = new Integer(maxStep);

		boolean isPop = false;
		boolean isPush = false;
		boolean isReplace = false;
		boolean isLastTimeLessThanTotalStairs = true;

		Integer popedStep = new Integer(minStep);
		Integer peekStep = new Integer(minStep);

		while (!(s.empty() && popedStep.intValue() == maxStep)) {
			loopnum = loopnum + 1;
			// if (loopnum > 4000)
			// try {
			// System.in.read();
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

			// System.out.print("SSSS");
			// System.out.print(s);
			// System.out.print(" pIndex=" + pIndex);
			// System.out.print(" isPop=" + isPop);
			// System.out.print(" isReplace=" + isReplace);
			// System.out.print(" lastPoped=" + lastPoped.intValue());
			// System.out.print(" isPush=" + isPush);
			// System.out.print(" isPush=" + isPush);
			// System.out.println(" isLastTimeLessThanTotalStairs=" +
			// isLastTimeLessThanTotalStairs);

			if (summarySteps >= TotalStairs) {
				if (summarySteps == TotalStairs) {
					count = count + 1;
					System.out.println("");
					System.out.print("ZZZZ");
					printSteps(s);
					fw.write(s.toString() + System.getProperty("line.separator"));
					System.out.println("");
				}

				popedStep = s.pop();
				summarySteps = summarySteps - popedStep.intValue();
				isPop = true;
				isReplace = false;
				isPush = false;
				lastPoped = popedStep;
				peekStep = s.peek();
				pIndex = 0;
				isLastTimeLessThanTotalStairs = false;

			} else {
				if (!isPop) { // 如果上次操作不是出栈，因为小于TotalStairs，继续入栈
					if (isReplace)
						pIndex = 0;
					s.push(new Integer(steps[pIndex]));
					summarySteps = summarySteps + steps[pIndex];
					continue;
				} else if (isPop) { // 如果上次操作是出栈
					if (lastPoped.intValue() == maxStep) { // 上次出栈的是最大值
						peekStep = s.peek();
						if (peekStep.intValue() == maxStep) { // 栈顶还是最大值，
							lastPoped = s.pop(); // 继续出栈
							summarySteps = summarySteps - lastPoped.intValue();
							isPop = true;
						} else { // 将栈顶值用下一个值替换
							popedStep = s.pop();
							summarySteps = summarySteps - popedStep.intValue();
							pIndex = getIndex(popedStep.intValue(), steps);
							s.push(steps[pIndex + 1]);
							summarySteps = summarySteps + steps[pIndex + 1];
							pIndex = 0;
							isReplace = true;
							isPop = false;
							isPush = false;
						}

					} else {
						if (isLastTimeLessThanTotalStairs) {
							pIndex = getIndex(lastPoped.intValue(), steps);
							s.push(steps[pIndex + 1]);
							summarySteps = summarySteps + steps[pIndex + 1];
							isPush = true;
							isPop = false;
							isReplace = false;
							pIndex = 0;

						} else {
							popedStep = s.pop();
							summarySteps = summarySteps - popedStep.intValue();

							pIndex = getIndex(popedStep.intValue(), steps);

							if ((pIndex + 1) == stepsNum) {
								popedStep = s.pop();
								lastPoped = popedStep;
								summarySteps = summarySteps - popedStep.intValue();
								isPop = true;
								isReplace = false;
								isPush = false;
								isLastTimeLessThanTotalStairs = true;

							} else {

								s.push(steps[pIndex + 1]);
								summarySteps = summarySteps + steps[pIndex + 1];
								isReplace = true;
								isPop = false;
								isPush = false;
							}

						}
					}

				}
				// isLastTimeLessThanTotalStairs = true;
			}
		}

		System.out.println("Total ways" + count + System.getProperty("line.separator"));
		fw.write("Total ways" + count);

		fw.close();

	}

	static void printSteps(Stack<Integer> s) {
		System.out.println(s);

	}

	static int getIndex(int value, int arr[]) {
		int i = 0;
		for (; i < arr.length; i++) {
			if (value == arr[i])
				break;
		}
		return i;

	}

	public static void writeFile2(String s, String fileName) throws IOException {
		FileWriter fw = new FileWriter("fileName");

		for (int i = 0; i < 10; i++) {
			fw.write("s");
		}

		fw.close();
	}

}
