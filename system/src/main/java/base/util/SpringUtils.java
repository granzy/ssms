package base.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * \* User: gzy
 * \* Date: 2017/1/10
 * \* Time: 11:04
 * \* Description:spring容器初始化后置处理
 * 用于获取当前上下文以及注册bean
 * \
 */
public final class SpringUtils implements BeanFactoryPostProcessor {

    private static ConfigurableListableBeanFactory beanFactory; // Spring应用上下文环境

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //TODO:this.beanFactory == SpringUtils.beanFactory的区别
        SpringUtils.beanFactory = beanFactory;
    }

    /**
     * 获取类型为requiredType的对象
     *
     * @param clz
     * @return
     * @throws org.springframework.beans.BeansException
     *
     */
    public static <T> T getBean(Class<T> clz) throws BeansException {
        @SuppressWarnings("unchecked")
        T result = (T) beanFactory.getBean(clz);
        return result;
    }

}
