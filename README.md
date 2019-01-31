# customer-api
api

## H2 database

https://github.com/oscarfonts/docker-h2

```
docker run -d -p 1521:1521 -p 81:81 -v //c/files/h2/data:/opt/h2-data --name=h2db oscarfonts/h2
```

Console Browser: http://localhost:81

Jdbc Url: jdbc:h2:tcp://localhost:1521/test
