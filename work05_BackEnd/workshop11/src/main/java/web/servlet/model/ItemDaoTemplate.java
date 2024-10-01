package web.servlet.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDaoTemplate {
	//
	ArrayList<Item> getAllItem() throws SQLException;
	Item getItem(int itemid) throws SQLException;
	
	boolean updateRecordCount(int itemid) throws SQLException;
}
