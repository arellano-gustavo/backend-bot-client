#Inserta una entidad en el chatbot

curl -X POST --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"areaId\":\"1\",
  \"sessionId\":\"9fa2c5fc-ea33-4861-a1ca-165f2c68fae5\",
  \"item\":{
        \"displayName\": \"Ejemplo\",
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
