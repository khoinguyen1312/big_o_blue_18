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
                                     