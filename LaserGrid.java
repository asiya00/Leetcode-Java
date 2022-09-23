public class LaserGrid{
	public static void main(String[] args) {
		int initR = 1;
		int initC = 0;
		int finalR = 2;
		int finalC = 3;
		int[] costRows = {1, 2, 3};
		int[] costCols = {4, 5, 6};
		int cost = 0;

		if ((initR <= finalR) && (initC <= finalC)){
			for (int i=initC; i<finalC; i++){
			cost += costCols[i];
			}
			for (int j=initR; j<finalR; j++){
				cost += costRows[j];
			}

			System.out.println(cost);
		}
		else if((initR <= finalR) && (initC >= finalC)){
			for (int i=initR; i<finalR; i++){
			cost += costRows[i];
			}
			for (int j=finalC; j<initC; j++){
				cost += costCols[j];
			}

			System.out.println(cost);
		}
		else if((initR >= finalR && initC <= finalC)){
			for(int i=initC; i<finalC; i++){
				cost += costCols[i];
			}
			for (int j=finalR; j<initR; j++){
				cost += costRows[j];
			}
			System.out.println(cost);

		}else if((initR >= finalR && initC >= finalC)){
			for (int i=finalR; i<initR; i++){
				cost += costRows[i];
			}
			for (int j=finalC; j<initC; j++){
				cost += costCols[j];
			}
			System.out.println(cost);
		}

	}
}