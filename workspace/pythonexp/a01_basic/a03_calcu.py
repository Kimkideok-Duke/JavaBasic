'''
Created on 2022. 7. 5.

@author: kideokkim

# 파이썬 특징 연산자
1. / : 소숫점 이하까지 표현
2. // : 소숫점 이하 절삭
3. ** : 변수의 제곱 처리
'''
num01 = 10
num02 = 3
print(num01/num02)
print(num01//num02)
print(num01**num02)

# ex) 곰돌이 세마리가 빵 20개를 동일하게 배분하여 먹은 빵의 갯수와 남은 빵의 갯수를 변수와
#   연산자를 통해서 출력하세요
bear = 3
bread = 20
print("동일하게 먹은 빵의 갯수:",bread//bear)
print("남은 빵의 갯수:",bread%bear)
'''
# 비교 연산자
1. 어떤것이 큰지, 작은지, 같은지를 비교하는 연산자
    ==, !=, <=, >=, <, >
# 논리 연산자
1. 비교 연산자가 여러번 필요할 때 사용
2. and, or, not
    ex) 나이가 10이상 18미만 청소년 요금제 적용
'''
age = 5
isPayCal = age>=10 and age<18
print("나이:",age)
print("청소년 요금제 적용 여부:",isPayCal)

# ex) 구매가격과 갯수를 입력받아 1000000 이상이면 MVP 고객이다.
#     MVP 고객 (True/False)여부를 출력하세요
inPrice = input("구매 가격을 입력하세요 : ")
inCnt = input("갯수를 입력하세요 : ")
sum2 = (int)(inPrice) * (int)(inCnt)
isMVP = sum2 >= 1000000
print("구매가격 : ",inPrice,", 갯수:",inCnt,", 총합:",sum2)
print("MVP회원 여부 :",isMVP)