import com.sun.deploy.util.StringUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException {
        // 在程序运行期间，java运行时系统始终为所有对象维护一个运行时类型标识

        String name = "java.lang.Double";
        printClassInfo(name);
    }

    /**
     * 输出指定类所有构造器、字段和函数描述
     * @param name 类的完全限定名
     * @throws ClassNotFoundException 根据限定名无法找到
     */
    public static void printClassInfo(String name) throws ClassNotFoundException {
        if (name == null || name.length() == 0) {
            return;
        }

        Class cl = Class.forName(name);
        Class superCl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length() > 0) {
            System.out.println("modifiers " + modifiers);
        }
        System.out.println("class " + name);
        if (superCl != null && superCl != Object.class) {
            System.out.println("extends " + superCl.getName());
        }

        System.out.println();
        printConstructors(cl);

        System.out.println();
        printFields(cl);

        System.out.println();
        printMethods(cl);
    }

    public static void printFields(Class cl) {
        System.out.println("fields: ");
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    public static void printMethods(Class cl) {
        System.out.println("methods: ");
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print("  ");
            String modifies = Modifier.toString(m.getModifiers());
            if (modifies.length() > 0) {
                System.out.print(modifies + " ");
            }
            System.out.print(retType.getName() + " " + name + "(");

            // 参数
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printConstructors(Class cl) {
        System.out.println("constructors: ");
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");

            // params
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }
}
