class Node{
    constructor(value){
        this.value = value;
        this.next = null;
    }
}

class LinkedList{
    constructor(){
        this.head = null;
        this.tail=null;
        this.size =0;
    }
    addAtTail(value){
        const node = new Node(value);
        if(!this.head){
            this.head = node;
            this.tail = this.head;
        }else{
            this.tail.next = node;
            this.tail = node;    
        }
        this.size++;
        return this;
    }
}

const add2Numbers = function(l1,l2){
    let carryForward =0;
    const results = new LinkedList();
    while(l1 || l2 || carryForward){
        let l1Value = l1 ? l1.value : 0;
        let l2Value = l2 ? l2.value : 0;
        let sum = (l1Value + l2Value +carryForward);
        let nodeValueInResult = sum%10;
        results.addAtTail(nodeValueInResult);
        carryForward = Math.floor(sum/10);
        l1 = l1 ?l1.next : null;
        l2 = l2 ? l2.next : null;
    }
    return results;
}


const n1 = new LinkedList();
const n2 = new LinkedList();
//540 + 723 = 1263
n1.addAtTail(0);
n1.addAtTail(4);
n1.addAtTail(5);

n2.addAtTail(3);
n2.addAtTail(2);
n2.addAtTail(7);

add2Numbers(n1.head, n2.head);