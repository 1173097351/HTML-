a = int(input("请输入一个整数输入："))
c = 0
while a > 1:
    a /= 10
    c += 1
print(c)
