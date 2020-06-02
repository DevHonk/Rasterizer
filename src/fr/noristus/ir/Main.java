package fr.noristus.ir;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

/** WARNING : 
 * 	800X600 MAX RESOLUTION IMAGES ONLY ! A VERY BIG RESOLUTION CAN FREEZE/CRASH YOUR COMPUTER !
 * 	YOU HAVE BEEN WARNED !!! (i do love this sentence, but seriously use small images)
 */
public class Main 
{
	private static Scanner scanner = new Scanner(System.in);
	
	/** The image that we're going to process */
	private static File image;
	/** An HTML file that will contain the raster */
	private static String currentUsersHomeDir = System.getProperty("user.home");
	private static File outputFile = new File(currentUsersHomeDir + "//Images//log.html");
	
	public static void main(String[] vmArgs)
	{
		System.out.println("Output file path setten to :  " + outputFile.getAbsolutePath());
		
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
		
		
		String[] pixels = ProcessImage(image);
		saveData(pixels, outputFile);
	}
	
	/** Returns image's pixels data. */
	private static String[] ProcessImage(File image)
	{
		System.out.println("Calculating image raster ...");
		
		long conversionTs = System.currentTimeMillis();		
		
		// (Test purposes) BufferedImage bufImage = new BufferedImage(8, 8, BufferedImage.TYPE_INT_RGB);
		BufferedImage bufImage = getTypeIntRGB(image);
		
		int[] pixels = ((DataBufferInt) bufImage.getData().getDataBuffer()).getData();	
		String[] hexData = new String[pixels.length];
		
		for (int i = 0; i < pixels.length; i++)
		{
			hexData[i] = Integer.toHexString(pixels[i]);
		}
		
		System.out.println("Image processing Took : " + ((System.currentTimeMillis() - conversionTs)) + " ms - Image bounds : " + bufImage.getWidth() + "x" + bufImage.getHeight());
		
		return hexData;
	}
	
	/** Save pixels data to a file */
	private static void saveData(String[] pixels, File output)
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
