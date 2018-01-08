
import java.util.Random;
import java.util.Scanner;

class Board{
  private int[][] mines;
  private char[][] boardgame;
  private int line;
  private int column;
  Random random = new Random();
  Scanner scanner = new Scanner(System.in);

  public Board(){
   mines = new int[10][10];
   boardgame = new char[10][10];
   startBoard();
   startMines();
   fillMines();
   fillTips();
  }

  public void showMines(){
   for(int i=1;i<9;i++){
    for(int j=1;j<9;j++){
     if(mines[i][j]==-1)
       boardgame[i][j]='*';
    }
   }
   show();
  } 

  public void show(){

   System.out.println("Lines");
   for(int i=8;i>0;i--){
    System.out.print("  "+ i+"  ");
    for(int j=1;j<9;j++){
     System.out.print("  "+boardgame[i][j]);
    }
    System.out.println();
   }
   System.out.println("       1  2  3  4  5  6  7  8 ");
   System.out.println("                column");
  }

  private void startBoard(){
   for(int i=1;i<boardgame.length;i++){
    for(int j=1;j<boardgame.length;j++){
     boardgame[i][j]='_';
    }
   }
  }

  private void startMines(){
   for(int i=0;i<mines.length;i++){
    for(int j=0;j<mines.length;j++){
     mines[i][j]=0;
    }
   }
  }

  private void fillMines(){
   boolean raffled;
   for(int i=0;i<10;i++){
     while(true){
       int r = random.nextInt(8)+1;
       int c = random.nextInt(8)+1;
       if(mines[r][c] != -1){
         mines[r][c] = -1;
         break;
       }
     }
   }
  }

  private void fillTips(){
   for(int i=1;i<9;i++){
    for(int j=1;j<9;j++){
     
     for(int ii=-1;ii<=1;ii++){
      for(int jj=-1;jj<=1;jj++){
       if(mines[i][j]!=-1){
         if(mines[i+ii][j+jj]==-1)
           mines[i][j]++;
       }
      }
     }
    }
   }
  }

  private int getPosition(int l, int c){
   return mines[l][c];
  }
  // This take valid line and column input
  // and return if true if it has mine, else false
  public boolean setPosition(){

    while(true){
      System.out.println("Enter Line: ");
      line = scanner.nextInt();
      System.out.println("Enter Column: ");
      column = scanner.nextInt();

      if(line>0 && line<9 && column>0 && column<9){
        if(boardgame[line][column]!='_')
          System.out.println("cell already selected");
        else 
          break;
      }else{
          System.out.println("Choose a number between 1 and 8");
      }
    }
    if(getPosition(line, column)==-1)
      return true;
    else 
      return false;
  }
  
  public boolean win(){
   int count = 0;
   for(int i=1;i<9;i++){
    for(int j=1;j<9;j++){
     if(boardgame[i][j]=='_')
       count++;
    } 
   }
   if(count == 10)
     return true;
   return false;
  }

  public void openNeighbors(){
   for(int i=-1;i<=1;i++){
    for(int j=-1;j<=1;j++){
     if(line != 0 && line != 9 && column != 0 && column != 9)
       if(mines[line+i][column+j]!=-1)
        boardgame[line+i][column+j]=Character.forDigit(mines[line+i][column+j],10);
    }
   }
  }
  
}
