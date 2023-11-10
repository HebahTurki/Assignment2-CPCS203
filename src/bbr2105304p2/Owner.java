package bbr2105304p2;

import java.util.*;
/**
 *
 * @author hebahturki
 */
public class Owner 
{
    
    //create the data fields of the class
    private String nationalID;
    private String First_name;
    private String Last_name;
    private Date dob;
    
//--------------------------------------------------------------------------------------  
    
    //construct with an args
    public Owner(String nationalID, String First_name, String Last_name, Date dob)
    {
        this.nationalID = nationalID;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.dob = dob;
    }
    
//-----------------------------------Setter and Getter for every data field in the class---------------------------------------------        
    public String getNationalID()
    {
        return nationalID;
    }
    
//--------------------------------------------------------------------------------------   
    public void setNationalID(String nationalID)
    {
        this.nationalID= nationalID;
    }
    
//--------------------------------------------------------------------------------------   
        public String getFirst_name()
    {
        return First_name;
    }
    
//--------------------------------------------------------------------------------------   
    public void setFirst_name(String First_name)
    {
        this.First_name= First_name;
    }
    
//-------------------------------------------------------------------------------------- 
        public String getLast_name()
    {
        return Last_name;
    }
    
//--------------------------------------------------------------------------------------   
    public void setLast_name(String Last_name)
    {
        this.Last_name= Last_name;
    }
    
//--------------------------------------------------------------------------------------     
    public Date getDob() 
    {
        return dob;
    }
    
//--------------------------------------------------------------------------------------  
    public void setDob(Date dob)
    {
        this.dob = dob;
    }
    
//--------------------------------------------------------------------------------------
    
    //to string method

    @Override
    public String toString() 
    {
        return "\n\tOwner ID: " + nationalID + "\tName: " + First_name + " " + Last_name
                ;
    }

}
