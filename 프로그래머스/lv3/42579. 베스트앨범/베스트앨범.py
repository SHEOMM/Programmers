def solution(genres, plays):
    answer = []
    dicts = {}
    most_dicts = {}
    num = 0
    for genre, play in zip(genres, plays):
        if genre in dicts:
            dicts[genre].append([num, play])
            most_dicts[genre] += play
        else:
            dicts[genre] = []
            most_dicts[genre] = play
            dicts[genre].append([num, play])
        num += 1
    
    sorted_most = sorted(most_dicts.items(), key = lambda x: x[1], reverse = True)
    new_dicts = {}
    for key in dicts:
        sorted_value = sorted(dicts[key], key = lambda x: (x[1], -x[0]), reverse = True)
        new_dicts[key] = sorted_value

    
    for most in sorted_most:
        num = 0
        for value in new_dicts[most[0]]:
            answer.append(value[0])
            num += 1
            if num == 2:
                break
            
    return answer