package bbr2105304p2;

/**
 *
 * @author hebahturki
 */
public class InsuranceCoverage 
{
    
    //create the data fields of the class
    private int InsuranceCoverageCode;
    private String description;
    private double amount;
    
//-------------------------------------------------------------------------------------- 
    
    //construct with an args
    public InsuranceCoverage(int InsuranceCoverageCode, String description, double amount)
    {
        this.InsuranceCoverageCode = InsuranceCoverageCode;
        this.amount = amount;
        this.description = description;
    }
    
//-----------------------------------Setter and Getter for every data field in the class---------------------------------------------    
    public int getInsuranceCoverageCode()
    {
        return InsuranceCoverageCode;
    }
    
//--------------------------------------------------------------------------------------   
    public void setInsuranceCoverageCode(int InsuranceCoverageCode)
    {
        this.InsuranceCoverageCode= InsuranceCoverageCode;
    }
    
//--------------------------------------------------------------------------------------
    public String getDescription()
    {
        return description;
    }
    
//--------------------------------------------------------------------------------------   
    public void setDescription(String description)
    {
        this.description= description;
    }
    
//-------------------------------------------------------------------------------------- 
    public double getAmount()
    {
        return amount;
    }
    
//--------------------------------------------------------------------------------------   
    public void setAmount(double amount)
    {
        this.amount= amount;
    }
    
//-------------------------------------------------------------------------------------- 
    
    //to string method
    @Override
    public String toString() 
    {
        return  "\n\tInsuranceCoverage Code: " + InsuranceCoverageCode 
                + "\tInsuranceCoverage Description: " + description;
    }
    
}
