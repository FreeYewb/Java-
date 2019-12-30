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
			//��ȡ��ַ�����ڵ�ַ�ϼ�file�ļ�·��
			String path = request.getServletContext().getRealPath("file");
			System.out.println(path);
			//��ȡ�ϴ����ļ���
			String name = img.getOriginalFilename();
			System.out.println(name);
			File file = new File(path,name);
		try {
			img.transferTo(file);
			//�����ϴ�֮����ļ�·��
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
			//�ж��ļ��Ƿ����
			if(file.exists()) {
				//����ǰ��Ҫ���õ�һЩ����
				response.setContentType("application/forc-download");
				//�������غ���ļ���
				response.setHeader("Content-Disposition","attachment;filename="+name);
				
				try {
					outputStream = response.getOutputStream();
					//���ļ��������
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
//	 * ʹ�� httpServletRequest��Ϊ����
//	 * @param  httpServletRequest
//	 * @return
//	 */
//	@PostMapping("/upload")
//	@ResponseBody
//	public Map<String, Object> upload(HttpServletRequest httpServletRequest){
//	    boolean flag = false;
//	    MultipartHttpServletRequest multipartHttpServletRequest = null;
//	    //ǿ��ת��ΪMultipartHttpServletRequest�ӿڶ��� (����������HttpServletRequest�ķ���)
//	    if(httpServletRequest instanceof MultipartHttpServletRequest){
//	        multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
//	    }else{
//	        return dealResultMap(false, "�ϴ�ʧ��");
//	    }
//	    //��ȡMultipartFile�ļ���Ϣ(ע�����Ϊǰ�˶�Ӧ�Ĳ�������)
//	    MultipartFile mf = multipartHttpServletRequest.getFile("file");
//	    //��ȡԴ�ļ�����
//	    String fileName = mf.getOriginalFilename();
//	    //�洢·�����������ļ���ָ��
//	    File pfile = new File("D:/fileupload1/");
//	    if (!pfile.exists()) {
//	        pfile.mkdirs();
//	    }
//	    File file = new File(pfile,  fileName);
//	   /* //ָ���ô洢·��
//	    File file = new File(fileName);*/
//	    try {
//	        //�����ļ�
//	        //ʹ�ô˷����������Ҫ����·�����ļ��б����Ѵ���,���򱨴�
//	        mf.transferTo(file);
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        return dealResultMap(false, "�ϴ�ʧ��");
//	    }
//	    return dealResultMap(true, "�ϴ��ɹ�");
//	}
//
//
//	/**
//	 * ʹ��Spring MVC��multipartFile ����Ϊ����
//	 *
//	 * @param multipartFile
//	 * @return
//	 */
//	@PostMapping("/upload/MultipartFile")
//	@ResponseBody
//	public Map<String, Object> uploadMultipartFile(@RequestParam("file") MultipartFile multipartFile){
//	    String fileName = multipartFile.getOriginalFilename();
//	    try {
//	        //��ȡ�ļ��ֽ�����
//	        byte [] bytes = multipartFile.getBytes();
//	        //�ļ��洢·��(/fileupload1/ �������ڸ�Ŀ¼�´����ʼۼ�)
//	        File pfile = new File("/fileupload1/");
//	        //�ж��ļ����Ƿ����
//	        if(!pfile.exists()){
//	            //������ʱ,�����ļ���
//	            pfile.mkdirs();
//	        }
//	        //�����ļ�
//	        File file = new File(pfile, fileName);
//	        //д��ָ���ļ���
//	        OutputStream out = new FileOutputStream(file);
//	        out.write(bytes);
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        return dealResultMap(false, "�ϴ�ʧ��");
//	    }
//
//	    /*//��������ļ�ָ��Ŀ¼,�Ϳ���ֱ������д(��ָ��·����,����Ҫ�Լ���䱣��·��)
//	    File file = new File(fileName);
//	    try {
//	        //ʹ�ô˷����������Ҫ����·�����ļ��б����Ѵ���,���򱨴�
//	        multipartFile.transferTo(file);
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        return dealResultMap(false, "�ϴ�ʧ��");
//	    }*/
//	    return dealResultMap(true, "�ϴ��ɹ�");
//	}
//
//
//	@PostMapping("/upload/part")
//	@ResponseBody
//	public Map<String, Object> uploadPart(@RequestParam("file") Part part){
//	    System.out.println(part.getSubmittedFileName());
//	    System.out.println(part.getName());
//	    //������
//	    InputStream inputStream = null;
//	    try {
//	        inputStream = part.getInputStream();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        return dealResultMap(false, "�ϴ�ʧ��");
//	    }
//	    //���浽��ʱ�ļ�
//	    //1K�����ݻ�����
//	    byte[] bytes = new byte[1024];
//	    //��ȡ�������ݳ���
//	    int len;
//	    //������ļ����浽�����ļ�
//	    File pfile = new File("/fileupload1/");
//	    if (!pfile.exists()) {
//	        pfile.mkdirs();
//	    }
//	    File file = new File(pfile, part.getSubmittedFileName());
//	    OutputStream out;
//	    try {
//	        out = new FileOutputStream(file);
//	        //��ʼ��ȡ
//	        while ((len = inputStream.read(bytes)) != -1){
//	            out.write(bytes, 0, len);
//	        }
//	    } catch (FileNotFoundException e) {
//	        e.printStackTrace();
//	        return dealResultMap(false, "�ϴ�ʧ��");
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        return dealResultMap(false, "�ϴ�ʧ��");
//	    }
//
//	    /*//�����ļ����õ���Ĭ���ϴ�·��
//	    //��ȡ�ύ�ļ�������
//	    String fileName = part.getSubmittedFileName();
//	    try {
//	        //ʹ�ô˷����������Ҫ����·�����ļ��б����Ѵ���,���򱨴�
//	        part.write(fileName);
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        return dealResultMap(false, "�ϴ�ʧ��");
//	    }*/
//	    return dealResultMap(true, "�ϴ��ɹ�");
//	}
//	
	
	
}
