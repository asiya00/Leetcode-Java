public class IslandCount{
	static private int ROW;
	static private int COL;

	public int countI(int[][] M){
		ROW = M.length;
		COL = M[0].length;
		int count = 0;
		boolean[][] visited = new boolean[ROW][COL];
		for (int i = 0; i<ROW; i++){
			for (int j = 0; j<COL; j++){
				// Condition for dfs
				if (M[i][j]==1 && !visited[i][j]){
					DFS(M, i, j, visited);
					count += 1;
				}
			}
		}
		return count;
	}

	public void DFS(int[][] M, int row, int col, boolean[][] visited){
		int rowD[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
		int colD[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
		visited[row][col] = true;

		for (int k=0; k<8; k++){
			if (isSafe(M, row+rowD[k], col+colD[k], visited)){
				DFS(M, row+rowD[k], col+colD[k], visited);
			}
		}
	}

	public boolean isSafe(int[][] M, int row, int col, boolean[][] visited){
		return (row >= 0 && row < ROW) && (col >= 0 && col < COL) && (M[row][col] == 1 && !visited[row][col]);
	}

	public static void main(String[] args) {
		IslandCount island = new IslandCount();
		int[][] M = new int[][]{
			{1, 1, 0, 0, 0},
			{0, 1, 0, 0, 1},
			{1, 0, 0, 1, 1},
			{0, 0, 0, 0, 0},
			{1, 0, 1, 0, 1}
		};

		System.out.println(island.countI(M));
	}
}

