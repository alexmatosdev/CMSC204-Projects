
public class ArraySum {

	public static int sumOfArray(Integer[] arr, int i) {
		int sum = 0;
		
		if (i >= 0)
			sum += sumOfArray(arr, i-1) + arr[i];
		return sum;
	}
}
