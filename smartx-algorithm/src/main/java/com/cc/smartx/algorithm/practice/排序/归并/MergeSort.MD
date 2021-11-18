    
主流程：

    定义主函数：arr[L.....R]上有序
    递归过程：arr[L.....M]上有序，arr[M+1.....R]上有序，将两个有序的部分合并

伪代码：

    让arr[L......R]上有序：
    {
        拆分到最细：M = L + (R - L) / 1;
        让arr[L......M]上有序
        让arr[M+1......R]上有序
        将两个有序的部分合并
    }

- 树形递归
- 深度优先遍历？？
- 先拆分到最细，再merge

经典题目：

    小和问题：
    while (p1 <= M && p2 <= R) {
        // 左右相等时，拷贝右边，不累加到结果里
        res += arr[p1] < arr[p2] ? arr[p1] * (R - p2 + 1) : 0;
        help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
    }

    逆序对问题：
    while (p1 <= M && p2 <= R) {
    	// 左右相等时，拷贝右边，不累加到结果里
    	res += arr[p1] < arr[p2] ? arr[p1] * (R - p2 + 1) : 0;
    	help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
	}

    比右侧大两倍问题：
    // 3 6 9 	 0 1 2
    int rightIndex = m + 1;
    for (int leftIndex = L; leftIndex <= m; leftIndex++) {
        while (rightIndex <= r && arr[leftIndex] > 2 * arr[rightIndex]) {
			rightIndex++;
        }
        ans += rightIndex - m - 1;
    }

    区间和的个数：
    int ans = 0;
    // [windowL, windowR) 左闭右开
    int windowsL = l;
    int windowsR = l;
    // 1 3 6    0 2 4
    for (int i = m + 1; i <= r; i++) {
        long min = sum[i] - upper;
        long max = sum[i] - lower;
        while (windowsL <= m && sum[windowsL] < min) {
            windowsL++;
        }
        while (windowsR <= m && sum[windowsR] <= max) {
            windowsR++;
        }
        ans += windowsR - windowsL;
    }
    


    