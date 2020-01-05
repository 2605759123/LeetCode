package leetcode2;

/**
 * Created with IntelliJ IDEA.
 * Description:给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * User: 宁
 * Date: 2020-01-04
 * Time: 15:47
 */
public class leetcode2 {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        for (ListNode next = Solution.addTwoNumbers(l1,l2);next!=null;next=next.next){
            System.out.println(next.val);
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode next=null;
        ListNode next1 = l1;
        ListNode next2 = l2;
        int x=0;
        for (; next2 != null || next1 != null;){
            if (next1 != null && next2 == null){
                next.next=next1;
                if (x==1){
                    next = next.next;
                    while (true){
                        int val_result = next.val+x;
                        if (val_result<10){
                            next.val=val_result;
                            x = 0;
                            break;
                        }else{
                            next.val=0;
                            // x = 1;
                            if (next.next==null){
                                break;
                            }
                            next=next.next;
                        }

                    }
                }
                break;
            }else if (next2 != null && next1 == null){
                next.next=next2;
                if (x==1){
                    next = next.next;
                    while (true){
                        int val_result = next.val+x;
                        if (val_result<10){
                            next.val=val_result;
                            x = 0;
                            break;
                        }else{
                            next.val=0;
                            // x = 1;
                            if (next.next==null){
                                break;
                            }
                            next=next.next;
                        }

                    }
                }
                break;
            }
            int val_result = next1.val+next2.val+x;
            if (next==null){
                next = result;
                if(val_result>=10){
                    next.val = val_result-10;
                    x = 1;
                }else{
                    next.val = val_result;
                    x = 0;
                }
            }else{
                if(val_result>=10){
                    next.next = new ListNode(val_result-10);
                    x = 1;
                }else{
                    next.next = new ListNode(val_result);
                    x = 0;
                }
                next = next.next;
            }
            next1=next1.next;
            next2=next2.next;

        }
        if (x==1){
            next.next=new ListNode(1);
        }
        return result;

    }
}

