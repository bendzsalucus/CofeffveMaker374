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
		
		break_out_of_multiple_loops_example:
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				System.out.println(i + " " + j);
				if(j == 20 && i == 2) {
					break break_out_of_multiple_loops_example;
				}
			}
		}

	}



}
