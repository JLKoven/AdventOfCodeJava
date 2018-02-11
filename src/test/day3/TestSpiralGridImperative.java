package test.day3;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;

import main.day3.DayThree;
import main.day3.SpiralGridCellImperative;
import main.day3.SpiralGridImperative;

public class TestSpiralGridImperative {
	
	@Test
	public void testIsGridCompleteSquare1() {
		SpiralGridImperative grid = new SpiralGridImperative();
		assertEquals(grid.isGridCompleteSquare(1), true);
		System.out.println("Success on Day3.testIsGridCompleteSquare1!");
	}

	@Test
	public void testIsGridCompleteSquare2() {
		SpiralGridImperative grid = new SpiralGridImperative();
		assertEquals(grid.isGridCompleteSquare(4), true);
		System.out.println("Success on Day3.testIsGridCompleteSquare2!");
	}

	@Test
	public void testIsGridCompleteSquare3() {
		SpiralGridImperative grid = new SpiralGridImperative();
		assertEquals(grid.isGridCompleteSquare(225), true);
		System.out.println("Success on Day3.testIsGridCompleteSquare3!");
	}

	@Test
	public void testIsGridCompleteSquareInitial() {
		SpiralGridImperative grid = new SpiralGridImperative();
		assertEquals(grid.isGridCompleteSquare(0), true);
		System.out.println("Success on Day3.testIsGridCompleteSquareInitial!");
	}
	
	@Test
	public void testIsGridCompleteSquareNegative1() {
		SpiralGridImperative grid = new SpiralGridImperative();
		assertEquals(grid.isGridCompleteSquare(2), false);
		System.out.println("Success on Day3.testIsGridCompleteSquareNegative1!");
	}
	@Test
	public void testIsGridCompleteSquareNegative2() {
		SpiralGridImperative grid = new SpiralGridImperative();
		assertEquals(grid.isGridCompleteSquare(3), false);
		System.out.println("Success on Day3.testIsGridCompleteSquareNegative2!");
	}
	@Test
	public void testIsGridCompleteSquareNegative3() {
		SpiralGridImperative grid = new SpiralGridImperative();
		assertEquals(grid.isGridCompleteSquare(5), false);
		System.out.println("Success on Day3.testIsGridCompleteSquareNegative3!");
	}
	@Test
	public void testIsGridCompleteSquareNegative4() {
		SpiralGridImperative grid = new SpiralGridImperative();
		assertEquals(grid.isGridCompleteSquare(224), false);
		System.out.println("Success on Day3.testIsGridCompleteSquareNegative4!");
	}
	@Test
	public void testIsGridCompleteSquareNegative5() {
		SpiralGridImperative grid = new SpiralGridImperative();
		assertEquals(grid.isGridCompleteSquare(226), false);
		System.out.println("Success on Day3.testIsGridCompleteSquareNegative5!");
	}
	
	
	@Test
	public void testAddCellToGridInitial() {
		SpiralGridImperative grid = new SpiralGridImperative();
		boolean shouldBeTrue = true;
		if (grid.getList().isEmpty() == false){
			shouldBeTrue = false;
		}
		grid.addCellToGrid();
		if (grid.getList().get(0).getXCoord() != 0){
			shouldBeTrue = false;
		}
		if (grid.getList().get(0).getYCoord() != 0){
			shouldBeTrue = false;
		}
		if (grid.getList().get(0).getValue() != 1){
			shouldBeTrue = false;
		}
		if (grid.getList().get(0).getCellCumulativeValue() != 1){
			shouldBeTrue = false;
		}
		if (!grid.getList().get(0).getNextDirection().equals(SpiralGridImperative.RIGHT)){
			shouldBeTrue = false;
		}
		assertEquals(shouldBeTrue, true);
		System.out.println("Success on Day3.testAddCellToGridInitial!");
	}
	
	@Test
	public void testAddCellToGrid() {
		SpiralGridImperative grid = new SpiralGridImperative();
		boolean shouldBeTrue = true;
		for (int i=0; i<24; i++){
			grid.addCellToGrid();
		}
		if (grid.getList().get(grid.getList().size()-1).getXCoord() != 1){//should I merge this with getMostRecentCell?
			shouldBeTrue = false;
		}
		if (grid.getList().get(grid.getList().size()-1).getYCoord() != -2){
			shouldBeTrue = false;
		}
		if (grid.getList().get(grid.getList().size()-1).getValue() != 24){
			shouldBeTrue = false;
		}
		if (grid.getList().get(grid.getList().size()-1).getCellCumulativeValue() != 880){
			shouldBeTrue = false;
		}
		if (!grid.getList().get(grid.getList().size()-1).getNextDirection().equals(SpiralGridImperative.RIGHT)){
			shouldBeTrue = false;
		}
		if (!(grid.getMaxX() == 2)){
			shouldBeTrue = false;
		}
		if (!(grid.getMaxY() == 2)){
			shouldBeTrue = false;
		}
		if (!(grid.getMinX() == -2)){
			shouldBeTrue = false;
		}
		if (!(grid.getMinX() == -2)){
			shouldBeTrue = false;
		}
		grid.addCellToGrid();
		if (grid.getList().get(grid.getList().size()-1).getXCoord() != 2){
			shouldBeTrue = false;
		}
		if (grid.getList().get(grid.getList().size()-1).getYCoord() != -2){
			shouldBeTrue = false;
		}
		if (grid.getList().get(grid.getList().size()-1).getValue() != 25){
			shouldBeTrue = false;
		}
		if (grid.getList().get(grid.getList().size()-1).getCellCumulativeValue() != 931){
			shouldBeTrue = false;
		}
		if (!grid.getList().get(grid.getList().size()-1).getNextDirection().equals(SpiralGridImperative.RIGHT)){
			shouldBeTrue = false;
		}
		if (!(grid.getMaxX() == 2)){
			shouldBeTrue = false;
		}
		if (!(grid.getMaxY() == 2)){
			shouldBeTrue = false;
		}
		if (!(grid.getMinX() == -2)){
			shouldBeTrue = false;
		}
		if (!(grid.getMinX() == -2)){
			shouldBeTrue = false;
		}
		grid.addCellToGrid();
		if (grid.getList().get(grid.getList().size()-1).getXCoord() != 3){
			shouldBeTrue = false;
		}
		if (grid.getList().get(grid.getList().size()-1).getYCoord() != -2){
			shouldBeTrue = false;
		}
		if (grid.getList().get(grid.getList().size()-1).getValue() != 26){
			shouldBeTrue = false;
		}
		if (grid.getList().get(grid.getList().size()-1).getCellCumulativeValue() != 957){
			shouldBeTrue = false;
		}
		if (!grid.getList().get(grid.getList().size()-1).getNextDirection().equals(SpiralGridImperative.UP)){
			shouldBeTrue = false;
		}
		if (!(grid.getMaxX() == 3)){
			shouldBeTrue = false;
		}
		if (!(grid.getMaxY() == 2)){
			shouldBeTrue = false;
		}
		if (!(grid.getMinX() == -2)){
			shouldBeTrue = false;
		}
		if (!(grid.getMinX() == -2)){
			shouldBeTrue = false;
		}
		assertEquals(shouldBeTrue, true);
		System.out.println("Success on Day3.testAddCellToGrid!");
	}



//	@Test
//	public void testSetDirectionBasedOnPriorDirection() {
//		assertEquals(0, 0);
//		System.out.println("Success on Day3.testWARGH!");
//	}
////	public SpiralGridCellImperative setDirectionBasedOnPriorDirection(SpiralGridCellImperative cell, SpiralGridCellImperative lastCell)
////			 {// sorry, Dan
////
////		if (RIGHT.equals(lastCell.getNextDirection())) {
////			cell.setXCoord(lastCell.getXCoord() + 1);
////			cell.setYCoord(lastCell.getYCoord() + 0);
////		} else if (UP.equals(lastCell.getNextDirection())) {
////			cell.setXCoord(lastCell.getXCoord() + 0);
////			cell.setYCoord(lastCell.getYCoord() + 1);
////		} else if (LEFT.equals(lastCell.getNextDirection())) {
////			cell.setXCoord(lastCell.getXCoord() - 1);
////			cell.setYCoord(lastCell.getYCoord() + 0);
////		} else if (DOWN.equals(lastCell.getNextDirection())) {
////			cell.setXCoord(lastCell.getXCoord() + 0);
////			cell.setYCoord(lastCell.getYCoord() - 1);
////		} else {
////			System.out.println("Something went very wrong here! There is a direction other than the listed constants");
////		}
////
////		if (cellWouldBeOutOfCurrentBounds(cell, lastCell)) {// switch direction
////			cell.setNextDirection(getNewDirectionFrom(lastCell.getNextDirection()));
////		} else {// keep old direction
////			cell.setNextDirection(lastCell.getNextDirection());
////		}
////
////		return cell;
////
////	}
////
	

	
	@Test
	public void testGetMostRecentCell() {
		SpiralGridImperative grid = new SpiralGridImperative();
		boolean shouldBeTrue = true;
		if ((grid.getMostRecentCell().isPresent())){
			shouldBeTrue = false;
		}
		for (int i=0; i<24; i++){
			grid.addCellToGrid();
		}
		if (grid.getMostRecentCell().get().getValue() != 24){
			shouldBeTrue = false;
		}
		grid.addCellToGrid();
		if (grid.getMostRecentCell().get().getValue() != 25){
			shouldBeTrue = false;
		}
		grid.addCellToGrid();
		if (grid.getMostRecentCell().get().getValue() != 26){
			shouldBeTrue = false;
		}
		assertEquals(shouldBeTrue, true);
		System.out.println("Success on Day3.testGetMostRecentCell!");
	}
//	public SpiralGridCellImperative getLastCell() {
//		SpiralGridCellImperative lastCell = getList().get((getList().size() - 1));
//
//		return lastCell;
//	}

}
