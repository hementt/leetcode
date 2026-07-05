/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode s = head;
        while(s != null){
            s = s.next;
            size++;
        }
        int target = size/k;


        ListNode curr = head;
        ListNode last = null;

        ListNode prev = null;
        ListNode next = null;
        boolean flag = false;


        while(target-- > 0 ){

            
            ListNode first = curr;
            

            int i = 0;
            while(i < k){
                next = curr.next;

                curr.next = prev;

                prev = curr;
                curr = next;
                i++;
            }

            first.next = curr;
            

            if (!flag) {
                head = prev;
            } else {
                last.next = prev;
            }
            
            last = first;
            flag = true;

            
        }
        return head;
    }
}