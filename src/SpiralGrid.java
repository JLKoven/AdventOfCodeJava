import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SpiralGrid {

	public static final String RIGHT = "Right";
	public static final String UP = "Up";
	public static final String LEFT = "Left";
	public static final String DOWN = "Down";

	private List<SpiralGridCell> list = new ArrayList<SpiralGridCell>();

//	private double maxDimension = 1.0; 
	private double maxDimensionRIGHT = 0.0; 



	private double maxDimensionUP = 0.0; 
	private double maxDimensionLEFT = 0.0; 
	private double maxDimensionDOWN = 0.0; 
	
	private Map<IntPair, SpiralGridCell> alreadyExists = new HashMap<IntPair, SpiralGridCell>();

	
	public List<SpiralGridCell> getList() {
		return list;
	}


	public void setList(List<SpiralGridCell> list) {
		this.list = list;
	}
	
	public double getMaxDimensionRIGHT() {
		return maxDimensionRIGHT;
	}


	public void setMaxDimensionRIGHT(double maxDimensionRIGHT) {
		this.maxDimensionRIGHT = maxDimensionRIGHT;
	}


	public double getMaxDimensionUP() {
		return maxDimensionUP;
	}


	public void setMaxDimensionUP(double maxDimensionUP) {
		this.maxDimensionUP = maxDimensionUP;
	}


	public double getMaxDimensionLEFT() {
		return maxDimensionLEFT;
	}


	public void setMaxDimensionLEFT(double maxDimensionLEFT) {
		this.maxDimensionLEFT = maxDimensionLEFT;
	}


	public double getMaxDimensionDOWN() {
		return maxDimensionDOWN;
	}


	public void setMaxDimensionDOWN(double maxDimensionDOWN) {
		this.maxDimensionDOWN = maxDimensionDOWN;
	}


//	public double getMaxDimension() {
//		return maxDimension;
//	}
//
//	public void setMaxDimension(double maxDimension) {
//		this.maxDimension = maxDimension;
//	}
//	
//	public double getMaxDimensionOneWay() {
//		return maxDimensionOneWay;
//	}
//
//
//	public void setMaxDimensionOneWay(double maxDimensionOneWay) {
//		this.maxDimensionOneWay = maxDimensionOneWay;
//	}
	
	public Map<IntPair, SpiralGridCell> getAlreadyExists() {
		return alreadyExists;
	}


	public void setAlreadyExists(Map<IntPair, SpiralGridCell> alreadyExists) {
		this.alreadyExists = alreadyExists;
	}
	
	public boolean isGridCompleteSquare(int input){
		boolean answer = false;
		int attemptedSquare = (int) Math.sqrt(input);
		if ((attemptedSquare * attemptedSquare == input) 
				//&& (attemptedSquare % 2== 1)
				){
			answer = true;
		}
		return answer;
	}
	
	
	public void addCellToGridInitial() throws Exception {
		
		SpiralGridCell cell = new SpiralGridCell();
		//figure out whether we are going to a new direction or not?
		//if (getList()
		
		if (getList().isEmpty()) {
			cell.setXCoord(0);
			cell.setYCoord(0);
			cell.setValue(1);
			cell.setNextDirection(RIGHT);
		} else {
			if (getMostRecentCell().isPresent()) {
				SpiralGridCell lastCell = getMostRecentCell().get();
				cell.setValue(lastCell.getValue() + 1);
				cell = setDirectionBasedOnPriorDirection(cell, lastCell);
			} else {
				System.out.println(
						"Something went very wrong here! You tried to find a cell, but no previous cell exsted");
			}
		}
		System.out.println("  The cell we are adding to this grid has value "+cell.getValue()+", x value "+cell.getXCoord()+" and y value "+cell.getYCoord()+".");

		Map<IntPair, SpiralGridCell> mapToReturn = getAlreadyExists();
		IntPair coordinates = new IntPair();
		coordinates.setIntOne(cell.getXCoord());
		coordinates.setIntTwo(cell.getYCoord());
		mapToReturn.put(coordinates, cell);
		setAlreadyExists(mapToReturn);
		
		getList().add(cell);
	}

	public SpiralGridCell setDirectionBasedOnPriorDirection(SpiralGridCell cell, SpiralGridCell lastCell) throws Exception {//sorry, Dan
		

		
		if (RIGHT.equals(lastCell.getNextDirection())) {
			cell.setXCoord(lastCell.getXCoord()+1);
			cell.setYCoord(lastCell.getYCoord()+0);
		} else if (UP.equals(lastCell.getNextDirection())) {
			cell.setXCoord(lastCell.getXCoord()+0);
			cell.setYCoord(lastCell.getYCoord()+1);
		} else if (LEFT.equals(lastCell.getNextDirection())) {
			cell.setXCoord(lastCell.getXCoord()-1);
			cell.setYCoord(lastCell.getYCoord()+0);
		} else if (DOWN.equals(lastCell.getNextDirection())) {
			cell.setXCoord(lastCell.getXCoord()+0);
			cell.setYCoord(lastCell.getYCoord()-1);
		} else {
			System.out.println(
					"Something went very wrong here! There is a direction other than the listed constants");
		}
		
		if (cellWouldBeOutOfCurrentBounds(cell, lastCell)){//switch direction 
			cell.setNextDirection(getNewDirectionFrom(lastCell.getNextDirection()));
		} else {//keep old direction
			cell.setNextDirection(lastCell.getNextDirection());
		}
		
		return cell;
		
	}


	private String getNewDirectionFrom(String priorDirection) throws Exception {
		String newDirection;
		if (RIGHT.equals(priorDirection)){
			newDirection = UP;
		} else if (UP.equals(priorDirection)){
			newDirection = LEFT;
		} else if (LEFT.equals(priorDirection)){
			newDirection = DOWN;
		} else if (DOWN.equals(priorDirection)){
			newDirection = RIGHT;			
		} else {
			Exception error = new Exception();
			throw error;
		}
		return newDirection;
	}


//	private boolean cellOutOfCurrentBounds(SpiralGridCell cell) {
//		boolean outOfBounds;
//		
//		
//		int greatestXYFromCell = (Math.abs(cell.getXCoord()) > Math.abs(cell.getYCoord())) ? Math.abs(cell.getXCoord()) : Math.abs(cell.getYCoord()); 
//
//		if (cell.getValue()==3){
//			System.out.println("");
//			System.out.println("cell's value is "+cell.getValue()+", x-value is "+cell.getXCoord()+", y-value is "+cell.getYCoord()+".");
//			System.out.println("maxInOneDirection is "+getMaxDimensionOneWay()+".");
//			System.out.println("greatestXYFromCell is "+greatestXYFromCell+".");
//			System.out.println("");
//		}
//
//		
//		if (greatestXYFromCell > getMaxDimensionOneWay()){
//			outOfBounds = true;
//			setMaxDimension(getMaxDimension()+2); 
//			setMaxDimensionOneWay(getMaxDimensionOneWay()+1); 
//		} else {
//			//System.out.println("Not out of bounds!");
//			outOfBounds = false;
//		}
//		return outOfBounds;
//	}
	
	private boolean cellWouldBeOutOfCurrentBounds(SpiralGridCell cell, SpiralGridCell lastCell) throws Exception {
		boolean outOfBounds;
		
		//let's get the direction if you would keep going 
		SpiralGridCell futureCell = new SpiralGridCell();// SpiralGridCell futureCell = cell <---LOL DAN WAS RIGHT
		futureCell.setValue(cell.getValue()+1);
		if (RIGHT.equals(lastCell.getNextDirection())){
			futureCell.setXCoord(cell.getXCoord()+1);
			futureCell.setYCoord(cell.getYCoord()+0);
		} else if (UP.equals(lastCell.getNextDirection())){
			futureCell.setXCoord(cell.getXCoord()+0);
			futureCell.setYCoord(cell.getYCoord()+1);			
		} else if (LEFT.equals(lastCell.getNextDirection())){
			futureCell.setXCoord(cell.getXCoord()-1);
			futureCell.setYCoord(cell.getYCoord()+0);			
		} else if (DOWN.equals(lastCell.getNextDirection())){
			futureCell.setXCoord(cell.getXCoord()+0);
			futureCell.setYCoord(cell.getYCoord()-1);			
		} else {
			Exception error = new Exception();
			throw error;
		}
		
		int greatestXYFromFutureCell = (Math.abs(futureCell.getXCoord()) > Math.abs(futureCell.getYCoord())) ? Math.abs(futureCell.getXCoord()) : Math.abs(futureCell.getYCoord()); 

//		if (futureCell.getValue()==18){
//			System.out.println("");
//			System.out.println("future cell's value is "+futureCell.getValue()+", x-value is "+futureCell.getXCoord()+", y-value is "+futureCell.getYCoord()+".");
//			System.out.println("maxInDirection is "+getMaxDimension()+".");
//			System.out.println("maxInOneDirection is "+getMaxDimensionOneWay()+".");
//			System.out.println("greatestXYFromFutureCell is "+greatestXYFromFutureCell+".");
//			System.out.println("");
//		}
		
		//it's not turning the corner at 17. what should happen is
		/*
		//at 16: "I am within the bounds of a 4x4. 
		 * 'maxDirection' should be 4
		 * 'maxDirectionOneWay' should be 2 
		 * right now I am at (-1, 2)
		 *   if I go sameDirection(further left), next(17) will be at (-2, 2), which will put me outside of a 4x4 by 1
		 *   if I go nextDirection(down), next(17) will be at (-1, 1), which ALREADY EXISTS
		 * Going further left would mean breaking out of that 4x4. 
		 * Now we are going to expand into a 5x5. 
		 * Then, my next (17), will go to the left 
		 * 
		//at 17: "I am within the bounds of a 5x5. 
		 * 'maxDirection' should be 5
		 * 'maxDirectionOneWay' should be 2 
		 * right now I am at (-2, 2)
		 *   if I go sameDirection(further left), next(17) will be at (-2, 2), which will put me outside of a 4x4 by 1
		 *   if I go nextDirection(down), next(17) will be at (-1, 1), which ALREADY EXISTS
		 * Going further left would mean breaking out of that 5x5. 
		 * Now we are going to expand into a 5x5. 
		 * Then, my next (18), will go down 
		 */

		
		if (greatestXYFromFutureCell > getMaxDimensionOneWay()){
			outOfBounds = true;
			System.out.println("");
			System.out.println("");
			System.out.println("cell's value is "+cell.getValue()+", x-value is "+cell.getXCoord()+", y-value is "+cell.getYCoord()+".");
			System.out.println("maxInDirection is "+getMaxDimension()+".");
			System.out.println("maxInOneDirection is "+getMaxDimensionOneWay()+".");
			int result = (Math.abs(cell.getXCoord()) > Math.abs(cell.getYCoord())) ? Math.abs(cell.getXCoord()) : Math.abs(cell.getYCoord());
			System.out.println("greatestXYFromCell is "+result +".");
			System.out.println("");
			System.out.println("future cell's value is "+futureCell.getValue()+", x-value is "+futureCell.getXCoord()+", y-value is "+futureCell.getYCoord()+".");
			System.out.println("maxInDirection is going to be "+(getMaxDimension()+1)+".");
			System.out.println("maxInOneDirection is going to be "+(getMaxDimensionOneWay()+0.5)+".");
			System.out.println("greatestXYFromFutureCell is "+greatestXYFromFutureCell+".");
			System.out.println("");
			System.out.println("");

			setMaxDimension(getMaxDimension()+1); 
			setMaxDimensionOneWay(getMaxDimensionOneWay()+0.5); 
			
			
		} else {
			//System.out.println("Not out of bounds!");
			outOfBounds = false;
		}
		return outOfBounds;
	}


	private Optional<SpiralGridCell> getMostRecentCell() {
		Optional<SpiralGridCell> answer = Optional.empty();
		if (!list.isEmpty()) {
			answer = Optional.of(list.get(list.size() - 1));
		}
		return answer;
	}


	public SpiralGridCell getLastCell() {
		SpiralGridCell lastCell = getList().get((getList().size()-1));

		return lastCell;
	}




}
