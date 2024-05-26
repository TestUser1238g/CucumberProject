package Vibrant.DriverFactory;

import java.util.Arrays;

public class Testing {
	
	public static void reverse(int left,int right, int a[]) {
		while(left<right) {
			int temp=a[left];
			a[left]=a[right];
			a[right]=temp;
			left++;
			right--;
		}
		
	}
	
	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5,6,7};
		int k=1;
		reverse(0,nums.length-1,nums);
		reverse(0,k,nums);
		reverse(k+1,nums.length-1,nums);
		System.out.println(Arrays.toString(nums));
		}
	}
