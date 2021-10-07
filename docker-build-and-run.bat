docker build -t ms-customer-order-svc .
docker stop ms-customer-order-svc
docker rm ms-customer-order-svc
docker run -p 8088:8088 --net ms-net --name ms-customer-order-svc ms-customer-order-svc