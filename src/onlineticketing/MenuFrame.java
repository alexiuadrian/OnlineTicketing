package onlineticketing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuFrame extends JFrame {
    public MenuFrame(MyContract proxy) {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JSplitPane splitPane = new JSplitPane();
        splitPane.setResizeWeight(0.3);
        contentPane.add(splitPane, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        splitPane.setRightComponent(panel);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWeights = new double[]{1, 0};
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0};
        gridBagLayout.rowWeights = new double[]{1, 0, 0};
        panel.setLayout(gridBagLayout);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        JPanel buttonsPanel = new JPanel();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel.add(buttonsPanel, gridBagConstraints);

        JButton sportButton = new JButton("Sport Event");
        sportButton.addActionListener(event -> {
            new SportEventsFrame(proxy).setVisible(true);
        });
        buttonsPanel.add(sportButton);
        sportButton.setVisible(true);


        JButton movieButton = new JButton("Movie Event");
        movieButton.addActionListener(event -> {

            new MovieEventsFrame(proxy).setVisible(true);
        });
        buttonsPanel.add(movieButton);
        movieButton.setVisible(true);

        JButton musicButton = new JButton("Music Event");
        musicButton.addActionListener(event -> {

            new MusicEventsFrame(proxy).setVisible(true);
        });
        buttonsPanel.add(musicButton);
        musicButton.setVisible(true);

        JButton theatreButton = new JButton("Theatre Event");
        theatreButton.addActionListener(event -> {

            new TheatreEventsFrame(proxy).setVisible(true);
        });
        buttonsPanel.add(theatreButton);
        theatreButton.setVisible(true);
    }
}
