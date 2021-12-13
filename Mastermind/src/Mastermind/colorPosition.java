package Mastermind;

public class colorPosition {
	// Parameters
	private int positionOnCol;
	private String colorOnPoint;
	
	//Constructor
	public colorPosition() {}
	
	public colorPosition(int positionOnCol, String colorOnPoint) {
		this.positionOnCol = positionOnCol;
		this.colorOnPoint = colorOnPoint;
	}
	
	// Setter/ Getter
	public void setPositionOnCol(int positionOnCol) { this.positionOnCol = positionOnCol; }
	public void setColorOnPoint(String colorOnPoint) { this.colorOnPoint = colorOnPoint; }
	
	public String getColorOnPoint() { return colorOnPoint; }
	public int getPositionOnCol() { return positionOnCol; }
		
	//Method
	@Override
	public String toString() {
		return "colorPosition [positionOnCol=" + positionOnCol + ", colorOnPoint=" + colorOnPoint + "]";
	}
}
