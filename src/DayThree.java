

public class DayThree {

	public static int getDistanceFromOrigin(int stepsFromOrigin){
		
		//stepsFromOrigin = stepsFromOrigin+1;
		
		int answer=0;
		SpiralGrid grid = new SpiralGrid();
		for (int i=0; i<stepsFromOrigin; i++){
			grid.addCellToGridInitial();
		}
//		System.out.println("  The size of this grid is "+grid.getList().size()+".");
		SpiralGridCell lastCell = grid.getLastCell();
				
				
//				.getList().get((grid.getList().size()-1));
		answer = answer + Math.abs(lastCell.getXCoord());
		answer = answer + Math.abs(lastCell.getYCoord());
		return answer;
	}

	public static  int getCumulativeValueOfThisCell(int index) {
		int answer = 0;
		SpiralGrid grid = new SpiralGrid();
		for (int i=0; i<index; i++){
			grid.addCellToGridInitial();
		}
		SpiralGridCell lastCell = grid.getLastCell();		
		return lastCell.getCellCumulativeValue();
	}
	
	public static  int getFirstCumulativeValueLargerThanThisNumber(int input) {
		int answer = 0;
		int i=0;
		SpiralGrid grid = new SpiralGrid();
		while (input>answer){
			grid.addCellToGridInitial();
			SpiralGridCell lastCell = grid.getLastCell();		
			answer = lastCell.getCellCumulativeValue();
		}
		return answer;
	}

}
