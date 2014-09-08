import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class DogLog{
  /* Get actual class name to be printed on */
  Logger log = Logger.getLogger(
                      DogLog.class.getName());

  public void dogLog()
                throws IOException,SQLException{
   
     log.debug("log debug");
  }
}
