/**
 * ClassName: GroovyProxyObjLoader
 * Description:
 * date: 2021/10/15 1:53 上午
 *
 * @author licheng
 */
package groovy;

import groovy.lang.GroovyObject;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class GroovyProxyObjLoader {

    final HashMap<Long, GroovyObject> groovyProxyCache = new HashMap<>();
    final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    final HashMap<Long, Object> groovyProxyObjCache = new HashMap<>();

    public <T> void loadProxyObjById(long id, Class<T> t) {
        T proxy = this.createProxy(id, t);
    }

    private <T> T createProxy(long id, Class<T> t) {
        InvocationHandler handler = new GroovyProxyHandler(id);
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{t}, handler);
    }
}
