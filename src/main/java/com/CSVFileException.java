package com;

public class CSVFileException  extends Exception
{
   enum ExceptionType
   {
     WRONG_FILE_PATH
   }
   ExceptionType type;


   public CSVFileException(ExceptionType type,String message)
   {
      super(message);
      this.type = type;

   }

   public CSVFileException(String message, Throwable cause, ExceptionType type)
   {
      super(message, cause);
      this.type = type;
   }

   public CSVFileException(Throwable cause, ExceptionType type)
   {
      super(cause);
      this.type = type;
   }
}
