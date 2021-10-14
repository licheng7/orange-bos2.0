package groovy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/10/14
 * Time:下午5:28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroovyInfo {

    private long id;

    private String name;

    private String scriptText;

    private String params;

    private int status;

    private long createTime;

    private long lastUpdateTime;
}
