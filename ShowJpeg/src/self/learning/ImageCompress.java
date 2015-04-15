// 以上程序仅仅通过改变图像的长宽来解决压缩

package self.learning;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageCompress {
	private int newW;
	private int newH;
	private BufferedImage bufferedImage;
//	private BufferedImage bufferedImageFrom;
//	private BufferedImage bufferedImageTo;
	private Image image;
	public static final String path = "/home/qsct/workspace/ShowJpeg/bin/";
	public ImageCompress() throws IOException
	{
//		try {
//			this.bufferedImage = ImageIO.read(new File(path + "java.jpg"));
//			throw new IOException();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Image read error!");
//			e.printStackTrace();
//		}
		this.image = ImageIO.read(new File(path + "java.jpg"));
		this.bufferedImage = ImageIO.read(new File(path + "java.jpg"));
		this.newH = bufferedImage.getHeight()/10;
		this.newW = bufferedImage.getWidth()/10;
//		Graphics g = bufferedImage.getGraphics();
//		g.drawImage(image, 0, 0, this.newW, this.newH, null);
	}
	public ImageCompress(int H, int W)
	{
		this.newH = H;
		this.newW = W;
//		this.bufferedImageFrom = new BufferedImage(this.newH, this.newW, BufferedImage.TYPE_INT_RGB); 
	}
	public void save() throws IOException
	{
		String fileName = "java.jpg";
		String fileExtendName = fileName.substring(fileName.indexOf(".") + 1);
		BufferedImage bufferImage = new BufferedImage(this.newW, this.newH, BufferedImage.TYPE_INT_RGB);
//		try {
//			ImageIO.write(bufferedImage, fileExtendName, new File(path + "javaz.jpg"));
//			throw new IOException();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Image write error!");
//			e.printStackTrace();
//		}
		ImageIO.write(bufferedImage, fileExtendName, new File(path + "javaz.jpg"));
	}
	public static void main(String[] args) throws IOException
	{
		ImageCompress imgCompress = new ImageCompress();
		imgCompress.save();
	}
	
}
