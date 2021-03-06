package edu.sysu.chris.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
Created by ChrisChan on 2017/8/30.
*/
public class NonOwnerInvocationHandler implements InvocationHandler {
    PersonBean person;

    public NonOwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("get")) {
            return method.invoke(person, args);
        } else if (method.getName().equals("setHotOrNotRating")) {
            return method.invoke(person, args);
        } else if (method.getName().startsWith("set")) {
            return new IllegalAccessException();
        }
        return null;
    }
}
