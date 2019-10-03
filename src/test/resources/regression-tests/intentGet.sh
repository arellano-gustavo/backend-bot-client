#Obtine un intent por medio de su id, 
#se debe cambiar el id deacuerdo al intent que se 
#desea visualizar

curl -X GET --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"areaId\":\"1\",
  \"sessionId\":\"9fa2c5fc-ea33-4861-a1ca-165f2c68fae5\",
  \"id\":\"29996ff1-dbac-4f53-947c-1906a9644aa7\"
}" "http://localhost:8080/api/chatbot/trainer/get-intent.json"
