/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author ACER
 */
class A{
    protected int value;
    public A(int x){
        this.value = x;
    }
    
    public A(){
        this(1);
    }
    
    public void inc1(){
        this.value += 1;
    }
    
    public void inc2(){
        this.value += 2;
    }
    
    public final void show(){
        System.out.println(this.value);
    }
}

class B extends A{
    public void inc2(){
        this.inc1();
        this.value += 2;
    }
}

class C extends B{
    public C(int y){
        this.value += y;
    }
    
    public void inc1(){
        this.value +=4;
    }
    
    public void inc2(){
        super.inc2();
        super.inc1();
    }
}
public class Test2 {
    public static void main(String[] args) {
        C a1 = new C(10);
        a1.inc1();
        a1.show();
        
        A a2 = new B();
        a2.inc1();
        a2.inc2();
        a2.show();
        
        A a3 = new C(3);
        a3.inc1();
        a3.inc2();
        a3.show();
    }
}
