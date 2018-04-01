/****************************************************************************
 *
 * Created by: Heejo Suh
 * Created on: Mar 2018
 * Created for: learning
 * 
 * This program uses the stack 'Triangle',
 * to calculate values of input triangle
 *
 ****************************************************************************/


import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


//****************************************************************************
public class TriangleCalculator {
	//This class tests the stack
	
	//-----------------------
	public static void main(String[] args) throws Exception {
		//instantiate triangle given the input and calculate values
		
		Scanner scanner = new Scanner(System.in);
		String input = "";
		
        //Hashtable<String, Double> inputValues = new Hashtable<String, Double>();
		//Map<String, Double> inputValues = new HashMap<String, Double>();
		
		//create list
		List<Double> inputValues = new ArrayList<>();

		
		//--------------------------------------------------------------------------
		//Get correct inputs -------------------------------------------------------
		while (inputValues.size() < 2) {
			//not have exited program
			
			//get number----------------------------------------
			for(int count = 0 ; count<3; count++) {
				//see if input is a number
				System.out.println("\nInsert the length of a side: ");
				
				try {
					//check if response is a number
					input = scanner.nextLine();
					double inputNumber = Double.valueOf(input);
					if (inputNumber < 0 ) {
						System.out.println("Insert a valid number!");
					} else {
						//insert into dictionary
						inputValues.add(inputNumber);
					}	
					//need to reset to default
					input = "";
					
				}catch (IllegalArgumentException x) { 
					System.out.println("Insert a number!");
				}
			}
		} 
		
		
		
		//instantiate Triangle
		Triangle customTriangle = new Triangle(inputValues.get(0), inputValues.get(1), inputValues.get(2));
		//check validity
		if (customTriangle.getTriangleValidity() == true) {
			//if valid triangle

			//Name
			System.out.println("Triangle: " + customTriangle.GetName() + " triangle");
			//Area
			System.out.println("Area: " + customTriangle.GetArea());
			customTriangle.printTriangleHeight();
			customTriangle.printLargestInscribedCircle();
			customTriangle.printAreaOfTheCircumcircleOfTheTriangle();
			
		} else {
			//error
			System.out.println("Invalid triangle!");
			
		}
			
	}
}
