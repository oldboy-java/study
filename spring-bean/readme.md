一、生命周期执行的过程如下:
1)spring对bean进行实例化,默认bean是单例
2)spring对bean进行依赖注入
3)如果bean实现了BeanNameAware接口,spring将bean的id传给setBeanName()方法
4)如果bean实现了BeanFactoryAware接口,spring将调用setBeanFactory方法,将BeanFactory实例传进来
5)如果bean实现了ApplicationContextAware()接口,spring将调用setApplicationContext()方法将应用上下文的引用传入
6) 如果bean实现了BeanPostProcessor接口,spring将调用它们的postProcessBeforeInitialization接口方法
7) 如果bean实现了InitializingBean接口,spring将调用它们的afterPropertiesSet接口方法,类似的如果bean使用了init-method属性声明了初始化方法,改方法也会被调用
8)如果bean实现了BeanPostProcessor接口,spring将调用它们的postProcessAfterInitialization接口方法
9)此时bean已经准备就绪,可以被应用程序使用了,他们将一直驻留在应用上下文中,直到该应用上下文被销毁
10)若bean实现了DisposableBean接口,spring将调用它的distroy()接口方法。同样的,如果bean使用了destroy-method属性声明了销毁方法,则该方法被调用。


二、beans.xml配置文件读取后，bean实例化情况
          通常情况下，spring是按照配置文件从上到下顺序读取配置文件内容，进而进行bean的实例化。
          
    1、如果B对象实例化配置设置scope="singleton"，A对象采用默认方式，则 spring先实例化B的对象实例。然后再进行A对象的实例化。
      
      　此时运行Clien程序，运行结果如下：
    
    　	B's constructor method is invoked
	B is calling setBeanName method
	B is calling setBeanFactory method
	B is calling setApplicationContext method
	
	A's constructor method is invoked
	B is autowired by spring container
	A is calling setBeanName method
	A is calling setBeanFactory method
	A is calling setApplicationContext method
	init method is invoked  in Class A
	destory method is invoked  in Class A
           
                
    2、如果B对象实例化配置设置scope="prototype"，A对象采用默认方式，则B对象不会被实例化。然后Spring容器会去实例化A对象，由于A
    对象本身依赖B对象，此时Spring容器再完成B对象的实例化，然后注入到A对象中来。
    　　
    　     A's constructor method is invoked
    
	B's constructor method is invoked
	B is calling setBeanName method
	B is calling setBeanFactory method
	B is calling setApplicationContext method
	
	B is autowired by spring container
	A is calling setBeanName method
	A is calling setBeanFactory method
	A is calling setApplicationContext method
	init method is invoked  in Class A
	destory method is invoked  in Class A
                
     
     3、如果A对象实例化配置设置scope="prototype"，B对象采用默认方式，则先实例化B对象。A对象在Spring容器启动时并不会
     实例化，只有在具体用到A对象时才会进行实例化：如 A a = context.getBean(A.class);

      此时运行Clien程序，运行结果如下：
     B's constructor method is invoked
	B is calling setBeanName method
	B is calling setBeanFactory method
	B is calling setApplicationContext method


       如果在Client程序中增加A对象的获取：A a = context.getBean(A.class)，此时运行Clien程序，运行结果如下：
   
     B's constructor method is invoked
	B is calling setBeanName method
	B is calling setBeanFactory method
	B is calling setApplicationContext method
	
	A's constructor method is invoked
	B is autowired by spring container
	A is calling setBeanName method
	A is calling setBeanFactory method
	A is calling setApplicationContext method
	init method is invoked  in Class A
	
	
	4、假如现在beans.xml中只有B对象配置，如果B对象实例化配置设置scope="singleton"，同时设置lazy-init="true"(延迟加载)
        则spring容器先不会去实例化B对象，只有在真正使用时才会去实例化。
        
    5、假如现在beans.xml中只有B对象配置，如果B对象实例化配置设置scope="prototype"，同时设置lazy-init="false"(延迟加载)
        则spring容器先不会去实例化B对象，只有在真正使用时才会去实例化，同时每次获取B对象时，都会重新创建一个新对象。  
   
   
  三、bean懒加载情形
  1、对于scope="singleton"，同时设置lazy-init="true"的bean，不考虑被其他非懒加载的bean依赖的话，spring容器只有在真正需要使用该bean时，才会去进行实例化。
  
  2、对于scope="prototype"，这种多实例bean，不管lazy-init设置何值，不考虑被其他非懒加载的bean依赖的话，spring容器只有在真正需要使用该bean时，才会去进行实例化，每次获取对象时，都会重新创建一个新对象。
   