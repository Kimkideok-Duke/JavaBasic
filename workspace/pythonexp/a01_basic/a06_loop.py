'''
Created on 2022. 7. 5.

@author: kideokkim

# for 문의 형식
1. for 변수 in range(시작값, 끝값+1, 중간값):
        변수
'''
for idx in range(3):    # range(마지막값+1) : 0부터 마지막+1
    print(idx, "번째 안녕하세요")
for cnt in range(1,4): # 1부터 ~ 3+1
    print(cnt,"번째 반갑습니다")
for cnt in range(10,20,2):
    print(cnt,",",end="\t") # end : 출력시 마지막에 기본 줄바꿈 외에 다른 문자열 처리시