package tsp;

import java.util.ArrayList;
import java.util.Stack;

public class NearestNeighbour {
	
	//Initializing arraylist of cities
	ArrayList<City> city;
	
	//Creating a stack of integers to store path
	Stack<Integer> cityStk = new Stack<Integer>();
	
	//Creating variables
	Double[][] distanceMatrix;
	Double distance = 0.0; 
	
	//Constructor
	public NearestNeighbour(ArrayList<City> city) {
		this.city = city;
		
		//Creating a matrix of distances using multi-dimensional array
		distanceMatrix = new Double[city.size()][city.size()];
		
		//Looping through each city in arraylist to find distance for first dimension
		for (int j=0; j<city.size(); j++) {
			
			//Looping through next set of cities in dimension to find distance
			for (int k=0; k<city.size(); k++) {
				
				//If both cities in both dimensions are the same, set their distance to -1 in the matrix
				if (j==k) {
					distanceMatrix[j][k]= -1.0;
				}
				
				//Else, calculate distance between first and second city in dimension using formula
				else {
					distanceMatrix[j][k] = Math.sqrt(Math.pow((city.get(j).getxPos() - city.get(k).getxPos()), 2)
							+ Math.pow((city.get(j).getyPos() - city.get(k).getyPos()), 2));
				}
			}
		}
		
		//Pushing first city in stack of cities
		cityStk.push(0);
		
		//Setting first city to visited
		city.get(0).setVisited(true);
	}
	
	//Recursion function that finds the nearest city and adds it to the stack
	public void nearestCitySearch(Integer index) {
		
		//Creating variables for nearest city and pointer
		Double nearestCity = Double.MAX_VALUE;
		int pointer = -1;
		
		//Loop through each city
		for (int i=0; i<city.size(); i++) {
			
			//If city is visited and it's not the same city that we are looking at and the distance 
			//in the matrix is smaller than the city we are looking at
			if (!city.get(i).isVisited() && !index.equals(i) && distanceMatrix[index][i] < nearestCity) {
				
				//Add the nearest city to the matrix
				nearestCity = distanceMatrix[index][i];
				
				//update the pointer to this city
				pointer = i;
			}
		}
		
		//Push the city on the pointer in the stack
		cityStk.push(pointer);
		
		//Set the city on pointer as visited
		city.get(pointer).setVisited(true);
		
		//Add the distance of the nearest city to the total distance
		distance += nearestCity; 
		
		//Check if all cities are visited
		boolean allVisited = true;
		
		//Loop through cities to check if any cities have not been visited
		for (int i=0; i<city.size(); i++) {
			if (!city.get(i).isVisited()) {
				allVisited = false;
			}
		}
		
		//If not all cities are visited, call recursive function to pinter
		if (!allVisited) {
			nearestCitySearch (pointer);
		} 
		//Else, add the first city in the list to the stack and update the distance
		else {
			cityStk.push(0);
			distance += distanceMatrix[pointer][0];
		}
	}
	
	//FUnction to print results
	public void printNNPath() {
		System.out.print("The shortest path for NN is: ");
		
		////Printing the full path on the shortest path
		for(int i=0; i < cityStk.size() - 1; i++) {
			System.out.print((cityStk.get(i) + 1) + " > ");
		}
		
		//Printing first city at the end of path and distance of path
		System.out.println("1.");
		System.out.println("The distance is: " + distance);
	}
}
