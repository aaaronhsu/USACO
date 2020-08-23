def get_max(cows, n):
    total_spaces = cows[-1] - cows[0] - 1
    front_space = cows[1] - cows[0] - 1
    back_space = cows[-1] - cows[-2] - 1
    return total_spaces - (n - 2) - min(front_space, back_space)

def get_min(cows, n):
    # Weird sliding window
    if (cows[-2] - cows[0] + 1 == n - 1 and cows[-1] - cows[-2] > 2) or\
       (cows[-1] - cows[1] + 1 == n - 1 and cows[1] - cows[0] > 2):
        return 2

    most_cows = 0
    has_changed = False
    for i in range(n):
        for j in range(i + 1, n):
            spaces_taken = cows[j] - cows[i] + 1
            if spaces_taken <= n:
                has_changed = True
                most_cows = max(most_cows, j - i + 1)
            else:
                break

    if not has_changed:
        most_cows = 1
    return n - most_cows

f = open('herding.in', 'r')
data = f.readlines()
for i in range(len(data) - 1):
    data[i] = tuple(int(j) for j in data[i][:-1].split(" "))

data[len(data) - 1] = tuple(int(j) for j in data[i + 1].split(" "))

print(data)

n, = data[0]
cows = [i[0] for i in data[1:n+1]]
cows.sort()

min_moves = get_min(cows, n)
max_moves = get_max(cows, n)

f = open("herding.out", "w+")
f.write(str(min_moves) + "\n" + str(max_moves))
f.close()