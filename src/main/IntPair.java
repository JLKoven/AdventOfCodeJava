package main;

public class IntPair {

	private int xCoord;
	private int yCoord;

	public int getXCoord() {
		return xCoord;
	}

	public void setXCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getYCoord() {
		return yCoord;
	}

	public void setYCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	@Override
	public boolean equals(Object o) {
		if (
				(o instanceof IntPair) 
				&& 
				(
		(((IntPair) o).getXCoord() == this.xCoord) 
		&& 
		(((IntPair) o).getYCoord() == this.yCoord)
		)
				) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = (int) (xCoord + yCoord / 11);
		return result;
	}

}
