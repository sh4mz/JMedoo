package cn.iliubang.jmedoo.parser;


import cn.iliubang.jmedoo.exception.SqlParseException;

import java.util.List;
import java.util.Map;

/**
 * {Insert class description here}
 *
 * @author <a href="mailto:it.liubang@gmail.com">liubang</a>
 * @version $Revision: {Version} $ $Date: 2018/5/29 20:50 $
 * @see
 */
public class LimitParser implements ParserInterface {
    public String parse(Map<String, Object> objectMap, List<Object> lists, Object... objects) throws SqlParseException {
        if (null == objectMap || objectMap.isEmpty()) {
            return "";
        }

        @SuppressWarnings("unchecked")
        List<Integer> listLimit = (List<Integer>) objectMap.get("limit");

        if (null == listLimit || listLimit.isEmpty()) {
            return "";
        }

        int s = listLimit.size();

        if (s > 2) {
            throw new SqlParseException("Sql parsing error.");
        }

        if (s == 1) {
            return "LIMIT " + listLimit.get(0);
        } else {
            return "LIMIT " + listLimit.get(0) + ", " + listLimit.get(1);
        }
    }
}
