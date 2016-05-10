
public class TicTacToe{
	/**
	 * Tic tac toe games
	 * derived from CS61B courses on youtube
	 * https://www.youtube.com/watch?v=hEEzZ-XwZi4&list=PL-XXv-cvA_iAlnI-BQr9hjqADPBtujFJd&index=11
	 * Using simple pruning and alpha-beta pruning combined
	 */

	private final static int BOARD_SIZE = 3;

	public void move(int[][] board, boolean turn){
		if(!turn)
			// not your turn
			return;
		int maxGrade = Integer.MIN_VALUE;
		int mi=0, mj=0;
		for(int i=0; i<BOARD_SIZE; ++i)
			for(int j=0; j<BOARD_SIZE; ++j){
				if(board[i][j] == 0){
					// could move here
					board[i][j] = 1;
					int grade = minMaxGrade(board, 1, maxGrade);
					board[i][j] = 0;
					if(grade == 1)
						return;
					if(grade > maxGrade){
						maxGrade = grade;
						mi = i;
						mj = j;
					}
				}
			}
		board[mi][mj] = 1;
	}
	
	/**
	 * Rank each status of the board according to the turn
	 * if in computer turn, choose the max value of each child situation
	 * otherwise choose the min value
	 * turn = 1 if in computer's turn
	 * -1 in human's turn
	 */
	private int minMaxGrade(int[][] board, int turn, int lastLevel){
		int levelGrade = turn > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		for(int i=0; i<BOARD_SIZE; ++i)
			for(int j=0; j<BOARD_SIZE; ++j){
				if(board[i][j] == 0){
					// could move here
					board[i][j] = turn;
					int grade = minMaxGrade(board, -turn, levelGrade);
					board[i][j] = 0;
					// simple pruning
					if(grade == turn)
						return turn;
					// alpha-beta pruning
					if((turn<0 && grade<=lastLevel) || (turn>0 && grade >= lastLevel))
						return grade;
					levelGrade = turn > 0 ? Math.max(grade, levelGrade) : Math.min(grade, levelGrade);
				}
			}
		return 0;
	}
	
	public static void main(String[] args){
		// initialize board size equals 3
		// computer in the first turn, humans are in the next
		// true means your turn
		// board[i][j] = 1 means there's a chess of computer on i,j
		// board[i][j] = -1 means there's a chess of human on i,j
		int[][] board = new int[BOARD_SIZE][BOARD_SIZE]; 
	}
}
