package com.hrm.config;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    String[] ig_uri = {"/", "/index.jsp", "loginForm.jsp", "login", ".css", ".js", ".jpg"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        //获取本次请求的uri
//        String uri = ((HttpServletRequest) request).getRequestURI();
//        for (String s : ig_uri) {
//            if (uri.endsWith(s)) {
//                //直接放行
//                chain.doFilter(httpServletRequest, httpServletResponse);
//                return;
//            }
//        }
//        if (httpServletRequest.getSession().getAttribute("user") != null) {
//            chain.doFilter(httpServletRequest, httpServletResponse);
//            return;
//        }else{
//            httpServletRequest.setAttribute("message","你还未登录，请登录");
//            httpServletRequest.getRequestDispatcher("/index.jsp").forward(httpServletRequest,httpServletResponse);
//        }
//

    }
}
