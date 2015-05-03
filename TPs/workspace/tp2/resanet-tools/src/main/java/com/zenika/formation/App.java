package com.zenika.formation;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger = Logger.getLogger(App.class.getName());

    public static void main( String[] args )
    {
        logger.debug("about to say Hello...");
        System.out.println( "Hello World!" );
	logger.debug("Everything went OK, good bye !");
    }
}
