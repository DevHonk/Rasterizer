package fr.noristus.rasterizer.util;

public class JavaUtil 
{
	/**
	 * Returns the full formated "name - version" of the currently installed / active & bound Java instance
	 */
	public static String javaInfo()
	{
		return String.format("%s - %s", System.getProperty("java.runtime.name"), System.getProperty("java.vm.version"));
	}
	
	/**
	 * Checks whether or not the user has at least the passed in parameters version ID, either it won't work.
	 * 
	 * E.g: BufferedImages has appeared since Java 7 a version lower than recommended can crash the program. 
	 * 
	 * @param version The oldest "acceptable" Java version
	 * 
	 * @return True if the user has the given Java version, false if not.
	 */
	public static boolean javaAtLeast(final float version)
	{
		if (Float.parseFloat(System.getProperty("java.class.version")) >= version)
		{
			return true;
		}
		else
		{
			return false;			
		}
	}
}
