/**
 * ClassName: BosComponentReportData
 * Description:
 * date: 2021/10/16 10:18 下午
 *
 * @author licheng
 */
package org.orange.bos.client.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BosComponentReportData implements Serializable {

    private String serviceName;

    private String interfaceName;

    private String desc;

    private String group;

    private String version;

    private Map<String, Class<?>> params;

    private Class<?> returnType;
}
