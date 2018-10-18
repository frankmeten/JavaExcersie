package learnJavaUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;

//https://stackoverflow.com/questions/36298051/count-and-display-ways-to-climb-staircase-java

public class DebosmitRay {
	static String fileName = "DebosmitRay stairs_";
	static FileWriter fw;
	static int totalN = 0;

	static int steps[] = { 1, 2, 3, 7, 11 };

	static {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();
		// Using DateFormat format method we can create a string
		// representation of a date with the defined format.
		String reportDate = df.format(today);

		fileName = "DebosmitRayStack" + reportDate + ".txt";
		try {
			fw = new FileWriter(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {

		// Usage:
		int currentValue = 0, n = 19;

		long start = System.currentTimeMillis();
		waysToReachN(currentValue, n, new Stack<Integer>());
		
		fw.close();

		System.out.println("Elapsed time " + (System.currentTimeMillis() - start) / 1000 + " s "
				+ System.getProperty("line.separator"));
		System.out.println("totalNum	" + totalN);

		Runtime rt = Runtime.getRuntime();
		long total_mem = rt.totalMemory();
		long free_mem = rt.freeMemory();
		long used_mem = total_mem - free_mem;
		System.out.println("Amount of total_mem memory: " + total_mem);
		System.out.println("Amount of free_mem memory: " + free_mem);
		System.out.println("Amount of used memory: " + used_mem);

	}
	//
	// public static void waysToReachN(int currentValue, int n, List<Integer>
	// pathSoFar) throws IOException {
	// if (currentValue == n) {
	// // System.out.println(pathSoFar);
	// fw.write(pathSoFar + System.getProperty("line.separator"));
	// totalN = totalN + 1;
	// return;
	// } else if (currentValue > n) {
	// return;
	// }
	// for (int i = 1; i <= 2; i++) {
	// // add step
	// pathSoFar.add(i);
	//
	// // recurse
	// waysToReachN(currentValue + i, n, pathSoFar);
	//
	// // remove step
	// pathSoFar.remove(pathSoFar.size() - 1);
	// }
	// }

	public static void waysToReachN(int currentValue, int n, Stack<Integer> pathSoFar) throws IOException {
		if (currentValue == n) {
			// System.out.println(pathSoFar);
			fw.write(pathSoFar + System.getProperty("line.separator"));
			totalN = totalN + 1;
			return;
		} else if (currentValue > n) {
			return;
		}
		// for (int i = 1; i <= 2; i++) {
		int i = 0;
		while (i < steps.length) {
			// add step
			pathSoFar.push(steps[i]);

			// recurse
			waysToReachN(currentValue + steps[i], n, pathSoFar);
			i++;

			// remove step
			// pathSoFar.remove(pathSoFar.size() - 1);
			pathSoFar.pop();
		}
	}

}
