import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DerbyFrame extends JFrame {

	private Derby theDerby;

	private JPanel jContentPane = null;
	private JTextField nameRegisterJTextField = null;
	private JButton registerJButton = null;

	private JSlider fishWeightJSlider = null;

	private JButton addFishJButton = null;

	private JTextField winnerNamejTextField = null;

	private JTextField winnerFishWeightJTextField = null;

	private JPanel registerJPanel = null;

	private JPanel addFishJPanel = null;

	private JPanel winnerJPanel = null;

	private JComboBox pickFisherJComboBox = null;

	private JTabbedPane jTabbedPane = null;

	private JPanel commonActivityJPanel = null;

	private JPanel allFishersJPanel = null;

	private JScrollPane allFIshersJScrollPane = null;

	private JTable allFishersJTable = null;

	public DerbyFrame() {
		super();
		initialize();

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				try {
					ObjectOutputStream outStream = new ObjectOutputStream(
							new FileOutputStream(new File("derby.ser")));
					outStream.writeObject(theDerby);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		this.setSize(558, 213);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Derby");

		ObjectInputStream inStream;
		try {
			inStream = new ObjectInputStream(new FileInputStream(new File(
					"derby.ser")));
			theDerby = (Derby) inStream.readObject();
		} catch (FileNotFoundException e) {
			theDerby = new Derby("Sooke");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FisherTableModel myModel = (FisherTableModel) getAllFishersJTable()
				.getModel();
		myModel.setDerby(theDerby);
		fillAllFishers();
		showCurrentWinner();
		myModel.fireTableDataChanged();
	}

	private void refillFisherTable() {
		FisherTableModel myModel = (FisherTableModel) getAllFishersJTable()
				.getModel();
		myModel.fireTableDataChanged();
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new FlowLayout());
			jContentPane.add(getJTabbedPane(), null);
		}
		return jContentPane;
	}

	private JTextField getNameRegisterJTextField() {
		if (nameRegisterJTextField == null) {
			nameRegisterJTextField = new JTextField();
			nameRegisterJTextField.setColumns(10);
		}
		return nameRegisterJTextField;
	}

	private JButton getRegisterJButton() {
		if (registerJButton == null) {
			registerJButton = new JButton();
			registerJButton.setText("Register");
			registerJButton
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							String name = getNameRegisterJTextField().getText();
							theDerby.add(new Fisher(name));
							getNameRegisterJTextField().setText("");
							fillAllFishers();
							refillFisherTable();
						}
					});
		}
		return registerJButton;
	}

	private void fillAllFishers() {
		if (theDerby != null) {
			JComboBox fisherCombo = getPickFisherJComboBox();
			fisherCombo.removeAllItems();
			ArrayList<String> names = new ArrayList<String>();
			for (Fisher who : theDerby) {
				names.add(who.getName());
			}

			Collections.sort(names);
			for (String aName : names) {
				fisherCombo.addItem(aName);
			}
		}
	}

	private JSlider getFishWeightJSlider() {
		if (fishWeightJSlider == null) {
			fishWeightJSlider = new JSlider();
			fishWeightJSlider.setMajorTickSpacing(10);
			fishWeightJSlider.setPaintTicks(true);
			fishWeightJSlider.setValue(1);
			fishWeightJSlider.setPaintLabels(true);
			fishWeightJSlider.setMaximum(50);
			fishWeightJSlider.setMinorTickSpacing(1);
		}
		return fishWeightJSlider;
	}

	private JButton getAddFishJButton() {
		if (addFishJButton == null) {
			addFishJButton = new JButton();
			addFishJButton.setText("Add Fish");
			addFishJButton
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							String chosenName = (String) getPickFisherJComboBox()
									.getSelectedItem();
							int fishWeight = getFishWeightJSlider().getValue();

							Fisher fake = new Fisher(chosenName);
							Fish aFish = new Fish(fishWeight, "Carp");
							theDerby.addFish(aFish, fake);

							showCurrentWinner();
							refillFisherTable();
						}
					});
		}
		return addFishJButton;
	}

	private void showCurrentWinner() {
		if (theDerby != null) {
			Fisher winner = theDerby.findWinner();
			if (winner != null) {
				Fish bigFish = winner.getBiggestFish();

				getWinnerNamejTextField().setText(winner.getName());
				int bigFishWeight = bigFish.getWeight();

				String fishWeightText = new Integer(bigFishWeight).toString();

				getWinnerFishWeightJTextField().setText(fishWeightText);
			}
		}
	}

	private JTextField getWinnerNamejTextField() {
		if (winnerNamejTextField == null) {
			winnerNamejTextField = new JTextField();
			winnerNamejTextField.setColumns(10);
			winnerNamejTextField.setEditable(false);
		}
		return winnerNamejTextField;
	}

	private JTextField getWinnerFishWeightJTextField() {
		if (winnerFishWeightJTextField == null) {
			winnerFishWeightJTextField = new JTextField();
			winnerFishWeightJTextField.setColumns(3);
			winnerFishWeightJTextField.setEditable(false);
		}
		return winnerFishWeightJTextField;
	}

	private JPanel getRegisterJPanel() {
		if (registerJPanel == null) {
			registerJPanel = new JPanel();
			registerJPanel.setBorder(javax.swing.BorderFactory
					.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			registerJPanel.add(getNameRegisterJTextField(), null);
			registerJPanel.add(getRegisterJButton(), null);
		}
		return registerJPanel;
	}

	private JPanel getAddFishJPanel() {
		if (addFishJPanel == null) {
			addFishJPanel = new JPanel();
			addFishJPanel.setBorder(javax.swing.BorderFactory
					.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			addFishJPanel.add(getPickFisherJComboBox(), null);
			addFishJPanel.add(getFishWeightJSlider(), null);
			addFishJPanel.add(getAddFishJButton(), null);
		}
		return addFishJPanel;
	}

	private JPanel getWinnerJPanel() {
		if (winnerJPanel == null) {
			winnerJPanel = new JPanel();
			winnerJPanel
					.setBorder(javax.swing.BorderFactory.createTitledBorder(
							javax.swing.BorderFactory
									.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
							"Current Winner",
							javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
							javax.swing.border.TitledBorder.DEFAULT_POSITION,
							null, null));
			winnerJPanel.add(getWinnerNamejTextField(), null);
			winnerJPanel.add(getWinnerFishWeightJTextField(), null);
		}
		return winnerJPanel;
	}

	private JComboBox getPickFisherJComboBox() {
		if (pickFisherJComboBox == null) {
			pickFisherJComboBox = new JComboBox();
			pickFisherJComboBox
					.setPreferredSize(new java.awt.Dimension(92, 24));
		}
		return pickFisherJComboBox;
	}

	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setPreferredSize(new java.awt.Dimension(450, 150));
			jTabbedPane.addTab("Register", null, getRegisterJPanel(), null);
			jTabbedPane.addTab("Add Fish", null, getCommonActivityJPanel(),
					null);
			jTabbedPane
					.addTab("All Fishers", null, getAllFishersJPanel(), null);
		}
		return jTabbedPane;
	}

	private JPanel getCommonActivityJPanel() {
		if (commonActivityJPanel == null) {
			commonActivityJPanel = new JPanel();
			commonActivityJPanel.setPreferredSize(new java.awt.Dimension(400,
					200));
			commonActivityJPanel.add(getAddFishJPanel(), null);
			commonActivityJPanel.add(getWinnerJPanel(), null);
		}
		return commonActivityJPanel;
	}

	private JPanel getAllFishersJPanel() {
		if (allFishersJPanel == null) {
			allFishersJPanel = new JPanel();
			allFishersJPanel.setPreferredSize(new java.awt.Dimension(230, 230));
			allFishersJPanel.add(getAllFIshersJScrollPane(), null);
		}
		return allFishersJPanel;
	}

	private JScrollPane getAllFIshersJScrollPane() {
		if (allFIshersJScrollPane == null) {
			allFIshersJScrollPane = new JScrollPane();
			allFIshersJScrollPane.setViewportView(getAllFishersJTable());
			allFIshersJScrollPane.setPreferredSize(new java.awt.Dimension(230,
					230));
		}
		return allFIshersJScrollPane;
	}

	private JTable getAllFishersJTable() {
		if (allFishersJTable == null) {
			FisherTableModel model = new FisherTableModel();
			model.setDerby(theDerby);
			allFishersJTable = new JTable(model);
		}
		return allFishersJTable;
	}

}
