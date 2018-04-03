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
	
	private double _sideA = 0;
	private double _sideB = 0;
	private double _sideC = 0;


	private double _angleA = 0;
	private double _angleB = 0;
	private double _angleC = 0;
	

	private double _semiperimeter;
	private double _perimeter;
	
	private double _area;
	private String _typeName;
	

	
	public Triangle(String typeA, double a, String typeB, double b, String typeC, double c){
		//Pass parameters
		
		
		//set input Values
		setValues(typeA, a);
		setValues(typeB, b);
		setValues(typeC, c);
		
		
		while (_sideA==0 || _sideB==0 || _sideC==0 || _angleA==0 || _angleB==0 || _angleC==0 ) {
			//loop until every value is put
			
			
			//pythagorean
			if (_angleA!=0 &&_sideB!=0 && _sideC!=0) {
				_sideA =  Math.pow((_sideB*_sideB + _sideC*_sideC - 4*_sideB*_sideC*Math.cos(Math.toRadians(_angleA))),0.5);
			}
			if (_angleB!=0 &&_sideA!=0 && _sideC!=0) {
				_sideB =  Math.pow((_sideA*_sideA + _sideC*_sideC - 4*_sideA*_sideC*Math.cos(Math.toRadians(_angleB))),0.5);
			}
			if (_angleC!=0 && _sideA!=0 && _sideB!=0) {
				_sideC = Math.pow((_sideA*_sideA + _sideB*_sideB - 4*_sideA*_sideB*Math.cos(Math.toRadians(_angleC))),0.5);
			}
			
			
			//sin law
			//a/sinA  = b/sinB
			// b = (a * sinB)/sinA
			// B = acos(b * sinA)/a
			if (_sideA!=0 && _angleA!=0) {
				if (_angleB!=0){
					_sideB= (_sideA*Math.sin(Math.toRadians(_angleB)))/Math.sin(Math.toRadians(_angleA));
				}
				if (_sideB!=0){
					_angleB = Math.asin((Math.sin(Math.toRadians(_angleA))*_sideB)/_sideA);
				}
				if (_angleC!=0){
					_sideC= (_sideA*Math.sin(Math.toRadians(_angleC)))/Math.sin(Math.toRadians(_angleA));
				}
				if (_sideC!=0){
					_angleC = Math.asin((Math.sin(Math.toRadians(_angleA))*_sideC)/_sideA);
				}
			}
			if (_sideB!=0 && _angleB!=0) {
				if (_angleA!=0){
					_sideA= (_sideB*Math.sin(Math.toRadians(_angleA)))/Math.sin(Math.toRadians(_angleB));
				}
				if (_sideA!=0){
					_angleA = Math.asin((Math.sin(Math.toRadians(_angleB))*_sideA)/_sideB);
				}
				if (_angleC!=0){
					_sideC= (_sideB*Math.sin(Math.toRadians(_angleC)))/Math.sin(Math.toRadians(_angleB));
				}
				if (_sideC!=0){
					_angleC = Math.asin((Math.sin(Math.toRadians(_angleB))*_sideC)/_sideB);
				}
			}
			if (_sideC!=0 && _angleC!=0) {
				if (_angleB!=0){
					_sideB= (_sideC*Math.sin(Math.toRadians(_angleB)))/Math.sin(Math.toRadians(_angleC));
				}
				if (_sideB!=0){
					_angleB = Math.asin((Math.sin(Math.toRadians(_angleC))*_sideB)/_sideC);
				}
				if (_angleA!=0){
					_sideA= (_sideC*Math.sin(Math.toRadians(_angleA)))/Math.sin(Math.toRadians(_angleC));
				}
				if (_sideA!=0){
					_angleA = Math.asin((Math.sin(Math.toRadians(_angleC))*_sideA)/_sideC);
				}
			}
			
			//cos law
			if (_sideA!=0 && _sideB!=0 && _sideC!=0) {
				_angleA = Math.acos((_sideB*_sideB + _sideC*_sideC - _sideA*_sideA)/(2*_sideB*_sideC)) * (180/Math.PI);
				_angleB = Math.acos((_sideA*_sideA + _sideC*_sideC - _sideA*_sideA)/(2*_sideA*_sideC)) * (180/Math.PI);
				_angleC = Math.acos((_sideB*_sideB + _sideA*_sideA - _sideA*_sideA)/(2*_sideB*_sideA)) * (180/Math.PI);
			}
			
		}
		
		//round each value
		_sideA = round(_sideA);
		_sideB = round(_sideB);
		_sideC = round(_sideC);
		_angleA = round(_angleA);
		_angleB = round(_angleB);
		_angleC = round(_angleC);
		
		_semiperimeter = 0.5 * (getPerimeter());
		
	} 		
	

	//TRIANGLE info set------------------------------------------------------------------------------------------
	protected void setValues(String inputType, double inputDouble){
		//sets the number as the appropriate variable value
		if (inputType.equals("SA")) {
			_sideA = inputDouble;
		}
		if (inputType.equals("SB")) {
			_sideB = inputDouble;
		}
		if (inputType.equals("SC")) {
			_sideC = inputDouble;
		}
		if (inputType.equals("AA")) {
			_angleA = inputDouble;
		}
		if (inputType.equals("AB")) {
			_angleB = inputDouble;
		}
		if (inputType.equals("AC")) {
			_angleC = inputDouble;
		}
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
		
		if ((_angleA+_angleB+_angleC)==180){
			//sum of angles is equal to 180
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
		if (_angleA == 90 || _angleB == 90 || _angleC == 90){
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

