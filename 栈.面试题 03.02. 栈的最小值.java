请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
示例：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-stack-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=================解法=========================
双栈法，一个记录数值，另一个记录当前最小值。如果数值栈pop了，如果它是一个最小值，那么另一个栈也要pop
坑的是一个测试用例：
输入：
["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
[[],[512],[-1024],[-1024],[512],[],[],[],[],[],[]]
输出：
[null,null,null,null,null,null,-1024,null,-1024,null,-1024]
预期：
[null,null,null,null,null,null,-1024,null,-1024,null,512]
这里需要将
    public void pop() {
        if (stack.peek() == minStack.peek())
            minStack.pop();
        stack.pop();
    }
改为：
    public void pop() {
        int peek = stack.peek();
        if (peek == minStack.peek())
            minStack.pop();
        stack.pop();
    }
这是为什么呢？首先这里有个坑。测试下面代码：
    public boolean test(int x) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        s1.push(x);
        s2.push(x);
        int p1 = s1.peek();
        int p2 = s2.peek();
        System.out.println(p1==p2);
        return (s1.peek() == s2.peek());
    }
如果x是-128~127，那么输出都是true，如果不是这个范围，那么内部输出是true，返回结果为false。
There are two reasons for this:
autoboxing：When you autobox, s1.push(x) for some int x is transformed into 
s1.push(Integer.valueOf(x)). And since this is a cached value, the same instance is reused for any of these values.

the fact that an Integer implementation, as per the documentation, has an internal 
cache of at least all values between, precisely, -128 and 127.
=====================================================
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    
    public void pop() {
        int peek = stack.peek();
        if (peek == minStack.peek())
            minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
