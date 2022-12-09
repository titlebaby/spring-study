package com.ling.demo03;

public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        //代理角色
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        handler.setRent(host);
        //生成代理类
        Rent proxy = (Rent)handler.getProxy();
        proxy.rent();
    }
}
