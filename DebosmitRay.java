package learnJavaUtil;

import java.util.ArrayList;
import java.util.List;

//https://stackoverflow.com/questions/36298051/count-and-display-ways-to-climb-staircase-java

public class DebosmitRay {

	public static void main(String[] args) {
		// Usage:
		int currentValue = 0, n = 37;
		waysToReachN(currentValue, n, new ArrayList<Integer>());

	}

	public static void waysToReachN(int currentValue, int n, List<Integer> pathSoFar) {
		if (currentValue == n) {
			System.out.println(pathSoFar);
			return;
		} else if (currentValue > n) {
			return;
		}
		for (int i = 1; i <= 2; i++) {
			// add step
			pathSoFar.add(i);

			// recurse
			waysToReachN(currentValue + i, n, pathSoFar);

			// remove step
			pathSoFar.remove(pathSoFar.size() - 1);
		}
	}

}
