
 drop database if exists policlinica;
 
 create database if not exists policlinica;
 use policlinica;

 drop table if exists asistent_medical;
 drop table if exists competenta;
 drop table if exists departament;
 drop table if exists expert_financiar_contabil;
 drop table if exists functie;
 drop table if exists inspector_financiar_contabil;
 drop table if exists functie; 
 drop table if exists inspector_resurse_umane;
 drop table if exists investigatii;
 drop table if exists medic;
 drop table if exists orar_generic;
 drop table if exists orar_medic;
 drop table if exists pacienti;
 drop table if exists program;
 drop table if exists programare;
 drop table if exists raport;
 drop table if exists receptioner;
 drop table if exists servicii_programare;
 drop table if exists specialitatea;
 drop table if exists tip_utilizator;
 drop table if exists utilizator;
 drop table if exists unitate_medicala;


create table unitate_medic
(id int unique not null primary key auto_increment,
cnp_medicul varchar(14),
id_unitate_medicala int);


create table  unitate_medicala
(id int not null primary key auto_increment,
denumire varchar(30),
adresa varchar(50),
profitul float(10,5),
cheltuieli float(10,5)
);

create table program
(nume_zi varchar(10) not null primary key,
zi_lucratoare bool,
ora_inceput time,
ora_sfarsit time
);

 create table tip_utilizator
(id int not null primary key,
denumire_tip varchar(30)
);

create table departament
(id_departament int not null primary key,
nume_departament varchar(30)
);

create table utilizator
(id int not null primary key auto_increment,
cnp varchar(14) not null,
id_tip_utilizator int,
id_departament int,
id_functie int,
id_unitate_medicala int,
nume varchar(30),
prenume varchar(30),
adresa varchar(50),
nr_telefon varchar(10),
email varchar(50),
parola varchar(30),
IBAN varchar(30),
nr_contract varchar(10),
data_angajarii date,
salariu_negociat float(20,5),
nr_ore int
);

drop table if exists servicii;

 create table servicii
(id_serviciu int not null primary key,
denumire_serviciu varchar(50),
id_specialitate int,
durata_min int,
pret int
);

create table inspector_resurse_umane
(cnp_inspector varchar(14) not null primary key,
id_functie int
);

 create table if not exists functie
(id_functie int not null primary key auto_increment,
denumire_functie varchar(30)
);

 create table expert_financiar_contabil
(cnp_contabil  varchar(14) not null primary key,
id_functie int
);

create table specialitatea
(id_specialitate int not null primary key auto_increment,
denumire_specialitate varchar(50)
);

create table competenta
(id_competenta int unique not null primary key auto_increment,
tip_competenta varchar(50),
id_specialitate int
);

create table servicii_programare
(idP int not null primary key auto_increment,
id_programare int,
id_serviciu int
);

create table orar_generic
(id_orar_generic int primary key,
 id int,
data_inceput_concediu date,
data_sfarsit_concediu date
);

create table receptioner
(cnp_receptioner varchar(14) not null primary key ,
id_functie int
);

create table asistent_medical
(cnp_asistent varchar(14) not null primary key ,
id_functie int,
tip varchar(20),
grad varchar(10)
);

drop table if exists medic;

create table medic
(cnp_medic varchar(14) not null primary key,
id_functie int,
id_specialitate int,
grad varchar(15),
cod_parafa varchar(30),
titlu_stiintific varchar(30),
post_didactic varchar(30),
procent_aditional float(10,5)
);

create table raport
(id_raport int not null primary key auto_increment,
id_pacient int,
cnp_medic varchar(14) ,
cnp_asistent varchar(14),
id_programare int unique not null,
rezultat enum('pozitiv','negativ'),
diagnostic varchar(30),
simptome varchar(100),
recomandari varchar(100),
id_investigatie int,
nume_medic varchar(30),
prenume_medic varchar(30),
nume_asistent varchar(30),
prenume_asistent varchar(30),
dataRap date
);

 create table pacienti
(id_pacient int not null primary key auto_increment,
cnp varchar(14),
nume varchar(30),
prenume varchar(30)
);

 create table programare
(id_programare int unique not null primary key auto_increment,
id_pacient int,
cnp_medic varchar(14),
data_programare date,
ora_programare time,
durata int,
id_unitate_medicala int
);

 create table investigatii
(id_investigatii int not null primary key auto_increment,
concluzie varchar(100),
id_raport int
);




 alter table programare
add foreign key(id_unitate_medicala) references unitate_medicala(id);
alter table utilizator
add foreign key(id_departament) references departament(id_departament);
alter table utilizator
add foreign key(id_tip_utilizator) references tip_utilizator(id);
 alter table orar_generic
add foreign key(id) references utilizator(id); ####
 alter table utilizator
add foreign key(id_functie) references functie(id_functie);
alter table servicii
add foreign key(id_specialitate) references specialitatea(id_specialitate);
alter table servicii_programare
add foreign key(id_serviciu) references servicii(id_serviciu);
 alter table servicii_programare
add foreign key(id_programare) references programare(id_programare);
 alter table medic
add foreign key(id_specialitate) references specialitatea(id_specialitate);
 alter table competenta
add foreign key(id_specialitate) references specialitatea(id_specialitate);
 alter table inspector_resurse_umane
add foreign key(id_functie) references functie(id_functie);
alter table receptioner
add foreign key(id_functie) references functie(id_functie);
 alter table asistent_medical
add foreign key(id_functie) references functie(id_functie);
alter table medic
add foreign key(id_functie) references functie(id_functie);
alter table expert_financiar_contabil
add foreign key(id_functie) references functie(id_functie);
alter table raport
add foreign key(cnp_asistent) references asistent_medical(cnp_asistent);
 alter table raport
add foreign key(id_investigatie) references investigatii(id_investigatii);
alter table programare
add foreign key(cnp_medic) references medic(cnp_medic);
 alter table programare
add foreign key(id_pacient) references pacienti(id_pacient);
alter table raport
add foreign key(id_programare) references programare(id_programare);
alter table utilizator
add foreign key(id_unitate_medicala) references unitate_medicala(id);
alter table unitate_medic
add foreign key(cnp_medicul) references medic(cnp_medic);
alter table unitate_medic
add foreign key(id_unitate_medicala) references unitate_medicala(id);

alter table orar_generic
modify id_orar_generic int auto_increment ;
create table bonFiscal
(	
	id_generareBon int not null primary key auto_increment,
    id_medic int not null,
    pret_servicii int,
    data_bon date
);

 DROP PROCEDURE IF EXISTS adauga_programare;

  DELIMITER //
  CREATE PROCEDURE adauga_programare(in cnp_medic varchar(14), in cnp_pacient varchar(14), in nume_pacient varchar(30), in prenume_pacient varchar(30), in nume_medic varchar(30), in prenume_medic varchar(30),in data_prog date, in ora time, in durata int,in idLocatie int)
  BEGIN
    set @cnp_med = null, @id_p = null;
    select cnp_medic into @cnp_med from medic where  id_functie = '3' and medic.cnp_medic = cnp_medic;
    
    select id_pacient into @id_p  from pacienti where cnp = cnp_pacient; -- cazul in care pacientul a mai fost programat
    if (@cnp_med is not null and @id_p is null ) then    -- cazul in care pacientul se prezinta pentru prima data la clinica; se introduc datele acestuia in BD 
		begin
		insert into pacienti values (null, cnp_pacient, nume_pacient, prenume_pacient);
        end;
	end if;
   
	select id_pacient into @id_p from pacienti where cnp = cnp_pacient;
    
    if(@cnp_med is not null and @id_p is not null) then
    begin
	INSERT INTO programare(id_programare,id_pacient,cnp_medic,data_programare,ora_programare,durata,id_unitate_medicala) VALUES (null, @id_p, @cnp_med,data_prog, ora, durata,idLocatie);
	end;
	end if;
    
  END;
  //
DELIMITER ;
 
 ###################---------------  INSERARE LEGATURI INTRE SERVICII SI PROGRAMARE   -----------------################
  DROP PROCEDURE IF EXISTS adauga_serviciu_prog;
  
  DELIMITER //
  CREATE PROCEDURE adauga_serviciu_prog(in cnp_medic varchar(14), in cnp_pacient varchar(14), in serviciu_med varchar(50), in durata_serv int, out ok int)
  BEGIN
    set ok = 0;
    set @cnp_med = null, @id_p = null, @id_serv = null, @durata = null, @id_prog = null;
	select cnp_medic into @cnp_med from medic where  id_functie = '3' and medic.cnp_medic = cnp_medic;
  	select id_pacient into @id_p from pacienti where cnp = cnp_pacient; 
    select id_serviciu into @id_serv from servicii where denumire_serviciu = serviciu_med;
    select durata_min into @durata from servicii where denumire_serviciu = serviciu_med; 
    select max(id_programare) into @id_prog from programare ;
    
    if (@cnp_med is not null and @id_p is null ) then    -- cazul in care pacientul se prezinta pentru prima data la clinica; se introduc datele acestuia in BD 
		begin
		insert into pacienti values (null, cnp_pacient, nume_pacient, prenume_pacient);
        end;
	end if;
    
    select id_pacient into @id_p from pacienti where cnp = cnp_pacient; 

    if(@cnp_med is not null and @id_p is not null and @id_serv is not null and @durata is not null and @id_prog is not null) then
    begin
	INSERT INTO servicii_programare VALUES (null, @id_prog, @id_serv);
    set ok = 1;
	end;
	end if;
    
  END;
  //
  DELIMITER ;

###################---------------  RETURNARE SERVICII OFERITE DE UN MEDIC -----------------################

drop procedure if exists getServiciiMedic;

DELIMITER //

CREATE PROCEDURE getServiciiMedic(in cnp_med varchar(14)) 
BEGIN
	set @id_spec = null;
    select id_specialitate into @id_spec  from medic where id_functie = '3' and cnp_medic = cnp_med;
    select denumire_serviciu from servicii where id_specialitate = @id_spec; 
END ;
//
DELIMITER ;

###################---------------  RETURNARE DURATA UNUI SERVICIU -----------------################

drop procedure if exists getDurataServiciiMedic;

DELIMITER //

CREATE PROCEDURE getDurataServiciiMedic(in denumireServ varchar(50)) 
BEGIN
    select durata_min from servicii where denumire_serviciu = denumireServ; 
END ;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS adauga_raport;

  DELIMITER //
  CREATE PROCEDURE adauga_raport(in cnp_medic varchar(14), in cnp_pacient varchar(14), in cnp_asistent varchar(14),in diagnostic varchar(30), in simptome varchar(100), in recomandari varchar(100),in rez varchar(10), out ok int, in nume_med varchar(30), in prenume_med varchar(30), in nume_a varchar(30), in prenume_a varchar(30), in dataR date)
  BEGIN
	set ok = 0;
    set @cnp_med = null, @id_p = null, @id_prog = null, @cnpA = null, @id_rap = null;
    select cnp_medic into @cnp_med from medic where  id_functie = '3' and medic.cnp_medic = cnp_medic;
    select id_pacient into @id_p  from pacienti where cnp = cnp_pacient; 
    select max(id_programare) into @id_prog from programare where id_pacient = @id_p and cnp_medic = @cnp_med;
    select cnp_asistent into @cnpA from asistent_medical where asistent_medical.cnp_asistent = cnp_asistent;
    
    if(@cnp_med is not null and @id_p is not null and @id_prog is not null) then
		begin
			INSERT INTO raport(id_raport, id_pacient,cnp_medic, cnp_asistent,id_programare,rezultat, diagnostic, simptome, recomandari,nume_medic,prenume_medic,nume_asistent, prenume_asistent,dataRap) 
				VALUES (null, @id_p, @cnp_med, @cnpA, @id_prog,rez, diagnostic, simptome, recomandari, nume_med, prenume_med,  nume_a, prenume_a, dataR);
			select max(id_investigatii) into @id_inv from investigatii; 
            select max(id_raport) into @id_rap from raport; 
            UPDATE policlinica.investigatii SET id_raport = @id_rap WHERE id_investigatii = @id_inv;
            update policlinica.raport set id_investigatie = @id_inv where id_raport = @id_rap;
            set ok = 1;
        end;

	end if;
    
  END;
  //
DELIMITER ;

######## ---------- INSERARE INVESTIGATII ------------- ########


DROP PROCEDURE IF EXISTS adauga_investigatie;

  DELIMITER //
  CREATE PROCEDURE adauga_investigatie(in concluzie varchar(100), out ok int)
  BEGIN
	set ok = 0;
    if(concluzie is not null) then
		begin
			INSERT INTO investigatii(id_investigatii, concluzie ) VALUES (null,concluzie);
			set ok = 1;
        end;
	end if;

  END;
  //
DELIMITER ;

#####-------------- ISTORIC ---------------------###########


DROP PROCEDURE IF EXISTS getIstoric;

  DELIMITER //
  CREATE PROCEDURE getIstoric(in cnp_pacient varchar(14))
  BEGIN

    set @id_p = null;
    select id_pacient into @id_p  from pacienti where cnp = cnp_pacient; 
    if(@id_p is not null) then
		begin
			select id_raport, dataRap, nume_medic, prenume_medic,nume_asistent, prenume_asistent, simptome,diagnostic,recomandari, rezultat from raport where id_pacient = @id_p;
        end;
	end if;
    
  END;
  //
DELIMITER ;
 
 #######---------preluare date utilizator------#####3
 
DELIMITER //
create procedure preluareDate(in idU int)
begin 
   select cnp,adresa,nr_telefon,
   email,IBAN,nr_contract,data_angajarii,
  salariu_negociat,nr_ore from utilizator 
   where utilizator.id=idU;
end;
// DELIMITER ;
call preluareDate('1');

########-------------preluare orar in functie de programari medic----------###########
DELIMITER //
create procedure getOrarProgramari(in cnpMedic varchar(14))
begin 
select programare.data_programare, programare.ora_programare, programare.durata, unitate_medicala.denumire 
from programare, unitate_medicala
where programare.cnp_medic=cnpMedic and
programare.id_unitate_medicala=unitate_medicala.id
order by programare.data_programare;
end;
// DELIMITER  ;

##############-------------adaugare concediu---------------------########
DELIMITER //
create procedure inserareConcediu(in idUtilizator int,in dataInceput date,in datasfarsit date)
begin
select id into @existaOrar from orar_generic where id=idUtilizator;
if( @existaOrar is not null ) then 
begin
 update orar_generic set data_inceput_concediu=dataInceput where id=idUtilizator;
 update orar_generic set data_sfarsit_concediu=dataSfarsit where id=idUtilizator;
end;
else 
begin 
 insert into orar_generic(id,data_inceput_concediu,data_sfarsit_concediu) values (idUtilizator,dataInceput,dataSfarsit);
end;
end if;
end;
// DELIMITER ;

################----------adauga bon fiscal-------######################3
DELIMITER //
create procedure adaugaBon(in cnpM varchar(14), in pret int,in dataBon date)
begin 
 select id into @idMedic from utilizator where cnp=cnpM;
 if( @idMedic is not null) then 
 insert into bonFiscal(id_medic,pret_servicii,data_bon) values(@idMedic,pret,dataBon);
 end if;
 end ;
 // DELIMITER ;


##########------------modificare date utilizator-----------#####

  DROP PROCEDURE IF EXISTS modificareDate;
DELIMITER //
create procedure modificareDate(in idUtilizator int,in salariuModificat float(20,5),in adresaModificata varchar(50), in telefonModificat varchar(10))
begin
select id into @existaUtilizator from utilizator where id=idUtilizator;
if( @existaUtilizator is not null ) then 

begin
 update utilizator set salariu_negociat = salariuModificat where id=idUtilizator;
 update utilizator set adresa=adresaModificata where id=idUtilizator;
 update utilizator set nr_telefon=telefonModificat where id=idUtilizator;
end;

end if;
end;
// DELIMITER ;

#########---------------creare cont nou-----------########

drop procedure if exists cont_nou;
 DELIMITER //
 create procedure cont_nou(cnp_1 varchar(14),nume_1 varchar(30),prenume_1 varchar(30),adresa_1 varchar(50),tel_1 varchar(10),email_1 varchar(50),iban_1 varchar(30),nr_1 varchar(10),angajare date,tip_util varchar(30),parola_1 varchar(30),salar_neg float(10,5),nr_ore_1 int,tip_functie varchar(30),unit_med varchar(30))
 begin
 set @id_util=null;
 select @id_util:=id from tip_utilizator where denumire_tip=tip_util; 
 select @id_functie:=id_functie from functie where denumire_functie=tip_functie;
 select @id_unit:=id from unitate_medicala where denumire=unit_med;
 if (tip_functie='Inspector resurse umane') then
 set @id_dep=1;
 else
 if (tip_functie='Expert financiar-contabil') then
 set @id_dep=2;
 else
 set @id_dep=3;
 end if;
 end if;
 if (tip_util='Administrator' or tip_util='Super-administrator') then
 begin
 set @id_functie=null;
 set @id_dep=null;
 end;
 end if;
 if (tip_functie='Medic') then      #daca este medic inserez tot mai putin departamentul/departamentele
 insert into utilizator
 (cnp,nume,prenume,adresa,nr_telefon,email,iban,nr_contract,data_angajarii,parola,salariu_negociat,nr_ore,id_tip_utilizator,id_departament,id_functie,id_unitate_medicala)
 values
 (cnp_1,nume_1,prenume_1,adresa_1,tel_1,email_1,iban_1,nr_1,angajare,parola_1,salar_neg,nr_ore_1,@id_util,@id_dep,@id_functie,null);
end if;
if (tip_functie<>'Medic') then  
insert into utilizator
 (cnp,nume,prenume,adresa,nr_telefon,email,iban,nr_contract,data_angajarii,parola,salariu_negociat,nr_ore,id_tip_utilizator,id_departament,id_functie,id_unitate_medicala)
 values
 (cnp_1,nume_1,prenume_1,adresa_1,tel_1,email_1,iban_1,nr_1,angajare,parola_1,salar_neg,nr_ore_1,@id_util,@id_dep,@id_functie,@id_unit);
  end if;
  END //
DELIMITER ;

############--------inserare asistent medical---------#######

drop procedure if exists insert_asistent;
 DELIMITER //
 create procedure insert_asistent(tip_1 varchar(20),grad_1 varchar(10))
 begin
 select @id_func:=MAX(id_functie) from functie where denumire_functie='Asistent medical';
 select @cnp_asist:=cnp from utilizator where id_functie=@id_func;
 insert into asistent_medical(cnp_asistent,id_functie,tip,grad) 
 values 
 (@cnp_asist,@id_func,tip_1,grad_1);
 end //
 DELIMITER ;
 
 
 #######-----------inserare medic----------#########
 
 drop procedure if exists insert_medic;
 DELIMITER //
 create procedure insert_medic(grad_1 varchar(15),cod_1 varchar(30),titlu varchar(30),post_1 varchar(30),procent_1 float,specialitate_1 varchar(100))
 begin
 select @id_func:=MAX(id_functie) from functie where denumire_functie='Medic';
 select @id_spec:=id_specialitate from specialitatea where denumire_specialitate=specialitate_1;
 select @cnp_med:=cnp from utilizator where id_functie=@id_func;
insert into medic(cnp_medic,id_functie,id_specialitate,grad,cod_parafa,titlu_stiintific,post_didactic,procent_aditional)
values
(@cnp_med,@id_func,@id_spec,grad_1,cod_1,titlu,post_1,procent_1);
end //
 DELIMITER ;

########------inserare unitati medicale pentru medic---------######
 drop procedure if exists insert_unitate;
 DELIMITER //
 create procedure insert_unitate(nume_unitate varchar(30))
 begin
 select @id_util:=MAX(id) from utilizator;    #ultimul id introdus in baza de date
 select @id_functie:=id_functie from utilizator where id=@id_util;    #id_functiei al ultimei pers introdusa
 if (@id_functie=3) then     #daca utlima pers introdusa este medic
 begin
 select @cnp_medic:=cnp from utilizator where id=@id_util;    #cnp-ul pers
 select @id_unit:=id from unitate_medicala where denumire=nume_unitate;     
 insert into unitate_medic(cnp_medicul,id_unitate_medicala)
 values
 (@cnp_medic,@id_unit);
 end;
 end if;
 end //
 DELIMITER ;
  

insert into functie(denumire_functie)
values
('Inspector resurse umane'),
('Expert financiar-contabil'),
('Medic'),
('Asistent medical'),
('Receptioner');

insert into departament
values('1','Resurse umane'),
		('2','Financiar-Contabil'),
        ('3', 'Medical');

insert into tip_utilizator
values ('1','Administrator'),
('2','Super-administrator'),
('3','Angajat');

 insert into specialitatea 
 values (null, 'Radiologie si Imagistica medicala'),
 (null,'Cardiologie'),
 (null,'Urologie'),
 (null,'Diabet si Nutritie'),
 (null, 'Chirurgie generala'),
 (null, 'Chirurgie toracica'),
 (null, 'Nefrologie'),
 (null, 'Neurochirurgie'),
 (null, 'Neurologie'),
 (null, 'Pneumologie'),
 (null, 'Chirurgie Pediatrica'),
 (null, 'Gastroenterologie'),
 (null, 'Chirurgie spinala');
 

INSERT INTO servicii(id_serviciu, denumire_serviciu, id_specialitate,durata_min, pret) 
 values('1', 'Ecografie', '1', '20', '100'), -- Radiologie
 ('2', 'Endoscopie digestiva', '12', '45', '250'), -- gastroenterologie
 ('3', 'Ecocardiografie', '2', '45', '150'),  -- Cardilogie
 ('4', 'Cardiologie interventionala', '2', '120', '800'), -- Cardiologie
 ('5', 'Bronhoscopie', '10', '30', '250'), -- Pneumologie
 ('6', 'EEG','9', '60', '180'), -- Neurologie
 ('7', 'EMG', '9', '90', '180'), -- Neurologie 
 ('8', 'Dializa', '7', '240', '0'), -- Nefrologie
 ('9', 'Chirurgie laparoscopica', '5', '180', '500'), -- Girurgie generala
 ('10', 'Chirurgie toracica', '6', '240', '1000'), -- Chirurgie toracica
 ('11', 'Chirurgie spinala', '13', '240','2500'), -- Chirurgie spinala
 ('12', 'Chirurgie pediatrica', '11', '180', '1500'), -- Chirurgie pediatrica
 ('13', 'Litotritie extracorporeala', '3', '120', '7500'), -- Urologie
 ('14', 'Explorare computer tomograf', '1', '45', '1000'), -- Radiologie
 ('15', 'Imagistica prin rezonanta magnetica', '1', '30', '1700'),  -- Radiologie
 ('16', 'Consiliere nutritionala', '4', '50', '850') ; -- Diabet si nutritie
 
 insert into competenta
  values ('1', 'ecografie', '1'), -- Radiologie
 ('2', 'endoscopie digestiva', '12'), -- gastroenterologie
 ('3', 'ecocardiografie', '2'),  -- Cardilogie
 ('4', 'cardiologie interventionala', '2'), -- Cardiologie
 ('5', 'bronhoscopie', '10'), -- Pneumologie
 ('6', 'EEG','9'), -- Neurologie
 ('7', 'EMG', '9'), -- Neurologie 
 ('8', 'dializa', '7'), -- Nefrologie
 ('9', 'chirurgie laparoscopica', '5'), -- Girurgie generala
 ('10', 'chirurgie toracica', '6'), -- Chirurgie toracica
 ('11', 'chirurgie spinala', '13'), -- Chirurgie spinala
 ('12', 'chirurgie pediatrica', '11'), -- Chirurgie pediatrica
 ('13', 'litotritie extracorporeala', '3'), -- Urologie
 ('14', 'explorare computer tomograf', '1'), -- Radiologie
 ('15', 'imagistica prin rezonanta magnetica', '1');  -- Radiologie

insert into unitate_medicala(denumire,adresa)
 values
 ('MedLife Cluj','Str.Unirii'),
 ('MedLife Valcea','Str.Ion Buteanu'),
 ('MedLife Sibiu','Str.Panduri'),
 ('MedLife Alba','Str.Eroilor'),
 ('MedLife Oradea','Str.Florilor'),
 ('MedLife Timisoara','Str.Independentei'),
 ('MedLife Craiova','Str.Bucuriei'),
 ('MedLife Bucuresti','Str.Gerge Enescu');

insert into program values
('Luni','1','07:00:00','15:00:00'),
('Marti','1','08:00:00','16:00:00'),
('Miercuri','1','09:00:00','17:00:00'),
('Joi','1','10:00:00','18:00:00'),
('Vineri','1','11:00:00','19:00:00'),
('Sambata','0',null,'23:00:00'),
('Duminica','0',null,'23:30:00');




delete from utilizator;
delete from unitate_medic;
delete from raport;
delete from servicii_programare;
delete from programare;
delete from medic;
delete from pacienti;
insert into utilizator values (null,'61',3,1,1,3,'Inspector', 'Popescu','Str. X nr 23', '0755555555','ip@ml.ro','1','ROBTRLRON97984','1','2018-01-01',3000,14);
insert into utilizator values (null,'21',3,3,3,null,'Pop', 'Alex','Str. X nr 23', '0755555555','ap@ml.ro','1','ROBTRLRON97954','2','2018-01-01',5000,14);
insert into medic values ('21', 3,	1,	'Specialist','21345','Doctorand','Preparator',	13.00000);
insert into unitate_medic values (null,'21',3);
insert into orar_generic values(null,2,'2022-01-01','2022-02-02');
insert into utilizator values (null,'123',	3,	2,	2,3, 'Contabil','Avram','Str. X nr 23', '0755555555',	'ca@ml.ro',	'1','ROBTRLEUR654777','3', '2020-01-01',2456.00000,	12);
insert into utilizator values (null,'13',	3,	3,	4,3, 'Asistent','Mircea','Str. X nr 21', '0755555555',	'am@ml.ro',	'1','ROBTRLEUR65417','4', '2020-01-01',2456.00000,	12);
insert into asistent_medical values('13',4,'Radiologie','Primar');
insert into expert_financiar_contabil values('123', 2);
insert into inspector_resurse_umane values('61',1);
insert into utilizator values (null,'51',1,null,null,null,'Admin', 'Pop','Str. X nr 23', '0755555555','admin','1','ROBTRLRON97984','1','2018-01-01',3000,14);
insert into utilizator values (null,'71',2,null,null,null,'Super Admin', 'Dan','Str. X nr 23', '0755555555','sadmin','1','ROBTRLRON97984','1','2018-01-01',3000,14);
insert into utilizator values (null,'81',3,3,5,3,'Recptioner', 'Dana','Str. X nr 23', '0755555555','r@ml.ro','1','ROBTRLRON97984','1','2018-01-01',3000,14);
insert into receptioner values ('81',5);
insert into pacienti values(null,'44','Pacient', 'Malina');
insert into programare values (null,1,'21',	'2021-01-14','07:00:00',65,3);
insert into servicii_programare values (null,	1,	1);
insert into servicii_programare values (null,	1,	14);




