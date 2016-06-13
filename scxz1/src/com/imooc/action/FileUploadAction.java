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
	// �ļ��б� ����ļ� �ͱ�ǩ����ͬ getset ����
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

	// �ļ����� �ļ���
	private List<String> uploadContentType;
	private List<String> uploadFileName;
//�������� set get ǰ�˿���ֱ��el���ʽ��ȡ
	private String result;

	@Override
	public String execute() throws Exception {
		// ��ȡimages�ļ��е� ��ʵ·��
		String path = ServletActionContext.getServletContext().getRealPath(
				"/images");
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		// �����ļ��б� �����ļ�
		for (int i = 0; i < upload.size(); i++) {
			FileUtils.copyFile(upload.get(i),
					new File(file, uploadFileName.get(i)));
		}
		result = "�ϴ��ɹ���";
		return SUCCESS;
	}
}
