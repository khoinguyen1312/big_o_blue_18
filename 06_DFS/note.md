# DFS
 - Can not find shortest

# Different in BFS, DFS

Solve Maze
    BFS -> shorttest
    DFS -> many way

Topo sort

# Compare with Back Tracking
    Backtracking
        Recursive
    DFS
        Recursive or Stack
    
    Example:
    |     |     |     |     |
    | --- | --- | --- | --- |
    | x   |     |     |     |
    |     |     |     |     |
    |     |     |     |     |
    |     |     |     |     |

    Backtracking can recursive to previous state to find next answer
    DFS if can not find answer, will stay, do not thing

    Backtracking find all answer
    DFS find an amount of answer

    Ex: Chess game Problem

    DFS Recursive stop when all are visited
    Backtracking stop when all senario are visited

    Ex: Find way from 1 -> 9
    1 2 3
    4 5 6
    7 8 9

    Back Tracking would:
                                    | 1 -> 2 -> 3 -> 6 -> 9 
                                    | ....
                                    | 1 -> 2 -> 3 -> 6 -> 5 -> 4 -> 7 -> 8 -> 9
        All possiple case        <  | ....
                                    | 1 -> 4 -> 7 -> 8 -> 9

        => BIG amount of cases
    
    DFS would
        finish when all are visited
        => small amount of case


# DFS Recursive
    Recursive stop when all are visited

# Usage
    DFS is effective on solving problem that belong to Tree structure
    Ex:
        when finding a way, there only one way to go to one node from root  
                      1               
                    / | \             
                   2  3  6           
                  / \     \           
                 4   5     7       
                                     
# Homework
## All Izz Well
//find way to get `ALL IZZ WELL`
     0 1 2 3 4 5
0    A W E . Q X
1    L L L . E O
2    I Z Z W L L
=> 0,0 -> 0,1 -> 1,1 -> 0,2 -> 1,2, -> 2,2 -> 3,2 ...

```
numberOfRows
numberOfCollumns
char[r][c] matrix

t = "ALLIZZWELL"

DFS(startX, startY, index)
    s = ""
    stack
    if index ==len(t)
        return true
        
    if a[r, c] != t[index]
        return false
    
    (newRs, newCs)[8] = getNextToPoint(r, c)
    for each (newR, newC) in (newRs, newCs)
        if visited[newR, newC] == false
            visited[newR, newC] = True              // Backtrack here
            reached = DFS(newR, newC, index + 1)

            if reached
                return True;

            visited[newR, newC] = false              // Backtrack here

main()
    for i: 0 -> r - 1                                 // O(T * r * c * r * c)
        for j: 0 -> c - 1                             // Worst case, it would check for every other cell
            if (a[i, j] == 'A')
                isFound = DFS(i, j, 0)
                if (isFound)
                    print("YES")
                    return;

    print("NO")

```


## Dudu Service Maker