package com;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyzer
{

   public int readDataFromFile(String stateCodeFilePath) throws CSVFileException
   {
      int stateCount=0;
      Reader reader = null;
      try
      {
         reader = Files.newBufferedReader(Paths.get(stateCodeFilePath));
         CsvToBean<CsvStates> csvToBean = new CsvToBeanBuilder(reader).withType(CsvStates.class).withIgnoreLeadingWhiteSpace(true).build();
         Iterator<CsvStates> CsvStateIterator = csvToBean.iterator();

         while(CsvStateIterator.hasNext())
         {
            stateCount++;
            CsvStates csvStates = CsvStateIterator.next();
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
