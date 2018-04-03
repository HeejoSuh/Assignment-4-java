/****************************************************************************
 * * Created by: Heejo Suh
 * Created on: Mar 2018
 * Created for: learning
 * 
 * This class is a 'blueprint' for a stack
 * 
 * 
 ****************************************************************************/


public class Triangle{
	//class for triangle
	
	//Private Fields
	
	private double _sideA;
	private double _sideB;
	private double _sideC;
	

	private double _semiperimeter;
	private double _perimeter;
	
	private double _area;
	private String _typeName;
	

	
	//CONSTRUCTOR ----------------------------------------------------------------------------------
	public Triangle(double a, double b, double c){
		//Pass parameters
		
		
		_sideA = a;
		_sideB = b;
		_sideC = c;
		
		_semiperimeter = 0.5 * (this.getPerimeter());
		
	} 

	
	
	
	//TRIANGLE VALID------------------------------------------------------------------------------------------
	protected double round(double inputDouble){
		//returns rounded number
		return Double.valueOf(String.format("%.2f", inputDouble));
	}	
	

	//PERIMETER--------------------------------------------------------------------------------------------------
	protected double getPerimeter(){
		//calculates and returns perimeter
		_perimeter = _sideA + _sideB +_sideC;
		return _perimeter;
	}
	
	
	
	
	//TRIANGLE VALID------------------------------------------------------------------------------------------
	protected boolean IsTriangleValid(){
		//check if triangle is valid or not
		
		boolean triangleValidity;
		
		if (_sideA + _sideB > _sideC && _sideA + _sideC > _sideB && _sideB + _sideC > _sideA){
			//sum of two sides are greater than the other
			triangleValidity = true;
			
		} else {
			triangleValidity = false;
		}

		return triangleValidity;
	}

	
	

	//AREA OF TRIANGLE-----------------------------------------------------------------------------------------
	public double GetArea() { 
		//calculates and returns the area
		
		//area = ( s(s-a)(s-b)(s-c) ) ^ 0.5
		_area = Math.sqrt((_semiperimeter*(_semiperimeter - _sideA)*(_semiperimeter - _sideB)*(_semiperimeter - _sideC)));
		//return Math.round(_area);
		return round(_area);
	}		

	//TRIANGLE TYPE-----------------------------------------------------------------------------------------------
	public String GetName() { 
		//calculates and returns the triangle type
		
		//Math.pow(side,2)
		if ((_sideA*_sideA)==(_sideB*_sideB)+(_sideC*_sideC) || (_sideB*_sideB)==(_sideA*_sideA)+(_sideC*_sideC) || (_sideC*_sideC)==(_sideA*_sideA)+(_sideB*_sideB)){
		//if (Math.pow(_sideA,2)==Math.pow(_sideB,2)+Math.pow(_sideC,2) || Math.pow(_sideB,2)==Math.pow(_sideA,2)+Math.pow(_sideC,2) || Math.pow(_sideC,2)==Math.pow(_sideA,2)+Math.pow(_sideB,2)){
			//right angle
			_typeName = "Right-angle";
			
		} else if (_sideA == _sideB && _sideA == _sideC){
			//all sides equal
			_typeName = "Equilateral";
			
		} else if (_sideA == _sideB || _sideB == _sideC || _sideA == _sideC){
			//two sides equal
			_typeName = "Isosceles";
			
		} else {
			//else
			_typeName = "Scalene";
		}
		
		
		return _typeName;
	}		
	
	
	//HEIGHT-----------------------------------------------------------------------------------------------------
	public void printTriangleHeight(){
		//calculates and prints the heights
		//A = 0.5*bh
		//h = 2A / b
		double heightA = _area*2 / _sideA;
		double heightB = _area*2 / _sideB;
		double heightC = _area*2 / _sideC;
		
		//just print here-> less work
		System.out.println("Heights: " + round(heightA) + ", " + round(heightB) + ", " + round(heightC));
	}
	
	//LARGEST INSCRIBED CIRCLE---------------------------------------------------------------------------------------
	public void printLargestInscribedCircle(){
		//calculates and prints the radius of the largest inscribed circle
		
		//radius= area of triangle / semiperimeter
		double radius = _area / _semiperimeter;
		
		System.out.println("The radius of the largest inscribed circle that can fit inside the triangle: " + round(radius));
		
	}
	
	//CIRCMCIRCLE----------------------------------------------------------------------------------------------------
	public void printAreaOfTheCircumcircleOfTheTriangle(){
		//calculates and returns the circumcircle
		//radius = (a+b+c)/(4*Area)
		double radiusOfCircumcircleOfTheTriangle = _sideA*_sideB*_sideC / (4 * _area);
		double areaOfCircumcircleOfTheTriangle = Math.PI * Math.pow(radiusOfCircumcircleOfTheTriangle, 2);
		
		System.out.println("The area of the circumcircle of the triangle: " + round(areaOfCircumcircleOfTheTriangle));
	}
	//----------------------------------------------------------------------------------------------------
	
}//closing for class
