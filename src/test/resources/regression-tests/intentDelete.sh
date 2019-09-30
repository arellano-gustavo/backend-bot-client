#Borra un intent por medio de su id, 
#se debe cambiar el id deacuerdo al intent que se 
#desea borrar

curl -X DELETE --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"areaId\":\"1\",
  \"sessionId\":\"9fa2c5fc-ea33-4861-a1ca-165f2c68fae5\",
  \"id\":\"706ffc1f-0df4-4c1b-bcb8-e78f82f3bba4\"
}" "http://localhost:8080/chatbotserver/intent"
