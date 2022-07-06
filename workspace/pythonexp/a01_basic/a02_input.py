'''
Created on 2022. 7. 5.

@author: kideokkim
# input 함수
1. 입력값을 console에서 받아서 처리할 때, 사용
2. 기본적으로 문자열 데이터를 입력받는다.
    - 숫자형을 사용할 경우, int(), float()를 이중 함수로 이용해서 형변환하여 처리한다.
3. 메시지를 포함시켜 입력할 때는 input("메시지")를 활용한다.
'''
# instr1 = input()
# print("입략된 문자:", instr1)
'''
instr2 = input("이름을 입력하세요=>")
print("이름:",instr2)
inNum01 = int(input("첫번째 숫자 입력:"))
inNum02 = int(input("두번째 숫자 입력:"))
print(inNum01," + ",inNum02," = ", inNum01+inNum02)
'''
# ex)
exp1 = input("지출 금액(1)을 입력하세요 : ")
exp2 = input("지출 금액(2)을 입력하세요 : ")
exp3 = input("지출 금액(3)을 입력하세요 : ")
sum1 = (int)(exp1)+(int)(exp2)+(int)(exp3)
print("총 지출 금액 : ", sum1)
