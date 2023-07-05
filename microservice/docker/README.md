# ELK stack info 
## Elastic 

Check default users 

```
http://<elastic host>:9200/_security/user?pretty
```

To reset default users password use command.

```
docker exec <container name> bin/elasticsearch-reset-password --batch --user elastic

docker exec <container name> bin/elasticsearch-reset-password --batch --user kibana_system

docker exec <container name> bin/elasticsearch-reset-password --batch --user logstash_system
```
