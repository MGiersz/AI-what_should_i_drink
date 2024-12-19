package com.sample;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GuiClass {
    private String question;
    private List<String> answers;
    private String selectedAnswer;
    private JFrame frame;
    private JPanel panel;

    public GuiClass(String question, List<String> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String gui() {
        frame = new JFrame("Question");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel questionLabel = new JLabel(question, SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(questionLabel, BorderLayout.NORTH);

        JPanel answersPanel = new JPanel();
        answersPanel.setLayout(new GridLayout(answers.size(), 1, 10, 10)); 

        for (String answer : answers) {
            JButton answerButton = new JButton(answer);
            answerButton.addActionListener(e -> {
                selectedAnswer = answer;
                frame.dispose();
            });
            answersPanel.add(answerButton);
        }

        frame.add(answersPanel, BorderLayout.CENTER);

        

        frame.setVisible(true);
        while (frame.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return selectedAnswer;
    }


    public void showResult(String[] pictures) {
        JFrame resultFrame = new JFrame("What should I drink? (SODA POP EDITION)");
        int rows = (int) Math.ceil(pictures.length / 3.0);
        JPanel resultPanel = new JPanel(new GridLayout(rows, 3, 10, 10));

        JLabel instructionLabel = new JLabel("You should drink one of these:");
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel instructionPanel = new JPanel();
        instructionPanel.setLayout(new BorderLayout());
        instructionPanel.add(instructionLabel, BorderLayout.CENTER);

        resultFrame.add(instructionPanel, BorderLayout.NORTH);

        for (String picture : pictures) {
            ImageIcon imageIcon = new ImageIcon("src/main/resources/images/" + picture + ".png");
            Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon resizedImageIcon = new ImageIcon(image);
            JLabel label = new JLabel(resizedImageIcon);
            resultPanel.add(label);
        }

        JScrollPane scrollPane = new JScrollPane(resultPanel);
        resultFrame.add(scrollPane, BorderLayout.CENTER);

        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultFrame.setSize(500, 500);
        resultFrame.setVisible(true);
        resultFrame.pack();
    }

    public void close() {
        if (frame != null) {
            frame.setVisible(false);
            frame.dispose();
        }
        frame = new JFrame();
    }
}
