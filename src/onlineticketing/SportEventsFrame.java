package onlineticketing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SportEventsFrame extends JFrame {
    public static final String NEW_sportevent = "<New sportevent>";
    public SportEventsFrame(MyContract proxy){
        setTitle("Sport Event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1920, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JSplitPane splitPane = new JSplitPane();
        splitPane.setResizeWeight(0.3);
        contentPane.add(splitPane, BorderLayout.CENTER);
        final DefaultListModel<SportEvent> sportevents = new DefaultListModel<SportEvent>();
        JList<SportEvent> list = new JList<>(sportevents);
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

        final SportEventsPanel sportEventsPanel = new SportEventsPanel();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0 ;
        gridBagConstraints.gridy = 0;
        panel.add(sportEventsPanel, gridBagConstraints);

        JPanel buttonsPanel  = new JPanel();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel.add(buttonsPanel, gridBagConstraints);

        // ----------------Create-------------------
        JButton createButton = new JButton("Create");
        createButton.addActionListener(event -> {
            SportEvent sportEvent = sportEventsPanel.getSportEvent();
            //if(!sportEvent.getName().isEmpty() && !sportEvent.getLocation().getVenue().isEmpty() && !sportEvent.getLocation().getCity().isEmpty() && !sportEvent.getLocation().getStreet().isEmpty() && !sportEvent.getSport().isEmpty() && !sportEvent.getTeam1().isEmpty() && !sportEvent.getTeam2().isEmpty()){
                try {
                    sportEvent = proxy.createSportEvent(sportEvent.getName(), sportEvent.getDay(), sportEvent.getMonth(), sportEvent.getYear(), sportEvent.getHour(), sportEvent.getMinutes(), sportEvent.getLocation(), sportEvent.getPrice(), sportEvent.getSport(),
                            sportEvent.getTeam1(), sportEvent.getTeam2(), sportEvent.getBlock(), sportEvent.getRow(), sportEvent.getSeat());
                    sportevents.addElement(sportEvent);
                    sportEventsPanel.clear();
                    list.setSelectedIndex(sportevents.size()-1);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(SportEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            //}
        });
        buttonsPanel.add(createButton);
        createButton.setVisible(false);

        // ----------------Create-------------------

        // ----------------Update-------------------
        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(event ->{
            SportEvent sportEvent = sportEventsPanel.getSportEvent();
            //if(!sportEvent.getName().isEmpty() && !sportEvent.getLocation().getVenue().isEmpty() && !sportEvent.getLocation().getCity().isEmpty() && !sportEvent.getLocation().getStreet().isEmpty() && !sportEvent.getSport().isEmpty() && !sportEvent.getTeam1().isEmpty() && !sportEvent.getTeam2().isEmpty()){
                try {
                    if(proxy.updateSportEvent(sportEvent)){
                        sportevents.set(list.getSelectedIndex(), sportEvent);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(SportEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                if(proxy.deleteSportEvent(sportEventsPanel.getSportEvent().getId())){
                    int index = list.getSelectedIndex();
                    list.setSelectedIndex(0);
                    sportevents.remove(index);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(SportEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonsPanel.add(deleteButton);
        deleteButton.setVisible(false);
        // ----------------Delete-------------------

        sportevents.addElement(new SportEvent().name(NEW_sportevent));
        list.addListSelectionListener(event -> {
            SportEvent sportEvent = ((JList<SportEvent>)event.getSource()).getSelectedValue();
            sportEventsPanel.setSportEvent(sportEvent);
            createButton.setVisible(NEW_sportevent.equals(sportEvent.getName()));
            updateButton.setVisible(!NEW_sportevent.equals(sportEvent.getName()));
            deleteButton.setVisible(!NEW_sportevent.equals(sportEvent.getName()));
        });

        try {
            proxy.readSportEvent().forEach(player -> sportevents.addElement(player));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(SportEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
