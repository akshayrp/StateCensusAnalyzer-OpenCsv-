package com;

import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.junit.Assert;
import org.junit.Test;


public class StateCensusTests
{
   StateCensusAnalyzer stateAnalyzer = new StateCensusAnalyzer();
   private static final String STATE_DATA_FILE_PATH
         = "/home/admin1/IdeaProjects/StateCensorAnalyzer/src/StateCensusData.csv";
   private static final String STATE_DATA_JSON_FILE_PATH
         = "/home/admin1/IdeaProjectsStateCensorAnalyzer/src/StateDataJson.json";

   @Test
   public void givenStateDataCSVFile_WhenCorrect_CountsNumberOfRecordsMatches()
   {
      try
      {
         Assert.assertEquals(29, stateAnalyzer.readDataFromFile(STATE_DATA_FILE_PATH));
      }
      catch (CSVFileException e)
      {
         e.printStackTrace();
      }
   }

   @Test
   public void givenStateDataCSVFile_WhenIncorrect_ThrowsCustomException()
   {
      try
      {
         Assert.assertEquals(29, stateAnalyzer.readDataFromFile(STATE_DATA_FILE_PATH));
      }
      catch (CSVFileException e)
      {
         Assert.assertEquals(CSVFileException.ExceptionType.WRONG_FILE_PATH, e.type);
      }
   }

   @Test
   public void givenStateDataCSVFile_WhenTypeIncorrect_ThrowsException()
   {
      try
      {
         Assert.assertEquals(37, stateAnalyzer.readDataFromFile(STATE_DATA_JSON_FILE_PATH));
      }
      catch (CSVFileException e)
      {
         Assert.assertEquals(CSVFileException.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION, e.type);
      }
   }

   @Test
   public void givenStateDataCSVFile_WhenDelimiterIncorrect_ThrowsException()
   {
      try
      {
         Assert.assertEquals(29, stateAnalyzer.readDataFromFile(STATE_DATA_FILE_PATH));
      }
      catch (CSVFileException e)
      {
         Assert.assertEquals(CSVFileException.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION, e.type);
      }
   }

   @Test
   public void givenStateDataCSVFile_WhenHeaderIncorrect_ThrowsException()
   {
      try
      {
         Assert.assertEquals(29, stateAnalyzer.readDataFromFile(STATE_DATA_FILE_PATH));
      }
      catch (CSVFileException e)
      {
         Assert.assertEquals(CSVFileException.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION, e.type);
      }
   }

   @Test
   public void storeDataInto_Json()
   {
      try
      {
         Assert.assertEquals(29, stateAnalyzer.readDataFromFile(STATE_DATA_FILE_PATH));
         Assert.assertTrue(stateAnalyzer.storeDataIntoJSON(STATE_DATA_JSON_FILE_PATH));
      }
      catch (CSVFileException e)
      {
         Assert.assertEquals(CSVFileException.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION, e.type);
      }
   }

   @Test
   public void storeDataInto_Json_PopulationDescending()
   {
      try
      {
         Assert.assertEquals(29, stateAnalyzer.readDataFromFile(STATE_DATA_FILE_PATH));
         Assert.assertTrue(stateAnalyzer.storeDataIntoJSON(STATE_DATA_JSON_FILE_PATH));
      }
      catch (CSVFileException e)
      {
         Assert.assertEquals(CSVFileException.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION, e.type);
      }
   }

   @Test
   public void givenCSVFileToConvertToJson_WhenDestinationFilePathIncorrect_Returns()
   {
      try
      {
         Assert.assertEquals(29, stateAnalyzer.readDataFromFile(STATE_DATA_FILE_PATH));
         Assert.assertTrue(stateAnalyzer.storeDataIntoJSON(STATE_DATA_JSON_FILE_PATH));
      }
      catch (CSVFileException e)
      {
         System.out.println("Enter Correct File path");
         Assert.assertEquals(CSVFileException.ExceptionType.WRONG_FILE_PATH, e.type);
      }
   }
}
