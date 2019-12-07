package com;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class StateCensusAnalyzer<T extends Comparable<T>>
{
   List<CSVStateData> csvCensusDataList = new ArrayList<>();

   public int readDataFromFile(String FilePath) throws CustomExceptions
   {
      int stateCount = 0;
      Reader reader = null;
      try
      {
         reader = Files.newBufferedReader(Paths.get(FilePath));
         CsvToBean<CSVStateData> csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateData.class)
               .withIgnoreLeadingWhiteSpace(true).build();
         Iterator<CSVStateData> csvStateIterator = csvToBean.iterator();

         while (csvStateIterator.hasNext())
         {
            stateCount++;
            CSVStateData csvUser = csvStateIterator.next();
            csvCensusDataList.add(csvUser);
         }
      }
      catch (IOException e)
      {
         throw new CustomExceptions(CustomExceptions.ExceptionType.WRONG_FILE_PATH, "File Not Found");
      }
      catch (RuntimeException e)
      {
         throw new CustomExceptions(CustomExceptions.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION,
               "Cannot Map CSV Header Or issue With Delimiter");
      }
      return stateCount;
   }


   private static void sortListBasedOnStateName(List<CSVStateData> censusList)
   {
      Comparator<CSVStateData> c = (s1, s2) -> s1.getStateName().compareTo(s2.getStateName());
      censusList.sort(c);
   }

   private static void sortListBasedOnPopulation(List<CSVStateData> censusList)
   {

      Comparator<CSVStateData> c = (s1, s2) ->
            Integer.parseInt(s1.getPopulation()) - Integer.parseInt(s1.getPopulation());
      censusList.sort(c);
   }

   private static void sortListBasedOnDensity(List<CSVStateData> censusList)
   {
      Comparator<CSVStateData> c = (s1, s2) ->
            Integer.parseInt(s2.getDensityPerSqKm()) - Integer.parseInt(s1.getDensityPerSqKm());
      censusList.sort(c);
   }

   private static void sortListBasedOnStateArea(List<CSVStateData> censusList)
   {
      Comparator<CSVStateData> c = (s1, s2) ->
            Integer.parseInt(s2.getAreaInSqKm()) - Integer.parseInt(s1.getAreaInSqKm());
      censusList.sort(c);
   }


      public Boolean storeDataIntoJSON (String FilePath) throws CustomExceptions
      {
         sortListBasedOnStateName(csvCensusDataList);
         sortListBasedOnPopulation(csvCensusDataList);
         sortListBasedOnDensity(csvCensusDataList);
         sortListBasedOnStateArea(csvCensusDataList);

         try
         {
            Gson gson = new Gson();
            String json = gson.toJson(csvCensusDataList);
            FileWriter writer = new FileWriter(FilePath);
            writer.write(json);
            writer.close();
            return true;
         }
         catch (IOException e)
         {
            throw new CustomExceptions(CustomExceptions.ExceptionType.WRONG_FILE_PATH, "File Not Found");
         }
      }
   }
