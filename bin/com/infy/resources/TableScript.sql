DROP TABLE mobile CASCADE CONSTRAINTS;
DROP TABLE app CASCADE CONSTRAINTS;
DROP TABLE MobileApp CASCADE CONSTRAINTS;


CREATE TABLE mobile (
IMEINumber NUMBER(38) CONSTRAINT pkey_mobile PRIMARY KEY,
mobileOS VARCHAR2(30),
mobileUserType CHAR,
appsCount NUMBER
);

CREATE TABLE app(
appName VARCHAR2(30) CONSTRAINT pkey_app PRIMARY KEY,
spaceRequiredInMB NUMBER,
appSuitableFor CHAR
);

CREATE TABLE MobileApp(
IMEINumber NUMBER CONSTRAINT Mobile_FK1 REFERENCES Mobile(IMEINumber),
appName VARCHAR2(30) CONSTRAINT App_FK1 REFERENCES app(appName),
CONSTRAINT MobileAppPK1 PRIMARY KEY(IMEINumber,appName)
);


INSERT INTO mobile VALUES(356938035643809,'Android','T',1);
INSERT INTO mobile VALUES(243456778787864,'BlackBerry','E',2);
INSERT INTO mobile VALUES(454546787988896,'Android','E',2);
INSERT INTO mobile VALUES(232328989898898,'BlackBerry','E',1);

INSERT INTO app VALUES('Yammer',30,'E');
INSERT INTO app VALUES('MyNinja',25,'B');
INSERT INTO app VALUES('MyTraining',20,'T');
INSERT INTO app VALUES('WorxMail',50,'E');


INSERT INTO MobileApp VALUES(356938035643809,'MyTraining');
INSERT INTO MobileApp VALUES(243456778787864,'Yammer');
INSERT INTO MobileApp VALUES(243456778787864,'WorxMail');
INSERT INTO MobileApp VALUES(356938035643809,'MyNinja');
INSERT INTO MobileApp VALUES(454546787988896,'WorxMail');
INSERT INTO MobileApp VALUES(454546787988896,'Yammer');
INSERT INTO MobileApp VALUES(232328989898898,'WorxMail');

COMMIT;

SELECT * FROM Mobile;
SELECT * FROM App;
SELECT * FROM MobileApp;