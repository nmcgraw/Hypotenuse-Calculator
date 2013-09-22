/*	Author:				Nick McGraw
 * 	Project:			Hypotenuse Calculator
 * 	Project Purpose:	The program takes input from the user for the lengths of
 * 						two legs of a right triangle, calculates the hypotenuse
 * 						of the right triangle with the given leg lengths, and
 * 						draws the triangle with labeled dimensions.
 * 	Class:				Graph
 * 	Class Purpose:		When an instance of this class is called, it uses the
 * 						public variables from the Input class to draw correctly
 * 						sized components of the JPanel graphics on the instance.
 * 
 * **********DO NOT READ THESE COMMENTS UNTIL YOU READ THOSE ON THE INPUT CLASS**********
 * **********DO NOT READ THESE COMMENTS UNTIL YOU READ THOSE ON THE INPUT CLASS**********
 * **********DO NOT READ THESE COMMENTS UNTIL YOU READ THOSE ON THE INPUT CLASS**********
 * **********DO NOT READ THESE COMMENTS UNTIL YOU READ THOSE ON THE INPUT CLASS**********
 * **********DO NOT READ THESE COMMENTS UNTIL YOU READ THOSE ON THE INPUT CLASS**********
 * **********DO NOT READ THESE COMMENTS UNTIL YOU READ THOSE ON THE INPUT CLASS**********
 * 
 * The comments on this class infer that the ones on the other class have already been
 * read and understood, so insufficient background on the project is found in the
 * comments below.
 */	

import javax.swing.*;
import java.awt.*;

/*	This is the class of which an instance was made in the code for InputWithComments. It
 * 	is the JPanel that was placed on the graphGUI JFrame. Since the variables that were
 * 	declared in the InputWithComments class are public, they will be used here to draw
 * 	the graph of the triangle. The size of the panel and the scale of the triangle were
 * 	determined in the other class, but this one actually draws and labels the triangle.
 */
public class GraphWithComments extends JPanel{
	
	//Simply a method that declares a backColor parameter:
	public GraphWithComments (Color backColor){
		setBackground(backColor);
	}
	
	//Graphics method:
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		/*	Because the modified leg lengths were multiplied by 100 in sizing the
		 * 	panel, the same must be done to each of the lengths of the legs that will
		 * 	actually get drawn by the program.
		 */
		int a = InputWithComments.leg1modified * 100; //Initializes the variable for the up-to-scale leg
		int b = InputWithComments.leg2modified * 100; //Initializes the variable for the up-to-scale leg
		/*	For this class, a will refer to the x-value and b will refer to the
		 * 	y-value, so another if-statement must be used to reverse the values as
		 * 	necessary.
		 */
		if (b > a){
			int difference = b - a;
			a = a + difference;
			b = b - difference;
		}
		g.setColor(Color.black); //The triangle will have a black outline
		/*	The margins for the triangle on the top, bottom, and left sides will be
		 * 	20, so the endpoints of each of the three lines will reflect these
		 * 	marginal spaces on the Java coordinate plane.
		 */
		g.drawLine(20, 20, 20, 20 + b); //The vertical leg
		g.drawLine(20, 20 + b, 20 + a, 20 + b); //The horizontal leg
		g.drawLine(20, 20, 20 + a, 20 + b); //The hypotenuse, drawn from the unconnected endpoints of the legs
		g.drawRect(20, 10 + b, 10, 10); //The little box that denotes the right angle
		/*	Even though the program used a geometrically similar Pythagorean triple
		 * 	to size the graph, the user wants to see HIS data labeling the triangle.
		 * 	By keeping the values of leg1 and leg2 the same throughout the code,
		 * 	the program has obtained two of the three necessary pieces of memory for
		 * 	this purpose. To get the third one, the following line is written to
		 * 	solve c^2 = a^2 + b^2 for c when a = leg1 and b = leg2. In this equation,
		 * 	size comparison between leg1 and leg2 does not matter.
		 */
		double c = Math.sqrt(InputWithComments.leg1 * InputWithComments.leg1 + InputWithComments.leg2 * InputWithComments.leg2);
		/*	At this point, the program has the three dimensions memorized, but it
		 * 	still has to convert them to strings. This time, size does matter, so
		 * 	another if-statement is necessary for the legs.
		 */
		String A, B;
		if (InputWithComments.leg1 >= InputWithComments.leg2){
			A = Integer.toString(InputWithComments.leg1);
			B = Integer.toString(InputWithComments.leg2);
		} else{
			B = Integer.toString(InputWithComments.leg1);
			A = Integer.toString(InputWithComments.leg2);
		}
		String C = Double.toString(c);
		/*	Finally, the dimensions as strings are drawn on the graph, each in the
		 * 	middle of and next to its side.
		 */
		g.drawString(A, a / 2 + 20, 20 + b);
		g.drawString(B, 20, b / 2 + 20);
		g.drawString(C, (40 + a) / 2, (40 + b) / 2);
	}
}

//SUMMARY:
/*	By the time an instance of this class was created in the main method, its size
 *	was already determined, so it just had to draw the triangle. It took the two
 *	modified leg variables from the InputWithComments class and converted them to
 *	variables that were then used to draw each of the legs of the triangle and,
 *	using the concept of connecting endpoints, the hypotenuse. When labeling the
 *	dimensions, the part where data cannot be simplified or altered, the program
 *	converted the two leg lengths held constant throughout the code into strings
 *	along with a mathematical calculation of the hypotenuse from those lengths.
 *	Then the strings were placed on the graph next to the midpoint of their
 *	respective dimensions.
 */
