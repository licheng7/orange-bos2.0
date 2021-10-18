/**
 * ClassName: GroovyProxyObjLoader
 * Description:
 * date: 2021/10/15 1:53 上午
 *
 * @author licheng
 */
package groovy;

import groovy.entity.GroovyInfo;
import groovy.lang.GroovyObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class GroovyProxyObjLoader {

    final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    final HashMap<Long, Object> groovyProxyObjCache = new HashMap<>();
    static GroovyProxyObjLoader groovyProxyObjLoader = new GroovyProxyObjLoader();

    private GroovyProxyObjLoader() {
    }

    public static GroovyProxyObjLoader getInstance() {
        return groovyProxyObjLoader;
    }

    public <T> T loadProxyObjById(long id, Class<T> interf) {
        Object proxy;
        readWriteLock.readLock().lock();
        proxy = groovyProxyObjCache.get(id);
        readWriteLock.readLock().unlock();
        if(ObjectUtils.isEmpty(proxy)) {
            readWriteLock.writeLock().lock();
            proxy = this.createProxy(id, interf);
            groovyProxyObjCache.put(id, proxy);
            readWriteLock.writeLock().unlock();
        }
        return (T) proxy;
    }

    private <T> T createProxy(long id, Class<T> interf) {
        InvocationHandler handler = new GroovyProxyHandler(id);
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{interf}, handler);
    }
}
