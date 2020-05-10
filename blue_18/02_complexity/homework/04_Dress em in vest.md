[number of soilder], [number of vest] 
n m x y
a[n] // size of soilder
b[m] // size of vest

ai - x, ai +y


5 3 0 0
1 2 3 3 4 
|  /_/
| |
1 3 5

suedo code
```
                Read 
                n,  m, x, y
                a[n], b[m]
                
                i = 0
O(max(m, n))    answer[]
                for j = 0 -> m:
                    while (i < n && b[j] > a[i] + y) :                  // áo khoác thứ j quá lớn so với người lính thứ i
                        i++                                             // ???
                        if (b[j] >= a[i] - x) && (b[j] <= a[i] + y) :   // áo khoác có vừa với người lính này hay không
                            answer.add(i, j)
                        i++

```