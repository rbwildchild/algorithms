package com.rfa.algs.exercises.uf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.rfa.algs.watch.Stopwatch;

public class MainUF {

	public static void main(String[] args) {
		File intsFile = new File(
				"src/main/resources/com/rfa/algs/exercises/uf/mineUF.txt");
		try (Scanner scan = new Scanner(intsFile)) {
			int N = scan.nextInt();
			UF uf = new QuickUnionUF(N);
			Stopwatch watch = new Stopwatch();
			watch.start();
			while (scan.hasNext()) {
				int p = scan.nextInt();
				int q = scan.nextInt();
				if (uf.connected(p, q))
					continue;
				uf.union(p, q);
				//System.out.println(p + " " + q);
			}
			uf.printIds();
			System.out.println(watch.elapsedTime());
			System.out.println(uf.count() + " components");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
