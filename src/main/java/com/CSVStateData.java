package com;

import com.opencsv.bean.CsvBindByName;

public class CSVStateData implements Comparable
{

   @CsvBindByName(required = true)
   private String StateName;

   @CsvBindByName
   private String Population;

   @CsvBindByName
   private String AreaInSqKm;

   @CsvBindByName
   private String DensityPerSqKm;

   public String getStateName()
   {
      return StateName;
   }

   public void setStateName(String stateName)
   {
      StateName = stateName;
   }

   public String getPopulation()
   {
      return Population;
   }

   public void setPopulation(String population)
   {
      Population = population;
   }

   public String getAreaInSqKm()
   {
      return AreaInSqKm;
   }

   public void setAreaInSqKm(String areaInSqKm)
   {
      AreaInSqKm = areaInSqKm;
   }

   public String getDensityPerSqKm()
   {
      return DensityPerSqKm;
   }

   public void setDensityPerSqKm(String densityPerSqKm)
   {
      DensityPerSqKm = densityPerSqKm;
   }


   @Override
   public int compareTo(Object o) {
      return (((CSVStateData) o).getStateName()).compareTo(this.getStateName());
   }
}
