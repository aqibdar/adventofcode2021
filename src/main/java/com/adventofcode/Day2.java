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
public class Day2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = readFile("cordinates.txt");
		System.out.print(list.size());
		composeCordinatesArrays(list);
	}
	

	private static void composeCordinatesArrays(List<String> pList) {
		int aim = 0;
		List<Integer> forwardList = new ArrayList<Integer>();
		List<Integer> downList = new ArrayList<Integer>();
		List<Integer> upList = new ArrayList<Integer>();
		List<Integer> increased_depth = new ArrayList<Integer>();
		for(String cord: pList) {
			String[] cordArray = cord.split(" ");
			if(cordArray[0].equalsIgnoreCase("up")) {
				upList.add(Integer.valueOf(cordArray[1]));
				aim-=Integer.valueOf(cordArray[1]);
			}else if(cordArray[0].equalsIgnoreCase("down")) {
				downList.add(Integer.valueOf(cordArray[1]));
				aim+=Integer.valueOf(cordArray[1]);
			}else {
				forwardList.add(Integer.valueOf(cordArray[1]));
				int increase_depth = aim*Integer.valueOf(cordArray[1]);
				increased_depth.add(increase_depth);
			}
		}
		int forwardSum = sumOfList(forwardList);
		int downSum = sumOfList(downList);
		int upSum = sumOfList(upList);
		int increased_Depth= sumOfList(increased_depth);
		
		System.out.println("Horizontal Sum"+forwardSum);
		System.out.println("Down Sum"+downSum);
		System.out.println("Up Sum"+upSum);
		System.out.println("increased_Depth"+increased_Depth);
		
		int total_depth = downSum-upSum+increased_Depth;
		System.out.println("Total Depth"+total_depth);
		System.out.println("Answer"+increased_Depth*forwardSum);
	}
	
	private static int sumOfList(List<Integer> pList) {
		int total_sum = 0;
		for(int num: pList) {
			total_sum+=num;
		}
		return total_sum;
	}
	private static List<String> readFile(String pFileName){
		List<String> list = new ArrayList<String>();
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
        		list.add(st);
        	}

        	// Print the string

        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
    }
	
}
