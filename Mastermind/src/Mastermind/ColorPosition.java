package Mastermind;

public class ColorPosition {
	// Parameters
	private String colorOnPoint;
	
	//Constructor
	public ColorPosition() {}
	
	public ColorPosition(String colorOnPoint) {
		this.colorOnPoint = colorOnPoint;
	}
	
	// Setter/ Getter
	public void setColorOnPoint(String colorOnPoint) { this.colorOnPoint = colorOnPoint; }
	
	public String getColorOnPoint() { return colorOnPoint; }
		
	//Method
	@Override
	public String toString() {
		return "colorPosition [colorOnPoint=" + colorOnPoint + "]";
	}
}
