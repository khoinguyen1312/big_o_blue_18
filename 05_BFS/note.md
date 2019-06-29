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
