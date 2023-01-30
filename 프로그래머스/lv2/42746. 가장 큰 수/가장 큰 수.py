def solution(numbers):
    input_list = list(map(str, numbers))
    input_list.sort(key = lambda x: x*3, reverse = True)
    return str(int(''.join(input_list)))