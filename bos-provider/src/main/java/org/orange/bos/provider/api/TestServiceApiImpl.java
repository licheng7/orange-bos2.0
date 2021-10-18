/**
 * ClassName: TestServiceApiImpl
 * Description:
 * date: 2021/10/17 10:17 下午
 *
 * @author licheng
 */
package org.orange.bos.provider.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.orange.bos.client.annotation.OrangeBosComponent;
import org.orange.bos.client.annotation.OrangeBosService;
import org.orange.bos.provider_facade.api.TestServiceApi;
import org.orange.bos.provider_facade.request.TestRequest;
import org.orange.bos.provider_facade.response.TestResponse;

@Slf4j
@Service(timeout = 5000, group = "qa", version = "1.0.0")
@OrangeBosService(group = "qa")
public class TestServiceApiImpl implements TestServiceApi {

    @OrangeBosComponent(name = "testMethod1", version = "1.0.0", desc = "一个test接口")
    @Override
    public TestResponse testMethod1(TestRequest request) {
        log.info("testServiceApiImpl.testMethod1被访问");
        return new TestResponse(request.getTestName(), "value-testMethod1");
    }
}
