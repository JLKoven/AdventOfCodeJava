package main.year2017.day03;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import main.IntPair;

public class SpiralGridImperative {

//	public static final String RIGHT = "Right";
//	public static final String UP = "Up";
//	public static final String LEFT = "Left";
//	public static final String DOWN = "Down";

	private List<SpiralGridCellImperative> list = new ArrayList<>();

	private int maxX=0;
	private int maxY=0;
	private int minX=0;
	private int minY=0;

	private Map<IntPair, SpiralGridCellImperative> mapOfExisting = new HashMap<>();

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

	public Map<IntPair, SpiralGridCellImperative> getMapOfExisting() {
		return mapOfExisting;
	}

	public void setAlreadyExists(Map<IntPair, SpiralGridCellImperative> alreadyExists) {
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
		
		mapPlacementIntPair(cell);



		getList().add(cell);
	}

	private void mapPlacementIntPair(SpiralGridCellImperative cell) {
		Map<IntPair, SpiralGridCellImperative> mapToReturn = getMapOfExisting();
		IntPair coordinates = new IntPair();
		coordinates.setXCoord(cell.getXCoord());
		coordinates.setYCoord(cell.getYCoord());
		
		if (!mapDoesContainCoordinates(mapToReturn, coordinates)){//, cell)){
			mapToReturn.put(coordinates, cell);
		} else {
			System.out.println("ERROR ERROR ERROR");
			mapToReturn = null;
		}
//		System.out.println("Existing pair print");
//		for (IntPair pair : mapToReturn.keySet()){
//			System.out.println("The value at x="+pair.getXCoord()+" and y="+pair.getYCoord()+" is "+mapToReturn.get(pair).getValue()+" with combined value "+mapToReturn.get(pair).getCellCumulativeValue()+".");
//		}
//		System.out.println("");
		setAlreadyExists(mapToReturn);
		
	}

	private boolean mapDoesContainCoordinates(Map<IntPair, SpiralGridCellImperative> mapToReturn,
			IntPair coordinates){//, SpiralGridCellImperative cell) {
		boolean boolToReturn = false;//we start by assuming the map doesn't have it
		for (IntPair pairToExamine : mapToReturn.keySet()){
			if (pairToExamine.equals(coordinates)){
				boolToReturn = true;
			}
		}
		return boolToReturn;
	}

	private int calculateCumulativeValueBruteForce(SpiralGridCellImperative cell) {
		int value=0;		
		
		//-1,-1
		IntPair innerMapLeftDown = new IntPair();
		innerMapLeftDown.setXCoord(cell.getXCoord()-1);
		innerMapLeftDown.setYCoord(cell.getYCoord()-1);
		if (mapDoesContainCoordinates(getMapOfExisting(), innerMapLeftDown)){
			IntPair equivalentPair = getEquivalentPair(innerMapLeftDown);
//			System.out.println(getMapOfExisting().get(equivalentPair).getCellCumulativeValue());
			value = value+getMapOfExisting().get(equivalentPair).getCellCumulativeValue();
		} 

		//-1,-0
		IntPair innerMapLeftCenter = new IntPair();
		innerMapLeftCenter.setXCoord(cell.getXCoord()-1);
		innerMapLeftCenter.setYCoord(cell.getYCoord()-0);
		if (mapDoesContainCoordinates(getMapOfExisting(), innerMapLeftCenter)){
			IntPair equivalentPair = getEquivalentPair(innerMapLeftCenter);
			value = value+getMapOfExisting().get(equivalentPair).getCellCumulativeValue();
		} 
		
		//-1,+1
		IntPair innerMapLeftUp = new IntPair();
		innerMapLeftUp.setXCoord(cell.getXCoord()-1);
		innerMapLeftUp.setYCoord(cell.getYCoord()+1);
		if (mapDoesContainCoordinates(getMapOfExisting(), innerMapLeftUp)){
			IntPair equivalentPair = getEquivalentPair(innerMapLeftUp);
			value = value+getMapOfExisting().get(equivalentPair).getCellCumulativeValue();
		} 		
		
		//-0,-1
		IntPair innerMapCenterDown = new IntPair();
		innerMapCenterDown.setXCoord(cell.getXCoord()+0);
		innerMapCenterDown.setYCoord(cell.getYCoord()-1);
		if (mapDoesContainCoordinates(getMapOfExisting(), innerMapCenterDown)){
			IntPair equivalentPair = getEquivalentPair(innerMapCenterDown);
			value = value+getMapOfExisting().get(equivalentPair).getCellCumulativeValue();			
		} 			
		
		//-0,+1
		IntPair innerMapCenterUp = new IntPair();
		innerMapCenterUp.setXCoord(cell.getXCoord()+0);
		innerMapCenterUp.setYCoord(cell.getYCoord()+1);
		if (mapDoesContainCoordinates(getMapOfExisting(), innerMapCenterUp)){
			IntPair equivalentPair = getEquivalentPair(innerMapCenterUp);
			value = value+getMapOfExisting().get(equivalentPair).getCellCumulativeValue();			
		} 			

		//+1,-1
		IntPair innerMapRightDown = new IntPair();
		innerMapRightDown.setXCoord(cell.getXCoord()+1);
		innerMapRightDown.setYCoord(cell.getYCoord()-1);
		if (mapDoesContainCoordinates(getMapOfExisting(), innerMapRightDown)){
			IntPair equivalentPair = getEquivalentPair(innerMapRightDown);
			value = value+getMapOfExisting().get(equivalentPair).getCellCumulativeValue();			
		} 		
		
		//+1,-0
		IntPair innerMapRightCenter = new IntPair();
		innerMapRightCenter.setXCoord(cell.getXCoord()+1);
		innerMapRightCenter.setYCoord(cell.getYCoord()+0);
		if (mapDoesContainCoordinates(getMapOfExisting(), innerMapRightCenter)){
			IntPair equivalentPair = getEquivalentPair(innerMapRightCenter);
			value = value+getMapOfExisting().get(equivalentPair).getCellCumulativeValue();			
		} 		
		
		//+1,+1
		IntPair innerMapRightUp = new IntPair();
		innerMapRightUp.setXCoord(cell.getXCoord()+1);
		innerMapRightUp.setYCoord(cell.getYCoord()+1);
		if (mapDoesContainCoordinates(getMapOfExisting(), innerMapRightUp)){
			IntPair equivalentPair = getEquivalentPair(innerMapRightUp);
			value = value+getMapOfExisting().get(equivalentPair).getCellCumulativeValue();			
		} 			
		
		
		return value;
	}

	private IntPair getEquivalentPair(IntPair innerMapLeftDown) {
		IntPair equivalentPair = innerMapLeftDown;
		for (IntPair pairToCheck : getMapOfExisting().keySet()){
			if (equivalentPair.equals(pairToCheck)){
				equivalentPair = pairToCheck;
				break;
			}
		}
		return equivalentPair;
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
			System.out.println("ERROR ERROR ERROR");
			newDirection = null;
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
			System.out.println("ERROR ERROR ERROR");
//			booleanToReturn = null;

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



}
