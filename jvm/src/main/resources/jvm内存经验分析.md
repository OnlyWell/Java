##1.
### > 从实践经验出发,除了java堆和永久代之外,下面这些部分也会占用较多内存,这里所有 的内存总和会受到操作系统进程最大内存的限制.
>> 1>Direct Memory:可通过-XX:MaxDirectMemorySIze调整大小,内存不足时抛出OutOfMemoryError或OutOfMemoryError:DirectBuffer memory.
>> 2>线程堆栈:可通过-Xss调整大小,内存不足时抛出StackOverflowError(纵向无法分配,即无法分配新的栈帧)或OutOfMemoryError:unable to create new native thread(本地库使用横向无法分配,即无法建立新的线程).
>> 3>Socket缓存区:每个Socket连接都Receive和Send两个缓存区.
>> 4>JNI代码:如果代码中使用JNI调用本地库,那本地库使用的内存也不在堆中
>> 5>虚拟机和GC: 虚拟机和GC的代码执行要消耗一定的内存.