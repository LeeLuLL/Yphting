package com.accp.t4.action.wxxAction;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
 
public class OperateImage {
	public OperateImage() {
		super();
	}

	public OperateImage(String srcpath, String subpath, int x, int y, int width, int height) {
		super();
		this.srcpath = srcpath;
		this.subpath = subpath;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public OperateImage(String srcpath, String subpath, int x, int y, int width, int height, String imgType) {
		super();
		this.srcpath = srcpath;
		this.subpath = subpath;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.imgType = imgType;
	}

	// ===源图片路径名称如:c:\1.jpg
	private String srcpath;
	// ===剪切图片存放路径名称.如:c:\2.jpg
	private String subpath;
//	// ===剪切点x坐标
	private int x;
	private int y;
	// ===剪切点宽度
	private int width;
	private int height;   //(省略四个属性的get & set)
	
	private String imgType;

	/** 对图片裁剪，并把裁剪完的新图片保存 */
	public void cut() throws IOException {
		FileInputStream is = null;
		ImageInputStream iis = null;
		try {
			// 读取图片文件
			is = new FileInputStream(srcpath);
			/*
			 * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。
			 * 参数：formatName - 包含非正式格式名称 . （例如 "jpeg" 或 "tiff"）等 。
			 */
			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(imgType);
			ImageReader reader = it.next();
			// 获取图片流
			iis = ImageIO.createImageInputStream(is);
			/*
			 * <p>iis:读取源.true:只向前搜索 </p>.将它标记为 ‘只向前搜索’。
			 * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
			 */
			reader.setInput(iis, true);
			/*
			 * <p>描述如何对流进行解码的类<p>.用于指定如何在输入时从 Java Image I/O
			 * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其 ImageReader 实现的
			 * getDefaultReadParam 方法中返回 ImageReadParam 的实例。
			 */
			ImageReadParam param = reader.getDefaultReadParam();
			/*
			 * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
			 * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。
			 */
			Rectangle rect = new Rectangle(x, y, width, height);
			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);
			/*
			 * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的
			 * BufferedImage 返回。
			 */
			BufferedImage bi = reader.read(0, param);
			// 保存新图片
			ImageIO.write(bi, "jpg", new File(subpath));
		} finally {
			if (is != null)
				is.close();
			if (iis != null)
				iis.close();
		}
	}

	 /**
	* 加图片水印  
	*
	* @param bufImg  --BufferedImage  用来画图的宽高跟需要加水印的图片一样的空白图
	* @param img --需要加水印的图片
	* @param markImg --水印图片
	* @param width	--水印图片宽
	* @param height --水印图片高
	* @param x	--水印相对于底片的x轴坐标(PS:左上角为(0,0))
	* @param y  --水印相对于底片的y轴坐标(PS:左上角为(0,0))
	* @author 高永强 
	* @version 2018年11月30日 上午11:18:51
	 */
	public static void markPic(BufferedImage bufImg, Image img, Image markImg, int width, int height, int x, int y) {
		//取到画笔
		Graphics2D g = bufImg.createGraphics();
		//画底片
		g.drawImage(img, 0, 0, bufImg.getWidth(), bufImg.getHeight(), null);
		//画水印位置
		g.drawImage(markImg, x, y, width, height, null);
		g.dispose();
	}
	
    /**
	 * 直接给multipartFile加上图片水印再进行保存图片的操作方便省事
	 *
	 * @param multipartFile
	 *            文件上传的对象
	 * @param markImg
	 *            水印文件的路径 如果是相对路径请使用相对路径new Image的方法,此处用的是url
	 * @return
	 * @throws IOException
	 * @author 高永强
	 * @version 2018年11月30日 上午11:15:56
	 */
	public static MultipartFile addPicMarkToMutipartFile(MultipartFile multipartFile,
			String markImg) throws IOException {
		// 获取图片文件名 xxx.png xxx
		String originFileName = multipartFile.getOriginalFilename();
		// 获取原图片后缀 png
		int lastSplit = originFileName.lastIndexOf(".");
		String suffix = originFileName.substring(lastSplit + 1);
		// 获取图片原始信息
		String dOriginFileName = multipartFile.getOriginalFilename();
		String dContentType = multipartFile.getContentType();
		// 是图片且不是gif才加水印
		if (!suffix.equalsIgnoreCase("gif") && dContentType.contains("image")) {
			// 获取水印图片
			InputStream inputImg = multipartFile.getInputStream();
			Image img =  ImageIO.read(inputImg);
			URL url = new URL(markImg);
			// 创建url连接;
			HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
			urlconn.connect();
			InputStream inputStream = urlconn.getInputStream();
			Image mark = ImageIO.read(inputStream);
 
			// 加图片水印
			int imgWidth = img.getWidth(null);
			int imgHeight = img.getHeight(null);
 
			int markWidth = mark.getWidth(null);
			int markHeight = mark.getHeight(null);
 
			BufferedImage bufImg = new BufferedImage(imgWidth, imgHeight,
					BufferedImage.TYPE_INT_RGB);
			//水印的相对位置  ps：这里是右下角  水印宽为底片的四分之一  位置自己可以调整
			markPic(bufImg, img, mark, imgWidth / 4, (imgWidth * markHeight) / (4 * markWidth),
					imgWidth - imgWidth / 4, imgHeight - (imgWidth * markHeight) / (4 * markWidth));

			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ImageOutputStream imOut = ImageIO.createImageOutputStream(bs);
			ImageIO.write(bufImg, suffix, imOut);
			InputStream is = new ByteArrayInputStream(bs.toByteArray());
 
			// 加水印后的文件上传
			multipartFile = new MockMultipartFile(dOriginFileName, dOriginFileName, dContentType,is);
			System.out.println(url+"7");
		}
		//返回加了水印的上传对象
		return multipartFile;
	}
	
}
