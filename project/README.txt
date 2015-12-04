The rationale:
This program aims to print out the function call sequences of Java application.

Given a Java application, it's obvious that we could trace its method sequences from the main method step by step, but we cannot easily add print function in every method. So I tried to discover the solution through binary files. As we know, JVM will compile the Java files to Class files, which contain all the information related to the application, certainly including the methods as well. Thus we could retrieve what we need from these class files.

I use ASM, an open-source software which could manipulate the binary code in a more accessible way. It could read and re-write the class files to generate a new type of class, or changing the methods inside the classes. Obviously I could add an output in every method through this tool to trace the method sequences.

Another necessary we need to know is that we have to deal with the class file before it's loaded in JVM. Fortunately, Java5th and above provide agent mode to permit developer to access the class before loading it into JVM. I just need to overload the premain method of agent class and pass into a class which implements the ClassFileTransFormer interface.

To sum up, I use instrument(the agent mode class) to access class files before JVM loads them, and add an output in every single method directly in class file, then I will get the output sequences.

How to use:
1. Using maven install to generate an runnable jar file;
2. If you have an application to monitor its call sequences, let's say, a testcase named MyTest, then you could input the following command in the terminal(I use windows): java -javaagent:%Name of your agent jar% %Path%\MyTest
3. You'll see the output results. 