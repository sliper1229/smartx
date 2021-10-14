```
import java.awt.*;
import java.util.LinkedList;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return digui(l1, l2, 0);
    }

    public ListNode digui(ListNode l1, ListNode l2, int add) {
        if (l1 == null && l2 == null && add == 0) {
            return null;
        }
        ListNode next1 = null;
        ListNode next2 = null;
        int sum = add;
        add = 0;
        if (l1 != null) {
            next1 = l1.next;
            sum += l1.val;
        }
        if (l2 != null) {
            next2 = l2.next;
            sum += l2.val;
        }
        add = sum >= 10 ? 1 : 0;
        sum = sum >= 10 ? sum - 10 : sum;
        if (l1 == null && l2 == null) {
            return new ListNode(sum);
        } else if (l1 != null) {
            l1.val = sum;
            l1.next = digui(next1, next2, add);
            return l1;
        } else {
            l2.val = sum;
            l2.next = digui(next1, next2, add);
            return l2;
        }
    }
}
```
