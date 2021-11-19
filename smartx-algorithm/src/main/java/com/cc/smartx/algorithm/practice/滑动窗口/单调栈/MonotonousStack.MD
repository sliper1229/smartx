主流程：

    求左右两侧距离最近比自己小的位置：从左到右遍历元素，保持 栈底（小）->栈顶（大）
    大循环：
        栈不为空，且当前元素 > 大于栈顶，弹出栈顶，记录栈顶元素的结果
    退出循环，将当前元素放入栈顶

    底 -> 顶：a b -> a (>b) (>b) (>b) b

伪代码：

     while (!stack.isEmpty() && stack.peek() > arr[i]) {
         Integer popIndex = stack.pop();
         res[popIndex][0] = !stack.isEmpty() ? stack.peek() : -1;
         res[popIndex][1] = i;
     }
     stack.push(i);

经典题目：
    
- [42]接雨水
- [84]柱状图中最大的矩形
- [85]最大矩形