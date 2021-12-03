/**
 * 
 */
package com.adventofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author darrraqi
 *
 */
public class Day1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = readFile("input.txt");
		System.out.print(list.size());
		System.out.println(day1part2(list));
	}
	
	private static int processTheList(List<Integer> pList) {
		int counter = 0;
		for(int i = 0;i<pList.size();i++) {
			if(i+1<pList.size()) {
				if(pList.get(i+1)>pList.get(i)) {
					counter++;
				}
			}

		}
		return counter;
	}

	private static int day1part2(List<Integer> pList) {
		int counter = 0;
		int sumNew = 0;
		int sumPrevious = 0;
		for(int i = 0;i<pList.size();i++) {
			if(i+2<pList.size()) {
				sumNew = pList.get(i)+pList.get(i+1)+pList.get(i+2);
				if(sumNew>sumPrevious && sumPrevious>0) {
					counter++;
				}
				sumPrevious = sumNew;
			}

		}
		return counter;
	}
	private static List<Integer> readFile(String pFileName){
		List<Integer> list = new ArrayList<Integer>();
		// File path is passed as parameter
        File file = new File( System.getProperty("user.dir")+"\\"+pFileName);
 
        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
 
        // Creating an object of BufferedReader class
        BufferedReader br;
        try {
        	br = new BufferedReader(new FileReader(file));

        	// Declaring a string variable
        	String st;
        	// Consition holds true till
        	// there is character in a string

        	while ((st = br.readLine()) != null) {
//        		System.out.println(st);
        		list.add(Integer.valueOf(st));
        	}

        	// Print the string

        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
    }
	
}
