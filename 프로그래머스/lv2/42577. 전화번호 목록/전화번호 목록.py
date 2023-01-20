def solution(phone_book):
    prefix_dict = {}
    answer = True
    for phone_num in phone_book:
        prefix_dict[phone_num] = 1
        
    for phone_num in phone_book:
        prefix = ""
        for num in phone_num:
            prefix += num
            if prefix in prefix_dict and prefix != phone_num:
                return False
    return answer