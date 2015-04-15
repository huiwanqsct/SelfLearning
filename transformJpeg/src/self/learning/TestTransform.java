// 实现了图片的缩放
// 使用了filter和setToScale
package self.learning;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TestTransform {
	private Image image;
	public static final String PATH = "/home/qsct/workspace/transformJpeg/bin/";
	public TestTransform()
	{
		this.image = null;
	}
	public TestTransform(String inputFile)
	{
		try {
			this.image = ImageIO.read(new File(PATH + inputFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Read image error!");
			e.printStackTrace();
		}
	}
	public int showHeight()
	{
		return image.getHeight(null);
	}
	public int showWidth()
	{
		return image.getWidth(null);
	}
	public void transform(int newH, int newW)
	{
		int originH = this.image.getHeight(null);
		int originW = this.image.getWidth(null);
		
		BufferedImage originBufferedImg = new BufferedImage(originW, originH, BufferedImage.TYPE_3BYTE_BGR);
		
		//  如果没有这两句就没办法显示图片，虽然有保存的jpg文件，但是是黑屏
		Graphics2D g2d = originBufferedImg.createGraphics(); 
        g2d.drawImage(image, 0, 0, null); 
        
        BufferedImage newBufferedImg = new BufferedImage(newW, newH, BufferedImage.TYPE_3BYTE_BGR);
        
        double widthBo = (double)newW/originW;  
        double heightBo = (double)newH/originH;  
          
        AffineTransform transform = new AffineTransform();  
        transform.setToScale(widthBo, heightBo);  
          
        AffineTransformOp ato = new AffineTransformOp(transform, null);  
        ato.filter(originBufferedImg, newBufferedImg);
        
        File outputFile = new File(PATH + "javaz.jpg");
        try
        {
        	ImageIO.write(newBufferedImg, "jpg", outputFile);
        }
        catch (IOException e)
        {
        	// TODO Auto-generated catch block
        	System.out.println("Write image error!");
        	e.printStackTrace();
        }
	}
	public static void main(String[] args)
	{
		TestTransform tt = new TestTransform("java.jpg");
		int height = tt.showHeight();
		int width = tt.showWidth();
//		System.out.println("The height of the image is: " + height);
//		System.out.println("The width of the image is: " + width);
		tt.transform(300, 400);
	}
}
