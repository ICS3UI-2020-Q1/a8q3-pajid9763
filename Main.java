import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  JLabel fahLabel;
  JLabel celLabel;

  JTextField fahInput;
  JTextField celInput;

  JButton fcButton;
  JButton cfButton;
  

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main JPanel 
    mainPanel = new JPanel();
    // turn on manual layouts 
    mainPanel.setLayout(null);
    // add the main panel to JFrame 
    frame.add(mainPanel);


    // create the labels 
    fahLabel = new JLabel("Degrees Fahrenheit");
    celLabel = new JLabel("Degrees Celcius");

    // set the location and size of the labels
    fahLabel.setBounds(40, 40, 150, 25);
    celLabel.setBounds(40, 80, 150, 25);

    // add the labels to the main panel 
    mainPanel.add(fahLabel);
    mainPanel.add(celLabel);
 

    // initialize the JTextFields 
    fahInput = new JTextField();
    celInput = new JTextField();

    // set the location and size of the text fields 
    fahInput.setBounds(210, 40, 150, 25);
    celInput.setBounds(210, 80, 150, 25);

    // add the labels to the main panel 
    mainPanel.add(fahInput);
    mainPanel.add(celInput);


    // initialize the JButtons
    fcButton = new JButton("F -> C");
    cfButton = new JButton("C -> F");

    // add actionListener to the buttons 
    fcButton.addActionListener(this);
    cfButton.addActionListener(this);

    // add action command to the buttons 
    fcButton.setActionCommand("fc");
    cfButton.setActionCommand("cf");

    // set the location and size of the buttons 
    fcButton.setBounds(375, 40, 80, 25);
    cfButton.setBounds(375, 80, 80, 25);

    // add the buttons to the main panel 
    mainPanel.add(fcButton);
    mainPanel.add(cfButton);
    
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if (command.equals("fc")){
      // get the text as a String
      String fahText = fahInput.getText();
      // convert String to double 
      double fahNumber = Double.parseDouble(fahText);
      // calculate Fahrenheit to Celcius
      double fahToCel = (fahNumber - 32)* 5 / 9;
      // convert double to String 
      String fahToCelResult = String.valueOf(fahToCel);
      // write the degrees in Celsius in the celInput
      celInput.setText(fahToCelResult);
    
    } else if (command.equals("cf")){
      // get the text as a String
      String celText = celInput.getText();
      // convert String to double
      double celNumber = Double.parseDouble(celText);
      // calculate Celsius to Fahrenheit
      double celToFah = (celNumber * 9)/5 + 32;
      // convert double to String
      String celToFahResult = String.valueOf(celToFah);
      // write the degrees Fahrenheit in the fahInput
      fahInput.setText(celToFahResult);
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
