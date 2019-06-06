package org.junhi.servlet;

import org.junhi.domain.City;
import org.junhi.service.CityService;
import org.junhi.service.impl.CityServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/6/6 11:23
 */
@WebServlet("/city/*")
public class CityServlet extends BaseServlet {

    /**
     * 获取所有的城市列表
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     */
    public void getCityList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        CityService cityService = new CityServiceImpl();
        List<City> cityList = cityService.getCityList();
        writeValue(cityList, response);
    }

}
