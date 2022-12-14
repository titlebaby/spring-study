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

### 依赖注入

1. 构造器注入
2. set方式注入【重点】
    1. 依赖注入： set注入
        1. 依赖： bean对象的创建依赖于容器
        2. 注入： bean对象中的所有属性，由容器来注入
3. 拓展方式注入

### Bean的自动装配

1. 自动装配是Spring满足bean依赖一种方式
2. Spring会在上下文中自动寻找，并自动给bean装配属性

在spring中有三种装配的方式

1. 在xml中显示的配置
2. 在java中显示配置
3. 隐式的自动装配

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="cat" class="com.ling.pojo.Cat"/>
    <bean id="dog" class="com.ling.pojo.Dog"/>
    <!--   byName: 会自动在容器上下文中查找，和自己对象setXXX（dog）方法后面的值对应的beanid==dog (beanid唯一)-->
    <!--   byType: 会自动在容器上下文中查找，和自己对象属性类型相同的bean com.ling.pojo.Dog（类唯一） -->
    <bean id="people" class="com.ling.pojo.People" autowire="byType">
        <property name="name" value="张三"/>
    </bean>
</beans>
```

### 使用注解实现自动装配

spring-05

1. 导入约束：context
2. 配置约束的支持：content:annotation-config

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:content="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-context.xsd">
    <content:component-scan base-package="com.ling.pojo"/>
    <content:annotation-config/>

    <bean id="cat" class="com.ling.pojo.Cat"/>
    <bean id="dog" class="com.ling.pojo.Dog"/>
    <bean id="dog22" class="com.ling.pojo.Dog"/>
    <bean id="people" class="com.ling.pojo.People"/>
</beans>
```

@Autowired

直接在（实体类的）属性上使用即可！也可以在set方式上使用

使用Autowired可以不用编写set方法了，前提是这个自动装配的属性在IOC（spring）容器中存在，且符合名字byname

科普

```java
// @nullable 说明这个字段可以为null
//如果显示定义 Autowired 的required属性 为false，说明这个对象的值可以为null，否则不允许为空
class People {
    @Autowired(required = false)
    private Cat cat;

    @Autowired
    @Qualifier(value = "dog22")
    //自动装配的环境比较复杂，无法通过一个注解【@Autowired】完成的时候，
    // 可以使用 @Qualifier(value="xxx")去配合Autowired使用 ，指定另一个唯一的beanid对象注入
    private Dog dog;
}
//@Resource 
//@Resource(name="cat2")
```

Resource和Autowired 区别

1. 都是用来自动装配的，都可以放在属性字段上
2. @Autowired通过byname的方式实现（找beanid）
3. @Resource默认通过byname的方式实现，如果找不到名字，则通过bytype实现，如果两个都找不到的情况就报错【常用】
4. 执行的顺序不同

### 常用注解

- @Value 等价于配置  <property name="name" value="张三"/>
- @Component - 等价于配置 <bean id="cat" class="com.ling.pojo.Cat"/> 放在类上面，说明这个类被管理类
- @Repository - dao
- @Controller - controller
- @Service - service 以上四个注解功能都是一样，都是代表将某个类注册到spring容器中，装配Bean
- @Scope or @Scope("singleton")  作用域 单例

-----------
小结 xml与注解

- xml更加万能，适用于任何场合，维护简单方便
- 注解不是自己类使用不了(??)，维护相对复杂 xml与注解最佳实践
- xml用来管理bean
- 注解只负责完成属性的注入
- 我们在使用过程中，只需要注意一个问题，必须让注解生效，就需要开启注解的支持

```xml
<?xml version="1.0" encoding="UTF-8"?>
<bean>
    <content:component-scan base-package="com.ling.pojo"/>
    <content:annotation-config/>
</bean>
```



## IOC
1. 对象是由spring创建
2. 对象的属性是由spring容器设置的

即： 这个过程就叫控制反转：

控制： 睡来控制对象的创建，传统应用程序的对象是由程序本身控制创建的，使用spring后，对象是由spring来创建。

反转： 程序本身不创建对象，而变成被动的接受对象。

依赖注入： 就是利用set方法进行注入的。

IOC是以重编程思想，由主动的编程变成被动的接受。



## 代理模式

为什么要学习代理模式？因为这就是SpringAOP的底层！【springAOP和springMVC】重点！！！！

代理模式分类：

- 静态代理
- 动态代理

关系图：

### 静态代理
- 抽象角色：一般会使用接口或者抽象类来解决（租房接口）
- 真是角色： 被代理的角色 （房东出租房，实现出租房的接口）
- 代理角色： 代理真实角色（代理类中实例化真实类），代理真实角色后，我们一般会做一些附属操作（中介代理房东，看房，出租房，签合同）
- 客户： 访问代理对象 （想租房的人，在代理类中传入，想租房的房东类）

代理模式的好处：

- 可以使真实角色的操作更加纯粹，不用取关注一些公共业务
- 公共也就交给代理角色，实现了业务的分工
- 公共业务发生扩展的时候，方便集中管理

缺点：
b
- 一个真实角色就会产生一个代理角色，代码量会翻倍，开发效率会变低。


### 动态代理

- 动态代理和静态代理角色一样
- 动态代理的代理类湿动态生成的，不是我们直接写好的
- 动态代理分为两大类，基于接口的动态代理，基于类的动态代理

    - 基于接口已——JDK动态代理
    - 基于类—— cglib
    - java字节码实现： javasist

需要了解两个类： proxy、invocationHandler：调用处理程序（是代理实例的调用处理程序实现的接口）

每个代理实例都有一个关联的调用处理程序，当在代理实例上调用方法时，方法调用将被编码并分派到其调用处理程序的invoke方法。


### hashset和treeSet分别如何实现去重得
（1）hashSet的去重机制：hashCode()+equals()，底层先通过存入对象，进行运算得到一个hash值，通过hash值得到对应得索引，
如果发现table索引所在的位置，没有数据，就直接存放，如果有数据，就进行equals比较【链表就遍历比较】，
如果比较后，不相同，就加入，否则就不加入
(2)TreeSet的去重机制:如果你传了了一个comparator匿名对象，就使用实现的compare去重，如果方法返回0，
就认为是相同的元素/数据，就不添加，如果你没有传入一个comparator匿名对象，
则以你添加的对象实现的compareable接口的compareTo去重（默认）





