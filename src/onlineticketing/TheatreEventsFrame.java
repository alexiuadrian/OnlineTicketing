package onlineticketing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TheatreEventsFrame extends JFrame {
    public static final String NEW_theatreevent = "<New theatreevent>";
    public TheatreEventsFrame(MyContract proxy){
        setTitle("Theatre Event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1920, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JSplitPane splitPane = new JSplitPane();
        splitPane.setResizeWeight(0.3);
        contentPane.add(splitPane, BorderLayout.CENTER);
        final DefaultListModel<TheatreEvent> theatreEvents = new DefaultListModel<TheatreEvent>();
        JList<TheatreEvent> list = new JList<>(theatreEvents);
        //JList<String> list = new JList<>(playerNames);
        splitPane.setLeftComponent(list);
        JPanel panel = new JPanel();
        splitPane.setRightComponent(panel);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWeights = new double[]{1, 0};
        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0};
        gridBagLayout.rowWeights = new double[]{1, 0, 0};
        panel.setLayout(gridBagLayout);

        final TheatreEventsPanel theatreEventsPanel = new TheatreEventsPanel();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0 ;
        gridBagConstraints.gridy = 0;
        panel.add(theatreEventsPanel, gridBagConstraints);

        JPanel buttonsPanel  = new JPanel();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel.add(buttonsPanel, gridBagConstraints);

        // ----------------Create-------------------
        JButton createButton = new JButton("Create");
        createButton.addActionListener(event -> {
            TheatreEvent theatreEvent = theatreEventsPanel.getTheatreEvent();
            //if(!sportEvent.getName().isEmpty() && !sportEvent.getLocation().getVenue().isEmpty() && !sportEvent.getLocation().getCity().isEmpty() && !sportEvent.getLocation().getStreet().isEmpty() && !sportEvent.getSport().isEmpty() && !sportEvent.getTeam1().isEmpty() && !sportEvent.getTeam2().isEmpty()){
            try {
                theatreEvent = proxy.createTheatreEvent(theatreEvent.getName(), theatreEvent.getDay(), theatreEvent.getMonth(), theatreEvent.getYear(), theatreEvent.getHour(), theatreEvent.getMinutes(), theatreEvent.getLocation(), theatreEvent.getPrice(), theatreEvent.getGenre(),
                        theatreEvent.getAgeRestriction(), theatreEvent.getHall(), theatreEvent.getRow(), theatreEvent.getSeat(), theatreEvent.isGroupTicket());
                theatreEvents.addElement(theatreEvent);
                theatreEventsPanel.clear();
                list.setSelectedIndex(theatreEvents.size()-1);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(TheatreEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            //}
        });
        buttonsPanel.add(createButton);
        createButton.setVisible(false);

        // ----------------Create-------------------

        // ----------------Update-------------------
        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(event ->{
            TheatreEvent theatreEvent = theatreEventsPanel.getTheatreEvent();
            //if(!sportEvent.getName().isEmpty() && !sportEvent.getLocation().getVenue().isEmpty() && !sportEvent.getLocation().getCity().isEmpty() && !sportEvent.getLocation().getStreet().isEmpty() && !sportEvent.getSport().isEmpty() && !sportEvent.getTeam1().isEmpty() && !sportEvent.getTeam2().isEmpty()){
            try {
                if(proxy.updateTheatreEvent(theatreEvent)){
                    theatreEvents.set(list.getSelectedIndex(), theatreEvent);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(TheatreEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                if(proxy.deleteTheatreEvent(theatreEventsPanel.getTheatreEvent().getId())){
                    int index = list.getSelectedIndex();
                    list.setSelectedIndex(0);
                    theatreEvents.remove(index);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(TheatreEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonsPanel.add(deleteButton);
        deleteButton.setVisible(false);
        // ----------------Delete-------------------

        theatreEvents.addElement(new TheatreEvent().name(NEW_theatreevent));
        list.addListSelectionListener(event -> {
            TheatreEvent theatreEvent = ((JList<TheatreEvent>)event.getSource()).getSelectedValue();
            theatreEventsPanel.setTheatreEvent(theatreEvent);
            createButton.setVisible(NEW_theatreevent.equals(theatreEvent.getName()));
            updateButton.setVisible(!NEW_theatreevent.equals(theatreEvent.getName()));
            deleteButton.setVisible(!NEW_theatreevent.equals(theatreEvent.getName()));
        });

        try {
            proxy.readTheatreEvent().forEach(theatreEvent -> theatreEvents.addElement(theatreEvent));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(TheatreEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
