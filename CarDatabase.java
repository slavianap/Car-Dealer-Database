// INST1002 Programming 1 -  Assessment 3. 
// Author -  Slaviana Pavlovich.
// This is the main program.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CarDatabase 
{
    public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<Cars> cars = new ArrayList<>();   //the reason why i use ArrayList and not Array is because Array is a fixed size data structure while ArrayList is not
        int Option;                                 //i didn't put that Option = 0, becuase it is 0 by default
        do                                          //i needed to do this so the programme pushes the whole menu with the options to type again
		{
			DisplayMenu();
			System.out.print("\tPlease, enter your choice: ");
			Option = sc.nextInt();
			while (Option < 0 || Option > 7) 
			{
				System.out.print("\n\tPlease, enter a valid menu option. \n\tIf you want to display the menu - press '0', use '7' to quit. \n\tTry again: ");
				Option = sc.nextInt();              //getting a user's choice                           
			}
			DoOption(Option, cars);
		}
		while (Option != 7);                       //this number of option is used to quit the programme
    }

    public static void DisplayMenu()               //this method is to display the menu
	{
        System.out.println("");                                                                   //To have a visually appealing spacing before the menu
        System.out.println("\t============================================================");     // This will print out the first line of the menu    
        System.out.println("\t|                       MENU SELECTION                     |");     
        System.out.println("\t|                 What would you like to do?               |");     
        System.out.println("\t============================================================");     
        System.out.println("\t|  1.Display the list of cars in the database.             |");     
		System.out.println("\t|  2.The database as a table, sorted by manufacturer.      |");
        System.out.println("\t|  3.Add a new car record to the database.                 |");     
        System.out.println("\t|  4.Delete a car record from the database.                |");    
        System.out.println("\t|  5.Search for a car, using a car's registration number.  |");     
        System.out.println("\t|  6.Update information about a car.                       |"); 
		System.out.println("\t|  7.Quit.                                                 |");     
        System.out.println("\t============================================================");     
        System.out.println("\t                                    by Slaviana Pavlovich   ");     // This will be displayd at the end of the menu
        System.out.println("");                                                                   //To have a visually appealing spacing after the menu
    }

    public static void DoOption(int choice, ArrayList<Cars> c) //the method includes the switch statement. One of the cases in switch statements is executed after the user chooses an option from the menu
	{
        switch (choice)                                   //I used switch statements as an alternative to "if-else if-else" statements
        {                                                 /*  The statements which are going to be executed are exactly those between the first choice
                                                           which matches the input of the user and the first break after this matching choice. */
            case 0:
                DisplayMenu();
                break;
            case 1:
                System.out.println("\n\tOption 1 to see the list of cars is selected now.");
                displayCars(c);
                break;
			case 2:
                System.out.println("\n\tOption 2 to display the table is selected.");
                displayTable(c);
                break;	
            case 3:
                System.out.println("\n\tOption 3 to add a new car is selected now. Follow the instructions.");
                addCar(c);
                break;
            case 4:
                System.out.println("\n\tOption 4 to delete the car from the database is selected now.");
				deleteCar(c);
                break;
            case 5:
                System.out.println("\n\tOption 5 to search for a car is selected now.");
                searchCar(c);
			    break;
            case 6:
				System.out.println("\n\tOption 6 to update the information is selected now.");
				updateCar(c);
			    break;
			case 7:
				System.out.println("\n\tThank you for using the programme, bye!");
                break; 
        }                                                    //End of switch
    }                                                        //End of the main method

    public static void addCar(ArrayList<Cars> cars)          //this method allows a user to create a new car record
	{
        String manufacturer = "", brand = "", model = "", regnumb = "", colour = "", price = "";      //Declaring multiple variables of the same type and of the same value

        System.out.println("\tPut parameters of a new car in the following order...");
		Scanner sc = new Scanner(System.in);                 //Without this line there would be a bug. So the programme would skip the first entry "manufacturer" and would only start taking input, starting from "brand".
		System.out.print("\n\tManufacturer: ");
		manufacturer = sc.nextLine();			
				
		System.out.print("\tBrand: ");
		brand = sc.nextLine();
			
		System.out.print("\tModel: ");
		model = sc.nextLine();
				
		System.out.print("\tRegistration Number: ");
		regnumb = sc.nextLine();
				
		System.out.print("\tColour: ");
		colour = sc.nextLine();
				
		System.out.print("\tPrice: ");	
		price = sc.nextLine();
				
		cars.add(new Cars(manufacturer, brand, model, regnumb, colour, price));
		System.out.println("\n\tGreat, this car is now in the database!");
		System.out.println("\t" + manufacturer + " " + brand + " " + model + " " + regnumb + " " + colour + " " + price);  //allows a user to see what is saved in the database
	}
	
	public static void displayCars(ArrayList<Cars> cars)     //this method displays all car entries as a list
	{
		if(cars.size()>0)                                     //as long as there are entries in the ArrayList<Cars> to display, the programme will show the cars
		{
		System.out.println("\n\tManufacturer Brand Model RegNumber Colour Price ");
		for(int i = 0; i < cars.size(); i++)                  //the programme goes through the Array List, starting from i=0 and it is getting the properties of the car, like brand, colour etc, while i is smaller than the size of the array list
		{
			System.out.println("\n\t" + cars.get(i).getManufacturer() + " " + cars.get(i).getBrand() + " " + cars.get(i).getModel() + " " + cars.get(i).getRegnumb() + " " + cars.get(i).getColour() + " " + cars.get(i).getPrice());
		}
		}
		else System.out.println("\n\tThere are no cars to display! Please add cars first!"); 	//if there is nothing in the ArrayList<Cars>
	}  

	public static void displayTable(ArrayList<Cars> cars)      //this method displays all car entries as a table
	{
		Collections.sort(cars);
		String divider ="--------------------------------------------------------------------------------";
		String column1 = "Manufacturer"; String column2 = "Brand"; String column3 = "Model";
		String column4 = "RegNumb"; String column5 = "Colour"; String column6 = "Price";
		System.out.println("");
		System.out.printf("%-14s%-10s%-14s%-19s%-10s%-14s%n", column1, column2, column3, column4, column5, column6);   //assuming that the user doesn't input values that are over 14 characters long for manufacturer,model and price; 10 for brand and colour and maximum of 19 for reg number
		System.out.println(divider);
        for (Cars car : cars) 
		{
            System.out.printf("%-14s%-10s%-14s%-19s%-10s%-14s%n", car.getManufacturer(), car.getBrand(), car.getModel(), car.getRegnumb(), car.getColour(), car.getPrice());
        }
		System.out.println(divider);
		System.out.println("");		
	}

	public static void searchCar(ArrayList<Cars> cars)           //a search method that allows the details of a given car item to be looked up in the array, by entering a car’s registration number
    {
        Scanner sc = new Scanner(System.in);
		String regnumb; 
		boolean regFound = false;
		
		if(cars.size()>0)                                        //as long as there are entries in the ArrayList<Cars>, the programme will search for a car
		{
        System.out.print("\tEnter the Reg Number of the car you are looking for: ");
        regnumb = sc.next();
		for(int i = 0; i < cars.size(); i++)
		{
		                                                            // print car info if registry no. match found
			if(cars.get(i).getRegnumb().compareTo(regnumb) == 0)   //the value 0 if the argument string with register number is equal to this string - applies to all identical cases
			{
				regFound = true;
				System.out.println("\n\tThere is the following car in the database:"); 
				System.out.println("\n\t" + cars.get(i).getManufacturer() + " " + cars.get(i).getBrand() + " " + cars.get(i).getModel() + " " + cars.get(i).getRegnumb() + " " + cars.get(i).getColour() + " " + cars.get(i).getPrice());
				System.out.println("\n\tAnything else you want to do? Use '7' to quit.");
			}	
        }
		if(!regFound) System.out.println("\tSorry, no cars were found.");
		}
		else System.out.println("\n\tThere are no cars to search for! Please add cars first!"); 	//if there is nothing in the ArrayList<Cars>
	}		  

	public static void deleteCar(ArrayList<Cars> cars) //extra-functionality, this method allows a user to delete a car record from the database, by entering a car’s registration number
	{
		Scanner sc = new Scanner(System.in);
		String regnumbDEL; 
		boolean regFound = false;
		if(cars.size()>0)                             //as long as there are entries in the ArrayList<Cars>, the programme will delete the car from it
		{
		System.out.print("\tEnter the Reg Number of the car you want to remove: ");
		regnumbDEL = sc.next();
		for(int i = 0; i < cars.size(); i++)
		{
			if(cars.get(i).getRegnumb().compareTo(regnumbDEL) == 0)     
			{
				regFound = true;
				cars.remove(i);
				System.out.println("\n\tThe car was removed!");
				System.out.println("\tAnything else you want to do? Use '7' to quit.");
				}
		}
		if(!regFound) System.out.println("\n\tSorry, no cars were found with this reg number.");
		}
		else System.out.println("\n\tThere are no cars to remove! Please add cars first!"); 	//if there is nothing in the ArrayList<Cars>
	}		  

	public static void updateCar(ArrayList<Cars> cars)     //this method allows a user to update a car record from the database, by entering a current car’s registration number
	{
		Scanner sc = new Scanner(System.in);
		String regnumbCHANGE; String update = "";
		boolean regFound = false;
		int choice; 
		
		if(cars.size()>0)                                  //as long as there are entries in the ArrayList<Cars>, the programme will delete the car from it
		{
		System.out.print("\tEnter current Reg Number of the car you want to update: ");
		regnumbCHANGE = sc.next();
		for(int i = 0; i < cars.size(); i++)
		{
			Cars car = cars.get(i);
			if(car.getRegnumb().compareTo(regnumbCHANGE) == 0)   
			{
				regFound = true;
				System.out.println("");                                                                   //To have a visually appealing spacing before the menu
				System.out.println("\t============================================================");     // This will display the menu     
				System.out.println("\t|                 What would you like to update?           |");     
				System.out.println("\t============================================================");     
				System.out.println("\t|  1.The manufacturer of the car.                          |");     
				System.out.println("\t|  2.The brand of the car.                                 |");
				System.out.println("\t|  3.The model of the car.                                 |");     
				System.out.println("\t|  4.The registration number of the car.                   |");    
				System.out.println("\t|  5.The colour of the car.                                |");     
				System.out.println("\t|  6.The price of the car.                                 |"); 
				System.out.println("\t============================================================");    //It will be displayed at the end of the menu
				System.out.println("");  															     //To have a visually appealing spacing after the menu
				System.out.print("\n\tPlease, enter your choice: ");
			    choice = sc.nextInt();
					if (choice < 0 || choice > 6) 
					{
						System.out.print("\n\tPlease, enter a valid option. \n\tTry again: ");           
						choice = sc.nextInt();
					}
				switch (choice)                                                                    //One of the cases in switch statements is executed after the user chooses an option from the menu
				{
				case 1:
					System.out.print("\tPlease, enter the new value for the manufacturer: ");
					update = sc.nextLine();
					update = sc.nextLine(); // Consume newline left-over - applies to all identical cases
					car.setManufacturer(update);
					System.out.println("\n\tGreat, the manufacturer is updated!"); 
					System.out.println("\t" + cars.get(i).getManufacturer() + " " + cars.get(i).getBrand() + " " + cars.get(i).getModel() + " " + cars.get(i).getRegnumb() + " " + cars.get(i).getColour() + " " + cars.get(i).getPrice());
					break;
				case 2:
					System.out.print("\tPlease, enter the new value for the brand: ");
					update = sc.nextLine();
					update = sc.nextLine(); 
					car.setBrand(update);
					System.out.println("\n\tGreat, the brand is updated!"); 
					System.out.println("\t" + cars.get(i).getManufacturer() + " " + cars.get(i).getBrand() + " " + cars.get(i).getModel() + " " + cars.get(i).getRegnumb() + " " + cars.get(i).getColour() + " " + cars.get(i).getPrice());
					break;
				case 3:
					System.out.print("\tPlease, enter the new value for the model: ");
					update = sc.nextLine();
					update = sc.nextLine(); 
					car.setModel(update);
					System.out.println("\n\tGreat, the model is updated!"); 
					System.out.println("\t" + cars.get(i).getManufacturer() + " " + cars.get(i).getBrand() + " " + cars.get(i).getModel() + " " + cars.get(i).getRegnumb() + " " + cars.get(i).getColour() + " " + cars.get(i).getPrice());
					break;
				case 4:
					System.out.print("\tPlease, enter the new value for the reg number: ");
					update = sc.nextLine();
					update = sc.nextLine();
					car.setRegnumb(update);
					System.out.println("\n\tGreat, the reg number is updated!"); 
					System.out.println("\t" + cars.get(i).getManufacturer() + " " + cars.get(i).getBrand() + " " + cars.get(i).getModel() + " " + cars.get(i).getRegnumb() + " " + cars.get(i).getColour() + " " + cars.get(i).getPrice());
					break;
				case 5:
					System.out.print("\tPlease, enter the new value for the colour: ");
					update = sc.nextLine();
					update = sc.nextLine(); 
					car.setColour(update);
					System.out.println("\n\tGreat, the colour is updated!"); 
					System.out.println("\t" + cars.get(i).getManufacturer() + " " + cars.get(i).getBrand() + " " + cars.get(i).getModel() + " " + cars.get(i).getRegnumb() + " " + cars.get(i).getColour() + " " + cars.get(i).getPrice());
					break;
				case 6:
					System.out.print("\tPlease, enter the new value for the price: ");
					update = sc.nextLine();
					update = sc.nextLine(); 
					car.setPrice(update);
					System.out.println("\n\tGreat, the price is updated!"); 
					System.out.println("\t" + cars.get(i).getManufacturer() + " " + cars.get(i).getBrand() + " " + cars.get(i).getModel() + " " + cars.get(i).getRegnumb() + " " + cars.get(i).getColour() + " " + cars.get(i).getPrice());
					break;
				}
			}
		}
		if(!regFound) System.out.println("\n\tSorry, no cars were found with this reg number.");
		}
		else System.out.println("\n\tThere are no cars to update! Please add cars first!"); 	//if there is nothing in the ArrayList<Cars>
	}		  
	
}
