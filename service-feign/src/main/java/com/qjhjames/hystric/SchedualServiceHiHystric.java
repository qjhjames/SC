package com.qjhjames.hystric;

import com.qjhjames.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2017/11/20.
 */
@Component
public class SchedualServiceHiHystric  implements SchedualServiceHi{
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
