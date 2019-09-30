#Actualiza una entidad por medio de su id, 
#se debe cambiar el id deacuerdo a la entidad que se 
#desea visualizar

curl -X PATCH --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"areaId\":\"1\",
  \"sessionId\":\"9fa2c5fc-ea33-4861-a1ca-165f2c68fae5\",
  \"id\":\"bdaecaa1-ff49-4bb6-95a8-5c6e9eb0912a\",
  \"item\":{
         \"displayName\": \"EjemploActualizado\",
        \"entities\": [
            {
                \"synonyms\": [
                    \"salsa cumbeando\",
                    \"bachata\",
                    \"bachata romantica\"
                ],
                \"value\": \"pop\"
            },
            {
                \"synonyms\": [
                    \"rock\",
                    \"ruidoso\",
                    \"loco\"
                ],
                \"value\": \"rock\"
            },
            {
                \"synonyms\": [
                    \"balada\",
                    \"dulce\",
                    \"melodiosa\"
                ],
                \"value\": \"balada\"
            },
            {
                \"synonyms\": [
                    \"salsa cumbeando\",
                    \"bachata\",
                    \"bachata romantica\"
                ],
                \"value\": \"salsa\"
            }
        ],
        \"kind\": \"KIND_MAP\"
  }  
}" "http://localhost:8080/chatbotserver/entityType"
