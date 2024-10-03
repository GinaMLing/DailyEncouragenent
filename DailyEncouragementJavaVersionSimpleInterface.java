import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DailyEncouragementJavaVersionSimpleInterface {
    // Declare global variables for tracking happiness, experience, and other inputs
    private static int happiness = 0;
    private static int experience = 0;
    private static int feelScore = 0;
    private static String name = "";
    private static String issue = "";

    public static void main(String[] args) {
        // Create the main frame (window)
        JFrame frame = new JFrame("Daily Encouragement for Barbies :)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        // Create the main panel to add components & set the background
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 105, 180)); // Pink background
        panel.setLayout(new GridLayout(8, 1)); // 8 rows layout

        // Create labels, text fields, and buttons
        JLabel nameLabel = new JLabel("What is your name?");
        JTextField nameField = new JTextField(15);

        JLabel feelLabel = new JLabel("How are you feeling on a scale of 1-5?");
        JTextField feelField = new JTextField(5);

        JLabel feedbackLabel = new JLabel(""); // Label to display feedback
        JLabel responseLabel = new JLabel(""); // Label to display feedback


        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(255, 20, 147)); // Hot pink button
        submitButton.setForeground(new Color(255, 20, 147));

        JButton BreakThingsDownButton = new JButton("Help me break things down.");
        BreakThingsDownButton.setBackground(new Color(255, 20, 147)); // Blue button
        BreakThingsDownButton.setForeground(new Color(255, 20, 147));
        BreakThingsDownButton.setVisible(false); // Initially hidden until the first input is submitted

        JButton FurtherHelpButton = new JButton("Further Help!!");
        FurtherHelpButton.setBackground(new Color(255, 20, 147)); // Red button
        FurtherHelpButton.setForeground(new Color(255, 20, 147));
        FurtherHelpButton.setVisible(false); // Hidden until gamification starts

        // Add action listener to the submit button to handle inputs
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();  // Get the name input
                feelScore = Integer.parseInt(feelField.getText()); // Get the feeling score and convert to integer

                String feedback;
                if (feelScore >= 4) {
                    feedback = "Looks like you're having a good day, " + name + "!";
                    feedback += "\nTake a deep breath and enjoy this moment.";
                } else {
                    feedback = "Aww, " + name + ", something tough is happening!";
                    feedback += "\nLet's give you some encouragement!";
                }

                // Display feedback in the label
                feedbackLabel.setText("<html>" + feedback.replace("\n", "<br>") + "</html>");

                // Update happiness based on feel score
                happiness = 10 * feelScore;
                experience = feelScore >= 4 ? 100 : 50;  // For simplicity, assign some experience points

                // Enable the gamification button after input
                BreakThingsDownButton.setVisible(true);
            }
        });

        // Action for gamification session (interactive part)
        BreakThingsDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hide the submit button and show the end button
                submitButton.setVisible(false);
                FurtherHelpButton.setVisible(true);

                // Start the game with questions and random encouragement
                String gamificationMsg = "Let's break things down, " + name + "!";
                gamificationMsg += "\nWhat's on your mind? (relationship, school, work, etc.)";

                // Input dialog to simulate console input
                String issue = JOptionPane.showInputDialog(frame, "What's bothering you?").toLowerCase();

                if (issue.contains("boyfriend") || issue.contains("bf") || issue.contains("relationship") || issue.contains("breakup")
                        || issue.contains("friend") || issue.contains("family")) {

                    feedbackLabel.setText("<html>You should find someone who respects and supports you.<br>"
                            + "If he doesn't matter in a year, he doesn't deserve your time.<br>"
                            + "Think of one person you are grateful for, and stay in the moment for 10 seconds.<br>"
                            + "You gained 100 points of experience!</html>");
                    experience += 100;

                    if (Math.random() < 0.5) {
                        feedbackLabel.setText("<html>" + feedbackLabel.getText()
                                + "<br>Woah..you got really lucky this time.<br>You gained extra happiness!</html>");
                        happiness += 500;
                    } else {
                        feedbackLabel.setText("<html>" + feedbackLabel.getText()
                                + "<br>To cheer you up, I recommend Taylor Swift's 'You Are on Your Own, Kid' or 'I Can Do It with a Broken Heart'.</html>");
                    }

                } else if (issue.contains("test") || issue.contains("school") || issue.contains("work") || issue.contains("career")
                        || issue.contains("suck") || issue.contains("screw") || issue.contains("burnout")) {

                    feedbackLabel.setText("<html>You gotta focus on what you can control!<br>"
                            + "It is a fact that you can be whoever you want to be.<br>"
                            + "Take several deep breaths or watch the ceiling for 15 seconds.<br>"
                            + "Plan out what you're going to do from now.<br>"
                            + "You gained 100 points of experience!</html>");
                    experience += 100;

                    if (Math.random() < 0.5) {
                        feedbackLabel.setText("<html>" + feedbackLabel.getText()
                                + "<br>Woah..you got really lucky this time.<br>You gained extra happiness!</html>");
                        happiness += 500;
                    } else {
                        feedbackLabel.setText("<html>" + feedbackLabel.getText()
                                + "<br>To feel grounded, I recommend Lana Del Rey's 'Brooklyn Baby' and 'Young and Beautiful'.</html>");
                    }

                } else {
                    feedbackLabel.setText("<html>I have heard your problem, and it must be tough and overwhelming to deal with everything.<br>"
                            + "Maybe take a 5-minute break and continue.<br>Do you think you can solve it on your own? (yes/no)</html>");

                    // Asking the user if they think they can solve the problem on their own
                    String solveItOrNot = JOptionPane.showInputDialog(frame, "Do you think you can solve it on your own? (yes/no)").toLowerCase();

                    if (solveItOrNot.equals("yes")) {
                        feedbackLabel.setText("<html>Look at you!<br>That's great to hear!<br>You gained 500 points of happiness and experience!</html>");
                        happiness += 500;
                        experience += 500;
                    } else {
                        feedbackLabel.setText("<html>To make you feel better, I recommend:<br>Tessa Violet's 'Bad Bitch',<br>Doja Cat's 'Best Friend',<br>"
                                + "and Taylor Swift's 'Cruel Summer'.<br>You can also call one of our therapists.</html>");
                    }
                }

                // After handling the issue, show final gamification feedback
                feedbackLabel.setText(feedbackLabel.getText() + "<br><br>Current Status: Happiness = " + happiness + ", Experience = " + experience);
            }
        });

        // Further help
        FurtherHelpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a text field for user input
                JTextField inputField = new JTextField(10);  // 10 is the size of the text field

                // Create a panel to hold the inputField (to add it to the UI)
                JPanel panel = new JPanel();
                panel.add(inputField);

                // Use JOptionPane to show the text field in a dialog box
                int result = JOptionPane.showConfirmDialog(null, panel, "Want a therapist?", JOptionPane.OK_CANCEL_OPTION);

                // Check if the user pressed OK
                if (result == JOptionPane.OK_OPTION) {
                    String userInput = inputField.getText().toLowerCase();  // Get user input and convert it to lowercase

                    // Check if the input contains the word "yes"
                    if (userInput.contains("yes")) {
                        responseLabel.setText("<html>" + responseLabel.getText() + "<br>Pick one of our therapists.</html>");
                    } else {
                        responseLabel.setText("<html>" + responseLabel.getText() + "<br>Have a nice day :)</html>");
                    }
                } else {
                    responseLabel.setText("<html>" + responseLabel.getText() + "<br>Have a nice day :)</html>");
                }
            }
        });

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(feelLabel);
        panel.add(feelField);
        panel.add(submitButton);
        panel.add(BreakThingsDownButton);
        panel.add(FurtherHelpButton);
        panel.add(feedbackLabel);

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(feelLabel);
        panel.add(feelField);
        panel.add(submitButton);
        panel.add(BreakThingsDownButton);
        panel.add(FurtherHelpButton);
        panel.add(feedbackLabel);
        panel.add(responseLabel);

        // Add the panel to the frame and make the frame visible
        frame.add(panel);
        frame.setVisible(true);
    }
}
