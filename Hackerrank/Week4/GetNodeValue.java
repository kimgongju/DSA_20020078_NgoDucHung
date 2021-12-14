

/*
 * Complete the 'getNode' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_SINGLY_LINKED_LIST llist
 *  2. INTEGER positionFromTail
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

int getNode(SinglyLinkedListNode* llist,int positionFromTail){
    SinglyLinkedListNode *p1=llist,*p2=llist;
    while(positionFromTail--) p1=p1->next;
    while(p1->next!=NULL){
        p1=p1->next;
        p2=p2->next;
    }
    return p2->data;
}

