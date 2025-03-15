class Node{
    constructor(value){
        this.value=value;
        this.left = null;
        this.right=null;
    }
}

class BinarySearchTree{
    constructor(){
        this.root =null;
    }
    insert(value){
        const node = new Node(value);
        if(!this.root){
            this.root = node;
            return this;
        }
        let tree = this.root;
        while(true){
            if(value <tree.value){
                //move left
                if(!tree.left){
                    tree.left = node;
                    return this;
                }
                tree = tree.left;
            }else{
                if(!tree.right){
                    tree.right = node;
                    return this;
                }
                tree = tree.right;
            }
        } 
    }
    
    find(value){
        if(!this.root) return false;
        let tree = this.root;
        while(tree){
            if(value < tree.value) tree = tree.left;
            else if(value > tree.value) tree = tree.right;
            else if (value === tree.value) return tree;
        }
    return false;
    }
    
    remove(value,current=this.root,parent=null){
        if(!this.root) return false;
        while(current){
            if(value<current.value){
                parent=current;
                current=current.left;
            }
            else if(value> current.value){
                parent = current;
                current=current.right;
            }
            else{
                //node to be deleted has 2 childred
                if(current.left!==null && current.right!==null){
                    current.value = this.getMin(current.right);
                    this.remove(current.value,current.right,current);
                }
                //delete the root node
                else if(parent===null){
                    if(current.left!==null){
                        current.value= current.left.value;
                        current.left = current.left.left;
                        current.right = current.left.right;
                    } else if(current.right!==null){
                        current.value=current.right.value;
                        current.left = current.right.left;
                        current.right = current.right.right;
                    } else{
                        //single node bst
                        this.root = null;
                    }
                }
                else if(current===parent.left){
                    parent.left = current.left!==null ? current.left : current.right;
                }
                else if(current===parent.right){
                    parent.right = current.left!==null? current.left : current.right;
                }
                //break out
                break;
            }
        }
    return this;    
    }

    getMin(node){
        while(node.left!==null){
            node = node.left;
        }
        return node.value;
    }    
}

let bst = new BinarySearchTree();


bst.insert(20);
bst.insert(6);
bst.insert(35);
bst.insert(3);
bst.insert(8);
bst.insert(27);
bst.insert(55);
bst.insert(1);
bst.insert(3);
bst.insert(25);
bst.insert(29);
bst.insert(60);



