package Backtracking;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewSudoku implements ActionListener {
	private JButton btn[][] = new JButton[9][9]; // 20x20

	private JPanel pnlChess;
	private Sudoku sudoku;
	private JButton btnSolve, btnOpen;
	private boolean flag = false;

	public ViewSudoku() {
		// TODO Auto-generated constructor stub
		JFrame frame = new JFrame("Sudoku");
		frame.setSize(900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);

		init();
		frame.add(pnlChess);
		frame.setVisible(true);
	}

	private void init() {
		drawChess();

		btnSolve = new JButton("Giải sudoku");
		btnSolve.setBounds(500, 100, 150, 50);
		btnSolve.addActionListener(this);
		pnlChess.add(btnSolve);

		btnOpen = new JButton("open");
		btnOpen.setBounds(500, 10, 150, 50);
		btnOpen.addActionListener(this);
		pnlChess.add(btnOpen);
	}

	private void drawChess() {
		pnlChess = new JPanel(null);
		pnlChess.setBounds(0, 0, 800, 600);
//	        panel
		// add button
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				btn[i][j] = new JButton();
				btn[i][j].setBounds(0 + 50 * i, 0 + 50 * j, 50, 50);
				btn[i][j].setBackground(Color.LIGHT_GRAY);
				pnlChess.add(btn[i][j]);
			}
		}
	}

	private void show() {
		int x = 1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if (sudoku.input[i][j] != 0) {
					btn[j][i].setForeground(Color.black);
					btn[j][i].setText("" + sudoku.output[i][j]);
				} else if (sudoku.output[i][j] == 0) {
					btn[j][i].setText("");
				} else {
					btn[j][i].setForeground(Color.red);
					btn[j][i].setText("" + sudoku.output[i][j]);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnSolve) {
			solve();
		}
		if (e.getSource() == btnOpen) {
			open();
		}
	}

	private void open() {
		// TODO Auto-generated method stub
		String s = openFileName("open");
		if (s != null) {
			flag = true;
			sudoku = new Sudoku(s);
			show();
		}
	}

	private String openFileName(String title) {
		// mở file
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle(title);
		chooser.showOpenDialog(null);
		// lấy đường dẫn file được chọn
		File file = chooser.getSelectedFile();
		if (file != null) {
			return file.getPath();
		} else {
			return null;
		}
	}

	private void solve() {
		if (flag) {
			// solve sudoku
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						sudoku.solveSudoku(0, 0);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("finish");
					}
				}
			}).start();
			// show
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					while (true)
						show();
				}
			}).start();
		}
	}
}
