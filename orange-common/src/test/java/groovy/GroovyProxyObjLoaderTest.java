package groovy;

import groovy.interfaces.GroovyTest1Interf;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/10/15
 * Time:下午2:39
 **/
class GroovyProxyObjLoaderTest {

    @Test
    public void loadGroovyProxy() {
        GroovyTest1Interf proxy = GroovyProxyObjLoader.getInstance().loadProxyObjById(1L,
                GroovyTest1Interf.class);
        Assert.assertEquals(proxy.testMethod1("p"), "thanks orange");
    }
}