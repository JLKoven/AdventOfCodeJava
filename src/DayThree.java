

public class DayThree {

	public static int getDistanceFromOrigin(int stepsFromOrigin) throws Exception {
		
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

}
