package fr.noristus.rasterizer.util;

public class Logger 
{
	private String prefix;
	
	public static final String DEFAULT_LOG_STYLE = "[" + DateUtil.hmsDateString() + "][%s][%s]: %s \n";
	
	public Logger()
	{
		this("Logger");
	}
	
	public void info(Object message)
	{
		System.out.printf(DEFAULT_LOG_STYLE, this.prefix, "Info", message);
	}
	
	public void warn(Object message)
	{
		System.out.printf(DEFAULT_LOG_STYLE, this.prefix, "Warn", message);
	}
	
	public void error(Object message)
	{
		System.out.printf(DEFAULT_LOG_STYLE, this.prefix, "Error", message);
	}
	
	public Logger(String prefix)
	{
		this.prefix = prefix;
	}
	
	public void setPrefix(String prefix)
	{
		this.prefix = prefix;
	}
	
	public String getPrefix()
	{
		return this.prefix;
	}
}
