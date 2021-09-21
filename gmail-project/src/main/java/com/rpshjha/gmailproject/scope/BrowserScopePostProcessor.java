package com.rpshjha.gmailproject.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 08/09/21
 * Time: 10:31 AM
 * To change this template use File | Settings | File and Code Templates.
 */
public class BrowserScopePostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope("browserscope", new BrowserScope());
    }
}
