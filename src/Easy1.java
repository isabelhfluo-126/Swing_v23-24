import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Easy1 implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextArea ta; //typing area
    private int WIDTH=800;
    private int HEIGHT=700;


    public Easy1() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Easy1 easy1 = new Easy1();
        easy1.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(2, 3));
        //GridLayout makes everything the same size
        //todo: definition of borderlayout.

        //menu at top
        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        //end menu at top

//        ta = new JTextArea();
//        ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
//        mainFrame.add(ta);//add typing area, the top layer
        mainFrame.setJMenuBar(mb); //set menu bar

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        mainFrame.setVisible(true);//needs to be added for the changes to be seen.
    }

    private void showEventDemo() {

        JButton okButton = new JButton("OK");
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");
        JButton deleteButton = new JButton("Delete");
        ta = new JTextArea();
        ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
        statusLabel = new JLabel(" ");
        statusLabel.setSize(350, 100);

        mainFrame.add(ta);//adding the buttons in here
        mainFrame.add(okButton);
        mainFrame.add(submitButton);
        mainFrame.add(cancelButton);
        mainFrame.add(deleteButton);
        mainFrame.add(statusLabel);


        //what they are trying to scream
        okButton.setActionCommand("OK");
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Cancel");
        deleteButton.setActionCommand("Delete");

        //who listens for these screams
        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());
        deleteButton.addActionListener(new ButtonClickListener());

        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut)
            ta.cut();
        if (e.getSource() == paste)
            ta.paste();
        if (e.getSource() == copy)
            ta.copy();
        if (e.getSource() == selectAll)
            ta.selectAll();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            System.out.println(command);

            if (command.equals("OK")) {
                statusLabel.setText("Ok Button clicked.");
            } else if (command.equals("Submit")) {
                statusLabel.setText("Submit Button clicked.");
            } else if (command.equals("Cancel")) {
                statusLabel.setText("Cancel Button clicked.");
            } else {
                statusLabel.setText("Delete Button clicked.");
            }
        }
    }
}