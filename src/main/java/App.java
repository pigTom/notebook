import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

/**
 * @Description
 * @Author tangDunhong@163.com
 * @Date Created in 2018/9/12 10:19
 */
public class App {
    public static void main(String[] args) {
        A<Integer, Long> a = new A<>(4, 9L);
//        Object x = a;
        if (a instanceof Comparable) {
            Class<?> c;
            Type[] ts, as = null;
            Type t;
            ParameterizedType p;
            if ((c = a.getClass()) == String.class) // bypass checks
                System.out.println(c);
            if ((ts = c.getGenericInterfaces()) != null) {
                for (int i = 0; i < ts.length; ++i) {
                    if (((t = ts[i]) instanceof ParameterizedType) &&
                            ((p = (ParameterizedType) t).getRawType() ==
                                    Comparable.class) &&
                            (as = p.getActualTypeArguments()) != null// p generic interface
                            &&  as.length == 1 &&
                            as[0] == c ) // type arg is c
                        System.out.println(as.length);
                    System.out.println(c);
                    System.out.println();
                }
            }
        }
    }
}

class A<K, V> extends B implements Comparable<A<K, V>>, I<Integer, Long>, I1 {
    K key;
    V value;

    public A(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void print(Integer o, Long o2) {

    }

    @Override
    public void print(Object o) {

    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(A<K, V> o) {
        return 0;
    }
}

class B {
    @Override
    public String toString() {
        Class<?> clazz;
        return (clazz = this.getClass()).getName() + "@" + clazz.getTypeName();
    }
}

interface I<C, D> extends I1 {
    void print(C c, D d);
}

interface I1<B> {
    void print(B b);
}
