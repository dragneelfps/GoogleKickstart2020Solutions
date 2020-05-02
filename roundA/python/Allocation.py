def solve(n, costs, b):
    costs.sort()
    res = 0
    for i in range(n):
        if b >= costs[i]:
            b -= costs[i]
            res += 1
    return res


t = int(input())
for i in range(1, t + 1):
    n, b = list(map(int, input().split()))
    costs = list(map(int, input().split()))
    res = solve(n, costs, b)
    print("Case #{}: {}".format(i, res))
