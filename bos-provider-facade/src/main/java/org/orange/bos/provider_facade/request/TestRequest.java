/**
 * ClassName: TestRequest
 * Description:
 * date: 2021/10/17 9:51 下午
 *
 * @author licheng
 */
package org.orange.bos.provider_facade.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TestRequest implements Serializable {

    private static final long serialVersionUID = -5467586703619959660L;

    private long testId;

    private String testName;
}
