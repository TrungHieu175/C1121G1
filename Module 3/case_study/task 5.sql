select customer.customer_code,customer.customer_name,customer_type.customer_type_name,
contract.contract_id,service.service_name,contract.contract_start_date,contract.contract_end_date,
sum(service.service_cost + contract_detail.quatity * attach_service.attach_service_cost) as "Sum"
from customer left join contract on customer.customer_id = contract.customer_id
left join service on service.service_id = contract.service_id
left join contract_detail on contract_detail.contract_id = contract.contract_id
left join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id
left join customer_type on customer_type.customer_type_id = customer.customer_type_id group by customer.customer_id;