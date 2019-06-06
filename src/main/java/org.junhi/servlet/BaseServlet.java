package org.junhi.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author junhi
 * @Date 2019/6/3 12:27
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 完成方法的分发
        //1、获取请求的路径
        String uri = req.getRequestURI();
        // 2、获取方法的名称
        String methodName = uri.substring(uri.lastIndexOf("/") + 1);

        //将全路径设置到request域中，方便以后转发的调用
        String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/";
        req.setAttribute("basePath", basePath);

        //3.获取方法的对象
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            // 4、执行方法
            method.invoke(this, req, resp);


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 直接将传入的对象序列化为json数据，并写会客户端
     * @param obj
     * @param response
     */
    public void writeValue(Object obj, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf8");
        mapper.writeValue(response.getOutputStream(), obj);
    }

    /**
     * 将传入的对象序列化，并返回
     * @param obj
     */
    public String writeValueAsString(Object obj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
}
