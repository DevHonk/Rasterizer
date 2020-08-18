package fr.noristus.rasterizer;

import static fr.noristus.rasterizer.util.Constants.ERRCODE_INVALID_JAVA_VERSION;
import static fr.noristus.rasterizer.util.Constants.LOWEST_JAVA_VERSION;

import javax.swing.UIManager;

import fr.noristus.rasterizer.core.Rasterizer;
import fr.noristus.rasterizer.util.JavaUtil;
import fr.noristus.rasterizer.util.Logger;

public class Main 
{
	private static Logger logger = new Logger("Main");
	
	public static void main(String[] vmArgs)
	{
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		logger.warn("It is better to put the jar file in a seperate folder. Like so, you can find the output files with ease. \n");

		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		logger.info("Currently validating your Java's version...");

		if (!isCompatible())
		{
			logger.info("Terminating with error code: " + ERRCODE_INVALID_JAVA_VERSION);
			return;
		}
		
		logger.info("Starting up, the Rasterizer Program..");
		
		new Rasterizer().start();
	}
	
	private static boolean isCompatible()
	{	
		logger.info(String.format("Found the following java version: %s", JavaUtil.javaInfo()));
		
		if (!JavaUtil.javaAtLeast(LOWEST_JAVA_VERSION))
		{
			logger.error("You don't have the minimal requirements. Install a higher Java version.");
			return false;
		}
		
		logger.info("You have the minimum prerequisites.");
		
		return true;
	}
}
