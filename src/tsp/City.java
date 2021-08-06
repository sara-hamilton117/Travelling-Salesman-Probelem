package tsp;
public class City {

	//Initializing variables
	int cityNumber;
	double xPos;
	double yPos;
	boolean visited;
	
	//Constructor
	public City(int cityNumber, double xPos, double yPos) {
		this.cityNumber = cityNumber;
		this.xPos = xPos;
		this.yPos = yPos;
		this.visited = false;
	}
	
	//Getters and Setters
	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	public int getCityNumber() {
		return cityNumber;
	}

	public void setCityNumber(int cityNumber) {
		this.cityNumber = cityNumber;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
