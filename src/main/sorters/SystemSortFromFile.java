package sorters;

import static testfile.RandomNumberFileGenerator.files;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import util.ReadUtil;
import util.StopwatchCPU;
import util.WriteUtil;

public class SystemSortFromFile {
	public static void sort(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int a : arr)
			list.add(a);
		Arrays.sort(arr);
		int i = 0;
		for (Integer e : list)
			arr[i++] = e;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		for (int i = 0; i < files.length; i++) {
			int[] arr = ReadUtil.read(1000000, "nums.txt");
			StopwatchCPU sw = new StopwatchCPU();
			sort(arr);
			System.out.println("System sort:" + files[i] + sw.elapsedTime()
					+ " ms");
			WriteUtil.write("syssorted-" + files[i], arr);
		}
	}
}
