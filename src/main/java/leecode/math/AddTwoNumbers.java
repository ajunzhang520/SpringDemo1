package leecode.math;

/**
 * ajunzhang
 * 2020/1/10 21:40
 **/
public class AddTwoNumbers {


    public static void main(String[] args) {
        // 创建两个链表
        // 第一个链表: 1-> 8 -> 7 -> 6 (在做加法运算代表的是6781)
        ListNode l1 = new ListNode(6);
        // 这是第一个链表的第一个节点(不能用这个节点去往下加数据) 必须有一个指针去往第一个节点上去加数据
        ListNode p = l1;
        // 这个指针节点会从链表的第一个节点一直往下走(直至最后一个节点)
        p.next = new ListNode(7);
        p = p.next;
        p.next = new ListNode(8);
        p = p.next;
        p.next = new ListNode(1);
        // 第二个链表
        ListNode l2 = new ListNode(9);
        ListNode q = l2;
        q.next = new ListNode(9);
        q = q.next;
        q.next = new ListNode(9);
        q = q.next;
        q.next = new ListNode(9);
        ListNode re = addTwoNumbers(l1, l2);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);// 打印结果
        ListNode tempResult = result;
        ListNode tempL1 = l1;
        ListNode tempL2 = l2;

        int carry = 0;// 判断十进制相加是否溢出，0 表示没有溢出，1表示有溢出
        while (tempL1 != null || tempL2 != null) {
            int l1_val = tempL1 == null ? 0 : tempL1.val;
            int l2_val = tempL2 == null ? 0 : tempL2.val;

            int sum = carry + l1_val + l2_val;
            carry = sum / 10;// 获取相加的和是否大于10
            tempResult.next = new ListNode(sum % 10);
            tempResult = tempResult.next;
            if (tempL1 != null) {
                tempL1 = tempL1.next;
            }

            if (tempL2 != null) {
                tempL2 = tempL2.next;
            }
        }

        if (carry > 0) {
            tempResult.next = new ListNode(carry);
            tempResult = tempResult.next;
        }

        return result.next;
    }
}
