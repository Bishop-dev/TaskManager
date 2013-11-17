package com.hubachov.web.servlet;

import com.hubachov.form.UserForm;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class RegistrationController extends HttpServlet implements Servlet {
	private static final Logger log = Logger.getLogger(RegistrationController.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletFileUpload uploader = new ServletFileUpload(new DiskFileItemFactory());
		String fileName = "D:\\";
		System.out.println(fileName);
		FileItem fileItem = null;
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while (fileItemsIterator.hasNext()) {
				FileItem item = fileItemsIterator.next();
				if (item.isFormField()) {
					if (item.getFieldName().equals("login")) {
						fileName += item.getString() + ".jpg";
					}
					System.out.println(item.getFieldName() + ":" + item.getString());
				} else {
					fileItem = item;
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			log.error("Can't upload avatar", e);
		} catch (Exception e1) {
			e1.printStackTrace();
			log.error("Can't registrate user", e1);
		}
		System.out.println(fileName);
		if (fileItem != null) {
			try {
				fileItem.write(new File(fileName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private UserForm createUserForm(HttpServletRequest request) {
		UserForm form = new UserForm();

		return null;
	}


}
