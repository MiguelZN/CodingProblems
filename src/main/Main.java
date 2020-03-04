package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import main.CodingProblems.ListNode;

public class Main {
	public static void main(String args[]) {
		/*Problem: Finds the largest increasing sequence*/
		int a[] = //{4,4,4,5,3,234,324,2,0,-1,5,3,3,6};
			{7, 8, 10, 2, -3, 3, 6, 7, 55, 41, 76};
		//CodingProblems.findLargestIncrSequence(a);
		//----------------------------------------------
		/*Leet Code Problem 1: Two Sum*/
		/*Approach:
		 * 1) Loop through array and add all numbers into hashmap
		 * 2) Loop again and do: target-current element
		 */
		int p15[]= {5,5,11,15};
		//System.out.println(CodingProblems.twoSum(p15, 26));
		
		//----------------------------------------------
		/*Leet Code Problem 2: Add Two Numbers*/
		/*Approach:
		 *
		 */
		ListNode n1a = new ListNode(9);
		ListNode n1b = new ListNode(3);
		ListNode n1c = new ListNode(9);
		n1b.next = n1a;
		n1c.next = n1b;
		
		//CodingProblems.printListNode(n1c);
		
		ListNode n2a = new ListNode(9);
		ListNode n2b = new ListNode(9);
		ListNode n2c = new ListNode(9);
		n2b.next = n2a;
		n2c.next = n2b;
		
		ListNode n3a = new ListNode(8);
		ListNode n3b = new ListNode(6);
		n3b.next = n3a;

		
		//CodingProblems.printListNode(n3b);
		//CodingProblems.printListNode(CodingProblems.addTwoNumbers(n1c, n2c));
		
		//----------------------------------------------
		/*Leetcode Problem 3: 3. Longest Substring Without Repeating Characters
		 * Given a string, find the length of the longest 
		 * substring without repeating characters.
		 * EX: "abcabcbb" == 3  "abc"
		 */
		String p3 = "aab";
		System.out.println(CodingProblems.lengthOfLongestSubstring(p3));
		
		//----------------------------------------------
		/*Leetcode Problem 4: Median of two sorted arrays*/
		int nums1[] = {1,3};
		int nums2[] = {2};
		//CodingProblems.findMedianSortedArrays(nums1, nums2);
		
		//----------------------------------------------
		//Leetcode Problem 5: Longest Palindromic Substring
		String p5 = "abdaaaddfs";
		
		//WORKS but Time Complexity: O(n^3) 
		//CodingProblems.longestPalindrome1(p5); 
		//WORKS but Time Complexity: O(2n^2)
		//CodingProblems.longestPalindrome2(p5); 
		//CodingProblems.longestPalindrome3(p5); 
		
		//----------------------------------------------
		/*Leetcode Problem 15: 3Sum*/
		/*Approach
		 * Use a hashmap, store all possible numbers
		 * 
		 * Pick n*n-1*n-2 all possibilities
		 * Pick 1 number, pick 2nd number
		 * Pick a 3rd number
		 */
		
		
		
		
	}
}
