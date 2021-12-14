

/*
 * Complete the 'deleteNode' function below.
 *
 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
 * The function accepts following parameters:
 *  1. INTEGER_SINGLY_LINKED_LIST llist
 *  2. INTEGER position
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

SinglyLinkedListNode* deleteNode(SinglyLinkedListNode* llist, int position) {
    SinglyLinkedListNode* p=llist;
    if(position==0){
        llist=llist->next;
        delete p;
        return llist;
    }
    while(position--){
        if(position<1){
            SinglyLinkedListNode* temp=p->next;
            p->next=p->next->next;
            delete temp;
        }
        p=p->next;
    }
    return llist;
}

