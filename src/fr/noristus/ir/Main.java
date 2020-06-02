package fr.noristus.ir;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Main 
{
	private static Scanner scanner = new Scanner(System.in);
	
	/** The image that we're going to process */
	private static File image;
	/** An HTML file that will contain the raster */
	private static File outputFile = new File("/home/inoristus/Images/Papiers peints/log.html");
	
	public static void main(String[] vmArgs)
	{
		// If the file doesen't exist, then create one. 
		if (!outputFile.exists())
		{
			try 
			{
				outputFile.createNewFile();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		// Getting the image and assigning the image variable.
		do
		{
			System.out.println("Please, enter the path to your image :");
			
			image = new File(scanner.nextLine());
			
			if (!image.exists())
			{
				System.out.println("Sorry, something went wrong ! The path is inexisting ... Choose another one ^^ :");
			}
			
			System.out.println("Perfect ! Found image file at location " + image.getAbsolutePath());
		}
		while (!image.exists());
		
		
		int[] pixels = ProcessImage(image);
		saveData(pixels, outputFile);
	}
	
	/** Returns image's pixels data. */
	private static int[] ProcessImage(File image)
	{
		System.out.println("Calculating image raster ...");
		
		long conversionTs = System.currentTimeMillis();		
		
		BufferedImage bufImage = getTypeIntRGB(image);
	
		int[] pixels = ((DataBufferInt) bufImage.getData().getDataBuffer()).getData();	
		
		System.out.println("Image processing Took : " + ((System.currentTimeMillis() - conversionTs)) + " ms - Image bounds : " + bufImage.getWidth() + "x" + bufImage.getHeight());
		
		return pixels;
	}
	
	/** Save pixels data to a file */
	private static void saveData(int[] pixels, File output)
	{
		long writeFileTs = System.currentTimeMillis();

		try 
		{
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile.getAbsolutePath()), 8);
			
			for (int i = 0; i < pixels.length; i++)
			{
				bufferedWriter.write(pixels[i] +  ", ");
			}
			
			bufferedWriter.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("Writing all data in output file took : " + ((System.currentTimeMillis() - writeFileTs)) + " ms.");
	
	}
	
	/** Returns a TYPE_INT_RGB BufferedImage from a byte BufferedImage */
	private static BufferedImage getTypeIntRGB(File image)
	{
		BufferedImage INT_RGB_BUF = null;

		try 
		{
			BufferedImage source = ImageIO.read(image);
			
			INT_RGB_BUF = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_RGB);
			INT_RGB_BUF.setData(source.getRaster());			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return INT_RGB_BUF;
	}
}
