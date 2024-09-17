import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGame extends JPanel implements ActionListener {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 10;
    private static final int CELL_SIZE = 30;
    private static final Color SNAKE_COLOR = Color.GREEN;
    private static final Color FOOD_COLOR = Color.RED;
    private static final Color BACKGROUND_COLOR = Color.BLACK;

    private int snakeLength;
    private ArrayList<int[]> snake;
    private int[] food;
    private boolean gameOver;
    private Timer timer;
    private int dx = 1, dy = 0; // направление движения

    public SnakeGame() {
        setPreferredSize(new Dimension(WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE));
        setBackground(BACKGROUND_COLOR);
        
        snakeLength = 1;
        snake = new ArrayList<>();
        snake.add(new int[]{HEIGHT / 2, WIDTH / 2});

        placeFood();
        
        timer = new Timer(100, this);
        timer.start();
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: if (dy == 0) { dx = 0; dy = -1; } break;
                    case KeyEvent.VK_DOWN: if (dy == 0) { dx = 0; dy = 1; } break;
                    case KeyEvent.VK_LEFT: if (dx == 0) { dx = -1; dy = 0; } break;
                    case KeyEvent.VK_RIGHT: if (dx == 0) { dx = 1; dy = 0; } break;
                }
            }
        });
        setFocusable(true);
    }

    private void placeFood() {
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(HEIGHT);
            y = rand.nextInt(WIDTH);
        } while (snakeContains(x, y));
        food = new int[]{x, y};
    }

    private boolean snakeContains(int x, int y) {
        for (int[] segment : snake) {
            if (segment[0] == x && segment[1] == y) {
                return true;
            }
        }
        return false;
    }

    private void move() {
        if (gameOver) return;

        int headX = snake.get(0)[0] + dy;
        int headY = snake.get(0)[1] + dx;

        // Проверка на столкновение с границами или со своим телом
        if (headX < 0 || headX >= HEIGHT || headY < 0 || headY >= WIDTH || snakeContains(headX, headY)) {
            gameOver = true;
            timer.stop();
            return;
        }

        snake.add(0, new int[]{headX, headY});
        if (headX == food[0] && headY == food[1]) {
            snakeLength++;
            placeFood(); // еда появляется снова
        } else {
            snake.remove(snake.size() - 1); // удаляем последний сегмент
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            g.setColor(Color.RED);
            g.drawString("Игра окончена! Нажмите R для перезапуска", 50, 100);
            return;
        }

        // Рисуем змейку
        g.setColor(SNAKE_COLOR);
        for (int[] segment : snake) {
            g.fillRect(segment[1] * CELL_SIZE, segment[0] * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }

        // Рисуем еду
        g.setColor(FOOD_COLOR);
        g.fillRect(food[1] * CELL_SIZE, food[0] * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Змейка");
        SnakeGame game = new SnakeGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        game.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    game.resetGame();
                }
            }
        });
    }

    private void resetGame() {
        snakeLength = 1;
        snake.clear();
        snake.add(new int[]{HEIGHT / 2, WIDTH / 2});
        placeFood();
        gameOver = false;
        timer.start();
        repaint();
    }
}