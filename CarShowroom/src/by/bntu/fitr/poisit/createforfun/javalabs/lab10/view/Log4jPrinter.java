package by.bntu.fitr.poisit.createforfun.javalabs.lab10.view;

import org.apache.log4j.Logger;

public class Log4jPrinter implements Printer {
    private static final Logger LOG;

    static {
        LOG = Logger.getRootLogger();
    }

    public void print(String msg) {
        LOG.info(msg);
    }
}
