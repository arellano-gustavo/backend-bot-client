#01
# Inserta un 'Area' en el sistema y regresa un objeto 'MainControllerResponse' con el resultado de la operacion 

curl -X POST --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"active\": true,
  \"description\": \"AREA cuatro\",
  \"id\": 0,
  \"name\": \"cuatro\"
}" "http://localhost:8080/api/chatbot/admin/insert-area.json"