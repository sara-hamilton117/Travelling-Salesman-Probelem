package tsp;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
				
		//Initiating arraylist of cities 
		ArrayList<City> cityList = new ArrayList<City>();
		
		//Initiating instance of Timer class
		StopWatch timer = new StopWatch();
		
		try {
			
			//Getting path file
			//System.out.print("Please enter the full path of your file then press enter: \n");
			
			//Creating scanner object
			Scanner myObj = new Scanner(System.in);
			
			//Reading user input
		    String pathTxt = "C:\\Users\\sarah\\Google Drive\\Year 3\\CST3170 - Artificial Intelligence\\Coursework\\Coursework 1\\Train problems\\Test - 2020\\\\test4-20.txt";  
		    
			//Getting file from folder
		    File myFile = new File(pathTxt);
		    
		    //Creating instance of scanner
		    Scanner scan = new Scanner(myFile);
		     
		    //For each line in the file, add the co-ordinates to the city arraylist
		    while (scan.hasNextLine() && scan.hasNext()) {
		      
		    	//System.out.println(myReader.nextInt());
		    	City newCity = new City(scan.nextInt(), scan.nextInt(), scan.nextInt());
		    	cityList.add(newCity);
		    }
		      
		    //Prints the number of cities and the cities
		    System.out.println("Number of cities in " + "test4-20.txt" + " is " + cityList.size() + ".");
		    		    
		    //---------------------------------DFS ALgorithm----------------------------------//
//		    
//		    //Creating instance of DFS class and passing the list of cities to it
//		    DepthFirstSearch DFS = new DepthFirstSearch(cityList);
//		    
//		    //Starting timer when algorithm begins
//		    timer.start();
//		    
//		    //Calling the algorithm
//		    DFS.depthFS();
//		    
//		    //Stopping the timer when algorithm is finished and printing the time in nanoseconds
//		    timer.stop();
//		    System.out.println("The time taken to run Depth First Search is: " + timer.stop() + " nanoseconds.");
		    //-------------------------------DFS ALgorithm end--------------------------------//
		    
		    //----------------------------------NN ALgorithm----------------------------------//
	   	    
		    //Creating instance of NN class and passing the list of cities to it
		    NearestNeighbour NN = new NearestNeighbour(cityList);
		    
		    //Starting timer when algorithm begins
		    timer.start();
		    
		    //Calling the algorithm
		    NN.nearestCitySearch(0);
		    
		    //Stopping the timer when algorithm is finished and printing best path
		    timer.stop();
		    NN.printNNPath();
		    
		    //Printing the time in nanoseconds
		    System.out.println("The time taken to run Nearest Neighbor is: " + timer.stop() + " nanoseconds.");
		    //--------------------------------NN ALgorithm end--------------------------------//
		    		    
		    //Closing scanner
		    scan.close();
		 	} 
		
			//Catch exception if the file can not be loaded
			catch (FileNotFoundException e) {
			    System.out.println("An error occurred loading the file.");
			    e.printStackTrace();
			}
	}
}
