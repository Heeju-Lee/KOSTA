package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Item;
import web.servlet.model.ItemDao;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index.jsp";
		int itemNumber = Integer.parseInt(request.getParameter("itemNumber"));
		boolean updated = false;

		updated = ItemDao.getInstance().updateRecordCount(itemNumber);
		if (updated) {
			Item rvo = ItemDao.getInstance().getItem(itemNumber);
			request.setAttribute("vo", rvo);
		}
		path = "itemView.jsp";

		return new ModelAndView(path);
	}
}
