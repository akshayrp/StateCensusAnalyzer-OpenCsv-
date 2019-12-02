package com;

import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusTests
{
   StateCensusAnalyzer stateAnalyzer = new StateCensusAnalyzer();
   private static final String STATE_CODE_FILE_PATH = "/home/admin1/IdeaProjects/StateCensorAnalyzer/src/StateCode.csv";
   private static final String STATE_DATA_FILE_PATH =  "/home/admin1/IdeaProjects/StateCensorAnalyzer/src/StateCensusData.csv";
   @Test
   public void givenCSVFile_WhenCorrect_CountsNumberOfRecordsMatches() throws IOException
   {
      try
      {
         Assert.assertEquals(37,stateAnalyzer.readDataFromFile(STATE_CODE_FILE_PATH));
      }
      catch (CSVFileException e)
      {
         Assert.assertEquals(CSVFileException.ExceptionType.WRONG_FILE_PATH,e.type);
      }
   }

   @Test
   public void givenCSVFile_WhenIncorrect_ThrowsCustomException() throws CSVFileException
   {
      try
      {
         Assert.assertEquals(37,stateAnalyzer.readDataFromFile(STATE_CODE_FILE_PATH));
      }
      catch (CSVFileException e)
      {
         Assert.assertEquals(CSVFileException.ExceptionType.WRONG_FILE_PATH,e.type);
      }
   }

   @Test
   public void givenCSVFile_WhenTypeIncorrect_ThrowsException() throws CSVFileException
   {
      try
      {
         Assert.assertEquals(37,stateAnalyzer.readDataFromFile(STATE_DATA_FILE_PATH));
      }
      catch (CSVFileException e)
      {
         Assert.assertEquals(CSVFileException.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION,e.type);
      }
   }
}
