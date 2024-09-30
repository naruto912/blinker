import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlinkerLightApp {
    private static final int BLINK_INTERVAL = 500; // in milliseconds
    private static boolean isLightOn = false; // State of the light
    private static JPanel lightPanel; // Panel to represent the light
    private static Timer timer; // Timer for blinking

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BlinkerLightApp::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Blinker Light App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Create a panel to represent the light
        lightPanel = new JPanel();
        lightPanel.setBackground(Color.RED); // Start with the light off (red color)
        lightPanel.setPreferredSize(new Dimension(100, 100));
        frame.add(lightPanel, BorderLayout.CENTER);

        // Create a button to start/stop blinking
        JButton toggleButton = new JButton("Start/Stop Blinking");
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleBlinking();
            }
        });
        frame.add(toggleButton, BorderLayout.SOUTH);

        // Initialize the timer
        timer = new Timer(BLINK_INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isLightOn = !isLightOn; // Toggle the light state
                lightPanel.setBackground(isLightOn ? Color.GREEN : Color.RED); // Change color
            }
        });

        frame.setVisible(true);
    }

    private static void toggleBlinking() {
        if (timer.isRunning()) {
            timer.stop(); // Stop the blinking if it's already running
            lightPanel.setBackground(Color.RED); // Ensure the light is off when stopped
        } else {
            timer.start(); // Start blinking
        }
    }
}
