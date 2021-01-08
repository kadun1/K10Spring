package di;

public class BMICalResult {

	private double lowWeight;
	private double normal;
	private double overWeight;
	private double obesity;
	
	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}
	public void setNormal(double normal) {
		this.normal = normal;
	}
	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}
	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	//체질량지수 계산을 위한 메소드
	public String bmiCalculation(double weight, double height) {
		
		//지수를 계산한후...
		double h = height * 0.01;
		double result = weight / (h*h);
		
		String resultStr = "당신의 BMI지수는? "+ (int)result;
		
		//결과를 String으로 반환한다.
		if(result > obesity ) {
			resultStr += "<br/>비만입니다 ㅠㅠ";
		}
		else if(result > overWeight) {
			resultStr += "<br/>과제충입니다 ㅠㅠ";
		}
		else if(result > normal) {
			resultStr += "<br/>정상입니다 ^^*";
		}
		else {
			resultStr += "<br/>저체중입니다 -_-;";
		}
		
		return resultStr;
	}
}
