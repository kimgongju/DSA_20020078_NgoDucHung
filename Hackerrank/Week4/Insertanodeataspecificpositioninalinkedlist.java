

/*
 * Complete the 'insertNodeAtPosition' function below.
 *
 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
 * The function accepts following parameters:
 *  1. INTEGER_SINGLY_LINKED_LIST llist
 *  2. INTEGER data
 *  3. INTEGER position
 */

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */

SinglyLinkedListNode* insertNodeAtPosition(SinglyLinkedListNode* llist, int data, int position) {
    if(position<1){
        SinglyLinkedListNode* head=new SinglyLinkedListNode(data);
        head->next=llist;
        return head;
    }
    --position;
    SinglyLinkedListNode *p=llist,*newNode=new SinglyLinkedListNode(data);
    while(position--) p=p->next;
    newNode->next=p->next;
    p->next=newNode;
    return llist;
}

