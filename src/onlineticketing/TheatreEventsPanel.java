package onlineticketing;


import javax.swing.*;
import java.awt.*;

public class TheatreEventsPanel extends JPanel {
    private JTextField []textFields = new JTextField[20];
    private JLabel []labels = new JLabel[20];
    private TheatreEvent theatreEvent;

    public TheatreEventsPanel(){
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0, 1, 0};

        gridBagLayout.rowHeights =new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowWeights = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

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

        labels[12] = new JLabel("Genre");
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

        labels[13] = new JLabel("Age restriction");
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

        labels[14] = new JLabel("Hall");
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

        labels[15] = new JLabel("Row");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        add(labels[15], gridBagConstraints);

        textFields[15] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        add(textFields[15], gridBagConstraints);
        textFields[15].setColumns(10);

        labels[16] = new JLabel("Seat");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        add(labels[16], gridBagConstraints);

        textFields[16] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        add(textFields[16], gridBagConstraints);
        textFields[16].setColumns(10);

        labels[17] = new JLabel("Group ticket");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        add(labels[17], gridBagConstraints);

        textFields[17] = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        add(textFields[17], gridBagConstraints);
        textFields[17].setColumns(10);
    }



    public void setTheatreEvent(TheatreEvent theatreEvent){
        this.theatreEvent = theatreEvent;
        textFields[0].setText(theatreEvent.getName().equalsIgnoreCase(TheatreEventsFrame.NEW_theatreevent) ? "" : theatreEvent.getName());
        textFields[1].setText(Integer.toString(theatreEvent.getDay()));
        textFields[2].setText(Integer.toString(theatreEvent.getMonth()));
        textFields[3].setText(Integer.toString(theatreEvent.getYear()));
        textFields[4].setText(Integer.toString(theatreEvent.getHour()));
        textFields[5].setText(Integer.toString(theatreEvent.getMinutes()));
        textFields[6].setText(theatreEvent.getName().equalsIgnoreCase(TheatreEventsFrame.NEW_theatreevent) ? "" : theatreEvent.getLocation().getVenue());
        textFields[7].setText(theatreEvent.getName().equalsIgnoreCase(TheatreEventsFrame.NEW_theatreevent) ? "" : theatreEvent.getLocation().getCity());
        textFields[8].setText(theatreEvent.getName().equalsIgnoreCase(TheatreEventsFrame.NEW_theatreevent) ? "" : theatreEvent.getLocation().getStreet());
        textFields[9].setText(theatreEvent.getName().equalsIgnoreCase(TheatreEventsFrame.NEW_theatreevent) ? "" : Integer.toString(theatreEvent.getLocation().getNumber()));
        textFields[10].setText(theatreEvent.getName().equalsIgnoreCase(TheatreEventsFrame.NEW_theatreevent) ? "" : Integer.toString(theatreEvent.getLocation().getZipCode()));
        textFields[11].setText(Double.toString(theatreEvent.getPrice()));
        textFields[12].setText(theatreEvent.getGenre());
        textFields[13].setText(Integer.toString(theatreEvent.getAgeRestriction()));
        textFields[14].setText(Integer.toString(theatreEvent.getHall()));
        textFields[15].setText(Integer.toString(theatreEvent.getRow()));
        textFields[16].setText(Integer.toString(theatreEvent.getSeat()));
        textFields[17].setText(Boolean.toString(theatreEvent.isGroupTicket()));
        textFields[0].requestFocus();
    }

    public TheatreEvent getTheatreEvent(){

        theatreEvent.location = new Location(textFields[6].getText(), textFields[7].getText(), textFields[8].getText(), Integer.parseInt(textFields[9].getText()), Integer.parseInt(textFields[10].getText()));

        theatreEvent.name(textFields[0].getText());
        theatreEvent.day(Integer.parseInt(textFields[1].getText()));
        theatreEvent.month(Integer.parseInt(textFields[2].getText()));
        theatreEvent.year(Integer.parseInt(textFields[3].getText()));
        theatreEvent.hour(Integer.parseInt(textFields[4].getText()));
        theatreEvent.minutes(Integer.parseInt(textFields[5].getText()));
//        theatreEvent.location.setVenue(textFields[6].getText());
//        theatreEvent.location.setCity(textFields[7].getText());
//        theatreEvent.location.setStreet(textFields[8].getText());
//        theatreEvent.location.setNumber(Integer.parseInt(textFields[9].getText()));
//        theatreEvent.location.setZipCode(Integer.parseInt(textFields[10].getText()));
        theatreEvent.price(Double.parseDouble(textFields[11].getText()));
        theatreEvent.genre(textFields[12].getText());
        theatreEvent.ageRestriction(Integer.parseInt(textFields[13].getText()));
        theatreEvent.hall(Integer.parseInt(textFields[14].getText()));
        theatreEvent.row(Integer.parseInt(textFields[15].getText()));
        theatreEvent.seat(Integer.parseInt(textFields[16].getText()));
        theatreEvent.groupTicket(Boolean.parseBoolean(textFields[17].getText()));

        System.out.println(theatreEvent);

        return theatreEvent;
    }

    public void clear(){
        theatreEvent = new TheatreEvent();
        for(JTextField jTextField : textFields) {
            jTextField.setText("");
        }
    }
}
