package com.godaiyun.upupup.pattern.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyProxy {

  public static Object newProxyInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvokeHandler h) {

    try {
      // 动态生成java代码
      String str = generateStr(interfaces);

      // java文件输出到磁盘
      String filePath = MyProxy.class.getResource("").getPath();

      System.out.println(filePath);
      File file = new File(filePath + "$Proxy0.java");

      FileWriter fw = new FileWriter(file);
      fw.write(str);
      fw.flush();
      fw.close();

      // 编译生成的Java class文件
      JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
      StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);

      Iterable interable = manager.getJavaFileObjects(file);

      JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, interable);
      task.call();
      manager.close();

      // jvm加载calss文件
      Class proxy = classLoader.findClass("$Proxy0");
      Constructor s = proxy.getConstructor(MyInvokeHandler.class);
      file.delete();

      //返回java对象
      return s.newInstance(h);

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;

  }

  private static String generateStr(Class<?>[] interfaces) {
    StringBuffer sb = new StringBuffer();

    sb.append("package com.godaiyun.learn.pattern.proxy;" + "\r\n");

    sb.append("import com.godaiyun.learn.pattern.proxy.Person;" + "\r\n");
    sb.append("import java.lang.reflect.Method;" + "\r\n");

    sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + "\r\n");
    sb.append("MyInvokeHandler h;" + "\r\n");

    sb.append("public $Proxy0(MyInvokeHandler h) {" + "\r\n");
    sb.append("this.h = h;" + "\r\n");
    sb.append("}" + "\r\n");

    for (Method m : interfaces[0].getMethods()) {

      sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "()" + " {" + "\r\n");
      sb.append("try {" + "\r\n");
      sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + "\r\n");
      sb.append("this.h.invoke(this,m,null);" + "\r\n");
      sb.append("} catch(Throwable e) {" + "\r\n");
      sb.append("e.printStackTrace();" + "\r\n");
      sb.append("}" + "\r\n");
      sb.append("}" + "\r\n");
    }

    sb.append("}" + "\r\n");
    return sb.toString();
  }
}
