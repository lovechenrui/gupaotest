package com.chenrui.pattern.delegate.mvc;

import com.chenrui.pattern.delegate.mvc.controller.MemberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ServletDispatcher {

    List<Handler> handdingMapping = new ArrayList<Handler>();

    public ServletDispatcher() {
        Class<?> memberActionClass = MemberAction.class;
        try{
            this.handdingMapping.add(new Handler().
                    setController(memberActionClass.newInstance())
                    .setMethod(memberActionClass.getMethod("getMemberByid",new Class[]{String.class}))
                    .setUrl("/web/getMemberByid.jsp"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void doService(HttpServletRequest request, HttpServletResponse response){
        doDispatch(request,response);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response){
        //1、获取用户请求的url，每个url对应一个servlet
        //2、根据url找到对应的java类处理
        //3、通过url，拿到对应的handdingmapping
        //4、讲具体的业务分发给对应的method
        String uri = request.getRequestURI();
        Handler handler = null;
        for(Handler h:handdingMapping){
            if(uri.equals(h.getUrl())){
                handler = h;
                break;
            }
        }
        Object obj = null;
        try {
            obj = handler.method.invoke(handler.getController(),request.getParameter("memberid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            response.getWriter().write((String) obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
