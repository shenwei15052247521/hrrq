package com.lanswon.web.dto;


import java.net.InterfaceAddress;

public class Demo {
    public static void main(String[] args) {
        B b = new A();
        C c = new A();
    }
}

 class A extends B implements C{


}

 class B {


}

 interface C {


}