public class Ex5 {
    public static void main(String args[]){
              /*
         * create a two di array which saves
         * use for loop to initialize the array to
         * 10 11 12 13 14
         * 15 16 17 18 19
         * 20 21 22 23 24 
         * 25 26 27 28 29
         * Find out the average of this array
         */
        int [][] b = new int[4][5];
        int counter = 10;
        int sum = 0;
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[i].length;j++){
                b[i][j] = counter++;
                sum += b[i][j];
                System.out.print(a[i][j]+ " ");
            }
        }
    
    }
}
