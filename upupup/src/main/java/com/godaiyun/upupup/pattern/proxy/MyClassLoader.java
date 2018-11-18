package com.godaiyun.upupup.pattern.proxy;

import java.io.*;

public class MyClassLoader extends ClassLoader {

  private File classFilePath;

  public MyClassLoader() {

    String baseClassPath = MyClassLoader.class.getResource("").getPath();

    this.classFilePath = new File(baseClassPath);
  }

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {

    String className = MyClassLoader.class.getPackage().getName() + "." + name;

    if (classFilePath != null) {
      File classFile = new File(classFilePath, name.replaceAll("\\.", "/") + ".class");

      if (classFile.exists()) {

        FileInputStream input = null;
        ByteArrayOutputStream out = null;

        try {
          input = new FileInputStream(classFile);
          out = new ByteArrayOutputStream();

          byte[] bytes = new byte[1024];
          int length;
          while ((length = input.read(bytes)) != -1) {

            out.write(bytes, 0, length);
          }

          return defineClass(className, out.toByteArray(), 0, out.size());
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          if (input != null) {
            try {
              input.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }

          if (out != null) {
            try {
              out.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }


      }
    }
    return null;
  }
}
