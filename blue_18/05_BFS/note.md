# Breadth First Search
 - Làm việc với đồ thị có hướng hoặc vô hướng không có trọng số
 - Độ phức tạo O(V + E)
 
# Homework
## Guilty Prince
 1st solution
 convet to Graph

 2nd solution run directly on matrix

```
O(T * width * height)

visited[][]


 BFS(startX, startY) {
     queue = [(startX, startY)]
     visited[startX][startY] = true
     count = 1
     while !queue.empty
        currentX,currentY = queue.pop, count
        
        connectedPoints = []

        top = top(currentX, currentY)
        bot = bot(currentX, currentY)
        left = left(currentX, currentY)
        right = right(currentX, currentY)

        if top != None: connectedPoints.add(top)
        if bot != None: connectedPoints.add(bot)
        if left != None: connectedPoints.add(left)
        if right != None: connectedPoints.add(right)

        for point in points:
            pointX = point.x
            pointY = point.Y

            if (visited[pointX][pointY] == false)
                queue.push(point.x, point.y)
                visited[pointX][pointY] = True
 }

 def isValid(int x, inty) {
     return x >= 0 && x < width && y >= 0 && y < height
 }

 ```


## Kefa and Park
BFS tree
```
B1: read graph
B2: cat[]
B3: BFS(1)

    queue.push(1)
    while queue note empty
        u = q.front
        visited(u) = 1
        for v in graph(u):
            if not visisted:
                if a[v]
                    cat[v] = cat[v] + 1
                if cat[v] <= M
                    if isLeaf(v)
                        ans += 1
                    else
                        queue.push()

def isLeaf(v):
    return v != root && graph[v].size >= 1

BFS:
    ...
    cat[]
    queue.push(1)
    while not queue.isEmpty:
        currentNode = queue.front
        visited[currentNode] = 1

        for nextNode in graph[currentNode]:
            if not isCat(nextNode)
                cat[nextNode] = 0
            else
                cat[nextNode] = cat[nextNode] + 1
                if (cat[nextNode] <= M)
                    if (isLeaf(nextNode))
                        answer++
                    else
                        queue.push(nextNode)

```