for x in range(1, 100):
    for y in range(1, 100):
        z = 100 - x - y
        if 3 * x + 2 * y + z / 2 == 100:
            print("大匹马", x, "中匹马", y, "小匹马", z)
