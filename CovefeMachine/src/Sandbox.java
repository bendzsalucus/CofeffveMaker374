import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Sandbox
 *
 *
 */
public class Sandbox {

	public static void main(String[] args) {
		Random randy = new Random();
		double count = 0;
		double ran = 1000000;
		for(int i =0; i < ran; i++) {
			int scarlett = randy.nextInt();
			int johansson = randy.nextInt();

			if(((scarlett + johansson) % 2) == 0) {
				count++;
			}
		}

		System.out.println(count / ran);
		System.out.println("James was here");
	}



}
