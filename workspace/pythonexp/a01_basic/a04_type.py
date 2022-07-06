'''
Created on 2022. 7. 5.

@author: kideokkim
# 데이터형
1. 변수나 상수의 종류를 의미함
2. 파이썬의 기본 데이터 유형 : 데이터 유형 확인 type() 함수
    1) 정수형
    2) 실수형
    3) 문자열형
    4) boolean형
'''
num01 = 25
num02 = 30
str01 = '안녕하세요'
bool01 = num01>=num02
print("데이터:",num01,", 유형:",type(num01))
print("데이터:",num02,", 유형:",type(num02))
print("데이터:",str01,", 유형:",type(str01))
print("데이터:",bool01,", 유형:",type(bool01))
'''
# 문자열 데이터
1. 큰따옴표나 작은 따옴표로 데이터를 설정할 수 있다.
2. 여러줄 문자열 데이터 선언은 큰따옴표, 작은 따옴표로 여러 라인에
    걸쳐 선언하여 사용할 수 있다.
'''
str02 = "반갑습니다."
str03 = '''
나보기가
역겨워 가실 때에는
죽어도 눈물
아니 흘리오리다!!
'''
print(str03)
str04="나보기가\n역겨워 가실 때에는\n죽어도 눈물\n아니 흘리오리다!!"
print(str04)
'''
3. 문자열 반복처리 연산자 *
    "문자열" 반복할 횟수
'''
print("안녕하세요!!"*10)
# ex) '''를 활용하여 물건명 가격 갯수 정보 3개를 리스트하게 처리하세요
#     \n\t를 활용하여 위 정보를 출력하세요
pdInfo1 = '''
연필    1200    12
지우개   500     3
샤프    3000    1
'''
pdInfo2 = "연필\t1200\t12"
pdInfo2 += "\n지우개\t500\t3"
pdInfo2 += "\n샤프\t3000\t1"
print(pdInfo1)
print(pdInfo2)
'''
4. 여러가지 문자열 지원함수
    1) len(문자열변수) : 문자열 길이 리턴
    2) count("찾을문자열") : 해당 문자열을 통해서 검색되는 문자열의 갯수
'''
str07="오라클 자바 파이썬 오라클 자바 파이썬 자바 파이썬"
print("문자열의 길이 : ", len(str07))
print("파이썬의 갯수 : ", str07.count("파이썬"))
'''
5. 문자열의 위치값으로 리턴
    1) 파이썬은 문자배열이라는 개념으로 문자열 데이터의 index로 접근하여 가져올 수 있다.
    2) 시작index:마지막순서      로 특정 문자열의 위치 범위의 데이터를 추출할 수 있다,
        0부터   1부터
'''
print(str07[0])
print(str07[1])
print(str07[2])
print(str07[3])
print(str07[4])
print("str07[0:5]", str07[0:5])
# ex) 글자를 5자로 입력받아서 문자열이 거꾸로 만들어 출력되게 처리하세요.
#    hello ==> olleh, 안녕하세요 ==> 요세하녕안
strhello = 'hello'
print(strhello[4],strhello[3],strhello[2],strhello[1],strhello[0])
strAn = '안녕하세요'
print(strAn[4],strAn[3],strAn[2],strAn[1],strAn[0])
str08 = input("5자의 문자열을 입력 : ")
print(str08[4],str08[3],str08[2],str08[1],str08[0])
str09Rev = str08[-1] # -1 : 마지막 문자열 추출
print("Reverse 문자열 : ",str09Rev)