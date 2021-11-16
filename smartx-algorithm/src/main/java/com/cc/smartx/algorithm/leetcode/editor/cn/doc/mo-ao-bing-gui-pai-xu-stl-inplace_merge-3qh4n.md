### 个人第500题
- `mark`一下
- `(/≧▽≦)/`

```cpp
class Solution {
public:
    int countRangeSum(vector<int>& nums, int lower, int upper) {
        vector<long> sum={0};
        for(int i=0;i<nums.size();i++)sum.emplace_back(sum[i]+nums[i]);
        return merge_sort(begin(sum),end(sum),lower,upper);
    }
private:
    template<class Iter>
    int merge_sort(Iter first, Iter last,int&lower,int&upper){
        int count=0;
        if(last-first>1){
            Iter middle=first+(last-first)/2;
            count=merge_sort(first,middle,lower,upper)+merge_sort(middle,last,lower,upper);
            auto right1=middle,right2=middle;
            for(auto left=first;left!=middle;left++){
                while(right1!=last&&*right1-*left<lower)right1++;
                while(right2!=last&&*right2-*left<=upper)right2++;
                count+=right2-right1;
            }
            inplace_merge(first,middle,last);
        }
        return count;
    }
};
```