#Borra una entidad por medio de su id, 
#se debe cambiar el id deacuerdo a la entidad que se 
#desea borrar

curl -X DELETE --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"areaId\":\"1\",
  \"sessionId\":\"9fa2c5fc-ea33-4861-a1ca-165f2c68fae5\",
  \"id\":\"bdaecaa1-ff49-4bb6-95a8-5c6e9eb0912a\"
}" "http://localhost:8080/chatbotserver/entityType"
