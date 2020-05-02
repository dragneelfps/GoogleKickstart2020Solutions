def solve(n, k, p, stacks):
    sol = [x[:] for x in [[0] * (n * k + 1)] * (p + 1)]
    for i in range(1, p + 1):
        sol[i][0] = -1

    for i in range(1, n * k + 1):
        for j in range(1, p + 1):
            c1 = c2 = -1
            c1 = sol[j][i - 1]
            val = (i - 1) % k + 1
            num = (i - 1) // k
            left = j - val
            if left >= 0:
                c2 = sol[left][i - val]
            if c2 != -1:
                c2 += stacks[num][val - 1]
            sol[j][i] = max(c1, c2)

    return sol[p][n * k]


t = int(input())
for i in range(1, t + 1):
    n, k, p = list(map(int, input().split()))
    stacks = []
    for j in range(n):
        stack = list(map(int, input().split()))
        sm = 0
        for z in range(k):
            stack[z] += sm
            sm = stack[z]
        stacks.append(stack)
    res = solve(n, k, p, stacks)
    print("Case #{}: {}".format(i, res))
