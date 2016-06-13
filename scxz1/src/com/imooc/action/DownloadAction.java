package com.imooc.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2099730426326854494L;
	// 文件路径和文件名
	public String inputPath;
	public String filename;

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	// 获取下载文件名 downloadFileName
	public String getDownloadFileName() {
		String filename = "download.jpg";
		try {
			// url 转码输出中文
			filename = URLEncoder.encode("下载文件.jpg", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filename;
	}

	// 获取输出流
	public InputStream getInputStream() throws IOException {
		// 文件夹绝对路径和 返回数据流
		String path = ServletActionContext.getServletContext().getRealPath(
				"/images");
		String filePath = path + "/" + filename;
		return FileUtils.openInputStream(new File(filePath));
	}
}
