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

   public int readDataFromFile(String stateCodeFilePath) throws CSVFileException
   {
      int stateCount=0;
      Reader reader = null;
      try
      {
         reader = Files.newBufferedReader(Paths.get(stateCodeFilePath));
      }
      catch (IOException e)
      {
         throw new CSVFileException(CSVFileException.ExceptionType.WRONG_FILE_PATH,"File Not Found");
      }
      CsvToBean<CsvStates> csvToBean = new CsvToBeanBuilder(reader).withType(CsvStates.class).withIgnoreLeadingWhiteSpace(true).build();
      Iterator<CsvStates> CsvStateIterator = csvToBean.iterator();

      while(CsvStateIterator.hasNext())
      {
         stateCount++;
         CsvStates csvStates = CsvStateIterator.next();
      }
      return  stateCount;
   }
}
