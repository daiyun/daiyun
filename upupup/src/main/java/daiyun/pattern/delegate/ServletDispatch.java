package daiyun.pattern.delegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ServletDispatch {


  private List<Handler> handlerMapping = new ArrayList<Handler>();

  public void doService(HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse) {
    doDispatch(httpServletRequest, httpServletResponse);
  }

  private void doDispatch(HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse) {

  }

  class Handler {
    private Object controller;
    private Method method;
    private String url;

    public Object getController() {
      return controller;
    }

    public void setController(Object controller) {
      this.controller = controller;
    }

    public Method getMethod() {
      return method;
    }

    public void setMethod(Method method) {
      this.method = method;
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }
  }
}
