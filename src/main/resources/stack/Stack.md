## 栈

### ADT

栈必须支持以下方法

| 操作方法 | 功能描述                                                     |
| -------- | ------------------------------------------------------------ |
| push(x)  | 将对象x压至栈顶<br>输入：一个对象<br>输出：无                |
| pop()    | 若栈非空，则将栈顶对象移除，并将其返回<br>否则，报错<br>输入：无<br>输出：对象 |

此外，定义如下方法

| 操作方法  | 功能描述                                                     |
| --------- | ------------------------------------------------------------ |
| getSize() | 返回栈内当前对象的数目<br>输入：无<br>输出：非负整数         |
| isEmpty() | 检查栈是否为空<br>输入：无<br>输出：布尔标志                 |
| top()     | 若栈非空，则返回栈顶对象(但并不删除)<br>否则，报错<br>输入：无<br>输出：栈顶对象 |

接口定义详见[Stack.java](../../java/dsa/stack/Stack.java)

### 基于数组的简单实现

用一个数组来存放其中的元素，即用一个容量为$N$的数组$S$，再加上一个变量top来指示当前栈顶的位置。

由于Java数组的元素都是从0开始编号，所以将top初始化为-1；**只要$top=-1$就说明栈为空**。因此需要处理好栈满的情况。

具体实现请看[StackArray.java](../../java/dsa/stack/array/StackArray.java)

在这个实现中，会将S[top]置为null，这样可以利用Java的垃圾回收机制在pop时回收对象占用的内存空间。

#### 复杂度分析

每一方法都只需进行常数次算术运算、比较和赋值。pop()和top()会调用一次isEmpty()，但后者也只需要常数时间。

若数组容量为N，则空间复杂度为$O(N)$，即无论实际用了多少单元，复杂度在创建栈时就注定了。

#### 缺陷

内部数组的容量是事先固定的。

很多时候需要大容量栈，事先确定容量难以保证足够大，因此在实际运行中很可能会造成栈溢出。小容量的栈足以满足需求，此时固定空间的容量又会造成存储空间浪费。

### 基于单链表实现栈

栈的操作只限于栈顶元素，而单链表只有对首元素才能在$O(1)$时间内完成插入和删除，因此将单链表的首节点作为栈顶。借助一个实例变量来动态记录栈中元素的数目，从而保证getSize()方法也能在$O(1)$时间内完成。

具体实现请看[StackList.java](../../java/dsa/stack/list/StackList.java)

如果栈中实际有$n$个元素，除记录长度的实例变量，只需保存$n$个节点。每个节点只占用$O(1)$空间，因此上述实现只占用$O(n)$的空间。占用的空间将取决于栈的实际规模，不再一成不变，且无需处理溢出问题产生的异常。

### 栈的应用

* 借助栈进行数组倒置

    算法思想很简单：将数组所有元素依次压入栈中，然后不断退栈，并将弹出的元素依次填入数组

    ```java
    public static Integer[] reverse(Integer[] a) {
        StackArray S = new StackArray(a.length);
        Integer[] b = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            // 所有元素顺序入栈
            S.push(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            // 逆序退栈
            b[i] = (Integer) (S.pop());
        }
        return b;
    }
    ```

#### Java虚拟机中的栈

* Java方法栈

    任何一个运行中的Java程序都会配备一个私有的栈，称为Java方法栈，来记录各个方法在被调用过程中的局部变量等重要信息。

    Java程序执行期间，JVM会维护一个栈，其中的元素分别是当前活跃的某个方法实例的描述符，称为**帧**(*Frame*)。

    JVM还设置了一个叫做**程序计数器**(*Program Counter*)的变量PC，负责记录程序在JVM中运行到的当前位置。

    每当有一个方法被调用，对应帧就会被压入栈中；一旦当前方法实例运行终止，程序计数器就会恢复为该帧中先前保存的位置，然后该帧出栈，控制权转交给新栈顶所对应的方法实例。

    JVM还会**通过Java栈将参数传递给被调用的方法**。

    Java总是以参数形式传递给被调用方法，总是变量或表达式当前的实际值。

    对属于基本类型的变量，传递的就是其算数值。如果是某对象的一个引用，那么传递的就是该对象的内存地址。

* 递归的实现

    借助栈来实现方法调用，支持程序的递归。

* 操作数栈

    JVM使用操作数栈来解决算术表达式的求值。

#### 括号匹配算法与HTML文档标志匹配

算术表达式中可能出现很多相互匹配的括号()、{}、[]等。

借助栈结构S，通过对算术表达式自左向右扫描一遍，检查其中括号是否匹配。

>算法：ParenMatch(X, n)
>
>输入：长度为n数组X，对应于某一算术表达式
>
>输出：判断X中的括号是否匹配
>
>{
>
>​	初始化栈S;
>
>​	for (i=0 to n-1)	// 依次扫描X中的各个符号
>
>​		if (X[i]为左括号)	// 若遇到左括号，则
>
>​			S.push(X[i]);	// 入栈
>
>​		else if (X[i]为右括号) {	// 若遇到右括号，则
>
>​			if (S.isEmpty())	// 若此时栈为空，则
>
>​				return false;	// 不用检查后续字段，即可报告"不匹配"
>
>​			if (S.pop()与X[i]不匹配)	// 否则，若弹出的栈顶与当前括号不匹配，则
>
>​				return false;
>
>​		}
>
>​	// 至此，整个表达式已经扫描完毕
>
>​	if (S.isEmpty())	return true;	// 若此时栈空，则报告"匹配"
>
>​	else	return false;	// 否则，报告"不匹配"
>
>}

对该算法稍作修改，即可用于对HTML文档进行标志匹配，具体实现请看[HTML.java](../../java/dsa/stack/list/occasion/HTML.java)
