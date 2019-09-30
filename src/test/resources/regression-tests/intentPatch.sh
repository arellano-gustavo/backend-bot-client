#Actualiza un intent por medio de su id, 
#se debe cambiar el id deacuerdo al intent que se 
#desea visualizar

curl -X PATCH --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"areaId\":\"1\",
  \"sessionId\":\"9fa2c5fc-ea33-4861-a1ca-165f2c68fae5\",
  \"id\":\"706ffc1f-0df4-4c1b-bcb8-e78f82f3bba4\",
  \"item\":{
    \"displayName\":\"intentReading\",
    \"trainingPhrases\":[{
      \"parts\":[
        {
          \"text\":\"frase actual uno\"
        },{
          \"text\":\" phrases\"
        }
      ]},{
      \"parts\":[
        {
          \"text\":\"frase actual dos\"
        },{
          \"text\":\" phrases\"
        }
      ]},{
      \"parts\":[
        {
          \"text\":\"frase actual tres\"
        },{
          \"text\":\" phrases\"
        }
      ]}
    ]}  
}" "http://localhost:8080/chatbotserver/intent"
