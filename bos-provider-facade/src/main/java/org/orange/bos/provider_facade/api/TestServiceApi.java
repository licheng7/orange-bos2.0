/**
 * ClassName: TestServiceApi
 * Description:
 * date: 2021/10/17 9:49 下午
 *
 * @author licheng
 */
package org.orange.bos.provider_facade.api;

import org.orange.bos.provider_facade.request.TestRequest;
import org.orange.bos.provider_facade.response.TestResponse;

public interface TestServiceApi {

    public TestResponse testMethod1(TestRequest request);
}
