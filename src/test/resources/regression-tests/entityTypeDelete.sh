#Borra una entidad por medio de su id, 
#se debe cambiar el id deacuerdo a la entidad que se 
#desea borrar

curl -X DELETE --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"areaId\":\"1\",
  \"sessionId\":\"9fa2c5fc-ea33-4861-a1ca-165f2c68fae5\",
  \"id\":\"1b88e311-d174-4c89-874c-0e625c1a3c45\"
}" "http://localhost:8080/api/chatbot/trainer/remove-entityType.json"
