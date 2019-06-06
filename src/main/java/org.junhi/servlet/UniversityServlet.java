package org.junhi.servlet;

import org.junhi.domain.University;
import org.junhi.service.UniversityService;
import org.junhi.service.impl.UniversityServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/6/6 13:33
 */
@WebServlet("/university/*")
public class UniversityServlet extends BaseServlet {

    /**
     * 获取跟城市对应的所有的大学list数组，返回给客户端
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    public void getUniversityByCityName(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String cName = request.getParameter("cName");
        UniversityService universityService = new UniversityServiceImpl();
        List<University> universityList = universityService.getUniversityByCityName(cName);

        writeValue(universityList, response);
    }

}
