/**
 * ClassName: GroovyProxyHandler
 * Description:
 * date: 2021/10/15 1:34 上午
 *
 * @author licheng
 */
package groovy;

import groovy.lang.GroovyObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GroovyProxyHandler implements InvocationHandler {

    private long id;

    public GroovyProxyHandler(long id) {
        this.id = id;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return GroovyExecutor.getInstance().execute(id, method, args);
    }
}
