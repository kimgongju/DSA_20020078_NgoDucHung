

// Complete the insertNodeAtTail function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */
SinglyLinkedListNode* insertNodeAtTail(SinglyLinkedListNode* head, int data) {
    if(head==NULL){
        SinglyLinkedListNode* newNode=new SinglyLinkedListNode(data);
        return newNode;
    }
    SinglyLinkedListNode *p=head,*newNode=new SinglyLinkedListNode(data);
    for(;p->next!=NULL;p=p->next);
    p->next=newNode;
    return head;
}

