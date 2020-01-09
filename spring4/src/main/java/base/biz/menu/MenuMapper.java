package base.biz.menu;

import java.util.HashMap;
import java.util.List;

public interface MenuMapper {

	public List<HashMap<String, String>> selectMenuList(HashMap<String, String> map) throws Exception;
}
