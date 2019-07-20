# To find nagetive cycle
Because standing at it's own is already the smallest cost
If after time and time, algorithm have to change value to it's own (Ex: from 0 -> -2) => have negative cycle

# Usage
TheFaceBook -> People you may known
Regular Expression

# Homework
## Meeting Prof
```
Separate graph for yuong and old

graphYoung = 
graphOld = 

solutionYoung = floyd(graphYoung)
solutionOld = floyd(graphOld)

youngPosition
oldPosition

costs = []

for i -> (A -> Z) {
    costs.add(solutionYoung.calculateCost(youngPosition, i)
        + solutionOld.calculateCost(oldPosition, i))
}

print costs.max()

```

## Asterix

```

for i = 1 -> 2 :

    dist[i][j]
    maxCost[i][j]

    dist[i][j] = INF
    maxCost[i][j] = max (f[i], f[j])

    for k = 1 -> c :
        if (dist[i][j] + maxcost[i][j] > (dist[i][k] + dist[k][j]) + max(maxcost[i][k], maxcost[k][j])) :
            dist[i][j] = dist[i][k] + dist[k][j]
            maxCost[i][j] = max(maxcost[i][k], maxcost[k][j])


```