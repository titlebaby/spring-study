# spring-study


## IOC
 1. 对象是由spring创建
 2. 对象的属性是由spring容器设置的

即： 这个过程就叫控制反转：

控制： 睡来控制对象的创建，传统应用程序的对象是由程序本身控制创建的，使用spring后，对象是由spring来创建。

反转： 程序本身不创建对象，而变成被动的接受对象。

依赖注入： 就是利用set方法进行注入的。

IOC是一种编程思想，由主动的编程变成被动的接受。

可以通过newClassPathXmlApplicationContext去浏览一下底层源码

所谓IOC就是，对象由spring来创建、管理、装配（只需要在xml配置文件中进行修改）


3. IOC创建对象的方式
   1. 使用无参创建对象，默认！
   2. 假设我们要使用有参创建对象
      1. 下标赋值( <constructor-arg index="0" value="李四"/>)
      2. 类型赋值（<constructor-arg type="java.lang.String" value="李四2"/>）
      3. 直接通过参数名赋值【推荐】（<constructor-arg name="name" value="李四23"/>）
