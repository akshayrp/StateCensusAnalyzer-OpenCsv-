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
         CsvToBean<Object> csvToBean = new CsvToBeanBuilder(reader).withType(Object.class)
               .withIgnoreLeadingWhiteSpace(true).build();
         Iterator<Object> CsvStateIterator = csvToBean.iterator();

         while(CsvStateIterator.hasNext())
         {
            stateCount++;
            Object csvStates = CsvStateIterator.next();
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
