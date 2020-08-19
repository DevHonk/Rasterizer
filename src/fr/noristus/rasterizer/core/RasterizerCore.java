package fr.noristus.rasterizer.core;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

import fr.noristus.rasterizer.util.GraphicsUtil;
import fr.noristus.rasterizer.util.Logger;

public class RasterizerCore
{
	private Logger logger = new Logger("Core");
	
	private BufferedImage in_ImageBuffer;

	private File outputFile;
	
	private long coreProgramStart = 0L;

	public RasterizerCore()
	{
		try 
		{
			File jarPath = new File(RasterizerCore.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
			
			this.outputFile = new File(jarPath.getParentFile().getAbsolutePath() + File.separator + "out" + File.separator + "out.txt");
			
			this.outputFile.getParentFile().mkdir();
			this.outputFile.createNewFile();
		} 
		catch (URISyntaxException | IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public void start(File inputImage) throws IOException
	{
		logger.info("Core program started successfully! Taking care of your image.");
		
		coreProgramStart();
		
		this.in_ImageBuffer = GraphicsUtil.toIntBuffer(inputImage);
		
		logger.info(String.format("Writing image's data in the output file located at: %s", this.outputFile.getAbsoluteFile()));
		
		int[] bufferData = ((DataBufferInt) in_ImageBuffer.getData().getDataBuffer()).getData();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(this.outputFile));
		writer.write(String.format("#define WIDTH %d%n#define HEIGHT %d%n", in_ImageBuffer.getWidth(), in_ImageBuffer.getHeight()));
		writer.write("int pixels[WIDTH * HEIGHT] = {%n");
		for (int pixelIndex = 0; pixelIndex < bufferData.length; pixelIndex++)
		{
			writer.write(String.format("%s, ", String.valueOf(Integer.toHexString(bufferData[pixelIndex]))));
		}
		
		coreProgramEnd();
		
		writer.close();
	}
	
	private void coreProgramStart()
	{
		this.coreProgramStart = System.currentTimeMillis();
	}
	
	private void coreProgramEnd()
	{
		long coreProgramEnd = System.currentTimeMillis();
		
		logger.info(String.format("Rasterization took %s milliseconds.", coreProgramEnd - this.coreProgramStart));
	}
}
