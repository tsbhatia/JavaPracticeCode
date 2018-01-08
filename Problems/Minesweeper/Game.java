
class Game {
	private Board board;
        private boolean finish;
        private boolean win;
        private int turn;

	public Game() {
		board = new Board();
		play(board);
	}
        
        private void play(Board board){
         while(!finish){
          turn++;
          System.out.println("Turn: "+turn);
          board.show();
          finish = board.setPosition();
          if(!finish){
           board.openNeighbors();
           finish = board.win();
          }
         }
         if(board.win()){
            System.out.println("Congratulations, you let the 10 fields with the mines in "+turn+" turns");
            board.showMines();
         } else {
            System.out.println("Mine! You lost!");
            board.showMines();
         }       
        }

	public static void main(String args[]) {
		Game game = new Game();
	}
}
