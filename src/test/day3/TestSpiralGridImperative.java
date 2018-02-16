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
		if (!grid.getList().get(0).getNextDirection().equals(DayThree.RIGHT)){
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
		if (!grid.getList().get(grid.getList().size()-1).getNextDirection().equals(DayThree.RIGHT)){
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
		if (!grid.getList().get(grid.getList().size()-1).getNextDirection().equals(DayThree.RIGHT)){
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
		if (!grid.getList().get(grid.getList().size()-1).getNextDirection().equals(DayThree.UP)){
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


	@Test
	public void testSetDirectionBasedOnPriorDirection(){
		SpiralGridImperative grid = new SpiralGridImperative();
		boolean shouldBeTrue = true;
		for (int i=0; i<24; i++){
			grid.addCellToGrid();
		}

		SpiralGridCellImperative futureCell = new SpiralGridCellImperative();
		futureCell = grid.setPositionAndDirectionBasedOnPriorDirection(futureCell, grid.getMostRecentCell().get());
		if (!futureCell.getNextDirection().equals(DayThree.RIGHT)
				||
				futureCell.getXCoord() != 2
				||
				futureCell.getYCoord() != -2
				){
			shouldBeTrue = false;
		}
		grid.addCellToGrid();
		futureCell = grid.setPositionAndDirectionBasedOnPriorDirection(futureCell, grid.getMostRecentCell().get());
		if (!futureCell.getNextDirection().equals(DayThree.UP)
				||
				futureCell.getXCoord() != 3
				||
				futureCell.getYCoord() != -2
				){
			shouldBeTrue = false;
		}
		for (int i=0; i<6; i++){
			grid.addCellToGrid();
		}
		futureCell = grid.setPositionAndDirectionBasedOnPriorDirection(futureCell, grid.getMostRecentCell().get());
		if (!futureCell.getNextDirection().equals(DayThree.LEFT)
				||
				futureCell.getXCoord() != 4
				||
				futureCell.getYCoord() != 3
				){
			shouldBeTrue = false;
		}
		for (int i=0; i<8; i++){
			grid.addCellToGrid();
		}

		futureCell = grid.setPositionAndDirectionBasedOnPriorDirection(futureCell, grid.getMostRecentCell().get());
		if (!futureCell.getNextDirection().equals(DayThree.DOWN)
				||
				futureCell.getXCoord() != -3
				||
				futureCell.getYCoord() != 4
				){
			shouldBeTrue = false;
		}
		for (int i=0; i<8; i++){
			grid.addCellToGrid();
		}
		futureCell = grid.setPositionAndDirectionBasedOnPriorDirection(futureCell, grid.getMostRecentCell().get());
		if (!futureCell.getNextDirection().equals(DayThree.RIGHT)
				||
				futureCell.getXCoord() != -4
				||
				futureCell.getYCoord() != -3
				){
			shouldBeTrue = false;
		}
		assertEquals(shouldBeTrue, true);
		System.out.println("Success on Day3.testSetDirectionBasedOnPriorDirection!");
	}
	



	
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
