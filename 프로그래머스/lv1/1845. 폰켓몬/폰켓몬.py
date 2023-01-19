def solution(nums):
    answer = 0
    dict1 = {}
    for num in nums:
        if num not in dict1:
            dict1[num] = 1
    
    answer = len(dict1)
    
    if len(dict1) > len(nums)/2 :
        answer = len(nums)/2
    
    return answer