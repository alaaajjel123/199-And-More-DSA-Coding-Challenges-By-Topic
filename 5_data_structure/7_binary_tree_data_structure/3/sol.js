class Node{
    constructor(value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree{
    constructor(){
        this.root = null;
    }
    insert(array){
        if(array.length===0) return;
        let i=0;
        //if root is null
        if(!this.root){
            if(array[0]===null)return;
            else{
                let node = new Node(array[0]);
                this.root = node;
                i++;
                if(i===array.length) return this;
            }
        }
        //insert elements
        const queue = [this.root];
        while(queue.length){
            let current = queue.shift();
            //left
            if(!current.left){
                if(array[i]!==null){
                    let node = new Node(array[i]);
                    current.left = node;
                }
                i++;
                if(i===array.length) return this;
            }
            if(current.left) queue.push(current.left);
            //right
            if(!current.right){
                if(array[i]!==null){
                    let node = new Node(array[i]);
                    current.right = node;
                }
                i++;
                if(i===array.length) return this;
            }
            if(current.right) queue.push(current.right);
        }
    }
}



const tree = new BinaryTree();
tree.insert([7,11,1,null,7,2,8,null,null,null,3,null,null,5,null]);
