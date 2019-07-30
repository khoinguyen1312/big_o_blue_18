# Homework
## Mega city
read (n, s)
map(int, int)
for i = 0 -> n
    read (x, y, k)
    dist = x*x + y*y
    if (dist in map):
        map[dist] + k
    else
        a = []
        map[dist] = k
        