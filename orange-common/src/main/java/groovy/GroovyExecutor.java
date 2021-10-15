package groovy;

import groovy.entity.GroovyInfo;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/10/14
 * Time:下午5:44
 **/
@Slf4j
public class GroovyExecutor {

    static GroovyExecutor groovyExecutor = new GroovyExecutor();

    private GroovyExecutor() {
    }

    public static GroovyExecutor getInstance() {
        return groovyExecutor;
    }

    public Object execute(long id, Method method, Object param) {
        return GroovyInfoLoader.getInstance().loadGroovyObjById(id).invokeMethod(method.getName(), param);
    }

    public Object execute(long id, Method method) {
        return this.execute(id, method, null);
    }
}
