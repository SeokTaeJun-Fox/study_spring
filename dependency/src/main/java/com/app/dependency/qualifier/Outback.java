package com.app.dependency.qualifier;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
public class Outback implements Restaurant {

    @Override
    public boolean isAvailableSaladBar() {
        return false;
    }
}

//@Component
//@Data
//public class Outback implements Resturant {
//    @Override
//    public boolean isSaladBar() {
//        return false;
//    }
//}
