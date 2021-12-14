

// Complete the compare_lists function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */
bool compare_lists(SinglyLinkedListNode* head1, SinglyLinkedListNode* head2) {
    int countA=0,countB=0;
    for(SinglyLinkedListNode* p=head1;p!=NULL;p=p->next) ++countA;
    for(SinglyLinkedListNode* p=head2;p!=NULL;p=p->next) ++countB;
    if(countA!=countB) return 0;
    SinglyLinkedListNode *pA=head1,*pB=head2;
    for(;pA!=NULL;pA=pA->next,pB=pB->next) if(pA->data!=pB->data) return 0;
    return 1;
}

