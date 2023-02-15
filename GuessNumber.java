package mysite;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessNumber extends JFrame implements ActionListener{

private JPanel panel = new JPanel(new BorderLayout());
private JPanel panelButtons = new JPanel(new FlowLayout());
private JPanel panelBottom = new JPanel(new BorderLayout());
private JTextField fieldBox = new JTextField(10);
private JButton button1 = new JButton("Try");
private JButton button2 = new JButton("Quit");
private JLabel comment = new JLabel("guess ..");
private int randomNumber;

public GuessNumber() {
super("Guess Number");
randomNumber = new Random().nextInt(100) + 1;
button1.addActionListener(this);
button2.addActionListener(this);
add(buildWindow());
setDefaultCloseOperation(EXIT_ON_CLOSE);
pack();
setLocationRelativeTo(null);
}
private JComponent buildWindow() {
panelButtons.add(button1);
panelButtons.add(button2);
panelBottom.add(panelButtons, BorderLayout.NORTH);
panelBottom.add(comment, BorderLayout.SOUTH);
panel.add(new JLabel("Guess a number from 1 to 100"), BorderLayout.NORTH);
panel.add(fieldBox, BorderLayout.CENTER);
panel.add(panelBottom, BorderLayout.SOUTH);
return panel;
}
public void actionPerformed(ActionEvent e) {
Object obj = e.getSource();
if (obj.equals(button1)){
comment.setText(" ");
compareResult();
} else if (obj.equals(button2)){
System.exit(0);
}
}
private void compareResult(){
int userInput=0;
int diff;
int Difference;
try {
userInput = Integer.parseInt(
fieldBox.getText().trim());
} catch (Exception ex){
comment.setText("Enter a VALID number!");
return;
}
if (userInput == randomNumber){
JOptionPane.showMessageDialog(null, "CONGRATULATIONS! You got it!!",
"Random Number: " + randomNumber, JOptionPane.INFORMATION_MESSAGE);
randomNumber = new Random().nextInt(100) + 1;
return;
}
if (userInput > randomNumber){
comment.setText( "Too High. Try a lower number." );
diff=userInput - randomNumber;
Difference=Math.abs(diff);
} else {
comment.setText( "Too Low. Try a higher number." );
diff=randomNumber - userInput;
Difference=Math.abs(diff);
}

if(Difference<=25){
  comment.setText("Differnce is less than or equal to 25");
  setBackgroundColor(Color.blue);
}

if(Difference<=10){
  comment.setText("Differnce is less than or equal to 15");
  setBackgroundColor(Color.red);
}

else {
}
}
private void setBackgroundColor(Color color){
panel.setBackground(color);
panelBottom.setBackground(color);
panelButtons.setBackground(color);
}
public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
public void run() {
GuessNumber GuessNumber = new GuessNumber();
GuessNumber.setVisible(true);
GuessNumber.setSize(400,400);
}
});
}
}