package com;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class CensusTest
{
   StateCensusAnalyzer stateAnalyzer = new StateCensusAnalyzer();
   private static final String STATE_CODE_FILE_PATH = "/home/admin1/IdeaProjects/StateCensorAnalyzer/src/StateCode.csv";
   private static final String STATE_DATA_FILE_PATH
         = "/home/admin1/IdeaProjects/StateCensorAnalyzer/src/StateCensusData.csv";
   private static final String STATE_DATA_JSON_FILE_PATH
         = "/home/admin1/IdeaProjects/StateCensorAnalyzer/src/StateDataJson.json";

   @Test
   public void givenCSVFile_WhenCorrect_CountsNumberOfRecordsMatches()
   {
      try
      {
         Assert.assertEquals(37, stateAnalyzer.readDataFromFile(STATE_CODE_FILE_PATH));
      }
      catch (CustomExceptions e)
      {
         Assert.assertEquals(CustomExceptions.ExceptionType.WRONG_FILE_PATH, e.type);
      }
   }

   @Test
   public void givenCSVFile_WhenIncorrect_ThrowsCustomException()
   {
      try
      {
         Assert.assertEquals(37, stateAnalyzer.readDataFromFile(STATE_CODE_FILE_PATH));
      }
      catch (CustomExceptions e)
      {
         Assert.assertEquals(CustomExceptions.ExceptionType.WRONG_FILE_PATH, e.type);
      }
   }

   @Test
   public void givenCSVFile_WhenTypeIncorrect_ThrowsException()
   {
      try
      {
         Assert.assertEquals(29, stateAnalyzer.readDataFromFile(STATE_DATA_FILE_PATH));
      }
      catch (CustomExceptions e)
      {
         Assert.assertEquals(CustomExceptions.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION, e.type);
      }
   }

   @Test
   public void givenCSVFile_WhenDelimiterIncorrect_ThrowsException()
   {
      try
      {
         Assert.assertEquals(37, stateAnalyzer.readDataFromFile(STATE_CODE_FILE_PATH));
      }
      catch (CustomExceptions e)
      {
         Assert.assertEquals(CustomExceptions.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION, e.type);
      }
   }

   @Test
   public void givenCSVFile_WhenHeaderIncorrect_ThrowsException()
   {
      try
      {
         Assert.assertEquals(37, stateAnalyzer.readDataFromFile(STATE_CODE_FILE_PATH));
      }
      catch (CustomExceptions e)
      {
         Assert.assertEquals(CustomExceptions.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION, e.type);
      }
   }

   @Test
   public void givenStateDataCSVFile_WhenCorrect_CountsNumberOfRecordsMatches()
   {
      try
      {
         Assert.assertEquals(29, stateAnalyzer.readDataFromFile(STATE_DATA_FILE_PATH));
      }
      catch (CustomExceptions e)
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
      catch (CustomExceptions e)
      {
         Assert.assertEquals(CustomExceptions.ExceptionType.WRONG_FILE_PATH, e.type);
      }
   }

   @Test
   public void givenStateDataCSVFile_WhenTypeIncorrect_ThrowsException()
   {
      try
      {
         Assert.assertEquals(37, stateAnalyzer.readDataFromFile(STATE_CODE_FILE_PATH));
      }
      catch (CustomExceptions e)
      {
         Assert.assertEquals(CustomExceptions.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION, e.type);
      }
   }

   @Test
   public void givenStateDataCSVFile_WhenDelimiterIncorrect_ThrowsException()
   {
      try
      {
         Assert.assertEquals(29, stateAnalyzer.readDataFromFile(STATE_DATA_FILE_PATH));
      }
      catch (CustomExceptions e)
      {
         Assert.assertEquals(CustomExceptions.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION, e.type);
      }
   }

   @Test
   public void givenStateDataCSVFile_WhenHeaderIncorrect_ThrowsException()
   {
      try
      {
         Assert.assertEquals(29, stateAnalyzer.readDataFromFile(STATE_DATA_FILE_PATH));
      }
      catch (CustomExceptions e)
      {
         Assert.assertEquals(CustomExceptions.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION, e.type);
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
      catch (CustomExceptions e)
      {
         Assert.assertEquals(CustomExceptions.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION, e.type);
      }
   }
}
