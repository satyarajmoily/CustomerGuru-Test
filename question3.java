import java.util.*;
import java.lang.*;
import java.io.*;

class MergeArray
{
    
    public static int[] merge(int[] a, int[] b) {
    int[] answer = new int[a.length + b.length];
    int i = a.length - 1, j = b.length - 1, k = answer.length;

    while (k > 0)
        answer[--k] = 
            (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
          return answer;  
            
}

	public static void main (String[] args) throws java.lang.Exception
	{
		int[] A = {1,2,3,4,5,6,7,8};
		int[] B = {2,3,4,4,5,6,8,9,9};
		
		int[] C = merge(A,B);
		for(int i=0; i<C.length;i++)
		System.out.print(C[i]);
	}
}
