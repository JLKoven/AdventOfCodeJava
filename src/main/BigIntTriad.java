package main;

import java.math.BigInteger;
import java.util.Objects;

public class BigIntTriad {
	
	private BigInteger xCoord;
	private BigInteger yCoord;
	private BigInteger zCoord;
	
	public BigInteger getXCoord() {
		return xCoord;
	}
	public void setXCoord(BigInteger xCoord) {
		this.xCoord = xCoord;
	}
	public BigInteger getYCoord() {
		return yCoord;
	}
	public void setYCoord(BigInteger yCoord) {
		this.yCoord = yCoord;
	}
	public BigInteger getZCoord() {
		return zCoord;
	}
	public void setZCoord(BigInteger zCoord) {
		this.zCoord = zCoord;
	}
	
	@Override
	public boolean equals(Object o) {
		if (
				(o instanceof BigIntTriad) 
				&& 
				(
		(((BigIntTriad) o).getXCoord() == this.xCoord) 
		&& 
		(((BigIntTriad) o).getYCoord() == this.yCoord)
		&& 
		(((BigIntTriad) o).getZCoord() == this.zCoord)
		)
				) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(xCoord, yCoord, zCoord);
	}


}
