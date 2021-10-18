package event_bus.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/10/15
 * Time:下午8:09
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TestEvent1 {

    private String eventName;


}
