/**
 * ClassName: BosComponentReporter
 * Description:
 * date: 2021/10/17 12:39 上午
 *
 * @author licheng
 */
package org.orange.bos.client.report;

import org.apache.dubbo.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BosComponentReporter {

    @Autowired
    private ApplicationConfig applicationConfig;

    @Async
    public void report(List<BosComponentReportData> reportDataList) {

    }
}
