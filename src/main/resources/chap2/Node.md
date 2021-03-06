## 链表

数组长度必须固定，在空间效率及适应性方面还存在不足。

单链表的长度不再固定，可以根据实际需要不断变化。

具体实现查看[Node.java](../../java/dsa/Node.java)

### 位置ADT

为了保持链表结构的高效性，又不至于违背面向对象设计原则，抽象出位置(Position)这一概念。

位置是支持以下方法的数据类型

| 操作方法   | 功能描述                                                     |
| ---------- | ------------------------------------------------------------ |
| getElem()  | 返回存放于当前位置的元素<br>输入：无<br>输出：对象           |
| setElem(e) | 将元素e放入当前位置，并返回此处原先存放的元素<br>输入：一个元素<br>输出：一个元素 |

按线性次序排列的一组位置，就构成了一个列表，各个位置都是相对而言——相对于它的前、后邻居。如果位置p对应于列表中某个元素e，那么即使e在列表中的次序改变了，位置p也依然不变。只有在e被显式删除后，位置p才会相应地被销毁。

无论元素e被替换还是与另一个元素互换，位置p都不会改变。

基于位置的概念，可以为列表定义出一套以位置对象为参数、返回位置对象的方法。

接口定义请看[Position.java](../../java/dsa/Position.java)

### 链表分析

* 首节点插入

    创建节点n，将其next引用n.next指向当前head，将链表的head引用指向新插入的节点n。

* 首节点删除

    将首节点的next引用head.next复制一份记为n，删除该节点，将head设置为n。

    即使单链表只含一个节点，上述操作依然正确。要注意在这种情况下，**要同时更新tail引用**，将其置为null。

* 末节点插入

    假如借助一个引用tail始终指向末节点，则在表尾插入新节点也只需O(1)时间。

    1. 创建新节点n
    2. 将其next引用n.next置为null
    3. 将末节点的next引用即tail.next指向新节点n
    4. 将tail指向新节点n

    上述次序不能随意调换。

    即使是空的单链表，上述操作仍然可行。实际上，对空的单链表来说，插入的节点既是末节点也是首节点，需要同时更新head使其指向新插入的节点。

* 末节点删除

    即使始终通过一个tail引用指向当前末节点，末节点的删除操作也不能在O(1)时间内完成。因为只有找到末节点的直接前驱节点之后，才能对表尾节点实施删除操作。但我们为此不得不从链表头逐一检查各个节点，需要O(n)时间

### 链表应用

[单链表实现队列QueueList](../../java/dsa/queue/list/QueueList.java)

[单链表实现栈StackList](../../java/dsa/stack/list/StackList.java)



