a = eval(input("输入要输出的行数:"))
b = []
for i in range(a):
    d = [1] * (i + 1)
    for c in range(2, i + 1):
        d[c - 1] = b[c - 1] + b[c - 2]
    b = d
    print(d)
