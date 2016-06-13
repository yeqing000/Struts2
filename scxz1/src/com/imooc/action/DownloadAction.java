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
	// �ļ�·�����ļ���
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

	// ��ȡ�����ļ��� downloadFileName
	public String getDownloadFileName() {
		String filename = "download.jpg";
		try {
			// url ת���������
			filename = URLEncoder.encode("�����ļ�.jpg", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filename;
	}

	// ��ȡ�����
	public InputStream getInputStream() throws IOException {
		// �ļ��о���·���� ����������
		String path = ServletActionContext.getServletContext().getRealPath(
				"/images");
		String filePath = path + "/" + filename;
		return FileUtils.openInputStream(new File(filePath));
	}
}
