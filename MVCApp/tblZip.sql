CREATE TABLE tblzip(
	zipcode		varchar2(10),
	sido			varchar2(10),
	gugun		varchar2(30),
	dong			varchar2(70),
	bunji			varchar2(30)
);

select *from tblzip;

-- SQL   Loder(sqlldr.exe)
--��Ʈ�� ���� �ۼ�(.ctl) ���� �о� ���� ������ ��� �̸����� ��ʵ忡 ������� �˷���
/*
LOAD DATA
INFILE zipcode.csv
INTO TABLE tblzip INSERT
FIELDS TERMINATED BY ','
(zipcode,sido,gugun,dong,bunji)
*/
--sqlldr control=zipcode.ctl userid=scott/1111@orcl
select count(*) from tblzip;
where dong like '%����%';
/*
 * mysql
 * ------
 * load ��ɾ�
 * LOAD DATA
 * LOCAL INFILE 'D:\samson\download\zipcode_20130201(1)\zipcode.csv'
 * INTO TABLE tblzip(zipcode,sido,gugun,dong,bunji);
 */
