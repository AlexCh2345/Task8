import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator2 {
    private JFrame frame;
    private JTextField display;
    private StringBuilder currentInput;

    public Calculator2() {
        frame = new JFrame("Калькулятор");
        display = new JTextField();
        currentInput = new StringBuilder();

        // Налаштування вікна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());

        // Панель для відображення введеного тексту
        display.setFont(new Font("Arial", Font.PLAIN, 30));
        display.setEditable(false);
        frame.add(display, BorderLayout.NORTH);

        // Панель для кнопок
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        // Список кнопок
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };

        // Додавання кнопок на панель
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String command = source.getText();

            switch (command) {
                case "C":
                    currentInput.setLength(0);
                    break;
                case "=":
                    try {
                        // Виконання обчислень
                        String result = evaluate(currentInput.toString());
                        currentInput.setLength(0);
                        currentInput.append(result);
                    } catch (Exception ex) {
                        currentInput.setLength(0);
                        currentInput.append("Error");
                    }
                    break;
                default:
                    currentInput.append(command);
                    break;
            }
            display.setText(currentInput.toString());
        }
    }

    private String evaluate(String expression) {
        // Для простоти використовуємо eval для обчислень
        // У реальних додатках слід використовувати безпечніший метод
        return String.valueOf(new Object() {
            int pos = -1;
            int ch;

            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                return x;
            }
        }.parse());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator2::new);
    }
}
