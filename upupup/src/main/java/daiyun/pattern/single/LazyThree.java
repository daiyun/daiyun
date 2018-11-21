package daiyun.pattern.single;

public class LazyThree {


  private LazyThree(){

  }

  public static final LazyThree getInstance(){
    return LazyLoad.lazy;
  }

  private static class LazyLoad{
    public static final LazyThree lazy = new LazyThree();
  }
}
