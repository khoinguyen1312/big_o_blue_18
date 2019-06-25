

# Suedo code
```
read size_people, teapot_capacity, containers[]

sort(containers[])  //Onlogn
min_capacity_girl = containers[0]
min_capacity_boy = containers[n]
m = min(min_capacity_girl, min_capacity_boy / 2)

answer = min (3 * m * size_people, teapot_capacity)

```