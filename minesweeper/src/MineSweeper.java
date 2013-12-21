/*
 * This program implements the game of minesweeper. It is similar to
 * the standard Windows game except that there is no timer, bomb counter
 * or graphic bombs.
 *
 * The program uses a two dimensional array of BombButtons. It first adds the
 * buttons to the array. Then, for each Bombbutton, makes a list of the button's
 * neighbors and passes the list to the button. This means that the buttons are
 * totally unaware of the physical grid.
 *
 * Finally, bombs are randomly set on buttons.
 *
 * Mouse clicks are captured by the program through one common listener for
 * all the buttons. Clicks and right mouse clicks are sent to the appropriate
 * bomb method. After a click the button is queried to see if a bomb has gone
 * off, ending the game. At the end of a game all the buttons are uncovered.
 */

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MineSweeper {

	private Frame mainFrame;

	/* the size of the playing grid */

	private static final int ROW_ELEMENTS = 16;
	private static final int COL_ELEMENTS = 30;
	
	private static final int BUTTON_SIZE = 30;
	
	private static final int X_WINDOW_SIZE = COL_ELEMENTS * BUTTON_SIZE;
	private static final int Y_WINDOW_SIZE = ROW_ELEMENTS * BUTTON_SIZE;

	private static final double BOMB_DENSITY_PERCENT = 0.25;

	private static final int MAX_BOMBS = (int) ((ROW_ELEMENTS * COL_ELEMENTS) * BOMB_DENSITY_PERCENT);

	/* all the bombs are stored here */

	private BombButton mines[][];

	private JPanel minePanel;

	public void initComponents() {
		mines = new BombButton[ROW_ELEMENTS][COL_ELEMENTS];
		
		BombButton currentButton;
		MouseHit mouseListen = new MouseHit();

		minePanel = new JPanel();
		minePanel.setVisible(true);

		mainFrame.setLocationRelativeTo(null);

		minePanel.setLayout(new GridLayout(0, COL_ELEMENTS));

		// make the buttons and add the listener

		for (int rowIndex = 0; rowIndex < ROW_ELEMENTS; rowIndex++) {
			for (int colIndex = 0; colIndex < COL_ELEMENTS; colIndex++) {
				currentButton = new BombButton();
				currentButton.addMouseListener(mouseListen);

				minePanel.add(currentButton);
				mines[rowIndex][colIndex] = currentButton;
			}
		}

		locateAllNeighbors();

		placeBombs();

		mainFrame.add(minePanel);
	}

	/********************************************************/
	/* Randomly place bombs on the grid. */
	/* Copy all the bomb references from the two dimensional */
	/* array into a one dimensional array. Shuffle the */
	/* references and then marks the first few as bombs. */
	/********************************************************/

	private void placeBombs() {
		List<BombButton> theList = new ArrayList<BombButton>();

		// Copy all the bomb references from the two dimensional
		// array into a temporary one dimensional array.

		for (int rowIndex = 0; rowIndex < ROW_ELEMENTS; rowIndex++) {
			theList.addAll(Arrays.asList(mines[rowIndex]));
		}

		Collections.shuffle(theList);

		// Mark the required number of buttons as having bombs

		for (int bombNumber = 0; bombNumber < MAX_BOMBS; bombNumber++) {
			BombButton aButton = theList.get(bombNumber);
			aButton.setBomb();
		}
	}

	/********************************************************************/
	/* Run through the grid, build the neighbor list and pass it to the */
	/* appropriate button. */
	/********************************************************************/

	private void locateAllNeighbors() {
		List<BombButton> neighborList;

		for (int rowIndex = 0; rowIndex < ROW_ELEMENTS; rowIndex++) {
			for (int colIndex = 0; colIndex < COL_ELEMENTS; colIndex++) {
				neighborList = new ArrayList<BombButton>();
				buildNeighborList(rowIndex, colIndex, neighborList);

				mines[rowIndex][colIndex].setNeighbors(neighborList);
			}
		}
	}

	/************************************************************/
	/* Build a list of all the neighbors for this button. */
	/* The button is in the center of a 3x3 grid, so generate */
	/* all the positions, the eliminate positions if we are at */
	/* an edge. Remember not to consider ourselves. */
	/************************************************************/

	private void buildNeighborList(int rowLocation, int colLocation, List<BombButton> neighborList) {

		for (int rowOffset = -1; rowOffset <= +1; rowOffset++) {
			for (int colOffset = -1; colOffset <= +1; colOffset++) {
				int rowIndex = rowLocation + rowOffset;
				int colIndex = colLocation + colOffset;

				if (outOfBounds(rowIndex, colIndex)) {
					continue;
				}

				if ((rowIndex == rowLocation) && (colIndex == colLocation)) {
					continue;
				}

				neighborList.add(mines[rowIndex][colIndex]);
			}
		}
	}

	private boolean outOfBounds(int rowIndex, int colIndex) {
		if (rowIndex < 0) {
			return true;
		}

		if (rowIndex >= ROW_ELEMENTS) {
			return true;
		}

		if (colIndex < 0) {
			return true;
		}

		if (colIndex >= COL_ELEMENTS) {
			return true;
		}

		return false;
	}

	/********************************************************************/
	/* Handle all the mouse hits. Call the appropriate mouse method */
	/* depending on the type of click. Detect when the game is over. */
	/********************************************************************/

	public class MouseHit extends MouseAdapter {
		public void mouseClicked(MouseEvent theMouseEvent) {
			BombButton theButton = (BombButton) theMouseEvent.getSource();

			if (SwingUtilities.isRightMouseButton(theMouseEvent)) {
				theButton.cycleState();
				return;
			}

			theButton.doNormalClick();

			if (theButton.hasBomb())
				gameOver();
		}
	}

	/************************************************************************/
	/* Right now just displays all the buttons. Convenience routine that */
	/* can be built upon if we decide to do more at game end. */
	/************************************************************************/

	private void gameOver() {
		displayAllButtons();
	}

	/****************************************************************/
	/* Show all the button values by simulating a click on them. */
	/****************************************************************/

	private void displayAllButtons() {
		for (int rowIndex = 0; rowIndex < ROW_ELEMENTS; rowIndex++) {
			for (int colIndex = 0; colIndex < COL_ELEMENTS; colIndex++) {
				mines[rowIndex][colIndex].doNormalClick();
			}
		}
	}

	public static void main(String[] args) {
		new MineSweeper();
	}

	public MineSweeper() {
		mainFrame = new Frame("Minesweeper");
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		mainFrame.setMinimumSize(new Dimension(X_WINDOW_SIZE, Y_WINDOW_SIZE));
		
		initComponents();
		
		mainFrame.setVisible(true);
	}
}