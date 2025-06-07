package com.example.beanScopesDemo.controller;

import com.example.beanScopesDemo.scopes.*;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanScopeController {

    @Autowired
    private SingletonBean singletonBean;

    @Autowired
    private ObjectProvider<PrototypeBean> prototypeBeanProvider;

    @Autowired
    private ObjectProvider<RequestBean> requestBeanProvider;

    @Autowired
    private ObjectProvider<SessionBean> sessionBeanProvider;

    @GetMapping("/scopes")
    public String showScopes() {
        PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
        RequestBean requestBean = requestBeanProvider.getObject();
        SessionBean sessionBean = sessionBeanProvider.getObject();

        return "<h2>Bean Scope Demo</h2>" +
                "<p>Singleton Bean ID: " + singletonBean.getId() + "</p>" +
                "<p>Prototype Bean ID: " + prototypeBean.getId() + "</p>" +
                "<p>Request Bean ID: " + requestBean.getId() + "</p>" +
                "<p>Session Bean ID: " + sessionBean.getId() + "</p>" +
                "<p><i>Reload or open in new tabs to observe different scopes.</i></p>";
    }
}
