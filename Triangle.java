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
			
			
			//SIDE A-----------------------------------------------------------
			if (_sideA==0) {
				//pythagorean
				if (_angleA!=0 &&_sideB!=0 && _sideC!=0) {
					_sideA =  Math.pow(_sideB*_sideB + _sideC*_sideC - 4*_sideB*_sideC*cos(_angleA),0.5);
				}
				//sin law
				if (_sideB!=0 && _angleB!=0 && _angleA!=0){
					_sideA= (_sideB*sin(_angleA))/sin(_angleB);
				}
				if (_sideC!=0 && _angleC!=0 && _angleA!=0){
					_sideA= (_sideC*sin(_angleA))/sin(_angleC);
				}
			}
			
			//SIDE B-----------------------------------------------------------
			if (_sideB==0) {	
				//pythagorean
				if (_angleB!=0 &&_sideA!=0 && _sideC!=0) {
					_sideB =  Math.pow((_sideA*_sideA + _sideC*_sideC - 4*_sideA*_sideC*cos(_angleB)),0.5);
				}
				//sin law
				if (_sideA!=0 && _angleA!=0 && _angleB!=0){
					_sideB= (_sideA*sin(_angleB))/sin(_angleA);
				}
				if (_sideC!=0 && _angleC!=0 && _angleB!=0){
					_sideB= (_sideC*sin(_angleB))/sin(_angleC);
				}
			}
							
			//SIDE C-----------------------------------------------------------
			if (_sideC==0) {	
				//pythagorean
				if (_angleC!=0 && _sideA!=0 && _sideB!=0) {
					_sideC = Math.pow((_sideA*_sideA + _sideB*_sideB - 4*_sideA*_sideB*cos(_angleC)),0.5);
				}
				//sin law
				if (_sideA!=0 && _angleA!=0 && _angleC!=0){
					_sideC= (_sideA*sin(_angleC))/sin(_angleA);
				}
				if (_sideB!=0 && _angleB!=0 && _angleC!=0){
					_sideC= (_sideB*sin(_angleC))/sin(_angleB);
				}
			}
			
			
			//ANGLE A-----------------------------------------------------------
			if (_angleA == 0) {
				//180
				if (_angleB!=0 && _angleC!=0) {
					_angleA = 180 - _angleB - _angleC;
				}
				//sin law
				if (_sideB!=0 && _angleB!=0 && _sideA!=0){
					_angleA = aSin((sin(_angleB)*_sideA)/_sideB);
				}
				if (_sideC!=0 && _angleC!=0 && _sideA!=0){
					_angleA =aSin((sin(_angleC)*_sideA)/_sideC);
				}
				//cos law
				if (_sideA!=0 && _sideB!=0 && _sideC!=0) {
					_angleA = cos(((_sideB*_sideB) + (_sideC*_sideC) - (_sideA*_sideA))/(2*(_sideB*_sideC))) ;
				}
			}
			//ANGLE B-----------------------------------------------------------
			if (_angleB == 0) {
				//180
				if (_angleA!=0 && _angleC!=0) {
					_angleB = 180 - _angleA - _angleC;
				}
				//sin law
				if (_sideA!=0 && _angleA!=0 && _sideB!=0){
						_angleB = aSin((sin(_angleA)*_sideB)/_sideA);
				}
				if (_sideC!=0 && _angleC!=0 && _sideB!=0){
						_angleB = aSin((sin(_angleC)*_sideB)/_sideC);
				}
				//cos law
				if (_sideA!=0 && _sideB!=0 && _sideC!=0) {
					_angleB = cos((_sideA*_sideA + _sideC*_sideC - _sideB*_sideB)/(2*_sideA*_sideC)) ;
				}
			}
			
			//ANGLE C-----------------------------------------------------------
			if (_angleC == 0) {
				//180
				if (_angleA!=0 && _angleB!=0) {
					_angleC = 180 - _angleA - _angleB;
				}
				//sin law
				if (_sideA!=0 && _angleA!=0 && _sideC!=0){
						_angleC = aSin((sin(_angleA)*_sideC)/_sideA);
				}
				if (_sideB!=0 && _angleB!=0 && _sideC!=0){
					_angleC = aSin((sin(_angleB)*_sideC)/_sideB);
				}
				//cos law
				if (_sideA!=0 && _sideB!=0 && _sideC!=0) {
					_angleC = cos((_sideB*_sideB + _sideA*_sideA - _sideC*_sideC)/(2*_sideB*_sideA));
				}
			}
			
		}
		
		
		//round each value
		_sideA = round(_sideA);
		_sideB = round(_sideB);
		_sideC = round(_sideC);
		
		double toDegree = (180/Math.PI);
		
		_angleA = round(_angleA * toDegree);
		_angleB = round(_angleB * toDegree);
		_angleC = round(_angleC * toDegree);
		
		_semiperimeter = 0.5 * (_sideA + _sideB +_sideC);
		
		
		System.out.println(_angleA);
		System.out.println(_angleB);
		System.out.println(_angleC);
		System.out.println(_sideA);
		System.out.println(_sideB);
		System.out.println(_sideC);
		
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
	

	//SIN------------------------------------------------------------------------------------------
	protected double sin(double inputDouble){
		//returns rounded number
		return Math.sin(Math.toRadians(inputDouble));
	}	

	//COS------------------------------------------------------------------------------------------
	protected double cos(double inputDouble){
		//returns rounded number
		return Math.cos(Math.toRadians(inputDouble));
	}	

	//aSIN------------------------------------------------------------------------------------------
	protected double aSin(double inputDouble){
		//returns rounded number
		return Math.asin(Math.toRadians(inputDouble));
	}	

	//aCOS------------------------------------------------------------------------------------------
	protected double aCos(double inputDouble){
		//returns rounded number
		return Math.acos(Math.toRadians(inputDouble));
	}	

	
	//TRIANGLE VALID------------------------------------------------------------------------------------------
	protected boolean IsTriangleValid(){
		//check if triangle is valid or not
		
		boolean triangleValidity;
		
		if ((_angleA+_angleB+_angleC)==180 && ((_sideB +_sideC)>_sideA && (_sideA +_sideC)>_sideB && (_sideA + _sideB)>_sideC)){
			//sum of angles is equal to 180 & sum of two sides are longer than the other
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
		double radiusOfCircumcircleOfTheTriangle = _sideA*_sideB*_sideC / (4 * _semiperimeter);
		double areaOfCircumcircleOfTheTriangle = Math.PI * Math.pow(radiusOfCircumcircleOfTheTriangle, 2);
		
		System.out.println("The area of the circumcircle of the triangle: " + round(areaOfCircumcircleOfTheTriangle));
	}
	//----------------------------------------------------------------------------------------------------
	
}//closing for class
