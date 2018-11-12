package com.ltf.interceptors;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class ErrorInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
/*        String mapJson ="";
        if(response.getStatus()==500){
            JsonData jsonData = JsonData.fail("服务器500错误");
             mapJson = JSON.toJSONString(jsonData.toMap());
            Tools.showJson(request,response,mapJson);
        }else if(response.getStatus()==404){
            JsonData jsonData = JsonData.fail("404找不到页面错误");
            mapJson = JSON.toJSONString(jsonData.toMap());
            System.out.println(mapJson);
            JSONObject result = JSONObject.parseObject(mapJson);
            String data = result.toJSONString();
            System.out.println(data);
            Tools.showJson(request,response,data);
        }*/
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
