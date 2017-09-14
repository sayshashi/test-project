package com.polycom.datastructures;

public class EightQueensonCB {

	 	
	public static void main(String[] args) {
		
		EightQueensonCB q = new EightQueensonCB();
		q.start();

	}
	
	private void init(String[][] ChessBoard){
		for(int i=0;i<ChessBoard.length;i++){
					
			 		for(int j=0;j<ChessBoard[i].length;j++)
					{
			 			ChessBoard[i][j]="X " ;
					}
			  
				}
	}
	
	
	private void print(String[][] ChessBoard){
		for(int i=0;i<ChessBoard.length;i++){
					
			 		for(int j=0;j<ChessBoard[i].length;j++)
					{
						System.out.print(ChessBoard[i][j]);
					}
			 		System.out.println();
				}
	}
	
	private void start()
	{
		String[][] ChessBoard = new String[8][8];
		init(ChessBoard);
		
		for(int i=0;i<8;i++)
		{
			placeQueen(0,0,ChessBoard);
		}
	}

	private void placeQueen(int rows,int columns, String[][] chessboard)
	{
		for(int i=rows;i<8;i++)
		{
			for(int j=columns;j<8;j++)
			{
				if(checkPosition(i,j,chessboard)){
					chessboard[i][j]="O ";
				}
				print(chessboard);
				System.out.println();
				i++;
				placeQueen(i,j,chessboard);
			}
		}
		print(chessboard);
	}

	private boolean checkPosition(int i, int j, String[][] chessboard) {
		 
		for(int row=0;row<8;row++)
		{
			if(chessboard[i][row].equals("O "))
				return false;
//			if(chessboard[row][i].equals("O "))
//				return false;
//			if(chessboard[j][row].equals("O "))
//				return false;
			if(chessboard[row][j].equals("O "))
				return false;
			
			int uprow = i - row;
			int upcol = j - row;
			if(uprow>=0 && upcol>=0)
				if(chessboard[uprow][upcol].equals("O "))
					return false;
			
			int downrow = i + row;
			int downcol = j + row;
			
			if(downrow<8 && downcol<8)
				if(chessboard[downrow][downcol].equals("O "))
					return false;
			
		}
		return true;
	}
}
