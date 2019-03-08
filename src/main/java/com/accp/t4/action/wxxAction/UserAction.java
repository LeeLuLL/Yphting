package com.accp.t4.action.wxxAction;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import com.accp.t4.entity.wxxEntity.User;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c/wxx/")
@SuppressWarnings("all")
public class UserAction{
	private File pic;   //(在此省略 get 和 set 方法)
	private String picFileName; //（省略get和set方法， 该属性Struts2会自动赋值为上传文件的文件名）
	
	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	public OperateImage getImage() {
		return image;
	}

	public void setImage(OperateImage image) {
		this.image = image;
	}

	@PostMapping("uploadPic")
	public String uploadPic(HttpSession session) {
		String[] str = { ".jpg", ".jpeg", ".bmp", ".gif", ".png" };
		// 获取用户登录名
		User curruser = (User) session.getAttribute("USER");
		// 限定文件大小是4MB
		if (pic == null || pic.length() > 4194304) {
			//文件过大
			return "error";
		}
		for (String s : str) {
			if (picFileName.endsWith(s)) {
				String realPath = session.getServletContext().getRealPath("/uploadpic");// 在tomcat中保存图片的实际路径  ==  "webRoot/uploadpic/"
				File saveFile = new File(new File(realPath), "新文件名.jpg"); // 在该实际路径下实例化一个文件
				// 判断父目录是否存在
				if (!saveFile.getParentFile().exists()) {
					saveFile.getParentFile().mkdirs();
				}
				try {
					// 执行文件上传
					// FileUtils 类名 org.apache.commons.io.FileUtils;
					// 是commons-io包中的，commons-fileupload 必须依赖
					// commons-io包实现文件上次，实际上就是将一个文件转换成流文件进行读写
					FileUtils.copyFile(pic, saveFile);
				} catch (IOException e) {
					return "imageError";
				}
			}
		}
		return "success";
	}
	
	private OperateImage image;
	
	/**
	 * 裁剪头像
	 */
	@PostMapping("cutPic")
	@ResponseBody
	public Map<String, Object> cutPic(HttpSession session,int x,int y,int width,int height,String imgName,String imgType){
		Map<String, Object> res = new HashMap<String,Object>();
		
		String imgUrl = (String)session.getAttribute("imgUrl");
		
		String name = "E:\\Y2\\Yphting\\src\\main\\resources\\static\\"+imgUrl;
		String newFileName = UUID.randomUUID().toString().replaceAll("-","");
		String names = "E:\\Y2\\Yphting\\src\\main\\resources\\static\\Uploads\\image\\cutImg\\"+newFileName+".png";
		try {
			image = new OperateImage(name, names, x, y, width, height, imgType);
			
			image.cut(); //执行裁剪操作  执行完后即可生成目标图在对应文件夹内。
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String url = "/static/Uploads/cutImg/"+newFileName+".png";
		
		res.put("status", 1);
		res.put("url", url.toString());
		res.put("w", width);
		res.put("h", height);
		res.put("msg", "ok");
		
		return res;
	}
}