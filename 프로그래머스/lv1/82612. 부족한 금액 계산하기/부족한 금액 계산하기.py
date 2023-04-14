def solution(price, money, count):
    answer = -1
    total = count * (price + count * price)
    total_price = total/2
    left_money = money - total_price
    if left_money > 0:
        return 0
    return -left_money
    return answer