package fr.noristus.rasterizer.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GraphicsUtil 
{
	public static BufferedImage toIntBuffer(File image)
	{
		BufferedImage convertedImageBuffer = null;
		
		try
		{
			BufferedImage sourceImageBuffer = ImageIO.read(image);
			
			convertedImageBuffer = new BufferedImage(sourceImageBuffer.getWidth(), sourceImageBuffer.getHeight(), BufferedImage.TYPE_INT_RGB);
			convertedImageBuffer.setData(sourceImageBuffer.getData());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return convertedImageBuffer;
	}
}
