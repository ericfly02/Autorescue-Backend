SET search_path = hESbst_base;

-- ESTAT
INSERT INTO ESTAT (CODE, CREATE_DATE, CREATE_USER)
VALUES
       ('ACC', CURRENT_TIMESTAMP, 'admin'),
       ('REF', CURRENT_TIMESTAMP, 'admin'),
	   ('REV', CURRENT_TIMESTAMP, 'admin'),
	   ('DESC', CURRENT_TIMESTAMP, 'admin'),
	   ('PND', CURRENT_TIMESTAMP, 'admin');
	   
INSERT INTO ESTAT_LANGUAGE(REF_ID, LANGUAGE_CODE, DESCRIPTION, CREATE_DATE, CREATE_USER, UPDATE_DATE, UPDATE_USER)
VALUES
	((SELECT ID FROM ESTAT WHERE CODE = 'ACC') ,'ES', 'Acceptat', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM ESTAT WHERE CODE = 'ACC') ,'CA', 'Acceptat', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM ESTAT WHERE CODE = 'ACC') ,'EN', 'Acceptat', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM ESTAT WHERE CODE = 'REF') ,'ES', 'Refusat', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM ESTAT WHERE CODE = 'REF') ,'CA', 'Refusat', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM ESTAT WHERE CODE = 'REF') ,'EN', 'Refusat', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM ESTAT WHERE CODE = 'REV') ,'ES', 'RevoCAt', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM ESTAT WHERE CODE = 'REV') ,'CA', 'RevoCAt', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM ESTAT WHERE CODE = 'REV') ,'EN', 'RevoCAt', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM ESTAT WHERE CODE = 'DESC') ,'ES', 'DESC', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM ESTAT WHERE CODE = 'DESC') ,'CA', 'DESC', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM ESTAT WHERE CODE = 'DESC') ,'EN', 'DESC', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM ESTAT WHERE CODE = 'PND') ,'ES', 'Pendent de signar', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM ESTAT WHERE CODE = 'PND') ,'CA', 'Pendent de signar', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM ESTAT WHERE CODE = 'PND') ,'EN', 'Pendent de signar', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM');

-- DOCUMENT_TIPUS
INSERT INTO DOCUMENT_TIPUS (CODE, CREATE_DATE, CREATE_USER)
VALUES
       ('DIG', CURRENT_TIMESTAMP, 'admin'),
       ('ESC', CURRENT_TIMESTAMP, 'admin');
	   
INSERT INTO DOCUMENT_TIPUS_LANGUAGE(REF_ID, LANGUAGE_CODE, DESCRIPTION, CREATE_DATE, CREATE_USER, UPDATE_DATE, UPDATE_USER)
VALUES
	((SELECT ID FROM DOCUMENT_TIPUS WHERE CODE = 'DIG') ,'ES', 'Digital', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM DOCUMENT_TIPUS WHERE CODE = 'DIG') ,'CA', 'Digital', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM DOCUMENT_TIPUS WHERE CODE = 'DIG') ,'EN', 'Digital', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM DOCUMENT_TIPUS WHERE CODE = 'ESC') ,'ES', 'ESCAnejat', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM DOCUMENT_TIPUS WHERE CODE = 'ESC') ,'CA', 'ESCAnejat', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM DOCUMENT_TIPUS WHERE CODE = 'ESC') ,'EN', 'ESCAnejat', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM');
	
-- IDENTIFICACIO TIPUS
INSERT INTO IDENTIFICACIO_TIPUS (CODE, CREATE_DATE, CREATE_USER)
VALUES
       ('DNI', CURRENT_TIMESTAMP, 'admin'),
       ('NIE', CURRENT_TIMESTAMP, 'admin'),
       ('PASS', CURRENT_TIMESTAMP, 'admin'),
       ('CIP', CURRENT_TIMESTAMP, 'admin');
	   
INSERT INTO IDENTIFICACIO_TIPUS_LANGUAGE(REF_ID, LANGUAGE_CODE, DESCRIPTION, CREATE_DATE, CREATE_USER, UPDATE_DATE, UPDATE_USER)
VALUES
	((SELECT ID FROM IDENTIFICACIO_TIPUS WHERE CODE = 'DNI') ,'ES', 'Document nacional d''identitat', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM IDENTIFICACIO_TIPUS WHERE CODE = 'DNI') ,'CA', 'Document nacional d''identitat', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM IDENTIFICACIO_TIPUS WHERE CODE = 'DNI') ,'EN', 'Document nacional d''identitat', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM IDENTIFICACIO_TIPUS WHERE CODE = 'NIE') ,'ES', 'Número d''identitat d''EStranger', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM IDENTIFICACIO_TIPUS WHERE CODE = 'NIE') ,'CA', 'Número d''identitat d''EStranger', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM IDENTIFICACIO_TIPUS WHERE CODE = 'NIE') ,'EN', 'Número d''identitat d''EStranger', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM IDENTIFICACIO_TIPUS WHERE CODE = 'PASS') ,'ES', 'Passaport', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM IDENTIFICACIO_TIPUS WHERE CODE = 'PASS') ,'CA', 'Passaport', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM IDENTIFICACIO_TIPUS WHERE CODE = 'PASS') ,'EN', 'Passaport', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM IDENTIFICACIO_TIPUS WHERE CODE = 'CIP') ,'ES', 'CIP', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM IDENTIFICACIO_TIPUS WHERE CODE = 'CIP') ,'CA', 'CIP', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM IDENTIFICACIO_TIPUS WHERE CODE = 'CIP') ,'EN', 'CIP', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM');

-- SIGNATARI TIPUS
INSERT INTO SIGNATARI_TIPUS (CODE, CREATE_DATE, CREATE_USER)
VALUES
       ('TEST', CURRENT_TIMESTAMP, 'admin');
	   
INSERT INTO SIGNATARI_TIPUS_LANGUAGE(REF_ID, LANGUAGE_CODE, DESCRIPTION, CREATE_DATE, CREATE_USER, UPDATE_DATE, UPDATE_USER)
VALUES
	((SELECT ID FROM SIGNATARI_TIPUS WHERE CODE = 'TEST') ,'ES', 'TESt', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM SIGNATARI_TIPUS WHERE CODE = 'TEST') ,'CA', 'TESt', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM'),
	((SELECT ID FROM SIGNATARI_TIPUS WHERE CODE = 'TEST') ,'EN', 'TESt', CURRENT_DATE, 'SYSTEM', CURRENT_DATE, 'SYSTEM');