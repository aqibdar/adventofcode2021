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
public class Day3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = readFile("day3input.txt");
		System.out.print(list.size());
		solutionPart1(list);
		
	}
	

	private static void solutionPart1(List<String> pList) {
		int first_place_zeros = processBinary(pList,0);
		int second_place_zeros = processBinary(pList,1);
		int third_place_zeros = processBinary(pList,2);
		int forth_place_zeros = processBinary(pList,3);
		int fifth_place_zeros = processBinary(pList,4);
		int sixth_place_zeros = processBinary(pList,5);
		int seventh_place_zeros = processBinary(pList,6);
		int eight_place_zeros = processBinary(pList,7);
		int ninth_place_zeros = processBinary(pList,8);
		int tenth_place_zeros = processBinary(pList,9);
		int eleven_place_zeros = processBinary(pList,10);
		int twelve_place_zeros = processBinary(pList,11);
	
//		System.out.println("Zeros in First Place::"+first_place_zeros);
//		System.out.println("Zeros in Second Place::"+second_place_zeros);
//		System.out.println("Zeros in Third Place::"+third_place_zeros);
//		System.out.println("Zeros in Fourth Place::"+forth_place_zeros);
//		System.out.println("Zeros in Fifth Place::"+fifth_place_zeros);	
		
		String gamaRateStr = getGamaRate(pList.size(), first_place_zeros)+getGamaRate(pList.size(), second_place_zeros)+getGamaRate(pList.size(), third_place_zeros)+getGamaRate(pList.size(), forth_place_zeros)+getGamaRate(pList.size(), fifth_place_zeros)
		+getGamaRate(pList.size(), sixth_place_zeros)+getGamaRate(pList.size(), seventh_place_zeros)+getGamaRate(pList.size(), eight_place_zeros)+getGamaRate(pList.size(), ninth_place_zeros)+getGamaRate(pList.size(), tenth_place_zeros)+getGamaRate(pList.size(), eleven_place_zeros)+getGamaRate(pList.size(), twelve_place_zeros);
		String epsilonRate =reverseBinary(gamaRateStr);
		
		int gamaRateInt =Integer.parseInt(gamaRateStr,2);
		int epsilonRateInt =Integer.parseInt(epsilonRate,2);
		
		int sum = gamaRateInt*epsilonRateInt;
		
		System.out.println("ANSWER IS ::"+sum);
	}
	private static int processBinary(List<String> pList, int pIndex) {
		int count_zeros = 0;
		for(String cord: pList) {
			char[] charArray = cord.toCharArray();
			int val = Character.getNumericValue(charArray[pIndex]);
			if(val==0) {
				count_zeros++;
			}
		}
		return count_zeros;
	}
	
	
	private static String getGamaRate(int pTotalNumbers, int pTotalZeros) {
		int total_ones = pTotalNumbers-pTotalZeros;
		if(total_ones>pTotalZeros) {
			return "1";
		}else {
			return "0";
		}
	}
	private static String reverseBinary(String pBnary) {
		String composeReverse ="";
		char[] binaryArray = pBnary.toCharArray();
		for(int i =0;i<binaryArray.length;i++) {
			int val = Character.getNumericValue(binaryArray[i]);
			if(val==0) {
				composeReverse=composeReverse+"1";
			}else {
				composeReverse=composeReverse+"0";
			}
		}
		return composeReverse;
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
