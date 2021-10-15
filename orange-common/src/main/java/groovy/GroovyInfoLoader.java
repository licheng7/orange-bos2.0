package groovy;

import groovy.entity.GroovyInfo;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/10/14
 * Time:下午5:07
 **/
@Slf4j
public class GroovyInfoLoader {

    final ClassLoader parent;
    final GroovyClassLoader loader;
    final String BREAK = "-";
    final HashMap<Long, GroovyObject> groovyObjCache = new HashMap<>();
    final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static GroovyInfoLoader groovyInfoLoader = new GroovyInfoLoader();

    private GroovyInfoLoader() {
        parent = this.getClass().getClassLoader();
        loader = new GroovyClassLoader(parent);
    }

    public static GroovyInfoLoader getInstance() {
        return groovyInfoLoader;
    }

    /**
     * 根据id获取groovy对应的java对象
     * @param id
     * @return
     */
    public GroovyObject loadGroovyObjById(long id) {
        readWriteLock.readLock().lock();
        GroovyObject groovyObj = groovyObjCache.get(id);
        readWriteLock.readLock().unlock();
        if(ObjectUtils.isEmpty(groovyObj)) {
            readWriteLock.writeLock().lock();
            GroovyInfo info = new GroovyInfo(id, "groovy脚本1", "", "", 1, System.currentTimeMillis(), System.currentTimeMillis());
            groovyObj = this.createGroovyObj(info);
            groovyObjCache.put(id, groovyObj);
            readWriteLock.writeLock().unlock();
        }
        return groovyObj;
    }

    /**
     * 根据groovy脚本创建java对象
     * @param info
     * @return
     */
    private GroovyObject createGroovyObj(GroovyInfo info) {
        String scriptName = new StringBuilder().append(info.getName()).append(BREAK).append(info.getId()).toString();
        Class groovyClass = loader.parseClass(info.getScriptText(), scriptName);
        try {
            return (GroovyObject) groovyClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("创建id为{"+info.getId()+"}的对象失败", e);
        }
    }
}
