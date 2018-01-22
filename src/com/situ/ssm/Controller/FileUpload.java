package com.situ.ssm.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.situ.ssm.entity.Student;

@Controller
@RequestMapping(value="/fileupload")

public class FileUpload {
	@RequestMapping(value="/upload")
    public void upload(String name, MultipartFile pictureFile) {
        System.out.println(name);
        System.out.println(pictureFile.getContentType());//image/png
        System.out.println(pictureFile.getName());//pictureFile
        System.out.println(pictureFile.getOriginalFilename());//无标题.png
        System.out.println(pictureFile.getSize());//
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
           inputStream = pictureFile.getInputStream();
           outputStream = new FileOutputStream(new File("D:/out.png"));
           IOUtils.copy(inputStream, outputStream);
        } catch (IOException e) {
           e.printStackTrace();
        } finally {
           if (outputStream != null) {
               try {
                   outputStream.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (inputStream != null) {
               try {
                   inputStream.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
    }

	@RequestMapping(value="/download")
	public void dowload(HttpServletResponse response) {
	    FileInputStream inputStream = null;
	    try {
	        response.setHeader("Content-Disposition", "attachment;filename=D:/out.png");
	        inputStream = new FileInputStream(new File("D:/out.png"));
	        ServletOutputStream outputStream = response.getOutputStream();
	        IOUtils.copy(inputStream, outputStream);
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	

}
