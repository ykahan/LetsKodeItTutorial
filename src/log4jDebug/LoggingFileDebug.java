package log4jDebug;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class LoggingFileDebug {
	private static final Logger log = (Logger) LogManager.getLogger(LoggingFileDebug.class.getName());
	
	public static void main(String[] args) {
		log.trace("Trace message logged");
		log.debug("Debug message logged");
		log.info("Info message logged");
		log.error("Error message logged");
		log.fatal("Fatal message logged");
	}
}

