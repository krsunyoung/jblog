package com.bit2016.jblog.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.repository.CategoryDao;
import com.bit2016.jblog.repository.UserDao;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.CategoryVo;

@Service
public class BlogService {
	private static final String SAVE_PATH = "/upload";
	public static final String URL = "/gallery/assets/";

	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogDao;

	@Autowired
	private CategoryDao categoryDao;

	public List<CategoryVo> getList(String userId) {
		return categoryDao.getList(userId);
	}
	public void titleUpdate(BlogVo vo,String id ){
		
		String title = vo.getTitle();
		blogDao.titleUpdate(title, id);
		
		 
	}
	public boolean getByNo(String id) {
		return (userDao.getByNo(id) != null);
	}
	
	public BlogVo getID(String id){
		BlogVo blogVo = blogDao.getID(id);
		
		return blogVo;
	}
	
	public void restore( BlogVo blogVo, MultipartFile multipartFile )
	{
		//String url = null;
			try { 
		 		String orgFileName = multipartFile.getOriginalFilename(); 
		 		String fileExtName = orgFileName.substring(orgFileName.lastIndexOf('.')+1, orgFileName.length()); 
		 		String saveFileName = generateSaveFileName(fileExtName); 
		 
		 		writeFile(multipartFile, saveFileName); 
		 		 
		 		blogVo.setLogo(saveFileName);
		 		System.out.println(saveFileName);
		 	
		 		blogDao.imageupdate(blogVo); 
		 		
		 //		url = URL+saveFileName;
		 		 
		 		} catch (IOException ex) { 
		 			throw new RuntimeException(); 
		 		} 
	}

	private void writeFile(MultipartFile multipartFile, String saveFileName) throws IOException {
		byte[] fileData = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(fileData);
		fos.close();
	}

	private String generateSaveFileName(String extName) {
		String fileName = "";
		Calendar calendar = Calendar.getInstance();

		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += ("." + extName);

		return fileName;
	}
}
