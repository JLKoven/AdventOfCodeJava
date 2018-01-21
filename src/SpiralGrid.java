import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class SpiralGrid {

	public static final String RIGHT = "Right";
	public static final String UP = "Up";
	public static final String LEFT = "Left";
	public static final String DOWN = "Down";

	private List<SpiralGridCell> list = new ArrayList<SpiralGridCell>();

	// private double maxDimension = 1.0;
	private int maxX=0;//maxDimensionRIGHT = 0;
	private int maxY=0;//maxDimensionUP = 0;
	private int minX=0;//maxDimensionLEFT = 0;
	private int minY=0;//maxDimensionDOWN = 0;

	private Map<HashMap<Integer, Integer>, SpiralGridCell> mapOfExisting = new HashMap<HashMap<Integer, Integer>, SpiralGridCell>();

	public List<SpiralGridCell> getList() {
		return list;
	}

	public void setList(List<SpiralGridCell> list) {
		this.list = list;
	}

//	public double getMaxDimensionRIGHT() {
//		return maxDimensionRIGHT;
//	}
//
//	public void setMaxDimensionRIGHT(int maxDimensionRIGHT) {
//		this.maxDimensionRIGHT = maxDimensionRIGHT;
//	}
//
//	public double getMaxDimensionUP() {
//		return maxDimensionUP;
//	}
//
//	public void setMaxDimensionUP(int maxDimensionUP) {
//		this.maxDimensionUP = maxDimensionUP;
//	}
//
//	public double getMaxDimensionLEFT() {
//		return maxDimensionLEFT;
//	}
//
//	public void setMaxDimensionLEFT(int maxDimensionLEFT) {
//		this.maxDimensionLEFT = maxDimensionLEFT;
//	}
//
//	public double getMaxDimensionDOWN() {
//		return maxDimensionDOWN;
//	}
//
//	public void setMaxDimensionDOWN(int maxDimensionDOWN) {
//		this.maxDimensionDOWN = maxDimensionDOWN;
//	}

	// public double getMaxDimension() {
	// return maxDimension;
	// }
	//
	// public void setMaxDimension(double maxDimension) {
	// this.maxDimension = maxDimension;
	// }
	//
	// public double getMaxDimensionOneWay() {
	// return maxDimensionOneWay;
	// }
	//
	//
	// public void setMaxDimensionOneWay(double maxDimensionOneWay) {
	// this.maxDimensionOneWay = maxDimensionOneWay;
	// }

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

	public Map<HashMap<Integer, Integer>, SpiralGridCell> getMapOfExisting() {
		return mapOfExisting;
	}

	public void setAlreadyExists(Map<HashMap<Integer, Integer>, SpiralGridCell> alreadyExists) {
		this.mapOfExisting = alreadyExists;
	}

	public boolean isGridCompleteSquare(int input) {
		boolean answer = false;
		int attemptedSquare = (int) Math.sqrt(input);
		if ((attemptedSquare * attemptedSquare == input)
		// && (attemptedSquare % 2== 1)
		) {
			answer = true;
		}
		return answer;
	}

	public void addCellToGridInitial(){

		SpiralGridCell cell = new SpiralGridCell();
		// figure out whether we are going to a new direction or not?
		// if (getList()

		if (getList().isEmpty()) {
			cell.setXCoord(0);
			cell.setYCoord(0);
			cell.setValue(1);
			cell.setCellCumulativeValue(1);
			cell.setNextDirection(RIGHT);
		} else {
			if (getMostRecentCell().isPresent()) {
				SpiralGridCell lastCell = getMostRecentCell().get();
				cell.setValue(lastCell.getValue() + 1);
//				int cumulativeValue = calculateCumulativeValue(cell);
				cell = setDirectionBasedOnPriorDirection(cell, lastCell);
				cell.setCellCumulativeValue(calculateCumulativeValueBruteForce(cell));
			} else {
				System.out.println(
						"Something went very wrong here! You tried to find a cell, but no previous cell exsted");
			}
		}
//		System.out.println("  The cell we are adding to this grid has value " + cell.getValue() + ", x value "
//				+ cell.getXCoord() + " and y value " + cell.getYCoord() + ".");
		
		mapPlacementNoIntPair(cell);



		getList().add(cell);
	}

	private void mapPlacementNoIntPair(SpiralGridCell cell) {
		Map<HashMap<Integer, Integer>, SpiralGridCell> mapToReturn = getMapOfExisting();
		HashMap<Integer, Integer> coordinates = new HashMap<Integer, Integer>();
		coordinates.put(cell.getXCoord(), cell.getYCoord());
//		IntPair intPairCoordinates = new IntPair();
//		intPairCoordinates .setIntOne(cell.getXCoord());
//		intPairCoordinates.setIntTwo(cell.getYCoord());
		if (!mapToReturn.containsKey(coordinates)){
			mapToReturn.put(coordinates, cell);
		} else {
			Exception error = new Exception();
			try {
				throw error;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		setAlreadyExists(mapToReturn);
		
	}

	private int calculateCumulativeValueBruteForce(SpiralGridCell cell) {
		int value=0;
		
//		Map<HashMap<Integer, Integer>, SpiralGridCell> copyOfMapOfExisting = getMapOfExisting();
//		Set<Has
		
		//-1,-1
		Map<Integer, Integer> innerMapLeftDown = new HashMap<Integer, Integer>();
		innerMapLeftDown.put(cell.getXCoord()-1, cell.getYCoord()-1);
		if (getMapOfExisting().containsKey(innerMapLeftDown)){
			value = value+getMapOfExisting().get(innerMapLeftDown).getCellCumulativeValue();
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") does seem to have a neighbor at LeftDown with value of "+value+"!");
		} else {
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") doesn't seem to have a neighbor at LeftDown!");
		}

		//-1,-0
		Map<Integer, Integer> innerMapLeftCenter = new HashMap<Integer, Integer>();
		innerMapLeftCenter.put(cell.getXCoord()-1, cell.getYCoord());
		if (getMapOfExisting().containsKey(innerMapLeftCenter)){
			value = value+getMapOfExisting().get(innerMapLeftCenter).getCellCumulativeValue();
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") does seem to have a neighbor at LeftCenter with value of "+value+"!");
		} else {
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") doesn't seem to have a neighbor at LeftCenter!");
		}
		
		//-1,+1
		Map<Integer, Integer> innerMapLeftUp = new HashMap<Integer, Integer>();
		innerMapLeftUp.put(cell.getXCoord()-1, cell.getYCoord()+1);
		if (getMapOfExisting().containsKey(innerMapLeftUp)){
			value = value+getMapOfExisting().get(innerMapLeftUp).getCellCumulativeValue();
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") does seem to have a neighbor at LeftUp with value of "+value+"!");
		} else {
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") doesn't seem to have a neighbor at LeftUp!");
		}			
		
		//-0,-1
		Map<Integer, Integer> innerMapCenterDown = new HashMap<Integer, Integer>();
		innerMapCenterDown.put(cell.getXCoord(), cell.getYCoord()-1);
		if (getMapOfExisting().containsKey(innerMapCenterDown)){
			value = value+getMapOfExisting().get(innerMapCenterDown).getCellCumulativeValue();			
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") does seem to have a neighbor at Down with value of "+value+"!");
		} else {
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") doesn't seem to have a neighbor at Down!");
		}			
		
		//-0,+1
		Map<Integer, Integer> innerMapCenterUp = new HashMap<Integer, Integer>();
		innerMapCenterUp.put(cell.getXCoord(), cell.getYCoord()+1);
		if (getMapOfExisting().containsKey(innerMapCenterUp)){
			value = value+getMapOfExisting().get(innerMapCenterUp).getCellCumulativeValue();			
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") does seem to have a neighbor at Up with value of "+value+"!");
		} else {
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") doesn't seem to have a neighbor at Up!");
		}			

		//+1,-1
		Map<Integer, Integer> innerMapRightDown = new HashMap<Integer, Integer>();
		innerMapRightDown.put(cell.getXCoord()+1, cell.getYCoord()-1);
		if (getMapOfExisting().containsKey(innerMapRightDown)){
			value = value+getMapOfExisting().get(innerMapRightDown).getCellCumulativeValue();			
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") does seem to have a neighbor at DownRight with value of "+value+"!");
		} else {
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") doesn't seem to have a neighbor at DownRight!");
		}			
		
		//+1,-0
		Map<Integer, Integer> innerMapRightCenter = new HashMap<Integer, Integer>();
		innerMapRightCenter.put(cell.getXCoord()+1, cell.getYCoord());
		if (getMapOfExisting().containsKey(innerMapRightCenter)){
			value = value+getMapOfExisting().get(innerMapRightCenter).getCellCumulativeValue();			
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") does seem to have a neighbor at Right with value of "+value+"!");
		} else {
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") doesn't seem to have a neighbor at Right!");
		}			
		
		//+1,+1
		Map<Integer, Integer> innerMapRightUp = new HashMap<Integer, Integer>();
		innerMapRightUp.put(cell.getXCoord()+1, cell.getYCoord()+1);
		if (getMapOfExisting().containsKey(innerMapRightUp)){
			value = value+getMapOfExisting().get(innerMapRightUp).getCellCumulativeValue();			
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") does seem to have a neighbor at RightUp with value of "+value+"!");
		} else {
//			System.out.println("cell at ("+cell.getXCoord()+", "+cell.getYCoord()+") doesn't seem to have a neighbor at RightUp!");
		}			
		
//		System.out.println("");

		
		return value;
	}

	public SpiralGridCell setDirectionBasedOnPriorDirection(SpiralGridCell cell, SpiralGridCell lastCell)
			 {// sorry, Dan

		if (RIGHT.equals(lastCell.getNextDirection())) {
			cell.setXCoord(lastCell.getXCoord() + 1);
			cell.setYCoord(lastCell.getYCoord() + 0);
		} else if (UP.equals(lastCell.getNextDirection())) {
			cell.setXCoord(lastCell.getXCoord() + 0);
			cell.setYCoord(lastCell.getYCoord() + 1);
		} else if (LEFT.equals(lastCell.getNextDirection())) {
			cell.setXCoord(lastCell.getXCoord() - 1);
			cell.setYCoord(lastCell.getYCoord() + 0);
		} else if (DOWN.equals(lastCell.getNextDirection())) {
			cell.setXCoord(lastCell.getXCoord() + 0);
			cell.setYCoord(lastCell.getYCoord() - 1);
		} else {
			System.out.println("Something went very wrong here! There is a direction other than the listed constants");
		}

		if (cellWouldBeOutOfCurrentBounds(cell, lastCell)) {// switch direction
			cell.setNextDirection(getNewDirectionFrom(lastCell.getNextDirection()));
		} else {// keep old direction
			cell.setNextDirection(lastCell.getNextDirection());
		}

		return cell;

	}

	private String getNewDirectionFrom(String priorDirection) {
		String newDirection = priorDirection;
		if (RIGHT.equals(priorDirection)) {
			newDirection = UP;
		} else if (UP.equals(priorDirection)) {
			newDirection = LEFT;
		} else if (LEFT.equals(priorDirection)) {
			newDirection = DOWN;
		} else if (DOWN.equals(priorDirection)) {
			newDirection = RIGHT;
		} else {
			Exception error = new Exception();
			try {
				throw error;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newDirection;
	}

	// private boolean cellOutOfCurrentBounds(SpiralGridCell cell) {
	// boolean outOfBounds;
	//
	//
	// int greatestXYFromCell = (Math.abs(cell.getXCoord()) >
	// Math.abs(cell.getYCoord())) ? Math.abs(cell.getXCoord()) :
	// Math.abs(cell.getYCoord());
	//
	// if (cell.getValue()==3){
	// System.out.println("");
	// System.out.println("cell's value is "+cell.getValue()+", x-value is
	// "+cell.getXCoord()+", y-value is "+cell.getYCoord()+".");
	// System.out.println("maxInOneDirection is "+getMaxDimensionOneWay()+".");
	// System.out.println("greatestXYFromCell is "+greatestXYFromCell+".");
	// System.out.println("");
	// }
	//
	//
	// if (greatestXYFromCell > getMaxDimensionOneWay()){
	// outOfBounds = true;
	// setMaxDimension(getMaxDimension()+2);
	// setMaxDimensionOneWay(getMaxDimensionOneWay()+1);
	// } else {
	// //System.out.println("Not out of bounds!");
	// outOfBounds = false;
	// }
	// return outOfBounds;
	// }

	private boolean cellWouldBeOutOfCurrentBounds(SpiralGridCell cell, SpiralGridCell lastCell) {
		boolean outOfBounds = false;

		// let's get the direction if you would keep going
		SpiralGridCell futureCell = new SpiralGridCell();// SpiralGridCell
															// futureCell = cell
															// <---LOL DAN WAS
															// RIGHT
		//not bothering to set values for future cell 

		// outOfBoundsSubfunction();
//		boolean outOfBounds = true;
		if (RIGHT.equals(lastCell.getNextDirection())) {
			futureCell.setXCoord(cell.getXCoord() + 1);
			futureCell.setYCoord(cell.getYCoord() + 0);
			outOfBounds = outOfBoundsSubfunction(lastCell.getNextDirection(), futureCell);//, getMaxDimensionRIGHT());
		} else if (UP.equals(lastCell.getNextDirection())) {
			futureCell.setXCoord(cell.getXCoord() + 0);
			futureCell.setYCoord(cell.getYCoord() + 1);
			outOfBounds = outOfBoundsSubfunction(lastCell.getNextDirection(), futureCell);//, getMaxDimensionUP());
		} else if (LEFT.equals(lastCell.getNextDirection())) {
			futureCell.setXCoord(cell.getXCoord() - 1);
			futureCell.setYCoord(cell.getYCoord() + 0);
			outOfBounds = outOfBoundsSubfunction(lastCell.getNextDirection(), futureCell);//, getMaxDimensionLEFT());
		} else if (DOWN.equals(lastCell.getNextDirection())) {
			futureCell.setXCoord(cell.getXCoord() + 0);
			futureCell.setYCoord(cell.getYCoord() - 1);
			outOfBounds = outOfBoundsSubfunction(lastCell.getNextDirection(), futureCell);//, getMaxDimensionDOWN());
		} else {
			Exception error = new Exception();
			try {
				throw error;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// int greatestXYFromFutureCell = (Math.abs(futureCell.getXCoord()) >
		// Math.abs(futureCell.getYCoord())) ? Math.abs(futureCell.getXCoord())
		// : Math.abs(futureCell.getYCoord());

		// if (futureCell.getValue()==18){
		// System.out.println("");
		// System.out.println("future cell's value is "+futureCell.getValue()+",
		// x-value is "+futureCell.getXCoord()+", y-value is
		// "+futureCell.getYCoord()+".");
		// System.out.println("maxInDirection is "+getMaxDimension()+".");
		// System.out.println("maxInOneDirection is
		// "+getMaxDimensionOneWay()+".");
		// System.out.println("greatestXYFromFutureCell is
		// "+greatestXYFromFutureCell+".");
		// System.out.println("");
		// }

		// it's not turning the corner at 17. what should happen is
		/*
		 * //at 16: "I am within the bounds of a 4x4. 'maxDirection' should be 4
		 * 'maxDirectionOneWay' should be 2 right now I am at (-1, 2) if I go
		 * sameDirection(further left), next(17) will be at (-2, 2), which will
		 * put me outside of a 4x4 by 1 if I go nextDirection(down), next(17)
		 * will be at (-1, 1), which ALREADY EXISTS Going further left would
		 * mean breaking out of that 4x4. Now we are going to expand into a 5x5.
		 * Then, my next (17), will go to the left
		 * 
		 * //at 17: "I am within the bounds of a 5x5. 'maxDirection' should be 5
		 * 'maxDirectionOneWay' should be 2 right now I am at (-2, 2) if I go
		 * sameDirection(further left), next(17) will be at (-2, 2), which will
		 * put me outside of a 4x4 by 1 if I go nextDirection(down), next(17)
		 * will be at (-1, 1), which ALREADY EXISTS Going further left would
		 * mean breaking out of that 5x5. Now we are going to expand into a 5x5.
		 * Then, my next (18), will go down
		 */

		return outOfBounds;
	}

	private boolean outOfBoundsSubfunction(String nextDirection, SpiralGridCell futureCell){//, double maxDimensionDIRECTION) {
		boolean booleanToReturn = true;
		if (RIGHT.equals(nextDirection)){
			if (futureCell.getXCoord()+0 > getMaxX()+1){
				booleanToReturn = true;
				setMaxX(getMaxX()+1);
			} else {
				booleanToReturn = false;
			}
		} else if (UP.equals(nextDirection)){
			if (futureCell.getYCoord()+0 > getMaxY()+1){
				booleanToReturn = true;
				setMaxY(getMaxY()+1);
			} else {
				booleanToReturn = false;
			}
		} else if (LEFT.equals(nextDirection)){
//			System.out.println("    the future cell would be ");
			if (futureCell.getXCoord()-0 < getMinX()-1){
				booleanToReturn = true;
				setMinX(getMinX()-1);
			} else {
				booleanToReturn = false;
			}
		} else if (DOWN.equals(nextDirection)){
			if (futureCell.getYCoord()-0 < getMinY()-1){
				booleanToReturn = true;
				setMinY(getMinY()-1);
			} else {
				booleanToReturn = false;
			}
		} else {
			Exception error = new Exception();
			try {
				throw error;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		if (nextDirection)
//		if (greatestXYFromFutureCell > getMaxDimensionOneWay()){
//			outOfBounds = true;
//			System.out.println("");
//			System.out.println("");
//			System.out.println("cell's value is "+cell.getValue()+", x-value is "+cell.getXCoord()+", y-value is "+cell.getYCoord()+".");
//			System.out.println("maxInDirection is "+getMaxDimension()+".");
//			System.out.println("maxInOneDirection is "+getMaxDimensionOneWay()+".");
//			int result = (Math.abs(cell.getXCoord()) > Math.abs(cell.getYCoord())) ? Math.abs(cell.getXCoord()) : Math.abs(cell.getYCoord());
//			System.out.println("greatestXYFromCell is "+result +".");
//			System.out.println("");
//			System.out.println("future cell's value is "+futureCell.getValue()+", x-value is "+futureCell.getXCoord()+", y-value is "+futureCell.getYCoord()+".");
//			System.out.println("maxInDirection is going to be "+(getMaxDimension()+1)+".");
//			System.out.println("maxInOneDirection is going to be "+(getMaxDimensionOneWay()+0.5)+".");
//			System.out.println("greatestXYFromFutureCell is "+greatestXYFromFutureCell+".");
//			System.out.println("");
//			System.out.println("");
//
//			setMaxDimension(getMaxDimension()+1); 
//			setMaxDimensionOneWay(getMaxDimensionOneWay()+0.5); 
//			
//			
//		} else {
//			//System.out.println("Not out of bounds!");
//			outOfBounds = false;
//		}
		return booleanToReturn;

	}

	private Optional<SpiralGridCell> getMostRecentCell() {
		Optional<SpiralGridCell> answer = Optional.empty();
		if (!list.isEmpty()) {
			answer = Optional.of(list.get(list.size() - 1));
		}
		return answer;
	}

	public SpiralGridCell getLastCell() {
		SpiralGridCell lastCell = getList().get((getList().size() - 1));

		return lastCell;
	}

}
