-- 국내, 반값택배 예약 (비회원)
CREATE TABLE Rv_Half_Dome_nonMember_ProdInfo(
    selProd varchar2(50) CONSTRAINT Rv_Half_Dome_nonMember_ProdInfo_selProd_ck check(selProd IN('의류','서신/서류','가전제품류','과일류','곡물류','한약류','식품류','잡화/서적')),
    priceProd NUMBER NOT NULL,
    properties varchar2(100) NOT NULL
);
CREATE TABLE Rv_Half_Dome_nonMember_sender(
    sname varchar2(50) NOT NULL,
    PhoneNum char(13) NOT NULL,
    rvnumPHnum char(13) NOT NULL,
    addr varchar2(100) NOT NULL,
    passwd varchar2(50) NOT NULL
);
CREATE TABLE Rv_Half_Dome_nonMember_recipient(
    rname varchar2(50) NOT NULL,
    PhoneNum char(13) NOT NULL,
    addr varchar2(100) NOT NULL,
    request varchar2(100),
    payment varchar2(50) CONSTRAINT Rv_Half_Dome_nonMember_recipient_payment_ck check(payment IN('선불','착불'))
);

-- 국내, 반값택배 예약 (회원)
CREATE TABLE Rv_Half_Dome_Member_ProdInfo(
    selProd varchar2(50) CONSTRAINT Rv_Half_Dome_Member_ProdInfo_selProd_ck check(selProd IN('의류','서신/서류','가전제품류','과일류','곡물류','한약류','식품류','잡화/서적')),
    priceProd NUMBER NOT NULL,
    properties varchar2(100) NOT NULL
);
CREATE TABLE Rv_Half_Dome_Member_sender(
    sname varchar2(50) NOT NULL,
    PhoneNum char(13) NOT NULL,
    addr varchar2(100) NOT NULL
);
CREATE TABLE Rv_Half_Dome_Member_recipient(
    rname varchar2(50) NOT NULL,
    PhoneNum char(13) NOT NULL,
    subPhoneNum varchar2(50),
    addr varchar2(100) NOT NULL,
    request varchar2(100),
    payment varchar2(50) CONSTRAINT Rv_Half_Dome_Member_recipient_payment_ck check(payment IN('선불','착불'))
);

-- 국제 택배 예약
CREATE TABLE Rv_Inter_ProdInfo(
    properties varchar2(100) NOT NULL
    division varchar2(50) CONSTRAINT Rv_Inter_ProdInfo_division_ck check(division IN('비서류','서류')),
    selCourier varchar2(50) CONSTRAINT Rv_Inter_ProdInfo_selCourier_ck check(selCourier IN('SF','EMS', 'DHL'))
);
CREATE TABLE Rv_Inter_sender(
    sname varchar2(50) NOT NULL,
    PhoneNum char(13) NOT NULL,
    addr varchar2(100) NOT NULL
);
CREATE TABLE Rv_Inter_recipient(
    rname varchar2(50) NOT NULL,
    PhoneNum varchar2(50) NOT NULL,
    country varchar2(50) NOT NULL,
    zipcode NUMBER NOT NULL,
    address1 varchar2(100),
    address1 varchar2(100)
);
CREATE TABLE Rv_Inter_declaration(
    division varchar2(50),
    contents varchar2(50) NOT NULL,
    quantity NUMBER NOT NULL,
    HSCODE varchar2(50),
    placeProd varchar2(50) NOT NULL,
    priceProd NUMBER NOT NULL
);