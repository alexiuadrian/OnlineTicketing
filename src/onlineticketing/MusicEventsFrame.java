package onlineticketing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MusicEventsFrame extends JFrame {
    public static final String NEW_musicevent = "<New musicevent>";
    public MusicEventsFrame(MyContract proxy){
        setTitle("Music Event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1920, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JSplitPane splitPane = new JSplitPane();
        splitPane.setResizeWeight(0.3);
        contentPane.add(splitPane, BorderLayout.CENTER);
        final DefaultListModel<MusicEvent> musicEvents = new DefaultListModel<MusicEvent>();
        JList<MusicEvent> list = new JList<>(musicEvents);
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

        final MusicEventsPanel musicEventsPanel = new MusicEventsPanel();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0 ;
        gridBagConstraints.gridy = 0;
        panel.add(musicEventsPanel, gridBagConstraints);

        JPanel buttonsPanel  = new JPanel();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel.add(buttonsPanel, gridBagConstraints);

        // ----------------Create-------------------
        JButton createButton = new JButton("Create");
        createButton.addActionListener(event -> {
            MusicEvent musicEvent = musicEventsPanel.getMusicEvent();
            //if(!sportEvent.getName().isEmpty() && !sportEvent.getLocation().getVenue().isEmpty() && !sportEvent.getLocation().getCity().isEmpty() && !sportEvent.getLocation().getStreet().isEmpty() && !sportEvent.getSport().isEmpty() && !sportEvent.getTeam1().isEmpty() && !sportEvent.getTeam2().isEmpty()){
            try {
                musicEvent = proxy.createMusicEvent(musicEvent.getName(), musicEvent.getDay(), musicEvent.getMonth(), musicEvent.getYear(), musicEvent.getHour(), musicEvent.getMinutes(), musicEvent.getLocation(), musicEvent.getPrice(), musicEvent.getArtists(),
                        musicEvent.getGenre(), musicEvent.isFoodCourts());
                musicEvents.addElement(musicEvent);
                musicEventsPanel.clear();
                list.setSelectedIndex(musicEvents.size()-1);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(MusicEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            //}
        });
        buttonsPanel.add(createButton);
        createButton.setVisible(false);

        // ----------------Create-------------------

        // ----------------Update-------------------
        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(event ->{
            MusicEvent musicEvent = musicEventsPanel.getMusicEvent();
            //if(!sportEvent.getName().isEmpty() && !sportEvent.getLocation().getVenue().isEmpty() && !sportEvent.getLocation().getCity().isEmpty() && !sportEvent.getLocation().getStreet().isEmpty() && !sportEvent.getSport().isEmpty() && !sportEvent.getTeam1().isEmpty() && !sportEvent.getTeam2().isEmpty()){
            try {
                if(proxy.updateMusicEvent(musicEvent)){
                    musicEvents.set(list.getSelectedIndex(), musicEvent);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(MusicEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                if(proxy.deleteSportEvent(musicEventsPanel.getMusicEvent().getId())){
                    int index = list.getSelectedIndex();
                    list.setSelectedIndex(0);
                    musicEvents.remove(index);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(MusicEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonsPanel.add(deleteButton);
        deleteButton.setVisible(false);
        // ----------------Delete-------------------

        musicEvents.addElement(new MusicEvent().name(NEW_musicevent));
        list.addListSelectionListener(event -> {
            MusicEvent musicEvent = ((JList<MusicEvent>)event.getSource()).getSelectedValue();
            musicEventsPanel.setMusicEvent(musicEvent);
            createButton.setVisible(NEW_musicevent.equals(musicEvent.getName()));
            updateButton.setVisible(!NEW_musicevent.equals(musicEvent.getName()));
            deleteButton.setVisible(!NEW_musicevent.equals(musicEvent.getName()));
        });

        try {
            proxy.readMusicEvent().forEach(musicEvent -> musicEvents.addElement(musicEvent));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(MusicEventsFrame.this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
