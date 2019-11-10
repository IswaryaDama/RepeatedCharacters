package com.stackroute;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RepeatedCharacter {

   	//Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
   	//Use Scanner to get input from console
      String input;
      Scanner s =new Scanner(System.in);
      input = s.nextLine();
     Character result = findRepeatedCharacter(input);
     if(result == '0') {
    	 System.out.println("No Characters Repeated");
     }else {
      System.out.println(result);
	}
    }
	public static Character findRepeatedCharacter(String input) {
		//if(input.isEmpty() )
		if(input.isEmpty() || input ==null) {
			return '0';
		}
		char[] strArray = input.toCharArray();
		Character ch = null;
		int count = 0;
		
		HashMap<Character,Integer> inputMap = new HashMap<>();
		
		for(char c : strArray) {
			if(inputMap.containsKey(c)) {
				inputMap.put(c, inputMap.get(c)+1);
			}
			else {
				inputMap.put(c, 1);
			}
			
		}
		
		Set<Entry<Character,Integer>> entry = inputMap.entrySet();
		for(Entry<Character,Integer> en : entry) {
			if(en.getValue()>count) {
				ch = en.getKey();
				count = en.getValue();
			}else if(en.getValue()== count) {
				
				if(en.getKey() < ch) {
					ch = en.getKey();
					
				}
			}
		}
		
		if(count == 0) {
			return '0';
		}
		return ch;
	}
	
	
}