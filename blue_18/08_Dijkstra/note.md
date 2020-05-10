# Book
book algorithm 4h edition
Shortest Part
Seam carving

# Suedo Code
## Traffic Network
```
            numberOfNode numberOfOneWayRod numberOfTwoWayRoad s t
            | from to length    
one way     | from to length
            | ...

            | from to length    
two way     | from to length
            | ...

graphS, graphT
input u, v, w
graphS[w].push(v, w)
graphT[v].push(u, w)
distS, distT
dijkstra(graphS, distS, s)
dijkstra(graphT, distT, t)

res = distS[t]

for i: 0 -> k
   input u, v, w
   res = min(res,
             distS[u] + w + distT[v],
             distS[v] + w + distT[u])
   



```

## Comandos
O(RlogN)
```
numberOfBuilding
numberOfTwoWayRoad

u1 v1
...
uR vR

start destination

Disjkstra(start)
Disjkstra(destination)

ans = 0
for u = 0 -> n -1
   ans = max (ans, dist(s, u) + dist(d, u)

print(ans)
```
=> try BFS for better performance


