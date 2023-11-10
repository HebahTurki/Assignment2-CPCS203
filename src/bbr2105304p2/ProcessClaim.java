package bbr2105304p2;

import java.util.*;
import java.io.*;

/*
 Name : Hebah Turki Alahmari 
 IDs : 2105304
 Section : BBR
 course name : CPCS203
 Assignment#2
 */

public class ProcessClaim 
{
    //calculate the number of Insurance Coverage Per Owner and print it out in the file
    public static void NumOfInsuranceCoveragePerOwner(Owner[] owners, Claim[] claims, PrintWriter pin) 
    {
        pin.println("--------Total claim(s) by owner--------\n");
        pin.println("Owner ID             Owner Name            Total Claim(s)");
        
        for(int i = 0; i < owners.length; i++)
        {
            pin.printf("\n%-12s", owners[i].getNationalID());
            String fullName = owners[i].getFirst_name()+" "+owners[i].getLast_name();
            pin.printf("%19s",fullName);
            
        //check if the ID of the owner equals to the ID in the claim array then print it    
            int count = 0;
            for(int j = 0; j < claims.length; j++)
            {
                if(claims[j].getOwner().getNationalID().equals(owners[i].getNationalID()))
                    count++;
            }
            
            pin.printf("%26d",count);
        }
    }
    //calculate the number of Insurance Coverage Per Owner and print it out in the file ends here
  
//--------------------------------------------------------------------------------------  
    
    //print the Claims in the output file
    public static void PrintClaim(Claim claim, PrintWriter pin) 
    {
        pin.println("Invoice No. "+claim.getClaimNo()+"\n");
        pin.println("Insurance Coverage Details");
        pin.println("	Insurance Coverage Code: "+claim.getInsuranceCoverage().getInsuranceCoverageCode());
        pin.println("	Insurance Coverage Description: "+claim.getInsuranceCoverage().getDescription());
        pin.println("	Insurance Coverage Penalty: "+claim.getInsuranceCoverage().getAmount()+"\n");
        
        pin.println("Car Details");
        pin.println("	Number Plate: "+claim.getCar().getCarPlateNo());
        pin.println("	Type: "+claim.getCar().getCarType());
        pin.println("	Brand: "+claim.getCar().getBrand());
        pin.println("	Model: "+claim.getCar().getCarModel());
        pin.println("	Color: "+claim.getCar().getCarColor());
        pin.println("	Built Year: "+claim.getCar().getBuiltYear()+"\n");
        
        pin.println("Owner Details");
        pin.println("	National ID: "+claim.getOwner().getNationalID());
        pin.println("	Full Name: "+claim.getOwner().getFirst_name()+" "+claim.getOwner().getLast_name()+"\n");
        
        pin.println("Claim Details");
        pin.println("	Date: "+claim.getClaimDate().getYear() + "-" + claim.getClaimDate().getDate() + "-" +claim.getClaimDate().getMonth() );
        pin.println("	Location: "+claim.getLocation()+"\n");
        
        //calculate the final claims amount in the claims class
        pin.println("Total Amount: "+claim.calculateFinalClaimAmount());
        pin.println("â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”"
                + "€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€");
    }
    //print the Claims in the output file ends here
    
//-------------------------------------------------------------------------------------- 

    //create the claim object
    private static Claim GenerateClaim(Scanner input, InsuranceCoverage[] ICs, Car[] cars, Owner[] owners, PrintWriter pin) 
    {
        
        int ICCode = input.nextInt();
        String numberPlate = input.next();
        String ID = input.next();
        String location = input.next();
        long InvoiceClaimNumber = System.currentTimeMillis();
        
        int year = input.nextInt();
        int month = input.nextInt();
        int day = input.nextInt(); 
        Date date = new Date(year, month, day);
        
        Boolean hasPremium = input.nextBoolean();
        Boolean hasSpecialOffer = input.nextBoolean();
        
    //check if the Insurance Coverage code of the claim equals to the Insurance Coverage code in the ICs array then save it in ICCodeSearch
        InsuranceCoverage ICCodeSearch = null;
        for(int i = 0; i < ICs.length; i++)
        {
            if(ICs[i].getInsuranceCoverageCode() == ICCode)
            {
                ICCodeSearch = ICs[i];
                break;
            }
        }
        
    //check if the Car Plate Number of the claim equals to the Car Plate Number in the cars array then save it in carNumPlateSearch    
        Car carNumPlateSearch = null;
        for(int i = 0; i < cars.length; i++)
        {
            if(cars[i].getCarPlateNo().equals(numberPlate))
            {
                carNumPlateSearch = cars[i];
                break;
            }
        }
        
    //check if the Owner ID of the claim equals to the Owner ID in the owners array then save it in IDOwnerSearch     
        Owner IDOwnerSearch = null;
        for(int i = 0; i < cars.length; i++)
        {
            if(owners[i].getNationalID().equals(ID))
            {
                IDOwnerSearch = owners[i];
                break;
            }
        }
        
        Claim claim = new Claim(InvoiceClaimNumber, location, date, hasPremium,
                hasSpecialOffer, ICCodeSearch, carNumPlateSearch, IDOwnerSearch);
        
        return claim;
    }
    //create the claim object ends here
    
//-------------------------------------------------------------------------------------- 

    //create the Insurance Coverage object
    private static InsuranceCoverage getInsuranceCoverage(Scanner input) 
    {
        int ICCode = input.nextInt();
        String ICDescription = input.next();
        ICDescription = ICDescription.replace("_", " ");
        double claimAmount = input.nextDouble();
        
        InsuranceCoverage IC = new InsuranceCoverage(ICCode, ICDescription, claimAmount);
        
        return IC;
    }
    //create the Insurance Coverage object ends here
        
//-------------------------------------------------------------------------------------- 
    
    //create the owner object
    private static Owner getOwner(Scanner input) 
    {
        String NID = input.next();
        String Fname = input.next();
        String Lname = input.next();
        int year = input.nextInt();
        int month = input.nextInt();
        int day = input.nextInt();
        
        Date date = new Date(year, month, day); //create date object
        Owner owner = new Owner(NID, Fname, Lname, date);
        
        return owner; 
    }
    //create the owner object ends here

//--------------------------------------------------------------------------------------
    
    //create the car object
    private static Car getCar(Scanner input)
    {
        String numberPlate = input.next();
        String type = input.next();
        String brand = input.next();
        String model = input.next();
        String color = input.next();
        int Year = input.nextInt();
        
        Car car = new Car(numberPlate, type, brand, model, color, Year);
        
        return car;
    }
    //create the car object ends here

//--------------------------------------------------------------------------------------
    public static void main(String[] args) throws FileNotFoundException 
    {
        //Open the input Files & reading the data.
        File inputCICS = new File("/Users/hebahturki/NetBeansProjects/BBR2105304P2/inputCICSData.txt");
        File inputClaim = new File("/Users/hebahturki/NetBeansProjects/BBR2105304P2/inputClaims.txt");
        
        //File pointer to the output file.
        File outputCICS = new File("CICSDatabase.txt");
        File outputClaim = new File("ClaimInvoices.txt");
        
        //Check if the files exists.
        if(!inputCICS.exists() || !inputClaim.exists())
        {
            System.out.println("The input files does not exists!!");
            System.exit(0);
        }
        
        //Make Scanners for input Files.
        Scanner inputFile1 = new Scanner(inputCICS);
        Scanner inputFile2 = new Scanner(inputClaim);
        
        //Creating fileWriter to write in the Files.
        PrintWriter pinFile1 = new PrintWriter(outputCICS);
        PrintWriter pinFile2 = new PrintWriter(outputClaim);
        
//        input the number of cars, owners, and Insurance Coverage objects 
        int numberOfCars = inputFile1.nextInt();
        int numberOfOwners = inputFile1.nextInt();
        int numberOfICs = inputFile1.nextInt();
//        input the number of cars, owners, and Insurance Coverage objects ends here 

//        Create the required arrays
        Car [] cars = new Car[numberOfCars]; //cars array
        Owner [] owners = new Owner[numberOfOwners]; //owners array
        InsuranceCoverage [] ICs = new InsuranceCoverage[numberOfICs]; // Insurance Coverage array
        
        //create the commands 
        String command;
        String command2;
        int emptyi;
        
        do
        {
          command = inputFile1.next();
          
          switch(command)
          {
              case "AddCar" :
                  
                  Car car = getCar(inputFile1);
                 
                  //check if the index empty then save the object in
                  emptyi = -1;
                  for(int i =0; i < cars.length; i++)
                  {
                      if(cars[i] == null)
                      {
                          emptyi = i;
                          break;
                      }
                  }
                  
                  cars[emptyi] = car;
                  
                  break;
                  
              case "AddOwner" :
                  
                  Owner owner = getOwner(inputFile1);
                  
                  //check if the index empty then save the object in
                  emptyi = -1;
                  for(int i =0; i < owners.length; i++)
                  {
                      if(owners[i] == null)
                      {
                          emptyi = i;
                          break;
                      }
                  }
                  
                  owners[emptyi] = owner;
                  
                  break;
                  
              case "AddInsuranceCoverage" :  
                  
                  InsuranceCoverage IC = getInsuranceCoverage(inputFile1);
                  
                  //check if the index empty then save the object in
                  emptyi = -1;
                  for(int i =0; i < ICs.length; i++)
                  {
                      if(ICs[i] == null)
                      {
                          emptyi = i;
                          break;
                      }
                  }
                  
                  ICs[emptyi] = IC;
                  
                  break;
          }
          
        }while(!command.equals("Quit"));       
        
        //close the first file reader
        inputFile1.close();
        
        //print in the first file
        pinFile1.println("--------------- Welcome to CICS  Database ---------------\n");
        
        //print cars array content
        for(int i = 0; i < cars.length; i++)
        {
            pinFile1.println("\n"+cars[i].toString());
            pinFile1.print("------------------------------------------------------");
        }
        
        //print InsuranceCoverage array content
        for(int i = 0; i < ICs.length; i++)
        {
            pinFile1.println("\n"+ICs[i].toString());
            pinFile1.print("------------------------------------------------------");
        }
        
        //print owners array content
        for(int i = 0; i < owners.length; i++)
        {
            pinFile1.println("\n"+owners[i].toString());
            pinFile1.print("------------------------------------------------------");
        }
        //print in the first file ends here 
        
        //close the first file writer
        pinFile1.close();
        
//       ----------------- END OF THE FIRST PART ------------------

//       ----------------- START OF THE SECOND PART ------------------
        
//      input the number of Claims objects         
        int numberOfClaims = inputFile2.nextInt();

//        Create the required arrays        
        Claim [] claims = new Claim[numberOfClaims]; //claims array
        
        do
        {
          command2 = inputFile2.next();
          
          if(command2.equalsIgnoreCase("ProcessClaim"))
          {
              Claim claim = GenerateClaim(inputFile2, ICs, cars, owners, pinFile2);
              
              //check if the index empty then save the object in
              emptyi = -1;
              for(int i =0; i < claims.length; i++)
              {
                    if(claims[i] == null)
                    {
                        emptyi = i;
                        break;
                    }
              }
              claims[emptyi] = claim;
              
          }
          
        }while(!command2.equals("Quit")); 
        
        //close the second file reader
        inputFile2.close();
        
        //print in the second file  
        pinFile2.println("--------------- Welcome to Traffic Claim System ---------------\n\n");
        for(int i = 0; i < claims.length; i++)
        {
            PrintClaim(claims[i], pinFile2);
        }
        
        //calculate and print the Number Of Insurance Coverage Per Owner
        NumOfInsuranceCoveragePerOwner(owners, claims, pinFile2);
        
        //print in the second file ends here 
        
        //close the second file writer
        pinFile2.close();
        
    }

}
