package onlineticketing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MovieEventsFrame extends JFrame {
    public static final String NEW_movieevent = "<New movieevent>";
    public MovieEventsFrame(MyContract proxy){
        setTitle("Movie Event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1920, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JSplitPane splitPane = new JSplitPane();
        splitPane.setResizeWeight(0.3);
        contentPane.add(splitPane, BorderLayout.CENTER);
        final DefaultListModel<MovieEvent> movieEvents = new DefaultListModel<MovieEvent>();
        JList<MovieEvent> list = new JList<>(movieEvents);
        splitPane.setLeftComponent(list);
        JPanel panel = new JPanel();
        splitPane.setRightComponent(panel);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWeights = new double[]{1, 0};
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0};
        gridBagLayout.rowWeights = new double[]{1, 0, 0};
        panel.setLayout(gridBagLayout);

        final MovieEventsPanel movieEventsPanel = new MovieEventsPanel();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0 ;
        gridBagConstraints.gridy = 0;
        panel.add(movieEventsPanel, gridBagConstraints);

        JPanel buttonsPanel  = new JPanel();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel.add(buttonsPanel, gridBagConstraints);

        // ----------------Create-------------------
        JButton createButton = new JButton("Create");
        createButton.addActionListener(event -> {
            MovieEvent movieEvent = movieEventsPanel.getMovieEvent();
            //if(!sportEvent.getName().isEmpty() && !sportEvent.getLocation().getVenue().isEmpty() && !sportEvent.getLocation().getCity().isEmpty() && !sportEvent.getLocation().getStreet().isEmpty() && !sportEvent.getSport().isEmpty() && !sportEvent.getTeam1().isEmpty() && !sportEvent.getTeam2().isEmpty()){
            try {
                movieEvent = proxy.createMovieEvent(movieEvent.getName(), movieEvent.getDay(), movieEvent.getMonth(), movieEvent.getYear(), movieEvent.getHour(), movieEvent.getMinutes(), movieEvent.getLocation(), movieEvent.getPrice(), movieEvent.getGenre(),
                        movieEvent.getAgeRestriction(), movieEvent.getHall(), movieEvent.getRow(), movieEvent.getSeat());
                movieEvents.addElement(movieEvent);
                movieEventsPanel.clear();
                list.setSelectedIndex(movieEvents.size()-1);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(MovieEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            //}
        });
        buttonsPanel.add(createButton);
        createButton.setVisible(false);

        // ----------------Create-------------------

        // ----------------Update-------------------
        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(event ->{
            MovieEvent movieEvent = movieEventsPanel.getMovieEvent();
            //if(!sportEvent.getName().isEmpty() && !sportEvent.getLocation().getVenue().isEmpty() && !sportEvent.getLocation().getCity().isEmpty() && !sportEvent.getLocation().getStreet().isEmpty() && !sportEvent.getSport().isEmpty() && !sportEvent.getTeam1().isEmpty() && !sportEvent.getTeam2().isEmpty()){
            try {
                if(proxy.updateMovieEvent(movieEvent)){
                    movieEvents.set(list.getSelectedIndex(), movieEvent);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(MovieEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            //}
        });
        buttonsPanel.add(updateButton);
        updateButton.setVisible(false);
        // ----------------Update-------------------

        // ----------------Delete-------------------
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(event -> {
            try {
                if(proxy.deleteMovieEvent(movieEventsPanel.getMovieEvent().getId())){
                    int index = list.getSelectedIndex();
                    list.setSelectedIndex(0);
                    movieEvents.remove(index);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(MovieEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonsPanel.add(deleteButton);
        deleteButton.setVisible(false);
        // ----------------Delete-------------------

        movieEvents.addElement(new MovieEvent().name(NEW_movieevent));
        list.addListSelectionListener(event -> {
            MovieEvent movieEvent = ((JList<MovieEvent>)event.getSource()).getSelectedValue();
            movieEventsPanel.setMovieEvent(movieEvent);
            createButton.setVisible(NEW_movieevent.equals(movieEvent.getName()));
            updateButton.setVisible(!NEW_movieevent.equals(movieEvent.getName()));
            deleteButton.setVisible(!NEW_movieevent.equals(movieEvent.getName()));
        });

        try {
            proxy.readMovieEvent().forEach(player -> movieEvents.addElement(player));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(MovieEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
