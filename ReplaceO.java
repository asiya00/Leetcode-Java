public class ReplaceO{
	static int ROW;
	static int COL;

	public static void main(String[] args) {
		String[][] M = new String[][] {
			{"X", "O", "X", "X", "X", "X"},
			{"X", "O", "X", "X", "O", "X"},
			{"X", "X", "X", "O", "O", "X"},
			{"O", "X", "X", "X", "X", "X"},
			{"X", "X", "X", "O", "X", "O"},
			{"O", "O", "X", "O", "O", "O"}
		};

		ROW = M.length;
		COL = M[0].length;

		boolean[][] visited = new boolean[ROW][COL];

		for (int i=0; i<COL; i++){
			if (M[0][i].equals("O") && !visited[0][i]){
				M[0][i] = "-";
				DFS(M, 0, i, visited);
			}
		}

		for (int i=0; i<ROW; i++){
			if (M[i][0].equals("O") && !visited[i][0]){
				M[i][0] = "-";
				DFS(M, i, 0, visited);
			}
		}

		for (int i=0; i<COL; i++){
			if (M[ROW-1][i].equals("O") && !visited[ROW-1][i]){
				M[ROW-1][i] = "-";
				DFS(M, ROW-1, i, visited);
			}
		}

		for (int i=0; i<ROW; i++){
			if (M[i][COL-1].equals("O") && !visited[i][COL-1]){
				M[i][COL-1] = "-";
				DFS(M, i, COL-1, visited);
			}
		}

		for (int j=0; j<ROW; j++){
			for (int k=0; k<COL; k++){
				if (M[j][k].equals("-")){
					M[j][k] = "O";
				}else if(M[j][k].equals("O")){
					M[j][k] = "X";
				}
			}
		}

		for (int i=0; i<ROW; i++){
			for (int j=0; j<COL; j++){
				System.out.print(M[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void DFS(String[][] M, int row, int col, boolean[][] visited){

		int rowD[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
		int colD[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
		visited[row][col] = true;

		for (int i=0; i<8; i++){
			if (isSafe(M, row+rowD[i], col+colD[i], visited)){
				M[row+rowD[i]][col+colD[i]] = "-";
				DFS(M, row+rowD[i], col+colD[i], visited);
			}
		}

	}

	public static boolean isSafe(String[][] M, int row, int col, boolean[][] visited){
		return (row>=0 && row<ROW) && (col>=0 && col<COL) && (M[row][col].equals("O") && !visited[row][col]);
	}
}