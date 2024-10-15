public class Main {
    static char[][] matrix = new char[3][3];
    public static void clearMatrix(){
        for(int i = 0;i < 3; i++){
            for(int j = 0;j < 3; ++j){
                matrix[i][j] = '-';
            }
        }
    }
    public static void displayMatrix(){
        for(int i = 0;i < 3; ++i){
            for (int j = 0;j < 3; ++j){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void play(){
        clearMatrix();
        displayMatrix();
    }

    public static void main(String[] args) {
        play();
    }
}