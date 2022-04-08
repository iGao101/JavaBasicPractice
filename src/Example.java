import java.lang.reflect.InvocationTargetException;

public class Example {
    public Example() {
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Example e = new Example();
        Class c = e.getClass();
        Object object = c.getConstructor().newInstance();
        System.out.println(object instanceof Example);

        double videoDuration = 2.58989590293459828903;
        String durationStr = String.format("%.2f", videoDuration);
        System.out.println(durationStr);
    }
}
