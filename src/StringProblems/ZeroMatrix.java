public class ZeroMatrix{

    public static void nullifyRow(int[][] matrix, int row){
        for(int i=0;i<matrix[0].length;i++){
            matrix[row][i]=0;
        }
    }

    public static void nullifyColumn(int[][] matrix, int column){
        for(int i=0;i<matrix.length;i++){
            matrix[i][column]=0;
        }
    }
    public static void zeroCheck(int[][] matrix){
        boolean zeroRow = false;
        boolean zeroColumn = false;
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                zeroRow = true;
                break;
            }
        }

        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                zeroColumn = true;
                break;
            }
        }

        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0] =0;
                    matrix[0][j] =0;
                }
            }
        }

        //Nullify columns using zero rows

        for (int i=1; i<matrix[0].length; i++) {
            if(matrix[0][i]==0){
                nullifyColumn(matrix, i);
            }
        }

        for (int i=1; i<matrix.length; i++) {
            if(matrix[i][0]==0){
                nullifyRow(matrix, i);
            }
        }

        if(zeroRow){
            nullifyRow(matrix, 0);
        }

        if(zeroColumn){
            nullifyColumn(matrix, 0);
        }

    }

    public static void printMatrix(int[][] matrix){
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();         
        }
    }
    public static void main(String[] args){
        int row =4;
        int column = 3;
        int[][] matrix = new int[row][column];
        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                matrix[i][j] = (int) (Math.random()*10);
            }           
        }
        System.out.println(matrix.length +" "+matrix[0].length);
        printMatrix(matrix);
        zeroCheck(matrix);
        printMatrix(matrix);
    }
}