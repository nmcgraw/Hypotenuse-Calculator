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
 * 
 * **********READ THE COMMENTS ON THIS CLASS FIRST**********
 * **********READ THE COMMENTS ON THIS CLASS FIRST**********
 * **********READ THE COMMENTS ON THIS CLASS FIRST**********
 * **********READ THE COMMENTS ON THIS CLASS FIRST**********
 * **********READ THE COMMENTS ON THIS CLASS FIRST**********
 * **********READ THE COMMENTS ON THIS CLASS FIRST**********
 */	

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InputWithComments {

	/*	There are no restrictions on how large the input can be, but there is a
	 * 	point at which the graph will not be able to fit on the monitor. However,
	 * 	since the graph is not measured in any particular unit, scale does not
	 * 	matter, so similarity is the only issue in accuracy for the graph. This
	 * 	means that there has to be two variables for the exact input by the user
	 * 	as well as two variables with the same ratio but simplified to a place
	 * 	where they can be used in the process of sizing the graph of the triangle.
	 */
	
	//Declares variables for the leg lengths as given by the user:
	public static int leg1;
	public static int leg2;
	//Declares variables for the simplified leg lengths that will be used to correctly size the graph window:
	public static int leg1modified;
	public static int leg2modified;
	
	//MAIN METHOD
	public static void main(String[] args){
		//Creates the window for inputting values:
		JFrame theGUI = new JFrame("Hypotenuse Calculator"); //The Frame
		JPanel panel = new JPanel(); //The Panel
		JLabel leg1Label = new JLabel("Leg 1 Length:"); //The Label that identifies the first TextField
		final JTextField leg1Field = new JTextField(4); //The first TextField
		JLabel leg2Label = new JLabel("Leg 2 Length:"); //The Label that identifies the second TextField
		final JTextField leg2Field = new JTextField(4); //The second TextField
		JButton calcButton = new JButton("Calculate Hypotenuse & Generate Graph"); //The Button that confirms the input
		/*	Because an exact value expression cannot be translated with a single parse
		 * 	method, only integers and terminating decimals can possibly be entered. Since
		 * 	Pythagorean triples can be multiplied by a common factor and sizing a JFrame in
		 * 	Java can only use integers, there should be no need to use a double number.
		 * 	Instead of having the user try to enter a double a bunch of times and recieve a
		 * 	bunch of error messages, the code has been modified to cast a double as an
		 * 	integer, and the following two labels give the user fair warning of it.
		 */
		JLabel instructions = new JLabel("Only use integer values. If you enter a decimal,"); //First line of statement
		JLabel instructions2 = new JLabel("it will be rounded down to the nearest integer."); //Second line of statement
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
		
		//Click Event Procedure for the calcButton:
		calcButton.addMouseListener(new MouseAdapter(){
	    	  public void mouseClicked(MouseEvent e) { 
	    		  if (e.getButton() == MouseEvent.BUTTON1) {
	    			  JFrame graphGUI = new JFrame("Triangle Graph"); //Initializes a JFrame that the graph will be placed on
	    			  double leg1d = Double.parseDouble(leg1Field.getText()); //Parses the input for the first leg
	    			  double leg2d = Double.parseDouble(leg2Field.getText()); //Parses the input for the second leg
	    			  leg1 = (int)leg1d; //Initializes the leg1 variable as the rounded-down input for the first leg
	    			  leg2 = (int)leg2d; //Initializes the leg2 variable as the rounded-down input for the second leg
	    			  leg1modified = leg1; //Initializes the leg1modified variable to start with the same value as the input
	    			  leg2modified = leg2; //Initializes the leg2modified variable to start with the same value as the input
	    			  /*	To make it easier to document the general triangle structure for sizing
	    			   * 	purposes, the longest leg is always correspondent to the x-value and the
	    			   * 	shortest is always correspondent to the y-value since a monitor is
	    			   * 	almost always wider than it is tall. The three if-statements in the
	    			   * 	code for this class serve the purpose of making sure that the longer
	    			   * 	leg always corresponds to the width property of graphGUI and its panel. 
	    			   */
	    			  if (leg1modified >= leg2modified){
	    				  modifyLegs(leg1modified, leg2modified); //THE METHOD IS LOCATED AT THE BOTTOM
	    				  graphGUI.setSize((leg1modified * 100 + 60), (leg2modified * 100 + 80)); //The *100 makes it larger, the +60 adds margin room
	    			  } else{
	    				  modifyLegs(leg2modified, leg1modified); //THE METHOD IS LOCATED AT THE BOTTOM
	    				  graphGUI.setSize((leg2modified * 100 + 60), (leg1modified * 100 + 80)); //The *100 makes it larger, the +60 adds margin room
	    			  }
	    			  GraphWithComments graphPanel = new GraphWithComments(Color.white); //Initializes an instance of the GraphWithComments class
	    			  if (leg1modified >= leg2modified){
	    				  graphPanel.setSize((leg1modified * 100 + 60), (leg2modified * 100 + 80)); //Same size as graphGUI
	    			  } else{
	    				  graphPanel.setSize((leg2modified * 100 + 60), (leg1modified * 100 + 80)); //Same size as graphGUI
	    			  }
	    			  Container pane = graphGUI.getContentPane(); //Creates a pane for graphGUI
	    			  pane.setLayout(new GridLayout(1, 1)); //Specifies the pane to only have one cell
	    			  pane.add(graphPanel); //The instance of the GraphWithComments class is added to the pane
	    			  pane.setVisible(true);
	    			  graphGUI.setVisible(true);
	    		  }
	    	  }
	    });
	}
	
	//Method for simplifying the leg lengths:
	public static void modifyLegs(double x, double y){
		/*	The monitor size will vary from computer to computer, but a reasonably sized monitor
		 * 	should fit a window with the limits used in this code. With the screen used for
		 * 	creating this project, 12 and 6 appeared to be good approximations for the limits. The
		 * 	while loop decreases both values by a common factor until they BOTH shrink below their
		 * 	limits (as dictated by the "or" operator).
		 */
		while (x > 12 || y > 6){
			x = x * .999;
			y = y * .999;
		}
		/*	Even though x has already been arranged by the parameters to be the larger value, the
		 * 	legs still need to be assigned their new values. Since more than one possible
		 * 	parameter can be used in this method, distinguishing the large of the two has to be
		 * 	repeated in order to execute the correct assignment statements. x and y are doubles,
		 * 	but they can be converted to integers with a cast in this case since the objective is
		 * 	to go smaller anyway.
		 */
		if (leg1modified >= leg2modified){
			leg1modified = (int)x;
			leg2modified = (int)y;
		} else{
			leg2modified = (int)x;
			leg1modified = (int)y;
		}
	}
}

//SUMMARY:
/* A window was used by the user to input values for two legs of a right triangle. The user was
 * warned that entering a double would result in rounding down. When the user finished entering
 * data, calcButton was clicked, triggering a procedure to create an instance of the graphic
 * class GraphWithComments. The procedure began with six variables being initialized. Two of
 * them parsed the inputs for each leg, and the other four took casted double-to-integer values
 * of the first two. Two of the four represented the first leg, and the next two represented
 * the other leg. One of each representation kept its value for the remainder of the procedure
 * while the other was used in a simplification method to restrict the potential size of the
 * instance of the graphic class. Once the size of the graph was determined, the instance was
 * placed onto a JFrame initialized in the main method and made visible.
*/
