/*
# 데이터베이스 보안을 위한 권한 설정
1. 데이터베이스 관리자(DBA)는 사용자가 데이터베이스 객체(테이블, view, sequence)에 대한 특정
    권한을 가질수 있게 하여, 다수의 사용자가 데이터베이스에 저장된 정보를 공유하면서 정보에 대한 보안이
    이루어 지도록 한다.
2. DB 서버에 접근시 필요한 사용자 계정/암호를 통해 로그인 인증을 받는다.
3. 권한의 역할과 종류
    1) create user : 사용자를 새롭게 생성하는 권한
    2) drop user : 사용자를 삭제하는 권한
    3) drop any table : 테이블을 삭제하는 권한
    4) query rewrite : 함수 기반 인덱스 생성 권한
    5) backup any table : 테이블 백업 권한
    6) create session : 데이터베이스에 접속할 수 있는 권한
    7) create table/view/sequence/procedure 데이터베이스의 객체들을 생성하는 권한
    8) resource : 여러 객체들을 생성/사용 가능한 권한
    9) dba : 관리자 권한으로 계정을 생성하고, 권한을 부여할 수 있는 권한
*/
/*
# 사용자 생성하기
1. system 관리자 계정으로 접근하여 scott에 dba 권한을 부여하여
    계정 생성과 권한 부여가 가능하게 하여야 한다.
2. 권한 부여
    cmd
    sqlplus
    system/1111
    grant dba to scott;
3. 사용자 생성
    create user 사용자명 identified by 비밀번호;
4. 권한 부여
    grant 권한명 to 계정명
    create session - 접속 권한
*/
CREATE USER orauser100 identified by user100;
GRANT CREATE SESSION TO orauser100;
/*
ex)orauser200/user200으로 계정과 비밀번호를 선언하여 계정을 생성하고,
해당 계정에 접근 권한을 주고 접근하세요.
cmd 창에서 실행하세요.
1) dba 권한이 필요하다.
    - system계정으로 해당 계정을 만들거나
    - system계정에서 현재 접속 중에 scott계정에 dba 권한을 줘야한다.
        grant dba to scott
2) 계정 생성
    create user orauser200 identified by user200;
3) 접속 권한 처리
    grant create session to orauser200;

# 특정한 사용자의 테이블(자원)을 사용하는 권한 처리
1. 계정생성과 함께 접속, 자원 사용 권한 설정
    1) 기본 형식
    grant 권한1, 권한2, 권한3... to 사용자 identified by 계정명
    2) 실습 예제
    grant connect, resource, unlimited tablespace to scott;
        connect : 접속 권한
        resource : 자원에 대한 설정 권한
        unlimited tablespace : 실제 저장할 물리적 테이블 저장 공간에 대한 용량 제한 없이 설정
*/
GRANT CONNECT, resource, unlimited tablespace TO himan100 identified by 8888;