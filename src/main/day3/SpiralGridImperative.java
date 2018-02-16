package main.day3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SpiralGridImperative {

//	public static final String RIGHT = "Right";
//	public static final String UP = "Up";
//	public static final String LEFT = "Left";
//	public static final String DOWN = "Down";

	private List<SpiralGridCellImperative> list = new ArrayList<SpiralGridCellImperative>();

	private int maxX=0;
	private int maxY=0;
	private int minX=0;
	private int minY=0;

	private Map<HashMap<Integer, Integer>, SpiralGridCellImperative> mapOfExisting = new HashMap<HashMap<Integer, Integer>, SpiralGridCellImperative>();

	public List<SpiralGridCellImperative> getList() {
		return list;
	}

	public void setList(List<SpiralGridCellImperative> list) {
		this.list = list;
	}


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

	public Map<HashMap<Integer, Integer>, SpiralGridCellImperative> getMapOfExisting() {
		return mapOfExisting;
	}

	public void setAlreadyExists(Map<HashMap<Integer, Integer>, SpiralGridCellImperative> alreadyExists) {
		this.mapOfExisting = alreadyExists;
	}

	public boolean isGridCompleteSquare(int input) {
		boolean answer = false;
		int attemptedSquare = (int) Math.sqrt(input);
		if ((attemptedSquare * attemptedSquare == input)
		) {
			answer = true;
		}
		return answer;
	}

	public void addCellToGrid(){

		SpiralGridCellImperative cell = new SpiralGridCellImperative();

		if (getList().isEmpty()) {
			cell.setXCoord(0);
			cell.setYCoord(0);
			cell.setValue(1);
			cell.setCellCumulativeValue(1);
			cell.setNextDirection(DayThree.RIGHT);
		} else {
			if (getMostRecentCell().isPresent()) {
				SpiralGridCellImperative lastCell = getMostRecentCell().get();
				cell.setValue(lastCell.getValue() + 1);
				cell = setPositionAndDirectionBasedOnPriorDirection(cell, lastCell);
				cell.setCellCumulativeValue(calculateCumulativeValueBruteForce(cell));
			} else {
				System.out.println(
						"Something went very wrong here! You tried to find a cell, but no previous cell exsted");
			}
		}
		
		mapPlacementNoIntPair(cell);



		getList().add(cell);
	}

	private void mapPlacementNoIntPair(SpiralGridCellImperative cell) {
		Map<HashMap<Integer, Integer>, SpiralGridCellImperative> mapToReturn = getMapOfExisting();
		HashMap<Integer, Integer> coordinates = new HashMap<Integer, Integer>();
		coordinates.put(cell.getXCoord(), cell.getYCoord());
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

	private int calculateCumulativeValueBruteForce(SpiralGridCellImperative cell) {
		int value=0;
		
		
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

	public SpiralGridCellImperative setPositionAndDirectionBasedOnPriorDirection(SpiralGridCellImperative cell, SpiralGridCellImperative lastCell)
			 {// sorry, Dan

		if (DayThree.RIGHT.equals(lastCell.getNextDirection())) {
			cell.setXCoord(lastCell.getXCoord() + 1);
			cell.setYCoord(lastCell.getYCoord() + 0);
		} else if (DayThree.UP.equals(lastCell.getNextDirection())) {
			cell.setXCoord(lastCell.getXCoord() + 0);
			cell.setYCoord(lastCell.getYCoord() + 1);
		} else if (DayThree.LEFT.equals(lastCell.getNextDirection())) {
			cell.setXCoord(lastCell.getXCoord() - 1);
			cell.setYCoord(lastCell.getYCoord() + 0);
		} else if (DayThree.DOWN.equals(lastCell.getNextDirection())) {
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
		if (DayThree.RIGHT.equals(priorDirection)) {
			newDirection = DayThree.UP;
		} else if (DayThree.UP.equals(priorDirection)) {
			newDirection = DayThree.LEFT;
		} else if (DayThree.LEFT.equals(priorDirection)) {
			newDirection = DayThree.DOWN;
		} else if (DayThree.DOWN.equals(priorDirection)) {
			newDirection = DayThree.RIGHT;
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


	private boolean cellWouldBeOutOfCurrentBounds(SpiralGridCellImperative cell, SpiralGridCellImperative lastCell) {
		boolean outOfBounds = false;

		// let's get the direction if you would keep going
		SpiralGridCellImperative futureCell = new SpiralGridCellImperative();// SpiralGridCell
															// futureCell = cell
															// <---LOL DAN WAS
															// RIGHT
		//not bothering to set values for future cell 

		if (DayThree.RIGHT.equals(lastCell.getNextDirection())) {
			futureCell.setXCoord(cell.getXCoord() + 1);
			futureCell.setYCoord(cell.getYCoord() + 0);
			outOfBounds = outOfBoundsDirectionSubfunction(lastCell.getNextDirection(), futureCell);//, getMaxDimensionRIGHT());
		} else if (DayThree.UP.equals(lastCell.getNextDirection())) {
			futureCell.setXCoord(cell.getXCoord() + 0);
			futureCell.setYCoord(cell.getYCoord() + 1);
			outOfBounds = outOfBoundsDirectionSubfunction(lastCell.getNextDirection(), futureCell);//, getMaxDimensionUP());
		} else if (DayThree.LEFT.equals(lastCell.getNextDirection())) {
			futureCell.setXCoord(cell.getXCoord() - 1);
			futureCell.setYCoord(cell.getYCoord() + 0);
			outOfBounds = outOfBoundsDirectionSubfunction(lastCell.getNextDirection(), futureCell);//, getMaxDimensionLEFT());
		} else if (DayThree.DOWN.equals(lastCell.getNextDirection())) {
			futureCell.setXCoord(cell.getXCoord() + 0);
			futureCell.setYCoord(cell.getYCoord() - 1);
			outOfBounds = outOfBoundsDirectionSubfunction(lastCell.getNextDirection(), futureCell);//, getMaxDimensionDOWN());
		} else {
			Exception error = new Exception();
			try {
				throw error;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return outOfBounds;
	}

	private boolean outOfBoundsDirectionSubfunction(String nextDirection, SpiralGridCellImperative futureCell){//, double maxDimensionDIRECTION) {
		boolean booleanToReturn = true;
		if (DayThree.RIGHT.equals(nextDirection)){
			if (futureCell.getXCoord()+0 > getMaxX()+1){
				booleanToReturn = true;
				setMaxX(getMaxX()+1);
			} else {
				booleanToReturn = false;
			}
		} else if (DayThree.UP.equals(nextDirection)){
			if (futureCell.getYCoord()+0 > getMaxY()+1){
				booleanToReturn = true;
				setMaxY(getMaxY()+1);
			} else {
				booleanToReturn = false;
			}
		} else if (DayThree.LEFT.equals(nextDirection)){
			if (futureCell.getXCoord()-0 < getMinX()-1){
				booleanToReturn = true;
				setMinX(getMinX()-1);
			} else {
				booleanToReturn = false;
			}
		} else if (DayThree.DOWN.equals(nextDirection)){
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
		return booleanToReturn;

	}

	public Optional<SpiralGridCellImperative> getMostRecentCell() {
		Optional<SpiralGridCellImperative> answer = Optional.empty();
		if (!list.isEmpty()) {
			answer = Optional.of(list.get(list.size() - 1));
		}
		return answer;
	}

//	public Optional<SpiralGridCellImperative> getLastCell() {
//		Optional<SpiralGridCellImperative> lastCell = Optional.empty();
//		if (!list.isEmpty()) {
//			SpiralGridCellImperative lastCell = getList().get((getList().size() - 1));
//		}
//
//		return lastCell;
//	}

}
