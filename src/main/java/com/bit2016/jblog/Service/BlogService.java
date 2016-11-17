package com.bit2016.jblog.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

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
	public static final String BASE_URL = "/gallery/assets/";

	@Autowired
	private BlogDao blogDao;
	@Autowired
	private UserDao userDao;

	@Autowired
	private CategoryDao categoryDao;

	public List<CategoryVo> getList(String userId) {
		return categoryDao.getList(userId);
	}

	public boolean getByNo(String id) {
		return (userDao.getByNo(id) != null);
	}

	public void restore( BlogVo blogVo, MultipartFile multipartFile )
	{
		
		
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
