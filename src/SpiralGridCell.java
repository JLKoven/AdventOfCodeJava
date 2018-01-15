
public class SpiralGridCell {

	private int xCoord;
	private int yCoord;
	private int cellValue;
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

	public String getNextDirection() {
		return nextDirection;
	}

	public void setNextDirection(String input) {
		this.nextDirection = input;
	}
}
