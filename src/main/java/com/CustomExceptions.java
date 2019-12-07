package com;

public class CustomExceptions extends Exception
{
   enum ExceptionType
   {
     WRONG_FILE_PATH, CSV_HEADER_MAPPING_EXCEPTION
   }
   ExceptionType type;


   public CustomExceptions(ExceptionType type, String message)
   {
      super(message);
      this.type = type;

   }

   public CustomExceptions(String message, Throwable cause, ExceptionType type)
   {
      super(message, cause);
      this.type = type;
   }

   public CustomExceptions(Throwable cause, ExceptionType type)
   {
      super(cause);
      this.type = type;
   }
}
