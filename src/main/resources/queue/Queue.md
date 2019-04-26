## 队列

### ADT

队列ADT首先支持两个基本方法

| 操作方法   | 功能描述                                                     |
| ---------- | ------------------------------------------------------------ |
| enqueue(x) | 将元素x加到队列末端<br>输入：一个对象<br>输出：无            |
| dequeue()  | 若队列非空，移除队首元素并返回<br>否则，报空队列异常<br>输入：无<br>输出：对象 |

一个更加好用的队列ADT还应该支持如下方法

| 操作方法  | 功能描述                                                     |
| --------- | ------------------------------------------------------------ |
| getSize() | 返回队列中当前包含的元素数目                                 |
| isEmpty() | 检查队列是否为空<br>输入：无<br>输出：bool标志               |
| front()   | 若队列非空，则返回队首元素(但不移除)<br>否则，报空队列异常<br>输入：无<br>输出：队头对象 |
