package daiyun.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafeTool = (Unsafe) field.get(null);

        UnsafeObject unsafeObject = (UnsafeObject) unsafeTool.allocateInstance(UnsafeObject.class);

        unsafeObject.setName("34534");
        System.out.println(unsafeObject.getName());
        System.out.println(unsafeObject);


        UnsafeObject object1 = new UnsafeObject();
        Field field1 = UnsafeObject.class.getDeclaredField("name");

        object1.setName("123");


        unsafeTool.putObject(object1, unsafeTool.objectFieldOffset(field1), "345");

        System.out.println(object1.getName());

    }

    public static class UnsafeObject {
        private String name = "";

        public UnsafeObject() {
            name = "2";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
