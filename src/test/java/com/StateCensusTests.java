package com;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusTests
{
   private static final String STATE_CODE_FILE_PATH = "/home/admin1/IdeaProjects/StateCensorAnalyzer/src/StateCode.csv";

   @Test
   public void givenCSVFile_WhenCorrect_CountsNumberOfRecordsMatches() throws IOException
   {
      StateCensusAnalyzer stateAnalyzer = new StateCensusAnalyzer();
      Assert.assertEquals(37,stateAnalyzer.readDataFromFile(STATE_CODE_FILE_PATH));
   }
}
