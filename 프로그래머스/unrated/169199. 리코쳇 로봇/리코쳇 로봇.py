from collections import deque

def solution(board):
    answer = 0
    bfs_queue = deque()
    for x, row in enumerate(board):
        for y, point in enumerate(row):
            if point == 'R':
                bfs_queue.append((x, y, 0))

    visited = set()
    while bfs_queue:
        x, y, dist = bfs_queue.popleft()
        if (x, y) in visited:
            continue
        if board[x][y] == 'G':
            return dist
        visited.add((x, y))
        for mv_x, mv_y in ((0, 1), (1, 0), (0, -1), (-1, 0)):
            cur_x, cur_y = x, y
            while True:
                next_x, next_y = cur_x + mv_x, cur_y + mv_y
                if 0 <= next_x < len(board) and 0 <= next_y < len(board[0]) and board[next_x][next_y] != 'D':
                    cur_x, cur_y = next_x, next_y
                    continue
                bfs_queue.append((cur_x, cur_y, dist + 1))
                break
    return -1