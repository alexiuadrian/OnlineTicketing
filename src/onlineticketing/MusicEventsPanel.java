package onlineticketing;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MusicEventsPanel extends JPanel {
    private JTextField []textFields = new JTextField[19];
    private JLabel []labels = new JLabel[19];
    private MusicEvent musicEvent;

    public MusicEventsPanel(){
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0, 1, 0};

        gridBagLayout.rowHeights =new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowWeights = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

        setLayout(gridBagLayout);

        labels[0] =  new JLabel("Name");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(labels[0], gridBagConstraints);

        textFields[0] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(textFields[0], gridBagConstraints);
        textFields[0].setColumns(10);

        labels[1] = new JLabel("Day");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(labels[1], gridBagConstraints);

        textFields[1] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(textFields[1], gridBagConstraints);
        textFields[1].setColumns(10);

        labels[2] = new JLabel("Month");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(labels[2], gridBagConstraints);

        textFields[2] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        add(textFields[2], gridBagConstraints);
        textFields[2].setColumns(10);

        labels[3] = new JLabel("Year");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        add(labels[3], gridBagConstraints);

        textFields[3] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        add(textFields[3], gridBagConstraints);
        textFields[3].setColumns(10);

        labels[4] = new JLabel("Hour");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        add(labels[4], gridBagConstraints);

        textFields[4] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        add(textFields[4], gridBagConstraints);
        textFields[4].setColumns(10);

        labels[5] = new JLabel("Minutes");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        add(labels[5], gridBagConstraints);

        textFields[5] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        add(textFields[5], gridBagConstraints);
        textFields[5].setColumns(10);

        labels[6] = new JLabel("Venue");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        add(labels[6], gridBagConstraints);

        textFields[6] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        add(textFields[6], gridBagConstraints);
        textFields[6].setColumns(10);

        labels[7] = new JLabel("City");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        add(labels[7], gridBagConstraints);

        textFields[7] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        add(textFields[7], gridBagConstraints);
        textFields[7].setColumns(10);

        labels[8] = new JLabel("Street");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        add(labels[8], gridBagConstraints);

        textFields[8] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        add(textFields[8], gridBagConstraints);
        textFields[8].setColumns(10);

        labels[9] = new JLabel("Number");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        add(labels[9], gridBagConstraints);

        textFields[9] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        add(textFields[9], gridBagConstraints);
        textFields[9].setColumns(10);

        labels[10] = new JLabel("Zipcode");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        add(labels[10], gridBagConstraints);

        textFields[10] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        add(textFields[10], gridBagConstraints);
        textFields[10].setColumns(10);

        labels[11] = new JLabel("Price");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        add(labels[11], gridBagConstraints);

        textFields[11] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        add(textFields[11], gridBagConstraints);
        textFields[11].setColumns(10);

        labels[12] = new JLabel("Artists");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        add(labels[12], gridBagConstraints);

        textFields[12] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        add(textFields[12], gridBagConstraints);
        textFields[12].setColumns(10);

        labels[13] = new JLabel("Genre");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        add(labels[13], gridBagConstraints);

        textFields[13] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        add(textFields[13], gridBagConstraints);
        textFields[13].setColumns(10);

        labels[14] = new JLabel("Food courts");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        add(labels[14], gridBagConstraints);

        textFields[14] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        add(textFields[14], gridBagConstraints);
        textFields[14].setColumns(10);
    }



    public void setMusicEvent(MusicEvent musicEvent){
        this.musicEvent = musicEvent;
        textFields[0].setText(musicEvent.getName().equalsIgnoreCase(MusicEventsFrame.NEW_musicevent) ? "" : musicEvent.getName());
        textFields[1].setText(Integer.toString(musicEvent.getDay()));
        textFields[2].setText(Integer.toString(musicEvent.getMonth()));
        textFields[3].setText(Integer.toString(musicEvent.getYear()));
        textFields[4].setText(Integer.toString(musicEvent.getHour()));
        textFields[5].setText(Integer.toString(musicEvent.getMinutes()));
        textFields[6].setText(musicEvent.getName().equalsIgnoreCase(MusicEventsFrame.NEW_musicevent) ? "" : musicEvent.getLocation().getVenue());
        textFields[7].setText(musicEvent.getName().equalsIgnoreCase(MusicEventsFrame.NEW_musicevent) ? "" : musicEvent.getLocation().getCity());
        textFields[8].setText(musicEvent.getName().equalsIgnoreCase(MusicEventsFrame.NEW_musicevent) ? "" : musicEvent.getLocation().getStreet());
        textFields[9].setText(musicEvent.getName().equalsIgnoreCase(MusicEventsFrame.NEW_musicevent) ? "" : Integer.toString(musicEvent.getLocation().getNumber()));
        textFields[10].setText(musicEvent.getName().equalsIgnoreCase(MusicEventsFrame.NEW_musicevent) ? "" : Integer.toString(musicEvent.getLocation().getZipCode()));
        textFields[11].setText(Double.toString(musicEvent.getPrice()));
        //textFields[12].setText(musicEvent.getArtists().toString());
        textFields[13].setText(musicEvent.getGenre());
        textFields[14].setText(Boolean.toString(musicEvent.isFoodCourts()));
        textFields[0].requestFocus();
    }

    public MusicEvent getMusicEvent(){

        List<String> artists = Arrays.asList(textFields[12].getText().split(","));

        musicEvent.location = new Location(textFields[6].getText(), textFields[7].getText(), textFields[8].getText(), Integer.parseInt(textFields[9].getText()), Integer.parseInt(textFields[10].getText()));

        musicEvent.name(textFields[0].getText());
        musicEvent.day(Integer.parseInt(textFields[1].getText()));
        musicEvent.month(Integer.parseInt(textFields[2].getText()));
        musicEvent.year(Integer.parseInt(textFields[3].getText()));
        musicEvent.hour(Integer.parseInt(textFields[4].getText()));
        musicEvent.minutes(Integer.parseInt(textFields[5].getText()));
//        musicEvent.location.setVenue(textFields[6].getText());
//        musicEvent.location.setCity(textFields[7].getText());
//        musicEvent.location.setStreet(textFields[8].getText());
//        musicEvent.location.setNumber(Integer.parseInt(textFields[9].getText()));
//        musicEvent.location.setZipCode(Integer.parseInt(textFields[10].getText()));
//        musicEvent.price(Double.parseDouble(textFields[11].getText()));
        musicEvent.artists(artists);
        musicEvent.foodCourts(Boolean.parseBoolean(textFields[13].getText()));

        System.out.println(musicEvent);

        return musicEvent;
    }

    public void clear(){
        musicEvent = new MusicEvent();
        for(JTextField jTextField : textFields) {
            jTextField.setText("");
        }
    }
}
