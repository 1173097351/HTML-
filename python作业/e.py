names = ['zhao', 'qian', 'sun', 'li']
username = input("请输入姓：")
for a in names:
    if a == username:
        print("已经存在")
        break
else:
    names.append(username)
    print(names)
