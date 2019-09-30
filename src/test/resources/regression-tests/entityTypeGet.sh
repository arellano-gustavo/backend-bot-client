#Obtine una entidad por medio de su id, 
#se debe cambiar el id deacuerdo a la entidad que se 
#desea visualizar

curl -X GET --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"areaId\":\"1\",
  \"sessionId\":\"9fa2c5fc-ea33-4861-a1ca-165f2c68fae5\",
  \"id\":\"0e5d243d-d03f-4346-b78a-6d3515cf8e73\"
}" "http://localhost:8080/chatbotserver/entityType"
