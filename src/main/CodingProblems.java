package main;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CodingProblems {
	
	/*Leet Code Problem 1: Two Sum (WORKS)*/ 
	/*Approach:
	 * 1) Loop through array and add all numbers into hashmap
	 * 2) Loop again and do: target-current element
	 */
	 public static int[] twoSum(int[] nums, int target) {
		 HashMap<Integer, Integer> hold_nums = new HashMap<>(); 
		 for(int i=0;i<nums.length;i++) {
			 int x = nums[i];
			 
			if(!hold_nums.containsKey(x)) {
				hold_nums.put(x,i);
			}
		 }  
		 
		 for(int i=0;i<nums.length;i++) {
			 int want = target-nums[i];
			 int arr[] = new int[2];
			 
			if(hold_nums.containsKey(want)) {
				int index_want = hold_nums.get(want);
				
				if(index_want!=i) {
					arr[0] = i;
					arr[1] = index_want;
					
					System.out.println("["+i+","+index_want+"]");
					
					return arr;
				}
				
			}
		 } 
		 return null;
	 }
	//----------------------------------------------
	 /*Leetcode Problem 2: Add Two Numbers: (WORKS)
	  * You are given two non-empty linked lists representing two 
	  * non-negative integers. The digits are stored in reverse 
	  * order and each of their nodes contain a single digit. Add 
	  * the two numbers and return it as a linked list.
	  * You may assume the two numbers do not contain any 
	  * leading zero, except the number 0 itself.
	  */
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode combined = null;
		 int carry_over=0;
		 
		 ListNode c1 = l1;
		 ListNode c2 = l2;
		 
		 while(true) {
	
			 
			 //Both not null
			 if(c1!=null && c2!=null) {
				 int combined_val = c1.val+c2.val;
				 
				 if(carry_over>0) {
					 combined_val+=carry_over;
					 carry_over =0;
				 }
				 
				 int remainder = combined_val%10;
				 
				 if(combined_val>=10) {
					 carry_over+=1;
				 }
				 
				 ListNode new_node = new ListNode(remainder);
				 System.out.println("NEW NODE:"+remainder);
				 
				 
				 //Attach a new node
				 combined = CodingProblems.addListNode(combined, new_node);
				 
				 
				 c1 = c1.next;
				 c2 = c2.next;
	 
			 }
			 else if(c1!=null && c2==null) {
				 int combined_val = c1.val;
				 
				 if(carry_over>0) {
					 combined_val+=carry_over;
					 carry_over =0;
				 }
				 
				 int remainder = combined_val%10;
				 
				 if(combined_val>=10) {
					 carry_over+=1;
				 }
				 
				 ListNode new_node = new ListNode(remainder);
				 
				 //Attach a new node
				 CodingProblems.addListNode(combined, new_node);
				 
				 
				 
				 c1 = c1.next;
			 }
			 else if(c1==null && c2!=null) {
				 int combined_val = c2.val;
				 
				 if(carry_over>0) {
					 combined_val+=carry_over;
					 carry_over =0;
				 }
				 
				 int remainder = combined_val%10;
				 
				 if(combined_val>=10) {
					 carry_over+=1;
				 }
				 
				 ListNode new_node = new ListNode(remainder);
				 
				 //Attach a new node
				 CodingProblems.addListNode(combined, new_node);
				 
				 
				 
				 
				 c2 = c2.next;
			 }
			 //Break out of loop if finished looping through both lists
			 else if(c1==null && c2==null) {
				 System.out.println("BOTH NODE LISTS NULL");
				 break; 
			 }
		 }
		 
		 if(carry_over>0) {
			 System.out.println("CARRY OVER");
			 
			 ListNode new_node = new ListNode(carry_over);
			 CodingProblems.addListNode(combined, new_node);
		 }
		 
		 
		 return combined;
	 }
	 
	 public static void printListNode(ListNode ln) {
		 ListNode temp = ln;
		 int i = 0;
		 
		 while(temp!=null) {
			 System.out.printf("Node: %d|val: %d\n",i, temp.val);
			 
			 i+=1;
			 temp = temp.next;
		 }
	 }
	 
	 //Returns the newly appended node list
	 public static ListNode addListNode(ListNode curr_node, ListNode new_node) {
		 if(curr_node==null) {
			 System.out.println("Current node is null");

			 curr_node = new_node;
		 }
		 else {
			 ListNode temp = curr_node; //starts at beginning
			 
			 //Loops until next is null
			 System.out.println("Adding new node..");
			 while(temp.next!=null) {
				 System.out.println("Node:"+temp.val);
				 
				 temp = temp.next;
			 }
			 
			 
			 if(temp.next==null) {
				 temp.next = new_node;
				 System.out.println("Adding:"+new_node.val);
			 }
			 
			 
		 }
		 
		 return curr_node;
	 }
	 
	 public static class ListNode {
		 int val;
		 ListNode next = null;
		 ListNode(int x) 
		 { val = x; }
	 }
	//----------------------------------------------
		 /*Leet Code Problem 3. Longest Substring (WORKS) 
		  * Without Repeating Characters
		  * 
		  * Approach:
		  * 1) Loop through the entire string: O(n)
		  * 2) Add all unique characters to a hashmap (1)
		  * 3) Recheck every iteration to see if the current character
		  * is within the hashmap
		  * 4) If the character is within hashmap, reset and begin the for loop
		  * at the first character the duplicate was found
		  * 5) Also keeping track 
		  */
	 public static int lengthOfLongestSubstring(String s) {
		 HashMap<Character, Integer> all_chars= new HashMap<>();
		 int largest =0;
		 int current_largest = 0;
		 int index_start = -1;
		 
		 for(int i=0;i<s.length();i++) {
			 char current_char = s.charAt(i);
			 
			 if(!all_chars.containsKey(current_char)) {
				 all_chars.put(current_char,1);
				 current_largest +=1;
				 
				 //Reset where the index started
				 if(index_start==-1) {
					 index_start = i;
				 }
				 
				 if(largest<current_largest) {
					 largest = current_largest;
				 }
			 }
			 else if(all_chars.containsKey(current_char)) {
				 current_largest = 0;
				 all_chars.clear();
				
				 i = index_start;
				 index_start = -1;
			 }
		 }
		 
		 return largest;
	 }
	//----------------------------------------------
	 /*Leet Code Problem 10: Regular Expression Matching
	  * Approach:
	  * 1) Compare single string character at each index s, with p
	  * 2) 
	  */
	 public boolean isMatch(String s, String p) {
		
		 
		 return false;     
	 }
	 
	 
	//----------------------------------------------
	/*Problem: Find the largest increasing sequence*/
	public static void findLargestIncrSequence(int a[]){
	    int length = a.length;
	    int curr_length = 0;
	    Integer last_n = null;
	    
	    int largest_sequence = 0;
	    LinkedList<Integer> largest_list = null;
	    
	    LinkedList<Integer> curr_list = new LinkedList<>();
	    for(int i=0;i<length;i++){
	    	System.out.println("CURRENT:"+a[i]+", LAST N:"+last_n);
	        if(i==0){
	            last_n = a[i];
	            curr_length= 1;
	            curr_list.add(a[i]); //adds integer to list
	        }
	        else if(a[i]>last_n){
	            curr_list.add(a[i]); //push the largest number to the back
	            System.out.println("ADDING:"+a[i]);
	            curr_length++;
	        }
	        else if(a[i]<last_n){
	        	System.out.println("CURR IS LESS");
	            if(curr_length>largest_sequence){
	                largest_sequence = curr_length;
	                largest_list = curr_list;
	            }
	            curr_list = new LinkedList<>();
	            curr_length = 1;
	            curr_list.add(a[i]);
	            
	        }
	        last_n = a[i];
	    }
	    
	    System.out.println("LARGEST SEQUENCE:"+ largest_list + ", Length:"+largest_list.size());
	}
	
	
	/*Leetcode Problem 4: Median of two sorted arrays--------------*/
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*Approach:
         * Have to combine the two sorted arrays together into one:
         * Complexity must be <= Log(m+k) 
         * 
         * 1) Loop through both arrays at the same time and only continue through
         * if they are at the same number:
         * EX: 
         * A1: 0 1 1 1 5 5 6 7
         * A2: 5 5 6 6 9 9 9 9
         * 
         * Thus loop through and increase the pointer of A1 then once both at the same compare
         */
		
		int combined_arr[] = CodingProblems.createCombinedArrayTwoSorted(nums1, nums2);
		System.out.println(combined_arr);
		System.out.println("Array Length:"+combined_arr.length);
		
		int half_length = (int)Math.floor(combined_arr.length/2);
		double median;
		
		//Even length array
		if(combined_arr.length%2==0) {
			int n1 = combined_arr[half_length-1];
			int n2 = combined_arr[half_length];
			
			System.out.printf("N1:%d, N2:%d\n", n1,n2);
			//EX: 0,1,2,3 == length 4/2 == 2 == two numbers can be median
			//index: halflength-1 and index: half_length, must add together and divide by 2
			
			median = (n1+n2)/2.0;
		}
		//Odd length array
		else {
			median = combined_arr[half_length];
			//EX: 0,1,2,3,4 == length 5/2 == 2.5 == 2 floored == 2 is median
		}
		
		System.out.println(median);
		
		return median;
    }
	
	public static int[] createCombinedArrayTwoSorted(int[] nums1, int[] nums2) {
		int p1 = 0; //0th index for A1
		int p2 = 0; //0th index for A2
		
		int combined_length = nums1.length+nums2.length;
		
		int combined_arr[] = new int[nums1.length+nums2.length]; //Combined array
		for(int i =0; i<combined_length;i++) {
			
			System.out.printf("P1:%d, P2:%d, i:%d\n", p1,p2,i);
			if(p1<nums1.length && p2<nums2.length) {
				System.out.println("N1:"+nums1[p1]+", N2:"+nums2[p2]);
				if(nums1[p1]<nums2[p2]) {
					combined_arr[i] = nums1[p1];
					
					
					p1++;
				}
				else if(nums2[p2]<nums1[p1]) {	
					combined_arr[i] = nums2[p2];
					p2++;
				}
				else if(nums1[p1]==nums2[p2]) {
					combined_arr[i] = nums1[p1]; //does not matter which array to pick since currently have the same number	
					//p1++;
					p2++;
				}
			}
			
			else if(p1<nums1.length && !(p2<nums2.length)) {
				combined_arr[i] = nums1[p1];
				
				p1++;
			}
			
			else if(p2<nums2.length && !(p1<nums1.length)) {
				combined_arr[i] = nums2[p2];
				
				p2++;
			}
		}
		
		return combined_arr;
	
	}
	
	
	
	/*Leet Code Problem 5: Longest Palindromic Substring*/
	public static String longestPalindrome1(String s) {
        int longest = 0;
        String longest_palindrome = "";
        
        //Loops through each position
        for(int i =0;i<s.length();i++) {
        	String current="";
        	
        	//Loops and appends letters to a string
        	for(int k=i;k<s.length();k++) {
        		current+=s.charAt(k);
        		
        		if(current.equals(CodingProblems.reverseString(current))&& current.length()>longest) {
        			longest = current.length();
        			longest_palindrome = current;
        		}
        	}
        }
        
        System.out.println("Longest Palindrome:"+longest_palindrome);
        
        return longest_palindrome;
    }
	
	public static String longestPalindrome2(String s) {
        int longest = 0;
        String longest_palindrome = "";
        
        HashMap<String, Integer> all_substrings = new HashMap<>();
        
        //Loops through each position
        for(int p =0;p<s.length();p++) {
        	String current="";
        	
        	//Loops and appends letters to a string
        	for(int k=p;k<s.length();k++) {
        		current+=s.charAt(k);
        	
        		if(!all_substrings.containsKey(current)) {
        			all_substrings.put(current,p);
        		}	
        	}
        }
        
      //Loops through each position
        for(int p =s.length()-1;0<=p;p--) {
        	String current="";
        	
        	//Loops and appends letters to a string
        	for(int k=p;0<=k;k--) {
        		current+=s.charAt(k);
        	
        		if(all_substrings.containsKey(current)) {
        			
        			//Checking if it's the same string by checking their positions
        			int forward_position = all_substrings.get(current);
        			int backwards_position = k; 
        			
        			//If they are the same string at the same position then
        			//Check the length of the string and if its the longest palindromic
        			//Then save it as the longest palindromic substring
        			if(forward_position==backwards_position) {
        				if(current.length()>longest) {
        					longest = current.length();
        					longest_palindrome = current;
        				}
        			}
        		}	
        	}
        }
        
        System.out.println("Longest Palindrome:"+longest_palindrome);
        
        return longest_palindrome;
    }
	
	public static String longestPalindrome3(String s) {
        int longest = 1;
        String longest_palindrome = "";
        
        if(s.equals("")) {
        	return "";
        }
        else {
        	longest_palindrome += s.charAt(0);
        }
        
        //Approach O(n):
        /*1) Loop through each index
         * 2) Then check Left and Right and compare them
         * 3) If Left != Right: go to next index
         * 4) If Left == Right: go compare next Left and Right
         */
        
        for(int p=0;p<s.length();p++) {
        	boolean equal_sides = true;
        	
        	int LR_offset = 1;
        	int curr_length = 1;//current char

        	while(equal_sides) {
        		int left_index = p-LR_offset;
        		int right_index = p+LR_offset;
        		
        		
        		//Handles cases where len(palindrome)==2
        		if(right_index<=s.length()-1) {
        			char right = s.charAt(right_index);
        			char current = s.charAt(p);
        			
        			if(right==current && longest<2) {
        				curr_length = 2;
        				longest = 2;
        				longest_palindrome = s.substring(p, p+curr_length);
        			}
        			else {
        				equal_sides = false;
        			}
        			
        		}
        		
        		//Handles cases where len(palindrome)>=3
        		if(left_index>=0 && right_index>=0 && left_index<=s.length()-1 && right_index<=s.length()-1) {
        			char left = s.charAt(left_index);
        			char right = s.charAt(right_index);
        			
        			//equal sides
        			if(left==right) {
        				LR_offset+=1;
        				
        				curr_length+=2;
        				
        				if(curr_length>longest) {
        					longest = curr_length;
        					System.out.printf("P:%d, L:%d, R:%d, Curr_length:%d\n",p,left_index, right_index, s.length());
        					System.out.println("LRoffset:"+LR_offset);
        					longest_palindrome = s.substring(p-(LR_offset/2), p+(LR_offset/2)+1);
        				}
        			}
        			else if(left!=right) {
        				equal_sides = false;
        			}
        		}
        		else {
        			equal_sides = false;
        		}
        	}
        }
        System.out.println("Longest Palindrome:"+longest_palindrome);

   
        return longest_palindrome;
    }
	
	public static String reverseString(String s) {
		String reversed = "";
		for(int r = s.length()-1;0<=r;r--) {
			reversed += s.charAt(r);
		}
		
		return reversed;
	}
	
	
	/*Leetcode Problem 15: 3Sum*/
	/*Given an array nums of n integers, are there elements a, b, c 
	 * in nums such that a + b + c = 0? Find all unique triplets in 
	 * the array which gives the sum of zero
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		HashMap<Integer, Integer> hold_numbers = new HashMap<>();
		
		
		//Puts all the numbers in a hashmap for easy lookup
		for(int i=0;i<nums.length;i++) {
			
			if(!hold_numbers.containsKey(nums[i])) {
				hold_numbers.put(nums[i], 1);
			}
			else {
				int cur_val = hold_numbers.get(nums[i])+1;
				hold_numbers.put(nums[i], cur_val);
			}
		}
		
		for(Map.Entry<Integer, Integer> entries: hold_numbers.entrySet()) {
			
		}
		
		return null;
    }
	
	
	
}
