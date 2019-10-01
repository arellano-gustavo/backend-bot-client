#Realiza una consulta de texto al chatbot

curl -X POST --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"areaId\":\"1\",
  \"sessionId\":\"9fa2c5fc-ea33-4861-a1ca-165f2c68fae5\",
  \"item\":{
  \"languageCode\":\"es\",
  \"text\":\"hola\"
  }
}" "http://localhost:8080/chatbotserver/queryIntent"
