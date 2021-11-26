```java
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        //用来记录完全覆盖t，每种字母还需要多少个
        int[] map = new int[128];
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        //count用来记录，当前滑动窗口中，还缺几个字母才能覆盖t
        //left为滑动窗口的左边界
        int count = 0, left = 0;
        String res = "";
        //统计一下t中每种字母要多少个，完全覆盖t一共要多少个字母
        for (int i = 0; i < ct.length; i++){
            map[ct[i]]++;
            count++;
        }
        //遍历滑动窗口的右边界
        for (int right = 0; right < cs.length; right++){
        
        	//如果t之中包含当前这个字母，则覆盖t所需的字母就要减少一个,count--
            if (map[cs[right]] > 0){
                count--;
            }
            
            //无论t之中包不包含当前字母，map都--，如果t中出现过，频率要减少，
            //如果t中没出现过的话，当前字母的频率就变为负数，
            //一定要减少，一会儿移动左边界的时候要用
            map[cs[right]]--;
            
            //count == 0，即t之中所有的字母都集齐了，接下来需要移动左边界
            if (count == 0){
            	//此时滑动窗口中多余的字母频率在map中都是负数，所以当左边界指向的字母是多余的，
            	//左边界就要右移，直到map[cs[left]] == 0，这时就不能在移动了，
            	//因为如果再移动的话，map[cs[left]]就变为1了，也就是说t中又需要一个cs[left]了
                while (map[cs[left]] < 0){
                	//移动左边界
                    map[cs[left]]++;
                    left++;
                }
                
                //第一个答案或者当前窗口比res小，更新res。
                if (res.length() == 0 || right - left + 1 < res.length()){
                    res = s.substring(left, right + 1);
                }
                
                //再移动一个左边界，这时map[cs[left]]应该变为1了，覆盖t的count也增加1
                map[cs[left]]++;
                left++;
                count++;
            }
        }
        return res;
    }
}
```
