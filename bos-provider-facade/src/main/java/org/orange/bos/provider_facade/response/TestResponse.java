/**
 * ClassName: TestResponse
 * Description:
 * date: 2021/10/17 9:51 下午
 *
 * @author licheng
 */
package org.orange.bos.provider_facade.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TestResponse implements Serializable {

    private static final long serialVersionUID = -4814819639596806806L;

    private String name;

    private String value;
}
