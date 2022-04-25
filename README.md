#The trigger syntax

## FOR EACH ROW or FOR EACH STATEMENT

## For which event should the trigger fire INSERT, UPDATE or DELETE

## WHEN clause decides when the trigger should fire


CREATE [ OR REPLACE ] [ CONSTRAINT ] TRIGGER name { BEFORE | AFTER | INSTEAD OF } { event [ OR ... ] }
ON table_name
[ FROM referenced_table_name ]
[ NOT DEFERRABLE | [ DEFERRABLE ] [ INITIALLY IMMEDIATE | INITIALLY DEFERRED ] ]
[ REFERENCING { { OLD | NEW } TABLE [ AS ] transition_relation_name } [ ... ] ]
[ FOR [ EACH ] { ROW | STATEMENT } ]
[ WHEN ( condition ) ]
EXECUTE { FUNCTION | PROCEDURE } function_name ( arguments )

where event can be one of:

    INSERT
    UPDATE [ OF column_name [, ... ] ]
    DELETE
    TRUNCATE



### The trigger
CREATE TRIGGER mikes_trigger
AFTER INSERT
ON public.table_tennis_rank
FOR EACH ROW
WHEN (NEW.name like 'mike%')
EXECUTE FUNCTION public.mikes_function(club_name,name, points);

### The function
-- DROP FUNCTION public.mikes_function;
CREATE OR REPLACE FUNCTION public.mikes_function()
RETURNS TRIGGER AS $mikes_function$
BEGIN
insert into public.table_tennis_rank_log
(id, club_name, name, points, timestamp)
values
(nextval('ttr_log_id_seq'), new.club_name, new.name, new.points*2, now());
RETURN NULL;
END;
$mikes_function$
LANGUAGE plpgsql;


Insert sql:

insert into table_tennis_rank
(id, club_name, name, points)
values
(nextval('ttr_log_id_seq'), 'mikes_club', 'mike',99);

select * from table_tennis_rank;
delete from table_tennis_rank;

select * from table_tennis_rank_log;
delete from table_tennis_rank_log;
-- select * from mikes_function('test_club', 'some_player', 44);

# postgresql-triggers
