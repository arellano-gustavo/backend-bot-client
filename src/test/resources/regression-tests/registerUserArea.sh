#04
# Inserta un 'UserArea' en el sistema y regresa un objeto 'MainControllerResponse' con el resultado de la operacion 
#################################################    ERRORES      ###################################################

curl -X POST --header "Content-Type: application/json" --header "Accept: application/json;charset=utf-8" -d "{
  \"idArea\": 1,
  \"idUser\": 2
}" "http://localhost:8080/api/chatbot/admin/register-user-area.json"