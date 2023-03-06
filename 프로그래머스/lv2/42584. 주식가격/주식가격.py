def solution(prices):
    answer = []
    for i in range (len(prices)):
        num = 0
        for j in range (i + 1, len(prices)):
            num += 1
            if prices[i] > prices[j]:
                break
        answer.append(num)
    return answer