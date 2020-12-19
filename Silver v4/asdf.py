f = open('input.in')

data = f.readlines()

for i in range(len(data) - 1):
	data[i] = data[i][:-1]

for i in range(len(data)):
	data[i] = data[i].split(" ")


ans = 0

for i in data:
	rn = i[0].split("-")
	low = int(rn[0])
	high = int(rn[1])

	char = i[1][0]

	if ((i[2][low - 1] == char or i[2][high - 1] == char) and (not (i[2][low - 1] == char and i[2][high - 1] == char))):
		ans += 1

print(ans)