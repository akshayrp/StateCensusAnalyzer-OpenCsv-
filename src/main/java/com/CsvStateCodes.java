package com;

import com.opencsv.bean.CsvBindByName;

public class CsvStateCodes
{

   @CsvBindByName
   private int SrNo;

   @CsvBindByName(required = true)
   private String StateName;

   @CsvBindByName
   private int StateCode;

   @CsvBindByName
   private String TIN;

   public int getSrNo()
   {
      return SrNo;
   }

   public void setSrNo(int srNo)
   {
      SrNo = srNo;
   }

   public String getStateName()
   {
      return StateName;
   }

   public void setStateName(String stateName)
   {
      StateName = stateName;
   }

   public int getStateCode()
   {
      return StateCode;
   }

   public void setStateCode(int stateCode)
   {
      StateCode = stateCode;
   }

   public String getTIN()
   {
      return TIN;
   }

   public void setTIN(String TIN)
   {
      this.TIN = TIN;
   }
}
