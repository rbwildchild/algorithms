package com.rfa.algs.exercises.threesum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.rfa.algs.watch.Stopwatch;

public class ThreeSum {
	public static int count(int[] a) { // Count triples that sum to 0.
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++)
				for (int k = j + 1; k < N; k++)
					if (a[i] + a[j] + a[k] == 0) {
						cnt++;
					}
		return cnt;
	}

	public static void main(String[] args) {
		File intsFile = new File(
				"src/main/resources/com/rfa/algs/exercises/threesum/8Kints.txt");
		try (Scanner scan = new Scanner(intsFile)) {
			int size = scan.nextInt();
			int[] a = new int[size];
			for (int i = 0; i < size; i++)
				a[i] = scan.nextInt();
			Stopwatch watch = new Stopwatch();
			watch.start();
			int counter = count(a);
			System.out.println("Time: " + watch.elapsedTime());
			System.out.println(counter);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
