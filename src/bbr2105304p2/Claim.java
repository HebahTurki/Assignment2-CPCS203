package bbr2105304p2;
import java.util.*;
import java.text.*;
import java.time.*;

/**
 *
 * @author hebahturki
 */
public class Claim 
{
    //create the data fields of the class
    private long ClaimNo;
    private String location;
    private Date claimDate;
    private Boolean hasPremium;
    private Boolean hasSpecialOffer;
    
    private InsuranceCoverage insuranceCoverage;
    private Car car;
    private Owner owner;
 
//--------------------------------------------------------------------------------------  
    
    //construct with an args
    public Claim(long ClaimNo, String location, Date claimDate, Boolean hasPremium,
            Boolean hasSpecialOffer, InsuranceCoverage insuranceCoverage, Car car, Owner owner) 
    {
        this.ClaimNo = ClaimNo;
        this.location = location;
        this.claimDate = claimDate;
        this.hasPremium = hasPremium;
        this.hasSpecialOffer = hasSpecialOffer;
        this.insuranceCoverage = insuranceCoverage;
        this.car = car;
        this.owner = owner;
    }   
    
//-----------------------------------Setter and Getter for every data field in the class---------------------------------------------  
    public InsuranceCoverage getInsuranceCoverage() 
    {
        return insuranceCoverage;
    }
    
//-------------------------------------------------------------------------------------- 
    public void setInsuranceCoverage(InsuranceCoverage insuranceCoverage) 
    {
        this.insuranceCoverage = insuranceCoverage;
    }
    
//-------------------------------------------------------------------------------------- 
    public Car getCar() 
    {
        return car;
    }
    
//-------------------------------------------------------------------------------------- 
    public void setCar(Car car)
    {
        this.car = car;
    }
    
//-------------------------------------------------------------------------------------- 
    public Owner getOwner()
    {
        return owner;
    }
    
//-------------------------------------------------------------------------------------- 
    public void setOwner(Owner owner)
    {
        this.owner = owner;
    }
        
//--------------------------------------------------------------------------------------     
    public long getClaimNo() 
    {
        return ClaimNo;
    }

//--------------------------------------------------------------------------------------     
    public void setClaimNo(long ClaimNo) 
    {
        this.ClaimNo = ClaimNo;
    }

//--------------------------------------------------------------------------------------     
    public String getLocation() 
    {
        return location;
    }

//--------------------------------------------------------------------------------------     
    public void setLocation(String location) 
    {
        this.location = location;
    }

//--------------------------------------------------------------------------------------     
    public Date getClaimDate()
    {
        return claimDate;
    }

//--------------------------------------------------------------------------------------     
    public void setClaimDate(Date claimDate)
    {
        this.claimDate = claimDate;
    }

//--------------------------------------------------------------------------------------         
    public Boolean getHasPremium() 
    {
        return hasPremium;
    }

//--------------------------------------------------------------------------------------     
    public void setHasPremium(Boolean hasPremium) 
    {
        this.hasPremium = hasPremium;
    }

//--------------------------------------------------------------------------------------     
    public Boolean getHasSpecialOffer() 
    {
        return hasSpecialOffer;
    }

//--------------------------------------------------------------------------------------     
    public void setHasSpecialOffer(Boolean hasSpecialOffer) 
    {
        this.hasSpecialOffer = hasSpecialOffer;
    }

//-------------------------------------------------------------------------------------- 
    
    //calculate the final claims amounts by using the given conditions
    public double calculateFinalClaimAmount()
    {
        double Total = insuranceCoverage.getAmount();
        
        SimpleDateFormat fod = new SimpleDateFormat("YYYY-MM-DD");
        String month = String.format("%02d", owner.getDob().getMonth());
        String day = String.format("%02d", owner.getDob().getDate());
        String dob = owner.getDob().getYear()+"-"+month+"-"+day;
        LocalDate currentD = LocalDate.now();
        LocalDate birthDay = LocalDate.parse(dob);
        double age = Period.between(birthDay, currentD).getYears();
        
        if(age >= 60)
        {
            Total+=50;
        }
        
        if(hasPremium)
        {
            Total+=200;
        }
        
        if(hasSpecialOffer)
        {
            Total+=100;
        }
        
        return Total;
    }
    
}
