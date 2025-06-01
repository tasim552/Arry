
package arry;

public class Arry {

    public static void main(String[] args) {
        int[][] arry = {
            {1, 5, 1, 5, 1, 5},
            {3, 3, 2, 3, 3, 4},
            {2, 3, 4, 4, 3, 2},
            {2, 2, 3, 2, 2, 4},
            {2, 2, 4, 3, 4, 2},
            {4, 4, 4, 4, 2, 3},
        };

         int[][] max = new int[6][6];
        
        int[][] min = new int[6][6];
        
         int maxvalue = Max(arry, max);
        
        int minvalue = Min(arry, min);
        
        System.out.println("Grid additon Highest and Lowest value: ");
      
       System.out.println("Highest value: " + maxvalue);
        
        System.out.println("Lowest value: " + minvalue);
    }

    private static int Max(int[][] A, int[][] a) {
        for (int row = 0; row < 6; row++) {
           for (int col = 0; col < 6; col++) {
             if (row == 0) {
              a[row][col] = A[row][col];
               } 
             else {
                 int left,right;
                 if(col>0){
                     left = a[row - 1][col - 1];
                 }else{
                     left =0;
                 }
                  
               int middle = a[row - 1][col];
               if(col < A[0].length - 1){
                  right= a[row - 1][col + 1];
               }else{
                   right=0;
               }
   a[row][col] = A[row][col] + Math.max(left, Math.max(middle, right));
                }
            }
        }

        int maxTotal = Integer.MIN_VALUE;
        for (int col = 0; col < A[0].length; col++) {
            maxTotal = Math.max(maxTotal, a[A.length - 1][col]);
        }

        return maxTotal;
    }

    private static int Min(int[][] B, int[][] b) {
        
        for (int row = 0; row < B.length; row++) {
            for (int col = 0; col < B[0].length; col++) {
                
               if (row == 0) {
                   b[row][col] = B[row][col];
                } 
          else {
                  int left, right;
                  if(col>0){
                      left = b[row - 1][col - 1];
                  }else{
                    left=  Integer.MAX_VALUE;
                  }
        int middle = b[row - 1][col];
        if(col < B[0].length - 1){
            right = b[row - 1][col + 1];
        }else{
           right= Integer.MAX_VALUE;
        }
   b[row][col] = B[row][col] + Math.min(left, Math.min(middle, right));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int col = 0; col < B[0].length; col++) {
            min = Math.min(min, b[B.length - 1][col]);
        }

        return min;
    }
}



