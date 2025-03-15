const getDuplicate = function(nums){
    let hare =0;
    let tortoise = 0;

    while(true){
        hare = nums[nums[hare]];
        tortoise = nums[tortoise];

        if(hare===tortoise){
            let pointer = 0;
            while(pointer!==tortoise){
                pointer = nums[pointer];
                tortoise = nums[tortoise];
            }
            return pointer;
        }
    }
}

getDuplicate([5,4,3,1,2,5]);