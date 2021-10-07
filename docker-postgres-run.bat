docker stop postgres
docker rm postgres
docker run -d -p 5432:5432 --net ms-net --name postgres -v C:\Users\kwan\Desktop\docker_mount\postgres_container\data:/var/lib/postgresql/data -e POSTGRES_PASSWORD=password postgres