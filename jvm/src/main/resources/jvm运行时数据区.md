## java内存
### 1.1运行时数据区域
#### 程序计数器,通过改变这个计数器的值来选取下一条需要执行的字节码指令; 如果执行native方法,这个计数器值为空(Undefined),该内存是唯一一个在java虚拟机规范没有规定任何OutOfMemoryError情况的区域.  线程私有
#### java虚拟机栈(java virtual machaine Stacks)也是线程私有的,每个方法被执行的时候都会同时创建一个栈帧(Stack Frame)用于存储局部变量表、操作栈、动态链接、方法出口等信息.如果线程请求的栈深度大于虚拟机所允许的深度,将抛出StackOverflowError异常.
#### 本地方法栈(Native Method Stacks)
#### Java堆,是所有线程共享的一块内存区域,在虚拟机启动时创建.java堆可细分为:新生代和老年代,再细致一点可分为Eden空间,From Survivor,To Survivor空间.如果从内存分配角度,线程共享的java堆中可能划分出多个线程私有的分配缓冲区(Thread Local Allocation Buffer,TLAB).
#### 方法区(Method Area),是各个线程共享的内存区域,它用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器变异后的代码等数据.
#####  运行时常量池(Runtime Constant Pool)是方法区的一部分.Class文件中除了有类的版本、字段、方法、接口等描述信息外,还有
一项信息是常量池(Constant Pool Table),用于存放编译期生成的各种字面量和符号引用,这部分内容将在类加载后存放到方法区的运行时常量池中.
#### 直接内存(Direct Memory),在NIO中,可以使用Native函数书直接分配堆外内存,然后通过java中的DirectByteBuffer对象作为这块内存的引用进行操作.




