#02
# Inserta un 'Rol' en el sistema y regresa un objeto 'MainControllerResponse' con el resultado de la operacion. 

curl -X POST --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"active\": true,
  \"description\": \"ADMINISTRADOR DEL SISTEMA\",
  \"id\": 0,
  \"name\": \"ADMINISTRADOR\"
}" "http://localhost:8080/api/chatbot/admin/insert-rol.json"