counter = 0
s = 9
while True:
    s *= 2
    counter += 1
    if s > 884800000:
        break
print("需要对折:", counter)
