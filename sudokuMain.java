import java.util.Scanner;

public class sudokuMain {
    public static void main(String[] args){

        Scanner keyboardInput = new Scanner(System.in);

        sudokuCreator newSudoku = new sudokuCreator(0);

        newSudoku.boardCreator();

        newSudoku.printBoard();
    }
    
}
