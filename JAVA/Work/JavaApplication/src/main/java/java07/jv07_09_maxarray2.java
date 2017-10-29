package java07;

public class jv07_09_maxarray2 {
	
	public static void main(String[] args) {
		int[] ar = {2, 3, 7, 1, 4};
		
		java.util.Arrays.sort(ar);
		
		for(int i=0; i<ar.length; i++) {
			System.out.print(ar[i]);
		}
		int ma = max(ar);
		System.out.println();
		System.out.println(ma);
		
		
		
	}
	public static int max(int[] arr) {
		int max = arr[arr.length-1];
		
		return max;
		
	}

}
