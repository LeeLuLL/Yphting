package com.accp.t4.action.wxxAction;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.accp.t4.biz.wxxBiz.FaBuBiz;
import com.accp.t4.biz.wxxBiz.RuZhuBiz;
import com.accp.t4.entity.wxxEntity.ServiceType;
import com.accp.t4.entity.wxxEntity.Services;
import com.accp.t4.entity.wxxEntity.Sharea;
import com.accp.t4.entity.wxxEntity.User;
import com.accp.t4.util.file.Upload;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/c/wxx/fabu")
@SuppressWarnings("all")
public class FaBuServlet {
	@Autowired
	private RuZhuBiz rbiz;

	@Autowired
	private FaBuBiz fbiz;

	// 查询服务类别
	@GetMapping("selServiceType")
	@ResponseBody
	public List<ServiceType> selectServiceType(String stPid) {
		List<ServiceType> sers = rbiz.selectServiceType(stPid);
		return sers;
	}

	// 发布服务
	@PostMapping("addServices")
	public String addServiceszjy(HttpSession session, Model model, Services services, MultipartFile serviceCoverImg,
			MultipartFile serviceImgUrlOne, MultipartFile serviceImgUrlTwo, MultipartFile serviceImgUrlThree,
			MultipartFile serviceImgUrlFour, MultipartFile uploadDataUrl, String[] areaids, String[] serviceCostInclude,
			String serviceStartDate, String serviceEndDate, String sel_time_begin) {
		Integer userID = 25;
		// Integer userID=((User)session.getAttribute("USER")).getUserid();

		try {
			if (serviceCoverImg != null && !serviceCoverImg.isEmpty()) {
				String fmturl = Upload.uploadFile(serviceCoverImg);
				services.setServicecoverimg(fmturl);
			}
			if (serviceCoverImg != null && !serviceImgUrlOne.isEmpty()) {
				String xjturl1 = Upload.uploadFile(serviceImgUrlOne);
				services.setServiceimgurlone(xjturl1);
			}
			if (serviceCoverImg != null && !serviceImgUrlTwo.isEmpty()) {
				String xjturl2 = Upload.uploadFile(serviceImgUrlTwo);
				services.setServiceimgurltwo(xjturl2);
			}
			if (serviceCoverImg != null && !serviceImgUrlThree.isEmpty()) {
				String xjturl3 = Upload.uploadFile(serviceImgUrlThree);
				services.setServiceimgurlthree(xjturl3);
			}
			if (serviceCoverImg != null && !serviceImgUrlFour.isEmpty()) {
				String xjturl4 = Upload.uploadFile(serviceImgUrlFour);
				services.setServiceimgurlfour(xjturl4);
			}
			if (uploadDataUrl != null && !uploadDataUrl.isEmpty()) {
				String uploaddataurl = Upload.uploadFile(uploadDataUrl);
				services.setUploaddataurl(uploaddataurl);
			}
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String cs = "";
		if (areaids != null && areaids.length != 0) {
			for (String i : areaids) {
				cs += i + ",";
			}
		}
		String baohao = "";
		if (serviceCostInclude != null && serviceCostInclude.length != 0) {
			for (String val : serviceCostInclude) {
				baohao += val + ",";
			}
		}
		
		Date servicestartdate = null;
		Date serviceenddate = null;

		if (sel_time_begin != null && sel_time_begin != "") {
			String[] datas = { serviceStartDate, serviceEndDate };
			
			datas = sel_time_begin.split(" 至 ");

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
			try {
				servicestartdate = dateFormat.parse(datas[0]);
				serviceenddate = dateFormat.parse(datas[1]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		services.setUserid(userID);
		services.setServicecity(cs);
		services.setServicestartdate(servicestartdate);
		services.setServiceenddate(serviceenddate);
		services.setServicecostinclude(baohao);
		System.out.println(services);
		fbiz.addService(services);
		return "redirect:/view/sjzx-wzxfbfw";
	}
}
