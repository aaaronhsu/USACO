line1 = input()
line2 = input()

line1 = line1.split(" ")
line2 = line2.split(" ")

for i in range(len(line2)):
	line2[i] = int(line2[i])

line2.sort()

print(1)