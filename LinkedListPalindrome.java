import java.util.Stack;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LinkedListPalindrome {

    public static boolean isPalindrome(ListNode head){ //slower Method
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp!=null){
            stack.push(temp.val);
            temp = temp.next;
        }

        while (head!=null){
            if (head.val!=stack.peek())
                return false;
            stack.pop();
            head = head.next;
        }

        return true;
    }

    public static void reverse(ListNode head){
        ListNode prev=null;
        ListNode curr = head;
        ListNode next =null;
        while (curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public static boolean isPalindromefaster(ListNode head){
        ListNode slow = head;
        ListNode fast = head;


        while (fast!=null || fast.next!=null){
            fast=fast.next.next;
            slow =slow.next;
        }
        if (fast!=null){
            slow=slow.next;
        }
        reverse(slow);

        while (head!=null){
            if(head.val!=slow.val)
                return false;
            head = head.next;
            slow=slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        //drivercode call isPalindrome
    }
}
