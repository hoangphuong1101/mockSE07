package model.bo;

import java.util.ArrayList;

import model.bean.Category;
import model.bean.Thread;
import model.dao.ThreadDAO;

public class ThreadBO {
	ThreadDAO threadDAO = new ThreadDAO();

	public ArrayList<Thread> getList() {
		return threadDAO.getList();
	}

	public ArrayList<Thread> getListMostView() {
		return threadDAO.getListMostView();
	}

	public ArrayList<Thread> getListByCategory(Category category) {
		return threadDAO.getListByCategory(category);
	}

	public ArrayList<Thread> searchBy(Thread thread) {
		return threadDAO.searchBy(thread);
	}

	public Thread getById(Thread thread) {
		return threadDAO.getById(thread);
	}

	public ArrayList<Thread> getRelateThreadsByThread(Thread thread) {
		// TODO Auto-generated method stub
		return threadDAO.getRelateThreadsByThread(thread);
	}
}
