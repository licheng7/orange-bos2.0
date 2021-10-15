/**
 * ClassName: GroovyProxyObjLoader
 * Description:
 * date: 2021/10/15 1:53 上午
 *
 * @author licheng
 */
package groovy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class GroovyProxyObjLoader {

    public void register(long id, String interfacesStr) {
        Class clazz;
        try {
            clazz = Class.forName(interfacesStr);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("{"+interfacesStr+"}接口不存在");
        }

        this.createProxy(id, clazz);
    }

    private <T> T createProxy(long id, Class<T> t) {
        InvocationHandler handler = new GroovyProxyHandler(id);
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{t}, handler);
    }
}
