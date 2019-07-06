# Note
n/2 - 1 <=> vị trí cuối cùngng co khả năng có con
i*2 + 1 <=> node con trái
i*2 + 2 <=> node con phải
(i - 1) / 2 <=> node cha

minHeapify -> O(log)

# Homework
## Promotion
minAlreadyIndex[] = //store min index that already seen
maxAlreadyIndex[] = //store max index that already seen

numberIndexCounter[] = //use to store is number ready to push

## Restaurant Rating
MinHeap top
MaxHeap remain

int counter = 0;

for review in reviews
    if (input == 2)
        -> print top
    if (input == 1)
        remain.add(review)
        counter++;
        if (counter % 3 == 0) {
            top.add(remain.pop)
        } else {
            if (top.peek < remain.peek)
                swap(top.peek, remain.peek)
        }