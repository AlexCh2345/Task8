import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 30));
        display.setEditable(false);
        panel.add(display, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));


        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };


        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(new ButtonClickListener(display, text));
            buttonPanel.add(button);
        }


        panel.add(buttonPanel, BorderLayout.CENTER);
        frame.add(panel);


        frame.setVisible(true);
    }

    public String eval(String expression) {
        try {
            return String.valueOf(new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression));
        } catch (Exception e) {
            return "Error";
        }
    }

    static class ButtonClickListener implements ActionListener {
        private JTextField display;
        private String text;

        public ButtonClickListener(JTextField display, String text) {
            this.display = display;
            this.text = text;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = display.getText();

            if (text.equals("=")) {
                try {
                    display.setText(eval(currentText));
                } catch (Exception ex) {
                    display.setText("Error");
                }
            } else {
                display.setText(currentText + text);
            }
        }

        public String eval(String expression) {
            try {
                return String.valueOf(new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression));
            } catch (Exception e) {
                return "Error";
            }
        }
    }

}