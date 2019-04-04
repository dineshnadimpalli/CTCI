class StackOfPlates {
    constructor(maxSize) {
        if (maxSize < 1) {
            throw new Error("Not possible!")
        }
        this.maxSize = maxSize;
        this.stacks = [[]];
    }

    push(value) {
        if (this.stacks[this.stacks.length - 1].length == this.maxSize) {
            this.stacks.push([]);
        }
        this.stacks[this.stacks.length - 1].push(value);
    }

    pop() {
        const poppedValue = this.stacks[this.stacks.length - 1].pop();
        if (this.stacks.length > 1 && this.stacks[this.stacks.length - 1].length == 0) {
            this.stacks.pop();
        }
        return poppedValue;
    }

    popAt(index) {
        if (index < 1 && index > (this.stacks.length - 1)) {
            throw new Error("Index value is invalid")
        }
        if (index == this.stacks[this.stacks.length - 1]) {
            return this.pop();
        }

        let stack = this.stacks[index - 1];
        let value =  stack.pop();
        let nextStack = [];

        for (let i = index; i < this.stacks.length ; i++){
            nextStack = this.stacks[i];
            nextStack.reverse();
            stack.push(nextStack.pop());
            nextStack.reverse();
            stack = nextStack;
        }

        if (this.stacks.length > 1 && this.stacks[this.stacks.length - 1].length == 0) {
            this.stacks.pop();
        }

        return value;

    }
}


const myStack = new StackOfPlates(3);

myStack.push(1);
myStack.push(2);
myStack.push(3);
myStack.push(4);
myStack.push(5);
myStack.push(6);
myStack.push(7);
myStack.popAt(2);

console.log(myStack.stacks);