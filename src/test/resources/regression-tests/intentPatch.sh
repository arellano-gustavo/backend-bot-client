#Actualiza un intent por medio de su id, 
#se debe cambiar el id deacuerdo al intent que se 
#desea visualizar

curl -X PUT --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"areaId\":\"1\",
  \"sessionId\":\"9fa2c5fc-ea33-4861-a1ca-165f2c68fae5\",
  \"id\":\"29996ff1-dbac-4f53-947c-1906a9644aa7\",
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
}" "http://localhost:8080/api/chatbot/trainer/update-intent.json"
