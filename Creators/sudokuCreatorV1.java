import java.util.*;

import javax.sound.sampled.SourceDataLine;

class sudokuCreator{

    int[][] sudokuBoard = new int[9][9];
    int difficulty = 0;

    public sudokuCreator(int difficulty){

        this.difficulty = difficulty;

        for(int row=0;row<9;row++){
            for(int column=0;column<9;column++){
                sudokuBoard[row][column] = 0;
            }
        }
    };

    public void boardCreator(){

        for(int number=1;number<=9;number++){

            System.out.println("CURRENT NUMBER IS "+number);

            for(int rowRange = 0; rowRange<3 ; rowRange++){

                for(int columnRange = 0; columnRange<3 ; columnRange++){

                    printBoard();
    
                    rangeFiller(rowRange, columnRange, number);
    
                }
    
            }
        }
        
    }

    public void rangeFiller(int rowRange, int columnRange, int number){

        Random random = new Random();

        int row = rangeSet(rowRange);
        int column = rangeSet(columnRange);

        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();

        for(int i=row; i<(row+3) ;i++){
            for(int j=column; j<(column+3);j++){
                if(!rowChecker(i, number) && !columnChecker(j, number) && sudokuBoard[i][j]==0){
                    rows.add(i);
                    columns.add(j);
                }

            }
        }

        System.out.println("We reached here.");
        printArrayList(columns);

        int randomIndex = random.nextInt(0,rows.size());

        sudokuBoard[rows.get(randomIndex)][columns.get(randomIndex)] = number;

    }

    public ArrayList<Integer> returnRow(int row){
        
        ArrayList<Integer> rowList = new ArrayList<>();
        for(int i=0;i<9;i++){
            rowList.add(sudokuBoard[row][i]);
        }
        return rowList;

    }

    public ArrayList<Integer> returnColumn(int column){
        
        ArrayList<Integer> rowList = new ArrayList<>();
        for(int i=0;i<9;i++){
            rowList.add(sudokuBoard[i][column]);
        }
        return rowList;

    }

    public ArrayList<Integer> returnBox(int row, int column){

        ArrayList<Integer> boxElements = new ArrayList<>();
        int rowRange = rangeSet(row);
        int columnRange = rangeSet(column);

        for(int i=rowRange;i<rowRange+3;i++){
            for(int j=columnRange;j<columnRange+3;j++){
                boxElements.add(sudokuBoard[i][j]);
            }
        }

        return boxElements;

    }

    public int rangeSet(int range){
        int number = 0;

        if(range==0){
            number = 0;
        }else if(range==1){
            number = 3;
        }else{
            number = 6;
        }

        return number;
    }

    public ArrayList<Integer> allowedButNotInSecondList(ArrayList<Integer> possibleNumbers, ArrayList<Integer> columnCheck){
        ArrayList<Integer> allowed = new ArrayList<>();
        for(int i=0;i<possibleNumbers.size();i++){
            if(!columnCheck.contains(possibleNumbers.get(i))){
                allowed.add(possibleNumbers.get(i));
            }
        }
        return allowed;
    }

    public boolean columnChecker(int column, int number){

        for(int row=0;row<9;row++){
            if(sudokuBoard[row][column] == number){
                return true;
            }
        }

        return false;
    }

    public boolean rowChecker(int row, int number){

        for(int column=0;column<9;column++){
            if(sudokuBoard[row][column] == number){
                return true;
            }
        }

        return false;
    }

    public void printArrayList(ArrayList<Integer> current){
        for(int i=0;i<current.size();i++){
            System.out.println(current.get(i));
        }
    }

    public void printBoard(){
        for(int row=0;row<9;row++){
            for(int column=0;column<9;column++){
                System.out.print("| " + sudokuBoard[row][column] + " |");
            }
            System.out.println();
            System.out.println("---------------------------------------------");
        }
    }

}