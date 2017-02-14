package testfile;

import java.io.IOException;
import java.util.Arrays;

import util.ArrayUtil;
import util.WriteUtil;

public class RandomNumberFileGenerator {
	public static String[] files = { "nums.txt", "ascending.txt",
			"descending.txt", "consecutive-ascending-lower.txt",
			"consecutive-descending-lower.txt",
			"consecutive-ascending-higher.txt",
			"consecutive-descending-higher.txt" };

	private static int[] generate(int k, int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		ArrayUtil.shuffle(arr);
		return Arrays.copyOfRange(arr, 0, k);
	}

	public static void writeRandomNums(int k, int n, String filename)
			throws IOException {
		int[] arr = generate(k, n);
		WriteUtil.write(filename, arr);
	}

	public static void main(String[] args) throws IOException {
		writeRandomNums(1000000, 10000000, files[0]);
		writeAscendingNums(1000000, 10000000, files[1]);
		writeDescendingNums(1000000, 10000000, files[2]);
		writeConsecutiveNums(0, 999999, files[3]);
		writeConsecutiveNums(999999, 0, files[4]);
		writeConsecutiveNums(9000000, 9999999, files[5]);
		writeConsecutiveNums(9999999, 9000000, files[6]);
	}

	private static void writeConsecutiveNums(int i, int j, String filename)
			throws IOException {
		int[] arr = new int[Math.abs(j - i) + 1];
		int incr = i < j ? 1 : -1;
		for (int k = 0; k < arr.length; k++) {
			arr[k] = i;
			i = i + incr;
		}
		WriteUtil.write(filename, arr);
	}

	public static void writeDescendingNums(int k, int n, String filename)
			throws IOException {
		int[] arr = generate(k, n);
		Arrays.sort(arr);
		ArrayUtil.reverse(arr);
		WriteUtil.write(filename, arr);
	}

	public static void writeAscendingNums(int k, int n, String filename)
			throws IOException {
		int[] arr = generate(k, n);
		Arrays.sort(arr);
		WriteUtil.write(filename, arr);
	}
}
