// INST1002 Programming 1 -  Assessment 3.
// Author -  Slaviana Pavlovich.
// This is the main program.

public class Cars implements Comparable<Cars>                 
{
		private String manufacturer;                        //"private" means access to this is restricted
		private String brand;                     
	/*the reason why my program asks for a brand is because companies (in this case manufacturers) tend to have multiple brands. 
	So Toyota Motor Corporation produces vehicles under five brands, including the Toyota brand, Hino, Lexus, Ranz, and Daihatsu.*/
		private String model; 
		private String regnumb;
		private String price;
		private String colour;
		
	Cars(String manufacturer, String brand, String model, String regnumb, String colour, String price) //constructor, it accepts the parameters of the car 
    {
        this.manufacturer = manufacturer;                  // assigns the value of the parameter a to the field of the same name  
        this.brand = brand;
        this.model = model;
        this.regnumb = regnumb;
		this.colour = colour;        
		this.price = price;
    }

	public int compareTo(Cars other)
	{
    return manufacturer.compareTo(other.getManufacturer()); // overloading standard compareTo function to work for comparing Cars
	}  
    
	public String getManufacturer() 
	{
	return manufacturer;
	}
  
	public String getBrand() 
	{
    return brand;
	}  
  
	public String getModel() 
	{
    return model;
	}

	public String getRegnumb() 
	{
    return regnumb;
	}
  
	public String getColour() 
	{
    return colour;
	}
  
	public String getPrice() 
	{
    return price;
	}
 
	public void setManufacturer(String newManufacturer) 
	{
	this.manufacturer = newManufacturer;
	}
  
    public void setBrand(String newBrand) 
	{
    this.brand = newBrand;
	}
  
    public void setModel(String newModel) 
	{
    this.model = newModel;
	}
  
    public void setRegnumb(String newRegnumb) 
	{
    this.regnumb = newRegnumb;
	}
  
    public void setColour(String newColour) 
	{
    this.colour = newColour;
	}
  
    public void setPrice(String newPrice) 
	{
	this.price = newPrice;
	} 
}