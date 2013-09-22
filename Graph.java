/*	Author:			Nick McGraw
 * 	Project:		Hypotenuse Calculator
 * 	Project Purpose:	The program takes input from the user for the lengths of
 * 				two legs of a right triangle, calculates the hypotenuse
 * 				of the right triangle with the given leg lengths, and
 * 				draws the triangle with labeled dimensions.
 * 	Class:			Graph
 * 	Class Purpose:		When an instance of this class is called, it uses the
 * 				public variables from the Input class to draw correctly
 * 				sized components of the JPanel graphics on the instance.
 */	

import javax.swing.*;
import java.awt.*;

public class Graph extends JPanel{
	
	public Graph (Color backColor){
		setBackground(backColor);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int a = Input.leg1modified * 100;
		int b = Input.leg2modified * 100;
		if (b > a){
			int difference = b - a;
			a = a + difference;
			b = b - difference;
		}
		g.setColor(Color.black);
		g.drawLine(20, 20, 20, 20 + b);
		g.drawLine(20, 20 + b, 20 + a, 20 + b);
		g.drawLine(20, 20, 20 + a, 20 + b);
		g.drawRect(20, 10 + b, 10, 10);
		double c = Math.sqrt(Input.leg1 * Input.leg1 + Input.leg2 * Input.leg2);
		String A, B;
		if (Input.leg1 >= Input.leg2){
			A = Integer.toString(Input.leg1);
			B = Integer.toString(Input.leg2);
		} else{
			B = Integer.toString(Input.leg1);
			A = Integer.toString(Input.leg2);
		}
		String C = Double.toString(c);
		g.drawString(A, a / 2 + 20, 20 + b);
		g.drawString(B, 20, b / 2 + 20);
		g.drawString(C, (40 + a) / 2, (40 + b) / 2);
	}
}
