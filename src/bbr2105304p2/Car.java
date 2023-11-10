package bbr2105304p2;

/**
 *
 * @author hebahturki
 */
public class Car 
{
    //create the data fields of the class
    private String CarPlateNo;
    private String CarType;
    private String Brand;
    private String CarModel;
    private String CarColor;
    private int BuiltYear;
    
//-------------------------------------------------------------------------------------- 
    
    //construct with an args
    public Car(String CarPlateNo, String CarType, String Brand, String CarModel, String CarColor, int BuiltYear)
    {
        this.Brand= Brand;
        this.BuiltYear= BuiltYear;
        this.CarColor= CarColor;
        this.CarModel= CarModel;
        this.CarPlateNo= CarPlateNo;
        this.CarType= CarType;
    }

//-----------------------------------Setter and Getter for every data field in the class---------------------------------------------  
    public String getCarPlateNo()
    {
        return CarPlateNo;
    }
    
//--------------------------------------------------------------------------------------   
    public void setCarPlateNo(String CarPlateNo)
    {
        this.CarPlateNo= CarPlateNo;
    }
    
//--------------------------------------------------------------------------------------   
    public String getCarType()
    {
        return CarType;
    }
    
//--------------------------------------------------------------------------------------   
    public void setCarType(String CarType)
    {
        this.CarType= CarType;
    }
    
//--------------------------------------------------------------------------------------
    public String getBrand()
    {
        return Brand;
    }
    
//--------------------------------------------------------------------------------------   
    public void setBrand(String Brand)
    {
        this.Brand= Brand;
    }
    
//--------------------------------------------------------------------------------------
    public String getCarModel()
    {
        return CarModel;
    }
    
//--------------------------------------------------------------------------------------   
    public void setCarModel(String CarModel)
    {
        this.CarModel= CarModel;
    }
    
//--------------------------------------------------------------------------------------
    public String getCarColor()
    {
        return CarColor;
    }
    
//--------------------------------------------------------------------------------------   
    public void setCarColor(String CarColor)
    {
        this.CarColor= CarColor;
    }
    
//--------------------------------------------------------------------------------------     
    public int getBuiltYear()
    {
        return BuiltYear;
    }
    
//--------------------------------------------------------------------------------------   
    public void setBuiltYear(int BuiltYear)
    {
        this.BuiltYear= BuiltYear;
    }
    
//-------------------------------------------------------------------------------------- 
    
    //to string method

    @Override
    public String toString() 
    {
        return "\n\tCar No.: " + this.CarPlateNo + "\tType: " + this.CarType + 
                "\tBrand: " + this.Brand + "\tModel: " + this.CarModel + "\tColor: " 
                + this.CarColor + "\tMfg. Year: " + this.BuiltYear;
    }
    
}
