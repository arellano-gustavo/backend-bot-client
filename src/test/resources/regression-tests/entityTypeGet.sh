#Obtine una entidad por medio de su id, 
#se debe cambiar el id deacuerdo a la entidad que se 
#desea visualizar

curl -X GET --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"areaId\":\"area1\",
  \"sessionId\":\"a9fa2c5fc-ea33-4861-a1ca-165f2c68fae5\",
  \"id\":\"6ad03e7b-d21e-4afc-a4b5-f3b3b91f61ec\"
}" "http://localhost:8080/api/chatbot/trainer/get-entityType.json"
