import java.util.*;

public class ShortestPath{
	static int ROW;
	static int COL;
	public static void main(String[] args) {
		int[][] M = new int[][]{
			{0, 1, 0, 1},
			{1, 0, 1, 1},
			{0, 1, 1, 1},
			{1, 1, 1, 1}
		};

		ROW = M.length;
		COL = M[0].length;

		Point src = new Point(0, 3);
		Point dest = new Point(3, 0);
		System.out.println(BFS(M, src, dest));
	}

	static class Point{
		int x;
		int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	static class Node{
		Point pt;
		int dist;

		public Node(Point pt, int dist){
			this.pt = pt;
			this.dist = dist;
		}
	}

	static int[] rowD = new int[]{-1, 0, 0, 1};
	static int[] colD = new int[]{0, -1, 1, 0};
	public static int BFS(int[][] M, Point src, Point dest){

		// Edge Case
		if (M[src.x][src.y] == 0 || M[dest.x][dest.y] == 0){
			return -1;
		}

		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[ROW][COL];

		visited[src.x][src.y] = true;
		Node s = new Node(src, 0);
		q.add(s);

		while (!q.isEmpty()){
			Node curr = q.peek();
			Point pt = curr.pt;
			if (pt.x == dest.x && pt.y == dest.y){
				return curr.dist;
			}

			q.remove();

			for (int i=0; i<4; i++){
				int row = pt.x + rowD[i];
				int col = pt.y + colD[i];
				if (isvalid(row, col) && M[row][col] == 1 && !visited[row][col]){
					visited[row][col] = true;
					Node adjcell = new Node(new Point(row, col), curr.dist+1);
					q.add(adjcell);
				}
			}
		}

		return -1;

	}

	public static boolean isvalid(int row, int col){
		return (row>=0 && row<ROW) && (col>=0 && col<COL);
	}
}