-- 국내, 반값택배 예약 (비회원)
CREATE TABLE Rv_H_D_nMem_PdInfo(
    id NUMBER PRIMARY Key,
    selProd varchar2(50) CONSTRAINT Rv_H_D_nMem_PdInfo_selProd_ck 
                            check(selProd IN('의류','서신/서류','가전제품류','과일류','곡물류','한약류','식품류','잡화/서적')),
    priceProd NUMBER NOT NULL,
    properties varchar2(100) NOT NULL
);
CREATE TABLE Rv_H_D_nMem_sender(
    id NUMBER PRIMARY Key,
    sname varchar2(50) NOT NULL,
    PhoneNum varchar2(50) NOT NULL,
    rvnumPHnum varchar2(50) NOT NULL,
    addr varchar2(100) NOT NULL,
    passwd varchar2(50) NOT NULL
);
CREATE TABLE Rv_H_D_nMem_recip(
    id NUMBER PRIMARY Key,
    rname varchar2(50) NOT NULL,
    phoneNum varchar2(50) NOT NULL,
    addr varchar2(100) NOT NULL,
    request varchar2(100),
    payment varchar2(50) CONSTRAINT Rv_H_D_nMem_recip_payment_ck 
                            check(payment IN('선불','착불'))
);

-- 국내, 반값택배 예약 (회원)
CREATE TABLE Rv_H_D_Mem_PdInfo(
    id NUMBER PRIMARY Key,
    selProd varchar2(50) CONSTRAINT Rv_H_D_Mem_PdInfo_selProd_ck 
                            check(selProd IN('의류','서신/서류','가전제품류','과일류','곡물류','한약류','식품류','잡화/서적')),
    priceProd NUMBER NOT NULL,
    properties varchar2(100) NOT NULL
);
CREATE TABLE Rv_H_D_Mem_sender(
    id NUMBER PRIMARY Key,
    sname varchar2(50) NOT NULL,
    PhoneNum varchar2(50) NOT NULL,
    addr varchar2(100) NOT NULL
);
CREATE TABLE Rv_H_D_Memb_recip(
    id NUMBER PRIMARY Key,
    rname varchar2(50) NOT NULL,
    phoneNum varchar2(50) NOT NULL,
    subPhoneNum varchar2(50),
    addr varchar2(100) NOT NULL,
    request varchar2(100),
    payment varchar2(50) CONSTRAINT Rv_H_D_Memb_recip_payment_ck 
                            check(payment IN('선불','착불'))
);
-- 1
INSERT INTO Rv_H_D_Mem_PdInfo values(1, '가전제품류', 300000, '중고거래');
INSERT INTO Rv_H_D_Mem_sender values(1, '홍길동', '010-1111-2222', '서울 강남구');
INSERT  INTO Rv_H_D_Memb_recip values(1, '김범수', '010-1212-1313', NULL, '서울 강북구', '문앞에 두고가주세요', '선불');
-- 2
INSERT INTO Rv_H_D_Mem_PdInfo values(2, '과일류', 50000, '선물');
INSERT INTO Rv_H_D_Mem_sender values(2, '김길동', '010-2222-3333', '강원도 춘천시');
INSERT  INTO Rv_H_D_Memb_recip values(2, '박효신', '010-2545-1233', NULL, '서울 서초구', '부재시 연락주세요', '착불');
-- 3
INSERT INTO Rv_H_D_Mem_PdInfo values(3, '잡화/서적', 300000, '중고거래');
INSERT INTO Rv_H_D_Mem_sender values(3, '이길동', '010-3333-4444', '경기도 남양주시');
INSERT  INTO Rv_H_D_Memb_recip values(3, '아이유', '010-5464-3452', NULL, '강원도 강릉시', null, '선불');

SELECT selProd, priceProd, properties, 
        sname, s.PhoneNum, s.addr, 
        rname, r.phoneNum, subPhoneNum, r.addr, request, payment
FROM Rv_H_D_Mem_PdInfo p, Rv_H_D_Mem_sender s, Rv_H_D_Memb_recip r
WHERE p.id = s.id AND p.id = r.id;


-- 국제 택배 예약
CREATE TABLE Rv_Inter_PdInfo(
    id NUMBER PRIMARY Key,
    properties varchar2(100) NOT NULL,
    division varchar2(50) CONSTRAINT Rv_Inter_PdInfo_division_ck 
                            check(division IN('비서류','서류')),
    selCourier varchar2(50) CONSTRAINT Rv_Inter_PdInfo_selCourier_ck 
                            check(selCourier IN('SF','EMS', 'DHL'))
);
CREATE TABLE Rv_Inter_sender(
    id NUMBER PRIMARY Key,
    sname varchar2(50) NOT NULL,
    PhoneNum varchar2(50) NOT NULL,
    addr varchar2(100) NOT NULL
);
CREATE TABLE Rv_Inter_recipient(
    id NUMBER PRIMARY Key,
    rname varchar2(50) NOT NULL,
    phoneNum varchar2(50) NOT NULL,
    country varchar2(50) NOT NULL,
    zipcode NUMBER NOT NULL,
    address1 varchar2(100),
    address2 varchar2(100)
);
CREATE TABLE Rv_Inter_declaration(
    id NUMBER PRIMARY Key,
    contents varchar2(50) NOT NULL,
    quantity NUMBER NOT NULL,
    HSCODE varchar2(50),
    placeProd varchar2(50) NOT NULL,
    priceProd NUMBER NOT NULL
);
-- 1
INSERT INTO Rv_Inter_PdInfo values(1, '선물', '비서류', 'DHL');
INSERT INTO Rv_Inter_sender values(1, '김태형', '010-1234-4564', '대한민국 서울');
INSERT INTO Rv_Inter_recipient values(1, '김현수', '010-2233-5467', '중국', 23403, '베이징', null);
INSERT INTO Rv_Inter_declaration values(1, 'meat', 3, null, '대한민국', 120000);
-- 2
INSERT INTO Rv_Inter_PdInfo values(2, '문서', '서류', 'EMS');
INSERT INTO Rv_Inter_sender values(2, '박경완', '010-7373-1209', '대한민국 인천');
INSERT INTO Rv_Inter_recipient values(2, '양의지', '010-2364-1029', '베트남', 120938, '하노이', null);
INSERT INTO Rv_Inter_declaration values(2, 'paper', 10, 1, '일본', 4000);
-- 3
INSERT INTO Rv_Inter_PdInfo values(3, '배대지', '비서류', 'SF');
INSERT INTO Rv_Inter_sender values(3, '선동열', '010-3426-4823', '대한민국 광주');
INSERT INTO Rv_Inter_recipient values(3, '이용찬', '010-1238-3457', '미국', 1363, '뉴욕', '멘헤튼');
INSERT INTO Rv_Inter_declaration values(3, 'mobile', 1, 123, '대한민국', 1290000);

SELECT properties, division, selCourier, 
        sname, s.PhoneNum, country, zipcode, address1, address2,
        division, contents, quantity, HSCODE, placeProd, priceProd
FROM Rv_Inter_PdInfo p, Rv_Inter_sender s, Rv_Inter_recipient r, Rv_Inter_declaration d
WHERE s.id = p.id AND s.id = r.id AND s.id = d.id;