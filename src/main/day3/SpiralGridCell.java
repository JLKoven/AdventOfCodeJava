package main.day3;

public class SpiralGridCell {

	private int xCoord;
	private int yCoord;
	private int cellValue;
	private int cellCumulativeValue;
	private String nextDirection;

	public int getYCoord() {
		return yCoord;
	}

	public void setYCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public int getXCoord() {
		return xCoord;
	}

	public void setXCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getValue() {
		return cellValue;
	}

	public void setValue(int value) {
		this.cellValue = value;
	}
	
	public int getCellCumulativeValue() {
		return cellCumulativeValue;
	}

	public void setCellCumulativeValue(int cellCumulativeValue) {
		this.cellCumulativeValue = cellCumulativeValue;
	}

	public String getNextDirection() {
		return nextDirection;
	}

	public void setNextDirection(String input) {
		this.nextDirection = input;
	}


}
