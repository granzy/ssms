package base.annotation;


import utils.Constants;

import java.lang.annotation.*;

/**
 * \* User: gzy
 * \* Date: 2017/1/16
 * \* Time: 15:22
 * \* Description:
 * \
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
    String value() default Constants.CURRENT_USER;
}
