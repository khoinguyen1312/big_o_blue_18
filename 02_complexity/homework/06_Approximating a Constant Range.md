n
a[0], a[1], ... a[n - 1]

// tìm khoảng phần từ có độ chệnh lệch không quá k = 2

// mảng phân phối ???

Suedo code
```
count[n]
diff = 0
r = 0
for l = 0 -> n - 1
    while ( r < n && diff <= 2 ):
        count[a[r]] += 1
        if count[a[r]] == 1
            diff += 1
        r += 1
    res = max(res, r - l)
    count[a[l]] -= 1
    if (count a[l]] == 0)
        diff -= 1

```

```
count[n]
diff = 0
r = 0
for l = 0 -> n - 1
    while ( r < n && diff <= 2 ):
    if (count[a[r]] == 0 && diff == 2)
        break
    count[a[i]] += 1
    if (count[a[r]] == 1)
        diff += 1
    r += 1