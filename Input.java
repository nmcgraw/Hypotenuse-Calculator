/*	Author:				Nick McGraw
 * 	Project:			Hypotenuse Calculator
 * 	Project Purpose:	The program takes input from the user for the lengths of
 * 						two legs of a right triangle, calculates the hypotenuse
 * 						of the right triangle with the given leg lengths, and
 * 						draws the triangle with labeled dimensions.
 * 	Class:				Input (MAIN)
 * 	Class Purpose:		Upon execution, a JFrame window appears with two labels,
 * 						two text fields, and a button. When the user clicks the
 * 						button, the program uses parse methods to store the
 * 						values entered in the text fields into two public
 * 						variables. An instance of the Graph class is made, using
 * 						the variables to determine its size.
 */	

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Input {

	public static int leg1 = 0;
	public static int leg2 = 0;
	public static int leg1modified = 0;
	public static int leg2modified = 0;
	
	public static void main(String[] args){
		JFrame theGUI = new JFrame("Hypotenuse Calculator");
		JPanel panel = new JPanel();
		JLabel leg1Label = new JLabel("Leg 1 Length:");
		final JTextField leg1Field = new JTextField(4);
		JLabel leg2Label = new JLabel("Leg 2 Length:");
		final JTextField leg2Field = new JTextField(4);
		JButton calcButton = new JButton("Calculate Hypotenuse & Generate Graph");
		JLabel instructions = new JLabel("Only use integer values. If you enter a decimal,");
		JLabel instructions2 = new JLabel("it will be rounded down to the nearest integer.");
		panel.add(leg1Label);
		panel.add(leg1Field);
		panel.add(leg2Label);
		panel.add(leg2Field);
		panel.add(calcButton);
		panel.add(instructions);
		panel.add(instructions2);
		theGUI.add(panel);
		theGUI.setSize(300, 150);
		theGUI.setVisible(true);
		calcButton.addMouseListener(new MouseAdapter(){
	    	  public void mouseClicked(MouseEvent e) { 
	    		  if (e.getButton() == MouseEvent.BUTTON1) {
	    			  JFrame graphGUI = new JFrame("Triangle Graph");
	    			  double leg1d = Double.parseDouble(leg1Field.getText());
	    			  double leg2d = Double.parseDouble(leg2Field.getText());
	    			  leg1 = (int)leg1d;
	    			  leg2 = (int)leg2d;
	    			  leg1modified = leg1;
	    			  leg2modified = leg2;
	    			  if (leg1modified >= leg2modified){
	    				  modifyLegs(leg1modified, leg2modified);
	    				  graphGUI.setSize((leg1modified * 100 + 60), (leg2modified * 100 + 80));
	    			  } else{
	    				  modifyLegs(leg2modified, leg1modified);
	    				  graphGUI.setSize((leg2modified * 100 + 60), (leg1modified * 100 + 80));
	    			  }
	    			  Graph graphPanel = new Graph(Color.white);
	    			  if (leg1modified >= leg2modified){
	    				  graphPanel.setSize((leg1modified * 100 + 60), (leg2modified * 100 + 80));
	    			  } else{
	    				  graphPanel.setSize((leg2modified * 100 + 60), (leg1modified * 100 + 80));
	    			  }
	    			  Container pane = graphGUI.getContentPane();
	    			  pane.setLayout(new GridLayout(1, 1));
	    			  pane.add(graphPanel);
	    			  pane.setVisible(true);
	    			  graphGUI.setVisible(true);
	    		  }
	    	  }
	    });
	}
	
	public static void modifyLegs(double x, double y){
		while (x > 12 || y > 6){
			x = x * .999;
			y = y * .999;
		}
		if (leg1modified >= leg2modified){
			leg1modified = (int)x;
			leg2modified = (int)y;
		} else{
			leg2modified = (int)x;
			leg1modified = (int)y;
		}
	}
}
