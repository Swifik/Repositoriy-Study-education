import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MinesweeperGUI extends JFrame {
    private static final int SIZE = 10; 
    private static final int MINES = 10; 
    private JButton[][] buttons = new JButton[SIZE][SIZE];
    private boolean[][] mines = new boolean[SIZE][SIZE];
    private boolean[][] revealed = new boolean[SIZE][SIZE];
    
    public MinesweeperGUI() {
        setTitle("Сапёр");
        setSize(400, 400);
        setLayout(new GridLayout(SIZE, SIZE));
        initializeButtons();
        placeMines();
        calculateNumbers();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeButtons() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                buttons[x][y] = new JButton();
                buttons[x][y].setFont(new Font("Arial", Font.PLAIN, 20));
                buttons[x][y].setFocusPainted(false);
                buttons[x][y].addActionListener(new ButtonClickListener(x, y));
                add(buttons[x][y]);
            }
        }
    }

    private void placeMines() {
        Random rand = new Random();
        for (int i = 0; i < MINES; ) {
            int x = rand.nextInt(SIZE);
            int y = rand.nextInt(SIZE);
            if (!mines[x][y]) {
                mines[x][y] = true;
                i++;
            }
        }
    }

    private void calculateNumbers() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (!mines[x][y]) {
                    int count = countAdjacentMines(x, y);
                    if (count > 0) {
                        buttons[x][y].setText(String.valueOf(count));
                    }
                }
            }
        }
    }

    private int countAdjacentMines(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; 
                int nx = x + i;
                int ny = y + j;
                if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && mines[nx][ny]) {
                    count++;
                }
            }
        }
        return count;
    }

    private class ButtonClickListener implements ActionListener {
        private int x, y;

        public ButtonClickListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            revealCell(x, y);
        }
    }

    private void revealCell(int x, int y) {
        if (revealed[x][y]) return;

        revealed[x][y] = true;

        if (mines[x][y]) {
            buttons[x][y].setText("M"); 
            buttons[x][y].setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Вы проиграли!", "Game Over", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            buttons[x][y].setEnabled(false); 
            buttons[x][y].setBackground(Color.LIGHT_GRAY);
        }
    }

    public static void main(String[] args) {
        new MinesweeperGUI();
    }
}