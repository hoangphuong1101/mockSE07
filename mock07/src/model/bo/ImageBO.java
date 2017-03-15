package model.bo;

import java.util.ArrayList;

import model.bean.Image;
import model.bean.Thread;
import model.dao.ImageDAO;

public class ImageBO {
	ImageDAO imageDAO = new ImageDAO();

	public ArrayList<Image> getListByThread(Thread thread){
		return imageDAO.getListByThread(thread);
	}
	public ArrayList<Image> getList360ByThread(Thread thread){
		return imageDAO.getList360ByThread(thread);
	}

}
