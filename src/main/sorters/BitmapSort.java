package sorters;

import static testfile.RandomNumberFileGenerator.files;

import java.io.IOException;

import util.ReadUtil;
import util.StopwatchCPU;
import util.WriteUtil;
import bitvector.BitVector;

public class BitmapSort {
	public static void sort(int[] arr) {
		BitVector bv = new BitVector(10000000); //set size to max possible number
		for (int i : arr) {
			bv.set(i);
		}
		int j = 0;
		for (long i = 0; i < bv.length(); i++)
			if (bv.isSet(i))
				arr[j++] = (int) i;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		for (int i = 0; i < files.length; i++) {
			int[] arr = ReadUtil.read(1000000, files[i]);
			StopwatchCPU sw = new StopwatchCPU();
			sort(arr);
			System.out.println("Bitmap sort:" + files[i] + sw.elapsedTime()
					+ " ms");
			WriteUtil.write("bitmapsorted-" + files[i], arr);
		}
	}
}
