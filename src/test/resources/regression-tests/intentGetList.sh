#Obtine la lista de los intent del chatbot

curl -X GET --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"areaId\":\"1\",
  \"sessionId\":\"9fa2c5fc-ea33-4861-a1ca-165f2c68fae5\"
}" "http://localhost:8080/api/chatbot/trainer/all-intent.json"
