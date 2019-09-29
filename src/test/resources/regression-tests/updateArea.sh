#15
# Actualiza un 'Area' en el sistema y regresa un objeto 'MainControllerResponse' con el resultado de la operacion 

curl -X PUT --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"active\": true,
  \"description\": \"AREA CUATRO\",
  \"id\": 4,
  \"name\": \"CUATRO\"
}" "http://localhost:8080/api/chatbot/admin/update-area.json"