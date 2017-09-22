insert into bdcdt.CDT_persona (codigo, nombre) values (1, 'Martin Perez');
insert into bdcdt.CDT_persona (codigo, nombre) values (2, 'Benito Sanchez');
insert into bdcdt.CDT_persona (codigo, nombre) values (3, 'Paula Benitez');
insert into bdcdt.CDT_persona (codigo, nombre) values (4, 'Maria Gonzales');

insert into bdcdt.CDT_registro (codigo_persona, descripcion, valor, tipoRegistro) values (1, 'Pago de servicio de luz', 1500.00, 'GASTO' );
insert into bdcdt.CDT_registro (codigo_persona, descripcion, valor, tipoRegistro) values (1, 'Pago de servicio de agua', 500.00, 'GASTO' );
insert into bdcdt.CDT_registro (codigo_persona, descripcion, valor, tipoRegistro) values (1, 'Salario', 21000.00, 'INGRESO' );

insert into bdcdt.CDT_registro (codigo_persona, descripcion, valor, tipoRegistro) values (2, 'Pago de servicio de gaz', 250.00, 'GASTO' );
insert into bdcdt.CDT_registro (codigo_persona, descripcion, valor, tipoRegistro) values (2, 'Pago de internet fija', 400.00, 'GASTO' );
insert into bdcdt.CDT_registro (codigo_persona, descripcion, valor, tipoRegistro) values (2, 'Pago de internet 3g', 250.00, 'GASTO' );
 