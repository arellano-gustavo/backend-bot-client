#Inserta un intent en el chatbot

curl -X POST --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"areaId\":\"1\",
  \"sessionId\":\"9fa2c5fc-ea33-4861-a1ca-165f2c68fae5\",
  \"item\":
  {
    \"displayName\":\"intentReading\",
    \"trainingPhrases\":
    [
      {
        \"parts\":[
          {
            \"text\":\"frase uno\"
          },{
            \"text\":\" phrases\"
          }
        ]
      },
      {
        \"parts\":[
          {
            \"text\":\"frase dos\"
          },{
            \"text\":\" phrases\"
          }
        ]
      },
      {
        \"parts\":[
          {
            \"text\":\"frase tres\"
          },{
            \"text\":\" phrases\"
          }
        ]
      }
    ]
  }  
}" "http://localhost:8080/chatbotserver/intent"
