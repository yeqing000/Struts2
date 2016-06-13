package com.imooc.action;

import java.io.File;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 文件列表 多个文件 和标签名相同 getset 方法
	private List<File> upload;

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	// 文件类型 文件名
	private List<String> uploadContentType;
	private List<String> uploadFileName;
//设置属性 set get 前端可以直接el表达式获取
	private String result;

	@Override
	public String execute() throws Exception {
		// 获取images文件夹的 真实路径
		String path = ServletActionContext.getServletContext().getRealPath(
				"/images");
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		// 遍历文件列表 复制文件
		for (int i = 0; i < upload.size(); i++) {
			FileUtils.copyFile(upload.get(i),
					new File(file, uploadFileName.get(i)));
		}
		result = "上传成功！";
		return SUCCESS;
	}
}
