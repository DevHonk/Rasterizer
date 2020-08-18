package fr.noristus.rasterizer.core;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import fr.noristus.rasterizer.util.Logger;

@SuppressWarnings("unused")
public class Rasterizer 
{
	private Logger logger = new Logger("InputHandler");
	
	private RasterizerCore core = new RasterizerCore();
	
	public void start()
	{
		logger.info("Choose the image file you would like to get its raster.");

	    File inputImage = getImageFile();
	    
	    if (inputImage == null) return;
	    
	    logger.info("Processing your image, trying to start the core program...");
	    
	    try
	    {
			core.start(inputImage);
		} 
	    catch (IOException e) 
	    {
			e.printStackTrace();
		}
	}

	private File getImageFile()
	{
		File inputFile = null;
		
		boolean processDone = false;
		
		do
		{
			JFileChooser chooser = new JFileChooser();
			
			chooser.setDialogTitle("Choose an image file");

			chooser.setCurrentDirectory(new File(System.getProperty("user.home") + "//Desktop"));

		    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    chooser.setAcceptAllFileFilterUsed(true);
		    
		    // Checking if the user has pressed the cancel button.
		    if (chooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION) break;
		    
		    inputFile = chooser.getSelectedFile();
		    
		    if (inputFile == null) continue;
		    
		    try 
		    {
		    	// Checking whether or not the selected file is an image.
				if (ImageIO.read(inputFile) == null)
				{
					logger.error("The file you have selected isn't an image file, please select another file..");
					
					processDone = false;
				}
			} 
		    catch (IOException e) 
		    {
				e.printStackTrace();
			}
		    
		    logger.info("Perfect ! Selected the image file at location: " + inputFile.getAbsolutePath());
		    
		    processDone = true;
		}
		while(!processDone);
	    
	    return inputFile;
	}
}
