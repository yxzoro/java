
import java.util.logging.*;
import java.io.*;


        public void InitFileLogger() {
            this.logger = Logger.getLogger("flink");
            FileHandler fh = new FileHandler("/tmp/flink.log");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);            
        }

        public static String getStackTrace(Throwable throwable) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                try {
                    throwable.printStackTrace(pw);
                    return sw.toString();
                } 
                finally {
                    pw.close();
                }
        }




