select * from employee where (employee_name like 'H%' or employee_name like 'T%' or employee_name like 'K%' ) and (char_length(employee_name)<15);