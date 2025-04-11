CREATE VIEW vw_employee_audit AS
    SELECT employee_id as ID_EMP,
           name as NAME,
           old_name as OLD_NAME,
           salary as SALARY,
           old_salary as OLD_SALARY,
           birthday as BIRTHDAY,
           old_birthday as OLD_BIRTHDAY,
           operation as OPERATION
    FROM employees_audit
    ORDER BY created_at;
