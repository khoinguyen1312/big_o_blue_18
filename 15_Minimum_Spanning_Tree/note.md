# Minimum Spanning Tree
## Usage
MRT 

# Home work
## ACM
```
n,m
graph
trace[]
min, trace = prim(graph, 0)
min2 = inf
for j in range(1, n)
    item = trace[j]
    u =   |
    v =   |> remove edge(u, v, w) out of graph
    min2 = min(min1, primg(graph, 0))
    Restore edge(u, v, w)
```

## Audiophobia
```
numberOfNode
numberOfEdge
numberOfQuery
graph = buildGraph(numberOfNode, numberOfEdge)

MST solution = new MST(graph)
solution.prim(0)

querries = [(start, end), ...]
for (start, end) in querries:
    printMaximumCost(solution, start, end) -> recursive or DFS

O( (S logC / Prim) + Q * (C - 1))
```
