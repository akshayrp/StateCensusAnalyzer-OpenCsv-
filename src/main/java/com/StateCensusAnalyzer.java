package com;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyzer
{

   public int readDataFromFile(String FilePath) throws CSVFileException
   {
      int stateCount=0;
      Reader reader = null;
      try
      {
         reader = Files.newBufferedReader(Paths.get(FilePath));
         CsvToBean<CsvStateCodes> csvToBean = new CsvToBeanBuilder(reader).withType(CsvStateCodes.class).withIgnoreLeadingWhiteSpace(true).build();
         Iterator<CsvStateCodes> CsvStateIterator = csvToBean.iterator();

         while(CsvStateIterator.hasNext())
         {
            stateCount++;
            CsvStateCodes csvStates = CsvStateIterator.next();
         }
      }
      catch (IOException e)
      {
         throw new CSVFileException(CSVFileException.ExceptionType.WRONG_FILE_PATH,"File Not Found");
      }
      catch (RuntimeException e)
      {
         throw new CSVFileException(CSVFileException.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION,
               "Cannot Map CSV Header Or issue With Delimiter");
      }

      return  stateCount;
   }


   public int readStateDataFromFile(String FilePath) throws CSVFileException
   {
      int stateCount=0;
      Reader reader = null;
      try
      {
         reader = Files.newBufferedReader(Paths.get(FilePath));
         CsvToBean<CSVStateData> csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateData.class)
               .withIgnoreLeadingWhiteSpace(true).build();
         Iterator<CSVStateData> CsvStateIterator = csvToBean.iterator();

         while(CsvStateIterator.hasNext())
         {
            stateCount++;
           CsvStateIterator.next();
         }
      }
      catch (IOException e)
      {
         throw new CSVFileException(CSVFileException.ExceptionType.WRONG_FILE_PATH,"File Not Found");
      }
      catch (RuntimeException e)
      {
         throw new CSVFileException(CSVFileException.ExceptionType.CSV_HEADER_MAPPING_EXCEPTION,
               "Cannot Map CSV Header Or issue With Delimiter");
      }

      return  stateCount;
   }
}
