#16
# Actualiza un 'Rol' en el sistema y regresa un objeto 'MainControllerResponse' con el resultado de la operacion 

curl -X PUT --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"active\": true,
  \"description\": \"ADMINISTRADOR DEL SISTEMA.\",
  \"id\": 1,
  \"name\": \"ADMINISTRADOR\"
}" "http://localhost:8080/api/chatbot/admin/update-rol.json"