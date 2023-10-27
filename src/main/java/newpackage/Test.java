///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package newpackage;
//
///**
// *
// * @author ACER
// */
//
//class A {
//    protected int x;
//    public A(){
//        this.x = 1;
//    }
//    
//    public void inc1(){
//        this.x  += 10;
//    }
//    
//    public void inc2(){
//        this.x -= 5;
//    }
//    
//    public final void show(){
//        System.out.println(this.x);
//    }
//}
//
//class B extends A {
//    public void inc1() {
//        this.x += 20;
//    }
//}
//
//class C extends B{
//    public C(){
//        this.x += 5;
//    }
//    
//    public void inc2(){
//        this.x += 30;
//    }
//}
//
//
//public class Test {
//    public static void main(String[] args){
//        A a1 = new A();
//        a1.inc1();
//        a1.inc2();
//        a1.show();
//        
//        A a2 = new B();
//        a2.inc1();
//        a2.inc2();
//        a2.show();
//        
//        A a3 = new C();
//        a3.inc1();
//        a3.inc2();
//        a3.show();
//    }
//}
