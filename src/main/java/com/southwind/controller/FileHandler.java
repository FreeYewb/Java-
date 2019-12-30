package com.southwind.controller;


import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/file")
public class FileHandler {

	@PostMapping("/upload")	
	public String upload(MultipartFile img,HttpServletRequest request) {
		System.out.println(img);
		if (img.getSize()>0) {
			//获取地址，并在地址上加file文件路径
			String path = request.getServletContext().getRealPath("file");
			System.out.println(path);
			//获取上传的文件名
			String name = img.getOriginalFilename();
			System.out.println(name);
			File file = new File(path,name);
		try {
			img.transferTo(file);
			//保存上传之后的文件路径
			request.setAttribute("path","/file/"+name);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		return "upload";
		
	}
	
	@PostMapping("/uploads")
	public String uploads(MultipartFile[] imgs,HttpServletRequest request) {
		List<String> files = new ArrayList<>();
		for(MultipartFile img: imgs) {
			if(img.getSize()>0) {
				String path = request.getServletContext().getRealPath("file");
				String name = img.getOriginalFilename();
				File file = new File(path,name);
				
				try {
					img.transferTo(file);
					files.add("/file/"+name);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		request.setAttribute("files", files);
		
		return "uploads";
		
	}
	
	@GetMapping("/download/{name}")
	public void download(@PathVariable("name")String name,HttpServletRequest request,HttpServletResponse response) {
		if(name != null) {
			name += ".jpg";
			String path = request.getServletContext().getRealPath("file");
			File file = new File(path,name);
			OutputStream outputStream = null;
			//判断文件是否存在
			if(file.exists()) {
				//下载前需要设置的一些配置
				response.setContentType("application/forc-download");
				//设置下载后的文件名
				response.setHeader("Content-Disposition","attachment;filename="+name);
				
				try {
					outputStream = response.getOutputStream();
					//把文件变成数组
					outputStream.write(FileUtils.readFileToByteArray(file));
					outputStream.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
						if (outputStream != null) {
							try {
								outputStream.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
				}
				
			}
		}
	}
	
//	/**
//	 * 使用 httpServletRequest作为参数
//	 * @param  httpServletRequest
//	 * @return
//	 */
//	@PostMapping("/upload")
//	@ResponseBody
//	public Map<String, Object> upload(HttpServletRequest httpServletRequest){
//	    boolean flag = false;
//	    MultipartHttpServletRequest multipartHttpServletRequest = null;
//	    //强制转换为MultipartHttpServletRequest接口对象 (它包含所有HttpServletRequest的方法)
//	    if(httpServletRequest instanceof MultipartHttpServletRequest){
//	        multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
//	    }else{
//	        return dealResultMap(false, "上传失败");
//	    }
//	    //获取MultipartFile文件信息(注意参数为前端对应的参数名称)
//	    MultipartFile mf = multipartHttpServletRequest.getFile("file");
//	    //获取源文件名称
//	    String fileName = mf.getOriginalFilename();
//	    //存储路径可在配置文件中指定
//	    File pfile = new File("D:/fileupload1/");
//	    if (!pfile.exists()) {
//	        pfile.mkdirs();
//	    }
//	    File file = new File(pfile,  fileName);
//	   /* //指定好存储路径
//	    File file = new File(fileName);*/
//	    try {
//	        //保存文件
//	        //使用此方法保存必须要绝对路径且文件夹必须已存在,否则报错
//	        mf.transferTo(file);
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        return dealResultMap(false, "上传失败");
//	    }
//	    return dealResultMap(true, "上传成功");
//	}
//
//
//	/**
//	 * 使用Spring MVC的multipartFile 类作为参数
//	 *
//	 * @param multipartFile
//	 * @return
//	 */
//	@PostMapping("/upload/MultipartFile")
//	@ResponseBody
//	public Map<String, Object> uploadMultipartFile(@RequestParam("file") MultipartFile multipartFile){
//	    String fileName = multipartFile.getOriginalFilename();
//	    try {
//	        //获取文件字节数组
//	        byte [] bytes = multipartFile.getBytes();
//	        //文件存储路径(/fileupload1/ 这样会在根目录下创建问价夹)
//	        File pfile = new File("/fileupload1/");
//	        //判断文件夹是否存在
//	        if(!pfile.exists()){
//	            //不存在时,创建文件夹
//	            pfile.mkdirs();
//	        }
//	        //创建文件
//	        File file = new File(pfile, fileName);
//	        //写入指定文件夹
//	        OutputStream out = new FileOutputStream(file);
//	        out.write(bytes);
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        return dealResultMap(false, "上传失败");
//	    }
//
//	    /*//如果配置文件指定目录,就可以直接这样写(不指定路径的,就需要自己填充保存路径)
//	    File file = new File(fileName);
//	    try {
//	        //使用此方法保存必须要绝对路径且文件夹必须已存在,否则报错
//	        multipartFile.transferTo(file);
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        return dealResultMap(false, "上传失败");
//	    }*/
//	    return dealResultMap(true, "上传成功");
//	}
//
//
//	@PostMapping("/upload/part")
//	@ResponseBody
//	public Map<String, Object> uploadPart(@RequestParam("file") Part part){
//	    System.out.println(part.getSubmittedFileName());
//	    System.out.println(part.getName());
//	    //输入流
//	    InputStream inputStream = null;
//	    try {
//	        inputStream = part.getInputStream();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        return dealResultMap(false, "上传失败");
//	    }
//	    //保存到临时文件
//	    //1K的数据缓冲流
//	    byte[] bytes = new byte[1024];
//	    //读取到的数据长度
//	    int len;
//	    //输出的文件保存到本地文件
//	    File pfile = new File("/fileupload1/");
//	    if (!pfile.exists()) {
//	        pfile.mkdirs();
//	    }
//	    File file = new File(pfile, part.getSubmittedFileName());
//	    OutputStream out;
//	    try {
//	        out = new FileOutputStream(file);
//	        //开始读取
//	        while ((len = inputStream.read(bytes)) != -1){
//	            out.write(bytes, 0, len);
//	        }
//	    } catch (FileNotFoundException e) {
//	        e.printStackTrace();
//	        return dealResultMap(false, "上传失败");
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        return dealResultMap(false, "上传失败");
//	    }
//
//	    /*//配置文件配置的有默认上传路径
//	    //获取提交文件的名字
//	    String fileName = part.getSubmittedFileName();
//	    try {
//	        //使用此方法保存必须要绝对路径且文件夹必须已存在,否则报错
//	        part.write(fileName);
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        return dealResultMap(false, "上传失败");
//	    }*/
//	    return dealResultMap(true, "上传成功");
//	}
//	
	
	
}
