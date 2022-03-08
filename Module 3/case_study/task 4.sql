SELECT customer.customer_id, count(contract_id),customer.customer_name from contract 
INNER JOIN customer ON customer.customer_id=contract.customer_id
join customer_type on customer_type.customer_type_id = customer.customer_type_id
WHERE customer_type.customer_type_name  = "Diamond" group by customer.customer_id order by count(contract_id) asc;